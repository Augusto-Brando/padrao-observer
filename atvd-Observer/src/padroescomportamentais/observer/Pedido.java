package padroescomportamentais.observer;

import java.util.Observable;

public class Pedido extends Observable {
    private String numeroPedido;
    private String nomeCliente;
    private String status;

    public Pedido(String numeroPedido, String nomeCliente, String status) {
        this.numeroPedido = numeroPedido;
        this.nomeCliente = nomeCliente;
        this.status = status;
    }

    public void atualizarStatus() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "numeroPedido='" + numeroPedido + '\'' +
                ", nomeCliente='" + nomeCliente + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}