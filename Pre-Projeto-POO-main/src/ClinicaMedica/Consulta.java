public class Consulta{
    
    private Paciente paciente;
    private Medico medico;
    private String data;
    private String hora;
    private boolean realizada;

    public Consulta(Paciente paciente, Medico medico, String data, String hora) {
        this.paciente = paciente;
        this.medico = medico;
        this.data = data;
        this.hora = hora;
        this.realizada = false;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    public boolean isRealizada() {
        return realizada;
    }

    public void setRealizada(boolean realizada) {
        this.realizada = realizada;
    }

    @Override
    public String toString() {
        return "Consulta com " + medico.getNome() + " para o paciente " + paciente.getNome() +
                " no dia " + data + " às " + hora + ". Realizada: " + (realizada ? "Sim" : "Não");
    }

}