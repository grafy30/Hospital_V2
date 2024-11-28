package Hospital.Modelo;
import java.util.Date;

/**
 * @author Wilson
 */
public class ModelEnfermera {

    private int Id_Enfermera;
    private String Nombre;
    private String Apellido;
    private String Dni;
    private Date Fecha_Nacimiento;
    private String Telefono;
    private String Direccion;
    private String Email;
    private byte [] Foto;
    
    public ModelEnfermera() {
    }

    public int getId_Enfermera() {
        return Id_Enfermera;
    }

    public void setId_Enfermera(int Id_Enfermera) {
        this.Id_Enfermera = Id_Enfermera;
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

    public byte[] getFoto() {
        return Foto;
    }

    public void setFoto(byte[] Foto) {
        this.Foto = Foto;
    }

    public ModelEnfermera(int Id_Enfermera, String Nombre, String Apellido, String Dni, Date Fecha_Nacimiento, String Telefono, String Direccion, String Email, byte[] Foto) {
        this.Id_Enfermera = Id_Enfermera;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Dni = Dni;
        this.Fecha_Nacimiento = Fecha_Nacimiento;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
        this.Email = Email;
        this.Foto = Foto;
    }                
}
