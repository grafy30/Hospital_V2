package Hospital.Dao;

import Hospital.Conexion.CConexion;
import Hospital.Modelo.ModelPaciente;
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
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;



/**
 *
 * @author Wilson
 */
public class CPacienteDAO {
    public void SeleccionarPaciente(JTable tabla, JTextField txtCodPacie, JTextField txtNomPacie, JTextField txtApellidosPacie, JTextField txtDNIPacie,
                                JDateChooser jFechaNa, JTextField txtTelefonoPacie, JTextField txtDireccionPacie, JTextField txtCorreoPacie,
                                JLabel lblMostrarFoto, JTextField codUser,JTextField PassUser) {
                                      
        try {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                txtCodPacie.setText(tabla.getValueAt(fila, 0).toString());
                txtNomPacie.setText(tabla.getValueAt(fila, 1).toString());
                txtApellidosPacie.setText(tabla.getValueAt(fila, 2).toString());
                txtDNIPacie.setText(tabla.getValueAt(fila, 3).toString());
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Object fechaEntregaObj = tabla.getValueAt(fila, 4);
                if (fechaEntregaObj != null) {
                    java.util.Date fechanacstr = dateFormat.parse(fechaEntregaObj.toString());
                    jFechaNa.setDate(fechanacstr);
                } else {
                    jFechaNa.setDate(null);
                }                
                txtTelefonoPacie.setText(tabla.getValueAt(fila, 5).toString());                               
                txtDireccionPacie.setText(tabla.getValueAt(fila, 6).toString());
                txtCorreoPacie.setText(tabla.getValueAt(fila, 7).toString());

                // Cargar la foto del Pacientev si está disponible
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
            JOptionPane.showMessageDialog(null, "Error al seleccionar el Paciente: " + e.toString());
        }
    }

