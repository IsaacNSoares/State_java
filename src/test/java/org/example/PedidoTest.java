package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    Pedido pedido;

    @BeforeEach
    public void setUp() {
        pedido = new Pedido();
    }

    // Pedido Aguardando Pagamento

    @Test
    public void deveFaturarPedidoAguardandoPagamento() {
        pedido.setEstado(PedidoEstadoAguardandoPagamento.getInstance());
        assertTrue(pedido.faturar());
        assertEquals(PedidoEstadoFaturado.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveTransportarPedidoAguardandoPagamento() {
        pedido.setEstado(PedidoEstadoAguardandoPagamento.getInstance());
        assertFalse(pedido.transportar());
    }

    @Test
    public void naoDeveEntregarPedidoAguardandoPagamento() {
        pedido.setEstado(PedidoEstadoAguardandoPagamento.getInstance());
        assertFalse(pedido.entregar());
    }

    @Test
    public void deveCancelarPedidoAguardandoPagamento() {
        pedido.setEstado(PedidoEstadoAguardandoPagamento.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    // Pedido Faturado

    @Test
    public void naoDeveFaturarPedidoFaturado() {
        pedido.setEstado(PedidoEstadoFaturado.getInstance());
        assertFalse(pedido.faturar());
    }

    @Test
    public void deveTransportarPedidoFaturado() {
        pedido.setEstado(PedidoEstadoFaturado.getInstance());
        assertTrue(pedido.transportar());
        assertEquals(PedidoEstadoEmTransito.getInstance(), pedido.getEstado());
    }

    @Test
    public void deveEntregarPedidoFaturado() {
        pedido.setEstado(PedidoEstadoFaturado.getInstance());
        assertTrue(pedido.entregar());
        assertEquals(PedidoEstadoEntregue.getInstance(), pedido.getEstado());
    }

    @Test
    public void deveCancelarPedidoFaturado() {
        pedido.setEstado(PedidoEstadoFaturado.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    // Pedido Em Trânsito

    @Test
    public void naoDeveFaturarPedidoEmTransito() {
        pedido.setEstado(PedidoEstadoEmTransito.getInstance());
        assertFalse(pedido.faturar());
    }

    @Test
    public void naoDeveTransportarPedidoEmTransito() {
        pedido.setEstado(PedidoEstadoEmTransito.getInstance());
        assertFalse(pedido.transportar());
    }

    @Test
    public void deveEntregarPedidoEmTransito() {
        pedido.setEstado(PedidoEstadoEmTransito.getInstance());
        assertTrue(pedido.entregar());
        assertEquals(PedidoEstadoEntregue.getInstance(), pedido.getEstado());
    }

    @Test
    public void deveCancelarPedidoEmTransito() {
        pedido.setEstado(PedidoEstadoEmTransito.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    // Pedido Entregue

    @Test
    public void naoDeveFaturarPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.faturar());
    }

    @Test
    public void naoDeveTransportarPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.transportar());
    }

    @Test
    public void naoDeveEntregarPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.entregar());
    }

    @Test
    public void naoDeveCancelarPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.cancelar());
    }

    // Pedido Cancelado

    @Test
    public void naoDeveFaturarPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.faturar());
    }

    @Test
    public void naoDeveTransportarPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.transportar());
    }

    @Test
    public void naoDeveEntregarPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.entregar());
    }

    @Test
    public void naoDeveCancelarPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.cancelar());
    }
}