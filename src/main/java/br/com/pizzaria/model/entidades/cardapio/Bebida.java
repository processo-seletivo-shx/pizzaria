package br.com.pizzaria.model.entidades.cardapio;

public enum Bebida {
	
	REFRIGERANTE_1L  (152, "REFIGERANTE 1L"   ,	5.20,	20),
	REFRIGERANTE_2L  (152, "REFIGERANTE 2L"   ,	8.50,	30),
	REFRIGERANTE_LATA(152, "REFIGERANTE LATA" ,	4.50,	50),
	AGUA             (152, "AGUA"             ,	4.00,	15),
	SUCO_NATURAL     (153, "SUCO NATURAL ( LARANJA, ABACAXI E LIMÃO ) 500ML", 	8.00,	15),
	SUCO_POUPA       (154, "SUCO POUPA 500 ML", 	8.00,	15),
	CERVEJA_LATA     (155, "CERVEJA LATA"     , 	4.50,	30),
	CERVEJA_600ML    (156, "CERVEJA 600ML"    , 	9.50,	50),
	CERVEJA_1L       (157, "CERVEJA 1 LITRO"  , 	13.00,	20),
	VINHO_1L         (158, "VINHO 1 LITRO"    , 	25.00,	15),
	;

	private int id;
	private String descricao;
	private double preco;
	private int saldo;
	private Bebida(int id, String descricao, double preco, int saldo) {
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
		this.saldo = saldo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
	@Override
	public String toString() {
		return this.getDescricao();
	}
}