    public void MostrarTablaPaciente(JTable tabla) {
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
        String sql = "SELECT p.Id_Paciente, p.Nombre, p.Apellido, p.Dni, p.Fecha_Nacimiento, p.Telefono, "
                   + "p.Direccion, p.Email, p.Foto, u.Codigo_Usuario, u.Contraseña "
                   + "FROM Paciente p "
                   + "LEFT JOIN Usuario u ON p.Id_Paciente = u.Id_Paciente";

        Object[] datos = new Object[11]; // Cambiado a tamaño 14

        try (Connection conn = objCon.EstablecerConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                datos[0] = rs.getString("Id_Paciente");
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

    public boolean InsertarPacienteYUsuario(ModelPaciente Paciente, ModelUsuario usuario) {
        CConexion objCon = new CConexion();
        String sqlPaciente = "INSERT INTO Paciente (Nombre, Apellido, Dni, Fecha_Nacimiento, Telefono, Direccion, Email, Foto)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlUsuario = "INSERT INTO Usuario (Codigo_Usuario, Contraseña, Id_Rol, Id_Paciente, Foto, FechaRegistro) "
                + "VALUES (?, ?, ?, ?, ?, GETDATE())";

        try (Connection conn = objCon.EstablecerConexion()) {
            conn.setAutoCommit(false);

            // Insertar en Paciente
            try (PreparedStatement pstPacie = conn.prepareStatement(sqlPaciente, Statement.RETURN_GENERATED_KEYS)) {
                pstPacie.setString(1, Paciente.getNombre());
                pstPacie.setString(2, Paciente.getApellido());
                pstPacie.setString(3, Paciente.getDni());
                pstPacie.setDate(4, new java.sql.Date(Paciente.getFecha_Nacimiento().getTime()));
                pstPacie.setString(5, Paciente.getTelefono());
                pstPacie.setString(6, Paciente.getDireccion());
                pstPacie.setString(7, Paciente.getEmail());                
                pstPacie.setBytes(8, Paciente.getFoto());                
                pstPacie.executeUpdate();

                // Obtener el ID del Paciente
                ResultSet rsPacie = pstPacie.getGeneratedKeys();
                int Id_Paciente = 0;
                if (rsPacie.next()) {
                    Id_Paciente = rsPacie.getInt(1);
                }

                // Insertar en Usuarios
                try (PreparedStatement pstUsu = conn.prepareStatement(sqlUsuario)) {
                    pstUsu.setString(1, usuario.getCodigo_Usuario());
                    pstUsu.setString(2, usuario.getContraseña());
                    pstUsu.setInt(3, usuario.getRolID());
                    pstUsu.setInt(4, Id_Paciente);
                    pstUsu.setBytes(5, usuario.getFoto());                    
                    pstUsu.executeUpdate();
                }

                // Confirmar la transacción
                conn.commit();
                return true;
            } catch (SQLException ex) {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Error al insertar Paciente y usuario: " + ex.getMessage());
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar: " + e.toString());
            return false;
        }
    }

    public void ModificarPaciente(JTextField txtCodPacie, JTextField txtNomPacie, JTextField txtApellidosPacie, JTextField txtDNIPacie, JDateChooser jFechaNa,
            JTextField txtTelefonoPacie, JTextField txtDireccionPacie, JTextField txtCorreoPacie, JLabel lblMostrarFoto, 
            JTextField txtFotoRuta, JTextField txtUsuarioLogin, JTextField txtContraseñaLogin) {
        
        Connection con = null;
        CallableStatement cs = null;
        CConexion objCon = new CConexion();
        try {                      
            String sql = "UPDATE Paciente SET Nombre = ?, Apellido = ?, Dni = ?, Fecha_Nacimiento = ?, Telefono = ?, Direccion = ?, Email = ?, Foto = ? " +
                         "WHERE Id_Paciente = ?";
            cs=objCon.EstablecerConexion().prepareCall(sql);
            cs.setString(1, txtNomPacie.getText());
            cs.setString(2, txtApellidosPacie.getText());
            cs.setString(3, txtDNIPacie.getText());
            // Convertir la fecha de JDateChooser a un tipo de dato SQL
            java.util.Date fecha = jFechaNa.getDate();
            java.sql.Date fechaSQL = (fecha != null) ? new java.sql.Date(fecha.getTime()) : null;
            cs.setDate(4, fechaSQL);
            cs.setString(5, txtTelefonoPacie.getText());            
            cs.setString(6, txtDireccionPacie.getText());
            cs.setString(7, txtCorreoPacie.getText());          

            // Cargar la foto desde el archivo seleccionado, si existe
            if (!txtFotoRuta.getText().isEmpty()) {
                FileInputStream fis = new FileInputStream(txtFotoRuta.getText());
                cs.setBinaryStream(8, fis, (int) new File(txtFotoRuta.getText()).length());
            } else {
                cs.setNull(8, java.sql.Types.BLOB);
            }

            cs.setInt(9, Integer.parseInt(txtCodPacie.getText())); // ID del Paciente

            // Ejecutar la consulta
            int rowsUpdated = cs.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "¡Datos de la Paciente modificados exitosamente!");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar los datos del Paciente. Verifica el ID.");
            }
            // Actualizar también los datos del usuario si es necesario
            String sqlUsuario = "UPDATE Usuario SET Contraseña = ?, Foto = ? WHERE Id_Paciente = ?";
            cs = objCon.EstablecerConexion().prepareCall(sqlUsuario);
            cs.setString(1, txtContraseñaLogin.getText());
            if (!txtFotoRuta.getText().isEmpty()) {
                FileInputStream fis = new FileInputStream(txtFotoRuta.getText());
                cs.setBinaryStream(2, fis, (int) new File(txtFotoRuta.getText()).length());
            } else {
                cs.setNull(2, java.sql.Types.BLOB);
            }
            cs.setInt(3, Integer.parseInt(txtCodPacie.getText())); // Usar Id_Paciente para identificar al usuario relacionado

            rowsUpdated = cs.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "¡Datos del usuario modificados exitosamente!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el Paciente: " + e.getMessage());
        } finally {
            try {
                if (cs != null) cs.close();
                if (con != null) con.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }

    public void EliminarPaciente(JTextField txtCodUser,JTextField txtCodPacie) {
        CConexion objc=new CConexion();        
        String query= "DELETE FROM Usuario WHERE Usuario.Codigo_Usuario=?";       
        String query2= "DELETE FROM Paciente WHERE Paciente.Id_Paciente=?";
        System.out.println("Codigo Usuario: "+ txtCodUser.getText());
        try {            
            CallableStatement cs=objc.EstablecerConexion().prepareCall(query);
            cs.setString(1, txtCodUser.getText());
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "USUARIO ELIMINADO");
            
            cs=objc.EstablecerConexion().prepareCall(query2);
            cs.setInt(1,Integer.parseInt(txtCodPacie.getText()));
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "PACIENTE ELIMINADO");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar eliminar"+e.toString());
        }  
    }

