
package Hospital.Dao;

import Hospital.Conexion.CConexion;
import Hospital.Modelo.ModelCita;
import Hospital.Modelo.ModelDoctor;
import Hospital.Modelo.ModelPaciente;
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
public class CCitaDAO {

    public void MostrarTablaCita(JTable tablaCitas) {
        CConexion objCon = new CConexion();  
        DefaultTableModel modelo = new DefaultTableModel();
        // Definir las columnas de la tabla
        modelo.addColumn("Nº");
        modelo.addColumn("ID");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");                           
        modelo.addColumn("Doctor");                           
        modelo.addColumn("FechaCita");                           
        modelo.addColumn("Motivo");                           
        modelo.addColumn("Foto");                   
        tablaCitas.setModel(modelo);

        String sql = "SELECT c.Id_Cita, c.Id_Paciente, p.Nombre, p.Apellido, c.Id_Doctor, c.Fecha_Cita, c.Motivo, p.Foto FROM Citas c "
                + "LEFT JOIN Paciente p ON p.Id_Paciente = c.Id_Paciente "
                + "ORDER BY c.Fecha_Cita ASC;";

        Object[] datos = new Object[8]; 

        try (Connection conn = objCon.EstablecerConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                datos[0] = rs.getString("Id_Cita");
                datos[1] = rs.getString("Id_Paciente");
                datos[2] = rs.getString("Nombre");               
                datos[3] = rs.getString("Apellido");               
                datos[4] = rs.getString("Id_Doctor");               
                datos[5] = rs.getString("Fecha_Cita");               
                datos[6] = rs.getString("Motivo");               
                datos[7] = rs.getBytes("Foto");                
                modelo.addRow(datos);
            }
            tablaCitas.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se conectó correctamente, error: " + e.toString());
        } 
    }

    public boolean InsertarCita(ModelPaciente paciente, ModelCita cita, ModelDoctor doc) {
        CConexion objCon = new CConexion();
        
        String sqlCita = "INSERT INTO Citas (Id_Paciente, Id_doctor, Fecha_Cita, Motivo)"
                + "VALUES (?, ?, ?, ?)";

        try (Connection conn = objCon.EstablecerConexion()) {
            conn.setAutoCommit(false);

            // Insertar en Cita
            try (PreparedStatement pstCita = conn.prepareStatement(sqlCita, Statement.RETURN_GENERATED_KEYS)) {
                pstCita.setInt(1, paciente.getId_Paciente());
                pstCita.setInt(2, doc.getId_doctor());
                pstCita.setDate(3, new java.sql.Date(cita.getFecha_cita().getTime()));
                pstCita.setString(4, cita.getMotivo());                              
                pstCita.executeUpdate();

                // Obtener el ID del Paciente
                ResultSet rs = pstCita.getGeneratedKeys();
                int Id_Paciente = 0;
                if (rs.next()) {
                    Id_Paciente = rs.getInt(1);
                }
                conn.commit();
                return true;
            } catch (SQLException ex) {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Error al Insertar Paciente y usuario: " + ex.getMessage());
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar: " + e.toString());
            return false;
        }
    }

    public void SeleccionarCitas(JTable tabla, JTextField txtCodCita, JTextField txtCodPaciente, 
            JTextField txtNomPaciente, JTextField txtApellidosPaciente, JComboBox<String> jComboBoxDoctor,
            JDateChooser jFechaCita, JTextField txtMotivoPaciente, JLabel lblMostrarFoto) {
        try {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                txtCodCita.setText(tabla.getValueAt(fila, 0).toString());
                txtCodPaciente.setText(tabla.getValueAt(fila, 1).toString());
                txtNomPaciente.setText(tabla.getValueAt(fila, 2).toString());
                txtApellidosPaciente.setText(tabla.getValueAt(fila, 3).toString());
                String doc = (tabla.getValueAt(fila, 4) != null) ? tabla.getValueAt(fila, 4).toString() : "";
                int iddoc=Integer.parseInt(doc);
                System.out.println("id doctor: "+iddoc);
                
                if (!doc.isEmpty()) {
                    CDoctorDAO doctorDAO = new CDoctorDAO();
                    ModelDoctor nombrecom = doctorDAO.obtenerDoctorPorId(iddoc);
                    if (nombrecom != null) {
                        String nomDoc = nombrecom.getNombre();
                        String apelDoc = nombrecom.getApellido();
                        String NomComple = nomDoc + " " + apelDoc;
                        jComboBoxDoctor.setSelectedItem(NomComple);
                    } else {
                        JOptionPane.showMessageDialog(null, "El doctor con ID " + iddoc + " no fue encontrado.");
                        jComboBoxDoctor.setSelectedIndex(0);
                    }
                } else {
                    jComboBoxDoctor.setSelectedIndex(0);
                }
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Object fechaCita = tabla.getValueAt(fila, 5);
                if (fechaCita != null) {
                    java.util.Date fechanacstr = dateFormat.parse(fechaCita.toString());
                    jFechaCita.setDate(fechanacstr);
                } else {
                    jFechaCita.setDate(null);
                }
                txtMotivoPaciente.setText(tabla.getValueAt(fila, 6).toString());
                                                                
                byte[] fotoBytes = (byte[]) tabla.getValueAt(fila, 7);
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

    public void ModificarCita(JTextField txtCodCita, JComboBox<String> jComboBoxDoctor, JDateChooser jFechaCita, JTextField txtMotivoPaciente) {
        Connection con = null;
        CallableStatement cs = null;
        CConexion objCon = new CConexion();
        try {                      
            String sql = "UPDATE Citas SET Id_Doctor = ?, Fecha_Cita = ?, Motivo = ? WHERE Id_Cita = ?";
            cs = objCon.EstablecerConexion().prepareCall(sql);

            // Obtener el nombre completo del doctor seleccionado
            String nombreCompleto = (String) jComboBoxDoctor.getSelectedItem();
            if (nombreCompleto != null && !nombreCompleto.isEmpty()) {
                CDoctorDAO doctorDAO = new CDoctorDAO();
                int idDoctor = doctorDAO.obtenerIdDoctorPorNombreCompleto(nombreCompleto); // Usar el método existente

                if (idDoctor > 0) {
                    cs.setInt(1, idDoctor); // Establecer el ID del doctor en el SQL
                } else {
                    JOptionPane.showMessageDialog(null, "El doctor seleccionado no fue encontrado.");
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un doctor válido.");
                return;
            }

            // Configurar fecha y motivo
            java.util.Date fecha = jFechaCita.getDate();
            java.sql.Date fechaSQL = (fecha != null) ? new java.sql.Date(fecha.getTime()) : null;
            cs.setDate(2, fechaSQL);
            cs.setString(3, txtMotivoPaciente.getText());                                
            cs.setInt(4, Integer.parseInt(txtCodCita.getText()));

            // Ejecutar la consulta
            int rowsUpdated = cs.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "¡CITA MODIFICADA!");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar los datos de la cita. Verifica el ID.");
            }           

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar la Cita: " + e.getMessage());
        } finally {
            try {
                if (cs != null) cs.close();
                if (con != null) con.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }    

    public void EliminarCita(JTextField txtCodCita) {
        CConexion objc=new CConexion();
        
        String sql= "DELETE FROM Citas WHERE Id_Cita=?";       

        System.out.println("Codigo Usuario: "+ txtCodCita.getText());
        try {            
            CallableStatement cs=objc.EstablecerConexion().prepareCall(sql);
            cs.setString(1, txtCodCita.getText());
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "CITA ELIMINADA");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar eliminar"+e.toString());
        }  
    }
}
