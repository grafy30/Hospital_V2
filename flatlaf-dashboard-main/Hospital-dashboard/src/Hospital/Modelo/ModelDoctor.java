package Hospital.Modelo;

import java.util.Date;
/**
 * @author Wilson
 */
public class ModelDoctor {
    private int Id_doctor;
    private String Nombre;
    private String Apellido;
    private String Dni;
    private Date Fecha_Nacimiento;
    private String Telefono;
    private String Direccion;
    private String Email;
    private String Especialidad;    
    private byte [] Foto;    

    public ModelDoctor() {
    }

    public int getId_doctor() {
        return Id_doctor;
    }

    public void setId_doctor(int Id_doctor) {
        this.Id_doctor = Id_doctor;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String Dni) {
        this.Dni = Dni;
    }

    public Date getFecha_Nacimiento() {
        return Fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(Date Fecha_Nacimiento) {
        this.Fecha_Nacimiento = Fecha_Nacimiento;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }

    public byte[] getFoto() {
        return Foto;
    }

    public void setFoto(byte[] Foto) {
        this.Foto = Foto;
    }
    
    @Override
    public String toString() {
        return Nombre + " " + Apellido; // Lo que aparecerá en el JComboBox
    }
            
    //Cosntructor
    
    public ModelDoctor(int Id_doctor, String Nombre, String Apellido, String Dni, Date Fecha_Nacimiento, String Telefono, String Direccion, String Email, String Especialidad, byte[] Foto) {
        this.Id_doctor = Id_doctor;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Dni = Dni;
        this.Fecha_Nacimiento = Fecha_Nacimiento;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
        this.Email = Email;
        this.Especialidad = Especialidad;
        this.Foto = Foto;
    }
   
}
