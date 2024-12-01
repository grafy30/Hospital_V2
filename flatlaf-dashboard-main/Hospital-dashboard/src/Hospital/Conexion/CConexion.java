package Hospital.Conexion;

import javax.swing.JOptionPane;
import java.sql.*;

//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;


public class CConexion {
     Connection conectar=null;
    
    String puerto="1433";
    String bd="Hospital_V2";
    String usuario="admin";
    String password="1234";
    String ip="localhost";
    
    public Connection EstablecerConexion()    
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String cadena="jdbc:sqlserver://"+ip+":"+puerto+";"+"databaseName="+bd+";"+
                       "encrypt=true;trustServerCertificate=true";
            conectar=DriverManager.getConnection(cadena,usuario,password);
//            JOptionPane.showMessageDialog(null, "Conexion exitosa");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontro la conexion"+e);
        }
        return conectar;
    }       
}
