package Hospital.Dao;

import Hospital.Conexion.CConexion;
import Hospital.Conexion.UserSession;
import Hospital.Modelo.ModelUsuario;
//import javax.swing.JOptionPane;
import java.sql.*;
/**
 * @author Wilson
 */
public class CUsuarioDAO {
    public ModelUsuario autenticarUsuario(String codigoUsuario, String contraseña) {
        CConexion objc = new CConexion();
        String query = "SELECT u.Id_Usuario, u.Codigo_Usuario, u.Contraseña, u.Id_Rol, u.Foto, " +
                       "CASE " +
                       "  WHEN u.Id_Doctor IS NOT NULL THEN " +
                       "    (SELECT CONCAT(d.Nombre, ' ', d.Apellido) FROM Doctor d WHERE d.Id_Doctor = u.Id_Doctor) " +
                       "  WHEN u.Id_Enfermera IS NOT NULL THEN " +
                       "    (SELECT CONCAT(e.Nombre, ' ', e.Apellido) FROM Enfermera e WHERE e.Id_Enfermera = u.Id_Enfermera) " +
                       "  WHEN u.Id_Paciente IS NOT NULL THEN " +
                       "    (SELECT CONCAT(p.Nombre, ' ', p.Apellido) FROM Paciente p WHERE p.Id_Paciente = u.Id_Paciente) " +
                       "  ELSE 'Usuario General' " +
                       "END AS NombreCompleto " +
                       "FROM Usuario u " +
                       "WHERE u.Codigo_Usuario = ? AND u.Contraseña = ?";
        try (PreparedStatement ps = objc.EstablecerConexion().prepareStatement(query)) {
            ps.setString(1, codigoUsuario);
            ps.setString(2, contraseña);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ModelUsuario usuario = new ModelUsuario();
                usuario.setUsuarioID(rs.getInt("Id_Usuario"));
                usuario.setCodigo_Usuario(rs.getString("Codigo_Usuario"));
                usuario.setRolID(rs.getInt("Id_Rol"));
                usuario.setFoto(rs.getBytes("Foto")); // Foto como bytes
                usuario.setNombreCompleto(rs.getString("NombreCompleto")); // Nombre completo del usuario

                // Establecer los datos en la sesión del usuario
                UserSession.setUsuarioID(rs.getInt("Id_Usuario"));
                UserSession.setNombreUsuario(rs.getString("Codigo_Usuario"));
                UserSession.setRolId(rs.getInt("Id_Rol"));
                UserSession.setFoto(rs.getBytes("Foto"));
                UserSession.setNombreCompleto(rs.getString("NombreCompleto"));

                return usuario; // Devolver el modelo del usuario autenticado
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Usa un logger en un entorno real
        }
        return null; // Usuario no encontrado
    }
}



