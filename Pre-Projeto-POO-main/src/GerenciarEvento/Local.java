public class Local {
    private int capacidade;
    private double área;
    private String nome;
    private String endereço;

    public Local(int capacidade, double área, String nome, String endereço) {
        if(capacidade <= 0) throw new IllegalArgumentException("Capacidade deve ser maior que 0");
        if(área <= 0) throw new IllegalArgumentException("Área deve ser maior que 0");
        if(nome == null || nome.isEmpty()) throw new IllegalArgumentException("Nome não pode ser vazio");
        if(endereço == null || endereço.isEmpty()) throw new IllegalArgumentException("Endereço não pode ser vazio");

        this.capacidade = capacidade;
        this.área = área;
        this.nome = nome;
        this.endereço = endereço;
    }

    // Getters e Setters com validação
    public void setCapacidade(int capacidade) {
        if(capacidade <= 0) throw new IllegalArgumentException("Capacidade deve ser maior que 0");
        this.capacidade = capacidade;
    }

    public void setÁrea(double área) {
        if(área <= 0) throw new IllegalArgumentException("Área deve ser maior que 0");
        this.área = área;
    }

    public void setNome(String nome) {
        if(nome == null || nome.isEmpty()) throw new IllegalArgumentException("Nome não pode ser vazio");
        this.nome = nome;
    }

    public void setEndereço(String endereço) {
        if(endereço == null || endereço.isEmpty()) throw new IllegalArgumentException("Endereço não pode ser vazio");
        this.endereço = endereço;
    }
}
