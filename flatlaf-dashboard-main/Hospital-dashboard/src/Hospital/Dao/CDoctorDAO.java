package Hospital.Dao;

import Hospital.Conexion.CConexion;
import Hospital.Modelo.ModelDoctor;
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
import javax.swing.JComboBox;


/**
 * @author Wilson
 */
public class CDoctorDAO {

    public void Seleccionardoctor(JTable tabla, JTextField txtCodDoc, JTextField txtNomDoc, JTextField txtApellidosDoc, JTextField txtDNIDoc,
                                JDateChooser jFechaNa, JTextField txtTelefonoDoc, JTextField txtDireccionDoc, JTextField txtCorreoDoc,
                                JTextField txtEspDoc, JLabel lblMostrarFoto, JTextField codUser,JTextField PassUser) {
                                      
        try {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                txtCodDoc.setText(tabla.getValueAt(fila, 0).toString());
                txtNomDoc.setText(tabla.getValueAt(fila, 1).toString());
                txtApellidosDoc.setText(tabla.getValueAt(fila, 2).toString());
                txtDNIDoc.setText(tabla.getValueAt(fila, 3).toString());
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Object fechaEntregaObj = tabla.getValueAt(fila, 4);
                if (fechaEntregaObj != null) {
                    java.util.Date fechanacstr = dateFormat.parse(fechaEntregaObj.toString());
                    jFechaNa.setDate(fechanacstr);
                } else {
                    jFechaNa.setDate(null);
                }                
                txtTelefonoDoc.setText(tabla.getValueAt(fila, 5).toString());                               
                txtDireccionDoc.setText(tabla.getValueAt(fila, 6).toString());
                txtCorreoDoc.setText(tabla.getValueAt(fila, 7).toString());
                txtEspDoc.setText(tabla.getValueAt(fila, 8).toString());

                // Cargar la foto del Doctor si está disponible
                byte[] fotoBytes = (byte[]) tabla.getValueAt(fila, 9);
                if (fotoBytes != null) {
                    ImageIcon imageIcon = new ImageIcon(fotoBytes);
                    Image image = imageIcon.getImage().getScaledInstance(lblMostrarFoto.getWidth(), lblMostrarFoto.getHeight(), Image.SCALE_SMOOTH);
                    lblMostrarFoto.setIcon(new ImageIcon(image));
                } else {
                    ImageIcon icono = new ImageIcon("src/aplicativo/icon/jpg/foto_fondo.jpg");
                    lblMostrarFoto.setIcon(icono);
                }               
                 // Datos de la tabla Usuario
                codUser.setText(tabla.getValueAt(fila, 10).toString());
                PassUser.setText(tabla.getValueAt(fila, 11).toString());
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al seleccionar el Doctor: " + e.toString());
        }
    }

