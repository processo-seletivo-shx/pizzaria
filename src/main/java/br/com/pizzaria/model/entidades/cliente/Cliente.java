package br.com.pizzaria.model.entidades.cliente;

public enum Cliente {
	CLIENTE_00(""),
	CLIENTE_01("Arthur"),
	CLIENTE_02("Fiuk"),
	CLIENTE_03("Gilberto"),
	CLIENTE_04("Juliette"),
	CLIENTE_05("Karol Conká"),
	CLIENTE_06("Lumena"),
	CLIENTE_07("Projota"),
	CLIENTE_08("Rodolfo"),
	CLIENTE_09("Thais"),
	CLIENTE_10("Viih Tube"),
	;
	
	private String nome;

	private Cliente(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return getNome();
	}
}
