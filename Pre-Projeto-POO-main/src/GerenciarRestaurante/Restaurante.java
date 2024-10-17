public class Restaurante {
    private double totalVendas;
    private int pedidosDia;

    public Restaurante(double totalVendas, int pedidosDia) {
        this.totalVendas = totalVendas;
        this.pedidosDia = pedidosDia;
    }

    public double getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(double totalVendas) {
        this.totalVendas = totalVendas;
    }

    public int getPedidosDia() {
        return pedidosDia;
    }

    public void setPedidosDia(int pedidosDia) {
        this.pedidosDia = pedidosDia;
    }

    public void adicionarVenda(double valor){
        if (valor > 0) {
            totalVendas += valor;
        } else {
            System.out.println("Valor inválido para a venda.");
        }
    }

    public void registrarVenda(){
        pedidosDia++;
    }
}