    public void SeleccionarPacienteCITA(JTable tabla, JTextField txtCodPaciente, JTextField txtNomPaciente, JTextField txtApellidosPaciente,
            JLabel lblMostrarFoto) {
        try {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                txtCodPaciente.setText(tabla.getValueAt(fila, 0).toString());
                txtNomPaciente.setText(tabla.getValueAt(fila, 1).toString());
                txtApellidosPaciente.setText(tabla.getValueAt(fila, 2).toString());
                byte[] fotoBytes = (byte[]) tabla.getValueAt(fila, 3);
                if (fotoBytes != null) {
                    ImageIcon imageIcon = new ImageIcon(fotoBytes);
                    Image image = imageIcon.getImage().getScaledInstance(lblMostrarFoto.getWidth(), lblMostrarFoto.getHeight(), Image.SCALE_SMOOTH);
                    lblMostrarFoto.setIcon(new ImageIcon(image));
                } else {
                    ImageIcon icono = new ImageIcon("src/aplicativo/icon/jpg/foto_fondo.jpg");
                    lblMostrarFoto.setIcon(icono);
                }               
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al seleccionar el Paciente: " + e.toString());
        }
    }
    
    public void MostrarTablaPacienteCITA(JTable tabla) {
        CConexion objCon = new CConexion();  
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("CodPaciente");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");                           
        modelo.addColumn("Foto");                   
        tabla.setModel(modelo);

        String sql = "SELECT u.Codigo_Usuario, p.Nombre, p.Apellido, p.Foto " 
                   + "FROM Paciente p " 
                   + "LEFT JOIN Usuario u ON p.Id_Paciente = u.Id_Paciente";

        Object[] datos = new Object[4]; 

        try (Connection conn = objCon.EstablecerConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                datos[0] = rs.getString("Codigo_Usuario"); 
                datos[1] = rs.getString("Nombre");        
                datos[2] = rs.getString("Apellido");      
                datos[3] = rs.getBytes("Foto");           

                modelo.addRow(datos);
            }
            tabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se conectó correctamente, error: " + e.toString());
        } 
}

    public void BusquedaPorNombre(String nombre, JTable tabla) {
//        String sql = "select l.id_libro,l.titulo,au.nombre,f.nombre,l.cantidad_copias,l.estado from Libros l inner join Facultades f on l.id_facultad=f.id_facultad inner join Autores au on l.id_autor=au.id_autor where l.titulo = '"+nombre+"'";
        CConexion con = new CConexion();        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("CodPaciente");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");                           
        modelo.addColumn("Foto"); 
        tabla.setModel(modelo);
        
        String sql = "SELECT u.Codigo_Usuario, p.Nombre, p.Apellido, p.Foto " 
                   + "FROM Paciente p " 
                   + "LEFT JOIN Usuario u ON p.Id_Paciente = u.Id_Paciente "
                   + "where p.Nombre = '"+nombre+"'";
        
        
        String [] datos = new String[4];
         
        List<String[]> resultados = new ArrayList<>();
        
        try (Connection conn = con.EstablecerConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)){
            while (rs.next()) {
                datos[0] =rs.getString(1);
                datos[1] =rs.getString(2);
                datos[2] =rs.getString(3);
                datos[3] =rs.getString(4);
                resultados.add(datos.clone());
            } 
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e.toString());                
        }
        // Realizar búsqueda secuencial en los resultados obtenidos
        for (String[] paciente : resultados) {
            if (paciente[1].toLowerCase().contains(nombre.toLowerCase())) {
                modelo.addRow(paciente);
            }       
        }        
    }

}
