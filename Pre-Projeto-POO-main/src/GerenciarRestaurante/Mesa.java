public class Mesa {
    private String cliente;
    private int numero;
    private boolean disponivel;

    public Mesa(String cliente, int numero, boolean disponivel) {
        this.cliente = cliente;
        this.numero = numero;
        this.disponivel = disponivel;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void ocuparMesa() {
        if (this.disponivel) {
            this.disponivel = false; // Mesa ocupada
        } else {
            this.disponivel = true;  // Mesa disponível
        }
    }
}
