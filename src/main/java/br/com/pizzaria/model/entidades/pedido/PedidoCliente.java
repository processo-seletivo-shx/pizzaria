package br.com.pizzaria.model.entidades.pedido;

import java.util.ArrayList;
import java.util.List;

import br.com.pizzaria.model.entidades.cliente.Cliente;

public class PedidoCliente {
	private Cliente cliente;
	private List<Pedido> pedidos = new ArrayList<>();

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public void adicionarPedido(Pedido pedido) {
		pedidos.add(pedido);
	}
	public List<Pedido> getPedidos() {
		return new ArrayList<>(pedidos);
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
}
