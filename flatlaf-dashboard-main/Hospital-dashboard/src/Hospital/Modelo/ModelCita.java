package Hospital.Modelo;

import java.util.Date;
/**
 * @author Wilson
 */
public class ModelCita {
    private int Id_Cita;
    private String Id_Paciente;
    private String Id_Doctor;
    private Date Fecha_cita;
    private String Motivo;
    private byte [] Foto;   

    public ModelCita() {
    }

    public int getId_Cita() {
        return Id_Cita;
    }

    public void setId_Cita(int Id_Cita) {
        this.Id_Cita = Id_Cita;
    }

    public String getId_Paciente() {
        return Id_Paciente;
    }

    public void setId_Paciente(String Id_Paciente) {
        this.Id_Paciente = Id_Paciente;
    }

    public String getId_Doctor() {
        return Id_Doctor;
    }

    public void setId_Doctor(String Id_Doctor) {
        this.Id_Doctor = Id_Doctor;
    }

    public Date getFecha_cita() {
        return Fecha_cita;
    }

    public void setFecha_cita(Date Fecha_cita) {
        this.Fecha_cita = Fecha_cita;
    }

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String Motivo) {
        this.Motivo = Motivo;
    }

    public byte[] getFoto() {
        return Foto;
    }

    public void setFoto(byte[] Foto) {
        this.Foto = Foto;
    }

    public ModelCita(int Id_Cita, String Id_Paciente, String Id_Doctor, Date Fecha_cita, String Motivo, byte[] Foto) {
        this.Id_Cita = Id_Cita;
        this.Id_Paciente = Id_Paciente;
        this.Id_Doctor = Id_Doctor;
        this.Fecha_cita = Fecha_cita;
        this.Motivo = Motivo;
        this.Foto = Foto;
    }  
}
