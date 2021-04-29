package br.com.pizzaria.model.entidades.pedido;

import br.com.pizzaria.model.entidades.cardapio.Bebida;

public class PedidoBebida {
	private Bebida bebida;
	private int quantidade;
	
	public PedidoBebida(Bebida bebida, int quantidade) {
		super();
		this.bebida = bebida;
		this.quantidade = quantidade;
	}

	public Bebida getBebida() {
		return bebida;
	}

	public void setBebida(Bebida bebida) {
		this.bebida = bebida;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