    public void MostrarTablaDoctor(JTable tabla) {
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
        modelo.addColumn("Especialidad");             
        modelo.addColumn("Foto");                
        modelo.addColumn("CodUser");    
        modelo.addColumn("PassUser");    
        tabla.setModel(modelo);

        // Consulta SQL corregida
        String sql = "SELECT d.Id_Doctor, d.Nombre, d.Apellido, d.Dni, d.Fecha_Nacimiento, d.Telefono, "
                   + "d.Direccion, d.Email, d.Especialidad, d.Foto, u.Codigo_Usuario, u.Contraseña "
                   + "FROM Doctor d "
                   + "LEFT JOIN Usuario u ON d.Id_Doctor = u.Id_doctor";

        Object[] datos = new Object[14]; // Cambiado a tamaño 14

        try (Connection conn = objCon.EstablecerConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                datos[0] = rs.getString("Id_Doctor");
                datos[1] = rs.getString("Nombre");
                datos[2] = rs.getString("Apellido");
                datos[3] = rs.getString("Dni");
                datos[4] = rs.getString("Fecha_Nacimiento");                
                datos[5] = rs.getString("Telefono");
                datos[6] = rs.getString("Direccion");
                datos[7] = rs.getString("Email");
                datos[8] = rs.getString("Especialidad");
                datos[9] = rs.getBytes("Foto");                
                datos[10] = rs.getString("Codigo_Usuario");
                datos[11] = rs.getString("Contraseña");
                modelo.addRow(datos);
            }
            tabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se conectó correctamente, error: " + e.toString());
        } 
    }

    public boolean InsertardoctorYUsuario(ModelDoctor doctor, ModelUsuario usuario) {
        CConexion objCon = new CConexion();
        String sqldoctor = "INSERT INTO Doctor (Nombre, Apellido, Dni, Fecha_Nacimiento, Telefono, Direccion, Email, Especialidad, Foto)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlUsuario = "INSERT INTO Usuario (Codigo_Usuario, Contraseña, Id_Rol, Id_Doctor, Foto, FechaRegistro) "
                + "VALUES (?, ?, ?, ?, ?, GETDATE())";

        try (Connection conn = objCon.EstablecerConexion()) {
            conn.setAutoCommit(false);

            // Insertar en doctores
            try (PreparedStatement pstDoc = conn.prepareStatement(sqldoctor, Statement.RETURN_GENERATED_KEYS)) {
                pstDoc.setString(1, doctor.getNombre());
                pstDoc.setString(2, doctor.getApellido());
                pstDoc.setString(3, doctor.getDni());
                pstDoc.setDate(4, new java.sql.Date(doctor.getFecha_Nacimiento().getTime()));
                pstDoc.setString(5, doctor.getTelefono());
                pstDoc.setString(6, doctor.getDireccion());
                pstDoc.setString(7, doctor.getEmail());
                pstDoc.setString(8, doctor.getEspecialidad());
                pstDoc.setBytes(9, doctor.getFoto());                
                pstDoc.executeUpdate();

                // Obtener el ID del doctor
                ResultSet rsDoc = pstDoc.getGeneratedKeys();
                int Id_Doctor = 0;
                if (rsDoc.next()) {
                    Id_Doctor = rsDoc.getInt(1);
                }

                // Insertar en Usuarios
                try (PreparedStatement pstUsu = conn.prepareStatement(sqlUsuario)) {
                    pstUsu.setString(1, usuario.getCodigo_Usuario());
                    pstUsu.setString(2, usuario.getContraseña());
                    pstUsu.setInt(3, usuario.getRolID());
                    pstUsu.setInt(4, Id_Doctor);
                    pstUsu.setBytes(5, usuario.getFoto());                    
                    pstUsu.executeUpdate();
                }

                // Confirmar la transacción
                conn.commit();
                return true;
            } catch (SQLException ex) {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Error al insertar Doctor y usuario: " + ex.getMessage());
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar: " + e.toString());
            return false;
        }
    }

    public void Modificardoctor(JTextField txtCodDoc, JTextField txtNomDoc, JTextField txtApellidosDoc, JTextField txtDNIDoc, JDateChooser jFechaNa,
            JTextField txtTelefonoDoc, JTextField txtDireccionDoc, JTextField txtCorreoDoc, JTextField txtEspecialidad, JLabel lblMostrarFoto, 
            JTextField txtFotoRuta, JTextField txtUsuarioLogin, JTextField txtContraseñaLogin) {
        
        Connection con = null;
        CallableStatement cs = null;
        CConexion objCon = new CConexion();
        try {                      
            String sql = "UPDATE Doctor SET Nombre = ?, Apellido = ?, Dni = ?, Fecha_Nacimiento = ?, Telefono = ?, Direccion = ?, Email = ?, Especialidad = ?, Foto = ? " +
                         "WHERE Id_Doctor = ?";
            cs=objCon.EstablecerConexion().prepareCall(sql);
            cs.setString(1, txtNomDoc.getText());
            cs.setString(2, txtApellidosDoc.getText());
            cs.setString(3, txtDNIDoc.getText());
            // Convertir la fecha de JDateChooser a un tipo de dato SQL
            java.util.Date fecha = jFechaNa.getDate();
            java.sql.Date fechaSQL = (fecha != null) ? new java.sql.Date(fecha.getTime()) : null;
            cs.setDate(4, fechaSQL);
            cs.setString(5, txtTelefonoDoc.getText());            
            cs.setString(6, txtDireccionDoc.getText());
            cs.setString(7, txtCorreoDoc.getText());
            cs.setString(8, txtEspecialidad.getText());

            // Cargar la foto desde el archivo seleccionado, si existe
            if (!txtFotoRuta.getText().isEmpty()) {
                FileInputStream fis = new FileInputStream(txtFotoRuta.getText());
                cs.setBinaryStream(9, fis, (int) new File(txtFotoRuta.getText()).length());
            } else {
                cs.setNull(9, java.sql.Types.BLOB);
            }

            cs.setInt(10, Integer.parseInt(txtCodDoc.getText())); // ID del Doctor

            // Ejecutar la consulta
            int rowsUpdated = cs.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "¡Datos del Doctor modificados exitosamente!");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar los datos del Doctor. Verifica el ID.");
            }
            // Actualizar también los datos del usuario si es necesario
            String sqlUsuario = "UPDATE Usuario SET Contraseña = ?, Foto = ? WHERE Id_Doctor = ?";
            cs = objCon.EstablecerConexion().prepareCall(sqlUsuario);
            cs.setString(1, txtContraseñaLogin.getText());
            if (!txtFotoRuta.getText().isEmpty()) {
                FileInputStream fis = new FileInputStream(txtFotoRuta.getText());
                cs.setBinaryStream(2, fis, (int) new File(txtFotoRuta.getText()).length());
            } else {
                cs.setNull(2, java.sql.Types.BLOB);
            }
            cs.setInt(3, Integer.parseInt(txtCodDoc.getText())); // Usar Id_Doctor para identificar al usuario relacionado

            rowsUpdated = cs.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "¡Datos del usuario modificados exitosamente!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el Doctor: " + e.getMessage());
        } finally {
            try {
                if (cs != null) cs.close();
                if (con != null) con.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }

    public void EliminarDoctor(JTextField txtCodUser,JTextField txtCodDoc) {
        CConexion objc=new CConexion();
        
        String query= "DELETE FROM Usuario WHERE Usuario.Codigo_Usuario=?";       
        String query2= "DELETE FROM Doctor WHERE Doctor.Id_Doctor=?";
        System.out.println("Codigo Usuario: "+ txtCodUser.getText());
        try {            
            CallableStatement cs=objc.EstablecerConexion().prepareCall(query);
            cs.setString(1, txtCodUser.getText());
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "USUARIO ELIMINADO");
            
            cs=objc.EstablecerConexion().prepareCall(query2);
            cs.setInt(1,Integer.parseInt(txtCodDoc.getText()));
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "DOCTOR ELIMINADO");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar eliminar"+e.toString());
        }  
    }

    public void MostrarDoctoresCombo(JComboBox<String> Comb) {
        CConexion objCon = new CConexion();
        String sql = "SELECT CONCAT(Nombre, ' ', Apellido) AS NombreDoctor FROM Doctor";  
        Statement st;
        try {
            st = objCon.EstablecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String nombre = rs.getString("NombreDoctor");
                Comb.addItem(nombre);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se conecto correctamente, error:" + e.toString());
        } 
    }

    public int obtenerIdDoctorPorNombreCompleto(String nombreCompleto) {
        int idDoctor = -1; // Valor predeterminado si no se encuentra
        String sql = "SELECT Id_Doctor FROM Doctor WHERE CONCAT(Nombre, ' ', Apellido) = ?";

        // Crear una instancia de la conexión
        CConexion objCon = new CConexion();

        try (Connection conn = objCon.EstablecerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombreCompleto);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    idDoctor = rs.getInt("Id_Doctor");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener el ID del doctor: " + e.getMessage());
        }
        return idDoctor;
    }
}
