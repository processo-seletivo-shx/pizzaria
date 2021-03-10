package br.com.pizzaria.model.entidades.pedido;

import java.util.ArrayList;
import java.util.List;

import br.com.pizzaria.model.entidades.cardapio.Adicional;
import br.com.pizzaria.model.entidades.cardapio.Borda;
import br.com.pizzaria.model.entidades.cardapio.Massa;
import br.com.pizzaria.model.entidades.cardapio.Pizza;
import br.com.pizzaria.model.entidades.cardapio.Tamanho;

public class PedidoPizza {
	private Pizza pizzaUnica;
	private List<Pizza> pizzasSabores = new ArrayList<>();
	private List<Adicional> adicionais = new ArrayList<>();
	private Borda borda;
	private Massa massa;
	private Tamanho tamanho;
	private double valorTotal;
	
	public void adicionaPizzaUnica(Pizza pizza) {
		pizzaUnica = pizza;
	}

	public void adicionaSabor1(Pizza pizza) {
		pizzasSabores.add(pizza);
	}

	public void adicionaSabor2(Pizza pizza) {
		pizzasSabores.add(pizza);
	}
	
	public void adicionaAdicional(Adicional adicional) {
		adicionais.add(adicional);
	}

	public Pizza getPizzaUnica() {
		return pizzaUnica;
	}

	public void setPizzaUnica(Pizza pizzaUnica) {
		this.pizzaUnica = pizzaUnica;
	}

	public List<Pizza> getPizzasSabores() {
		return new ArrayList<>(pizzasSabores);
	}

	public void setPizzasSabores(List<Pizza> pizzasSabores) {
		this.pizzasSabores = pizzasSabores;
	}

	public List<Adicional> getAdicionais() {
		return new ArrayList<>(adicionais);
	}

	public void setAdicionais(List<Adicional> adicionais) {
		this.adicionais = adicionais;
	}

	public Borda getBorda() {
		return borda;
	}

	public void setBorda(Borda borda) {
		this.borda = borda;
	}

	public Massa getMassa() {
		return massa;
	}

	public void setMassa(Massa massa) {
		this.massa = massa;
	}
	
	public int getQuantidadeAdicionais() {
		return this.getAdicionais().size();
	}

	public Tamanho getTamanho() {
		return tamanho;
	}

	public void setTamanho(Tamanho tamanho) {
		this.tamanho = tamanho;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
}
