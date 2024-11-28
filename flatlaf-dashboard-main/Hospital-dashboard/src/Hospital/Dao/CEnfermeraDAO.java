package Hospital.Dao;

import Hospital.Conexion.CConexion;
import Hospital.Modelo.ModelEnfermera;
import Hospital.Modelo.ModelUsuario;
import com.toedter.calendar.JDateChooser;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;

/**
 * @author Wilson
 */
public class CEnfermeraDAO {
    public void SeleccionarEnfermera(JTable tabla, JTextField txtCodEnfer, JTextField txtNomEnfer, JTextField txtApellidosEnfer, JTextField txtDNIEnfer,
                                JDateChooser jFechaNa, JTextField txtTelefonoEnfer, JTextField txtDireccionEnfer, JTextField txtCorreoEnfer,
                                JLabel lblMostrarFoto, JTextField codUser,JTextField PassUser) {
                                      
        try {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                txtCodEnfer.setText(tabla.getValueAt(fila, 0).toString());
                txtNomEnfer.setText(tabla.getValueAt(fila, 1).toString());
                txtApellidosEnfer.setText(tabla.getValueAt(fila, 2).toString());
                txtDNIEnfer.setText(tabla.getValueAt(fila, 3).toString());
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Object fechaEntregaObj = tabla.getValueAt(fila, 4);
                if (fechaEntregaObj != null) {
                    java.util.Date fechanacstr = dateFormat.parse(fechaEntregaObj.toString());
                    jFechaNa.setDate(fechanacstr);
                } else {
                    jFechaNa.setDate(null);
                }                
                txtTelefonoEnfer.setText(tabla.getValueAt(fila, 5).toString());                               
                txtDireccionEnfer.setText(tabla.getValueAt(fila, 6).toString());
                txtCorreoEnfer.setText(tabla.getValueAt(fila, 7).toString());

                // Cargar la foto del Enfermera si está disponible
                byte[] fotoBytes = (byte[]) tabla.getValueAt(fila, 8);
                if (fotoBytes != null) {
                    ImageIcon imageIcon = new ImageIcon(fotoBytes);
                    Image image = imageIcon.getImage().getScaledInstance(lblMostrarFoto.getWidth(), lblMostrarFoto.getHeight(), Image.SCALE_SMOOTH);
                    lblMostrarFoto.setIcon(new ImageIcon(image));
                } else {
                    ImageIcon icono = new ImageIcon("src/aplicativo/icon/jpg/foto_fondo.jpg");
                    lblMostrarFoto.setIcon(icono);
                }               
                 // Datos de la tabla Usuario
                codUser.setText(tabla.getValueAt(fila, 9).toString());
                PassUser.setText(tabla.getValueAt(fila, 10).toString());
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al seleccionar el Enfermera: " + e.toString());
        }
    }

