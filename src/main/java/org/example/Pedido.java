package org.example;

public class Pedido {

    private String nome;
    private PedidoEstado estado;

    public Pedido() {
        this.estado = PedidoEstadoAguardandoPagamento.getInstance();
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
    }

    public boolean aguardarPagamento() {
        return estado.aguardarPagamento(this);
    }

    public boolean faturar() {
        return estado.faturar(this);
    }

    public boolean transportar() {
        return estado.transportar(this);
    }

    public boolean entregar() {
        return estado.entregar(this);
    }

    public boolean cancelar() {
        return estado.cancelar(this);
    }

    public String getNomeEstado() {
        return estado.getEstado();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public PedidoEstado getEstado() {
        return estado;
    }

}