package Hospital.Modelo;

/**
 * @author Wilson
 */
public class ModelCita {
    private int Id_Cita;
    private String Id_Paciente;
    private String Id_Doctor;
    private String Fecha_cita;
    private String Motivo;

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

    public String getFecha_cita() {
        return Fecha_cita;
    }

    public void setFecha_cita(String Fecha_cita) {
        this.Fecha_cita = Fecha_cita;
    }

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String Motivo) {
        this.Motivo = Motivo;
    }

    public ModelCita(int Id_Cita, String Id_Paciente, String Id_Doctor, String Fecha_cita, String Motivo) {
        this.Id_Cita = Id_Cita;
        this.Id_Paciente = Id_Paciente;
        this.Id_Doctor = Id_Doctor;
        this.Fecha_cita = Fecha_cita;
        this.Motivo = Motivo;
    }            
}