    public void MostrarTablaenfermera(JTable tabla) {
        CConexion objCon = new CConexion();  
        DefaultTableModel modelo = new DefaultTableModel();

        // Definir las columnas de la tabla
        modelo.addColumn("ID");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Dni");    
        modelo.addColumn("FechaNa");            
        modelo.addColumn("Teléfono");    
        modelo.addColumn("Dirección");    
        modelo.addColumn("Email");                        
        modelo.addColumn("Foto");                
        modelo.addColumn("CodUser");    
        modelo.addColumn("PassUser");    
        tabla.setModel(modelo);

        // Consulta SQL corregida
        String sql = "SELECT e.Id_Enfermera, e.Nombre, e.Apellido, e.Dni, e.Fecha_Nacimiento, e.Telefono, "
                   + "e.Direccion, e.Email, e.Foto, u.Codigo_Usuario, u.Contraseña "
                   + "FROM Enfermera e "
                   + "LEFT JOIN Usuario u ON e.Id_Enfermera = u.Id_Enfermera";

        Object[] datos = new Object[14]; // Cambiado a tamaño 14

        try (Connection conn = objCon.EstablecerConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                datos[0] = rs.getString("Id_Enfermera");
                datos[1] = rs.getString("Nombre");
                datos[2] = rs.getString("Apellido");
                datos[3] = rs.getString("Dni");
                datos[4] = rs.getString("Fecha_Nacimiento");                
                datos[5] = rs.getString("Telefono");
                datos[6] = rs.getString("Direccion");
                datos[7] = rs.getString("Email");                
                datos[8] = rs.getBytes("Foto");                
                datos[9] = rs.getString("Codigo_Usuario");
                datos[10] = rs.getString("Contraseña");
                modelo.addRow(datos);
            }
            tabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se conectó correctamente, error: " + e.toString());
        } 
    }

    public boolean InsertarEnfermeraYUsuario(ModelEnfermera Enfermera, ModelUsuario usuario) {
        CConexion objCon = new CConexion();
        String sqlEnfermera = "INSERT INTO Enfermera (Nombre, Apellido, Dni, Fecha_Nacimiento, Telefono, Direccion, Email, Foto)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlUsuario = "INSERT INTO Usuario (Codigo_Usuario, Contraseña, Id_Rol, Id_Enfermera, Foto, FechaRegistro) "
                + "VALUES (?, ?, ?, ?, ?, GETDATE())";

        try (Connection conn = objCon.EstablecerConexion()) {
            conn.setAutoCommit(false);

            // Insertar en Enfermera
            try (PreparedStatement pstEnfer = conn.prepareStatement(sqlEnfermera, Statement.RETURN_GENERATED_KEYS)) {
                pstEnfer.setString(1, Enfermera.getNombre());
                pstEnfer.setString(2, Enfermera.getApellido());
                pstEnfer.setString(3, Enfermera.getDni());
                pstEnfer.setDate(4, new java.sql.Date(Enfermera.getFecha_Nacimiento().getTime()));
                pstEnfer.setString(5, Enfermera.getTelefono());
                pstEnfer.setString(6, Enfermera.getDireccion());
                pstEnfer.setString(7, Enfermera.getEmail());                
                pstEnfer.setBytes(8, Enfermera.getFoto());                
                pstEnfer.executeUpdate();

                // Obtener el ID del Enfermera
                ResultSet rsEnfer = pstEnfer.getGeneratedKeys();
                int Id_Enfermera = 0;
                if (rsEnfer.next()) {
                    Id_Enfermera = rsEnfer.getInt(1);
                }

                // Insertar en Usuarios
                try (PreparedStatement pstUsu = conn.prepareStatement(sqlUsuario)) {
                    pstUsu.setString(1, usuario.getCodigo_Usuario());
                    pstUsu.setString(2, usuario.getContraseña());
                    pstUsu.setInt(3, usuario.getRolID());
                    pstUsu.setInt(4, Id_Enfermera);
                    pstUsu.setBytes(5, usuario.getFoto());                    
                    pstUsu.executeUpdate();
                }

                // Confirmar la transacción
                conn.commit();
                return true;
            } catch (SQLException ex) {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Error al insertar Enfermera y usuario: " + ex.getMessage());
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar: " + e.toString());
            return false;
        }
    }

    public void ModificarEnfermera(JTextField txtCodEnfer, JTextField txtNomEnfer, JTextField txtApellidosEnfer, JTextField txtDNIEnfer, JDateChooser jFechaNa,
            JTextField txtTelefonoEnfer, JTextField txtDireccionEnfer, JTextField txtCorreoEnfer, JLabel lblMostrarFoto, 
            JTextField txtFotoRuta, JTextField txtUsuarioLogin, JTextField txtContraseñaLogin) {
        
        Connection con = null;
        CallableStatement cs = null;
        CConexion objCon = new CConexion();
        try {                      
            String sql = "UPDATE Enfermera SET Nombre = ?, Apellido = ?, Dni = ?, Fecha_Nacimiento = ?, Telefono = ?, Direccion = ?, Email = ?, Foto = ? " +
                         "WHERE Id_Enfermera = ?";
            cs=objCon.EstablecerConexion().prepareCall(sql);
            cs.setString(1, txtNomEnfer.getText());
            cs.setString(2, txtApellidosEnfer.getText());
            cs.setString(3, txtDNIEnfer.getText());
            // Convertir la fecha de JDateChooser a un tipo de dato SQL
            java.util.Date fecha = jFechaNa.getDate();
            java.sql.Date fechaSQL = (fecha != null) ? new java.sql.Date(fecha.getTime()) : null;
            cs.setDate(4, fechaSQL);
            cs.setString(5, txtTelefonoEnfer.getText());            
            cs.setString(6, txtDireccionEnfer.getText());
            cs.setString(7, txtCorreoEnfer.getText());          

            // Cargar la foto desde el archivo seleccionado, si existe
            if (!txtFotoRuta.getText().isEmpty()) {
                FileInputStream fis = new FileInputStream(txtFotoRuta.getText());
                cs.setBinaryStream(8, fis, (int) new File(txtFotoRuta.getText()).length());
            } else {
                cs.setNull(8, java.sql.Types.BLOB);
            }

            cs.setInt(9, Integer.parseInt(txtCodEnfer.getText())); // ID del Enfermera

            // Ejecutar la consulta
            int rowsUpdated = cs.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "¡Datos de la Enfermera modificados exitosamente!");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar los datos del Enfermera. Verifica el ID.");
            }
            // Actualizar también los datos del usuario si es necesario
            String sqlUsuario = "UPDATE Usuario SET Contraseña = ?, Foto = ? WHERE Id_Enfermera = ?";
            cs = objCon.EstablecerConexion().prepareCall(sqlUsuario);
            cs.setString(1, txtContraseñaLogin.getText());
            if (!txtFotoRuta.getText().isEmpty()) {
                FileInputStream fis = new FileInputStream(txtFotoRuta.getText());
                cs.setBinaryStream(2, fis, (int) new File(txtFotoRuta.getText()).length());
            } else {
                cs.setNull(2, java.sql.Types.BLOB);
            }
            cs.setInt(3, Integer.parseInt(txtCodEnfer.getText())); // Usar Id_Enfermera para identificar al usuario relacionado

            rowsUpdated = cs.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "¡Datos del usuario modificados exitosamente!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el Enfermera: " + e.getMessage());
        } finally {
            try {
                if (cs != null) cs.close();
                if (con != null) con.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }

    public void EliminarEnfermera(JTextField txtCodUser,JTextField txtCodEnfer) {
        CConexion objc=new CConexion();
        
        String query= "DELETE FROM Usuario WHERE Usuario.Codigo_Usuario=?";       
        String query2= "DELETE FROM Enfermera WHERE Enfermera.Id_Enfermera=?";
        System.out.println("Codigo Usuario: "+ txtCodUser.getText());
        try {            
            CallableStatement cs=objc.EstablecerConexion().prepareCall(query);
            cs.setString(1, txtCodUser.getText());
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "USUARIO ELIMINADO");
            
            cs=objc.EstablecerConexion().prepareCall(query2);
            cs.setInt(1,Integer.parseInt(txtCodEnfer.getText()));
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "ENFERMERA ELIMINADO");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar eliminar"+e.toString());
        }  
    }
}
