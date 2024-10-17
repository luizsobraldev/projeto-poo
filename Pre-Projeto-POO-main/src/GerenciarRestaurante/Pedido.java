import java.util.List;

public class Pedido {
    private String cliente;
    private int id;
    private List<ItemDoPedido> itens;  // Verifique se o tipo é realmente List<ItemDoPedido> ou algo diferente

    public Pedido(String cliente, int id, List<ItemDoPedido> itens) {
        this.cliente = cliente;
        this.id = id;
        this.itens = itens;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ItemDoPedido> getItens() {
        return itens;
    }

    public void adicionarItem(ItemDoPedido item){
        if (!itens.contains(item)) { // Verifica se o item já está no pedido
            itens.add(item);
        } else {
            System.out.println("Item já adicionado ao pedido.");
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemDoPedido item : itens) {
            total += item.getValor();
        }
        return total;
    }
}
