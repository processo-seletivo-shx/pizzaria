package br.com.pizzaria.model.entidades.pedido;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private String data;
	private List<PedidoPizza> pizzaPedidos = new ArrayList<>();
	private List<PedidoBebida> bebidas = new ArrayList<>();
	private double valorTotal;
	
	public void adicionaPizzaPedido(PedidoPizza pedidoPizza) {
		this.pizzaPedidos.add(pedidoPizza);
	}
	
	public void removePizzaPedido(PedidoPizza pedidoPizza) {
		this.pizzaPedidos.remove(pedidoPizza);
	}
	
	public void adicionaBebida(PedidoBebida bebida) {
		boolean bebidaJaAdicionada = false;
		for (PedidoBebida pedidoBebida : bebidas) {
			if (pedidoBebida.getBebida() == bebida.getBebida()) {
				bebidaJaAdicionada = true;
				
				pedidoBebida.setQuantidade(pedidoBebida.getQuantidade() + bebida.getQuantidade());
			}
		}
		
		if (!bebidaJaAdicionada) {
			this.bebidas.add(bebida);
		}
	}
	
	public void removeBebida(PedidoBebida pedidoBebida) {
		this.bebidas.remove(pedidoBebida);
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public List<PedidoPizza> getPedidoPizzas() {
		return new ArrayList<>(pizzaPedidos);
	}

	public void setPizzaPedido(List<PedidoPizza> pizzaPedido) {
		this.pizzaPedidos = pizzaPedido;
	}

	public List<PedidoBebida> getPedidoBebidas() {
		return new ArrayList<>(bebidas);
	}

	public void setBebidas(List<PedidoBebida> bebidas) {
		this.bebidas = bebidas;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public int getQuantidadePedidos() {
		return pizzaPedidos.size();
	}
}
