public class Participante {
    private String inscrição;
    private String cpf;
    private Local local;
    private String data;
    private String hora;

    public Participante(String inscrição, String cpf) {
        // Validação de inscrição e CPF
        if(inscrição == null || inscrição.isEmpty()) throw new IllegalArgumentException("Inscrição não pode ser vazia");
        if(cpf == null || cpf.isEmpty() || cpf.length() != 11) throw new IllegalArgumentException("CPF inválido");
        this.inscrição = inscrição;
        this.cpf = cpf;
    }

    public String getInscrição() {
        return inscrição;
    }

    public void setInscrição(String inscrição) {
        if(inscrição == null || inscrição.isEmpty()) throw new IllegalArgumentException("Inscrição não pode ser vazia");
        this.inscrição = inscrição;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if(cpf == null || cpf.isEmpty() || cpf.length() != 11) throw new IllegalArgumentException("CPF inválido");
        this.cpf = cpf;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        if(local == null) throw new IllegalArgumentException("Local não pode ser nulo");
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
