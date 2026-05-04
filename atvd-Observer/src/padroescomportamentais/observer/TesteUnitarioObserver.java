package padroescomportamentais.observer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TesteUnitarioObserver {

    @Test
    public void testClienteRecebeNotificacao() {
        Pedido pedido = new Pedido("001", "Joao", "Recebido");
        Cliente cliente = new Cliente("Joao");
        cliente.acompanhar(pedido);
        pedido.atualizarStatus();
        assertNotNull(cliente.getUltimaNotificacao());
    }

    @Test
    public void testNotificacaoContemNomeCliente() {
        Pedido pedido = new Pedido("002", "Maria", "Em Preparo");
        Cliente cliente = new Cliente("Maria");
        cliente.acompanhar(pedido);
        pedido.atualizarStatus();
        assertTrue(cliente.getUltimaNotificacao().contains("Maria"));
    }

    @Test
    public void testMultiplosClientesRecebemNotificacao() {
        Pedido pedido = new Pedido("003", "Mesa 5", "Pronto");
        Cliente cliente1 = new Cliente("Carlos");
        Cliente cliente2 = new Cliente("Ana");
        cliente1.acompanhar(pedido);
        cliente2.acompanhar(pedido);
        pedido.atualizarStatus();
        assertNotNull(cliente1.getUltimaNotificacao());
        assertNotNull(cliente2.getUltimaNotificacao());
    }

    @Test
    public void testClienteSemAcompanhamentoNaoRecebe() {
        Pedido pedido = new Pedido("004", "Mesa 3", "Recebido");
        Cliente cliente = new Cliente("Pedro");
        pedido.atualizarStatus();
        assertNull(cliente.getUltimaNotificacao());
    }
}