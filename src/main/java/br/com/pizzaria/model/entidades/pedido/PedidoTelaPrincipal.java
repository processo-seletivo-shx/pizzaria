package br.com.pizzaria.model.entidades.pedido;

public class PedidoTelaPrincipal {
	private String data;
	private int quantidadePedidos;
	private double valorTotal;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getQuantidadePedidos() {
		return quantidadePedidos;
	}
	public void setQuantidadePedidos(int quantidadePedidos) {
		this.quantidadePedidos = quantidadePedidos;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
}
