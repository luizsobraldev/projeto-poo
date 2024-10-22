public class Participante {
    private String inscricao;
    private String cpf;
    private Local local;
    private String data;
    private String hora;

    public Participante(String inscricao, String cpf, Local local, String data, String hora) {
        this.inscricao = inscricao;
        this.cpf = cpf;
        this.local = local;
        this.data = data;
        this.hora = hora;
    }

    public String getInscricao() {
        return inscricao;
    }

    public void setInscricao(String inscricao) {
        this.inscricao = inscricao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
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
}
