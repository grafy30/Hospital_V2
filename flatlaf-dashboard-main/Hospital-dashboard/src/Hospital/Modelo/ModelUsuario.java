package Hospital.Modelo;

import java.util.Date;

public class ModelUsuario {
    private int UsuarioID;
    private String Codigo_Usuario;
    private String Contraseña;    
    private int RolID;    
    private int Id_Admin;
    private int Id_Doctor;
    private int Id_Enfermera;
    private int Id_Paciente;
    private byte [] Foto;  
    private Date FechaRegistro;
    private String NombreCompleto;

    public ModelUsuario() {
    }       

    public int getUsuarioID() {
        return UsuarioID;
    }

    public void setUsuarioID(int UsuarioID) {
        this.UsuarioID = UsuarioID;
    }

    public String getCodigo_Usuario() {
        return Codigo_Usuario;
    }

    public void setCodigo_Usuario(String Codigo_Usuario) {
        this.Codigo_Usuario = Codigo_Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public int getRolID() {
        return RolID;
    }

    public void setRolID(int RolID) {
        this.RolID = RolID;
    }

    public int getId_Admin() {
        return Id_Admin;
    }

    public void setId_Admin(int Id_Admin) {
        this.Id_Admin = Id_Admin;
    }
    
    public int getId_Doctor() {
        return Id_Doctor;
    }

    public void setId_Doctor(int Id_Doctor) {
        this.Id_Doctor = Id_Doctor;
    }

    public int getId_Enfermera() {
        return Id_Enfermera;
    }

    public void setId_Enfermera(int Id_Enfermera) {
        this.Id_Enfermera = Id_Enfermera;
    }

    public int getId_Paciente() {
        return Id_Paciente;
    }

    public void setId_Paciente(int Id_Paciente) {
        this.Id_Paciente = Id_Paciente;
    }
    
    public byte[] getFoto() {
        return Foto;
    }

    public void setFoto(byte[] Foto) {
        this.Foto = Foto;
    }

    public Date getFechaRegistro() {
        return FechaRegistro;
    }

    public void setFechaRegistro(Date FechaRegistro) {
        this.FechaRegistro = FechaRegistro;
    }
    
    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }
        
    //Constructor de la clase 

    public ModelUsuario(int UsuarioID, String Codigo_Usuario, String Contraseña, int RolID, int Id_Admin, int Id_Doctor, 
            int Id_Enfermera, int Id_Paciente, byte[] Foto, Date FechaRegistro, String NombreCompleto) {
        this.UsuarioID = UsuarioID;
        this.Codigo_Usuario = Codigo_Usuario;
        this.Contraseña = Contraseña;
        this.RolID = RolID;
        this.Id_Admin = Id_Admin;
        this.Id_Doctor = Id_Doctor;
        this.Id_Enfermera = Id_Enfermera;
        this.Id_Paciente = Id_Paciente;
        this.Foto = Foto;
        this.FechaRegistro = FechaRegistro;
        this.NombreCompleto = NombreCompleto;
    }
}
