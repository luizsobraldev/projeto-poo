public class ItemDoPedido {
    private String nomeItem;
    private double valor;
    private double peso;
    private String observacoes; // Remover acento para seguir convenções Java

    public ItemDoPedido(String nomeItem, double valor, double peso, String observacoes) {
        this.nomeItem = nomeItem;
        this.valor = valor;
        this.peso = peso;
        this.observacoes = observacoes;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
