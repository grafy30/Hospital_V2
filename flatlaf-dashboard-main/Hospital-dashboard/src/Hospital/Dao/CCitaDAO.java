
package Hospital.Dao;

import Hospital.Conexion.CConexion;
import Hospital.Modelo.ModelCita;
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
                + "ORDER BY c.Fecha_Cita DESC;";

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

    public boolean InsertarCita(ModelPaciente paciente, ModelCita cita) {
        CConexion objCon = new CConexion();
        
        String sqlCita = "INSERT INTO Citas (Id_Paciente, Id_doctor, Fecha_Cita, Motivo)"
                + "VALUES (?, ?, ?, ?)";

        try (Connection conn = objCon.EstablecerConexion()) {
            conn.setAutoCommit(false);

            // Insertar en Cita
            try (PreparedStatement pstCita = conn.prepareStatement(sqlCita, Statement.RETURN_GENERATED_KEYS)) {
                pstCita.setString(1, cita.getId_Paciente());
                pstCita.setString(2, cita.getId_Doctor());
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
    
}
