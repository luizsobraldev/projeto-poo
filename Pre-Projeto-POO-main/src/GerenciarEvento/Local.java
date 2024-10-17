public class Local {
    
    private String nome;
    private String endereco;
    private int capacidade;
    private double area;

    public Local(int capacidade, double area, String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.capacidade = capacidade;
        this.area = area;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio ou nulo");
        }
        this.nome = nome.trim();
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new IllegalArgumentException("Endereço não pode ser vazio ou nulo");
        }
        this.endereco = endereco.trim();
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        if (capacidade <= 0) {
            throw new IllegalArgumentException("Capacidade deve ser maior que 0");
        }
        this.capacidade = capacidade;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        if (area <= 0) {
            throw new IllegalArgumentException("Área deve ser maior que 0");
        }
        this.area = area;
    }

    
}