package br.com.pizzaria.model.entidades.cardapio;

public enum Borda {

	SEM_BORDA_999  (999, "SEM BORDA", 0.00, 0.00, 0.00, 0.00),
	PRES_QUEIJO_145(145, "PRESUNTO E QUEIJO", 8.00, 8.50, 9.10, 10.00),
	REQUEIJAO_146  (146, "REQUEIJÃO", 10.00, 11.00, 12.00, 13.00),
	CALABRESA_147  (147, "CALABRESA", 7.00, 7.50, 7.70, 8.00),
	FRANGO_148     (148, "FRANGO", 8.50, 9.20, 10.10, 11.00),
	QUEIJO_149     (149, "QUEIJO", 6.00, 6.50, 7.00, 7.50),
	;
	private int id;
	private String descricao;
	private double valorBroto;
	private double valorMedia;
	private double valorGrande;
	private double valorBig;
	
	private Borda(int id, String descricao, double valorBroto, double valorMedia, double valorGrande,
			double valorBig) {
		this.id = id;
		this.descricao = descricao;
		this.valorBroto = valorBroto;
		this.valorMedia = valorMedia;
		this.valorGrande = valorGrande;
		this.valorBig = valorBig;
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

	public double getValorBroto() {
		return valorBroto;
	}

	public void setValorBroto(double valorBroto) {
		this.valorBroto = valorBroto;
	}

	public double getValorMedia() {
		return valorMedia;
	}

	public void setValorMedia(double valorMedia) {
		this.valorMedia = valorMedia;
	}

	public double getValorGrande() {
		return valorGrande;
	}

	public void setValorGrande(double valorGrande) {
		this.valorGrande = valorGrande;
	}

	public double getValorBig() {
		return valorBig;
	}

	public void setValorBig(double valorBig) {
		this.valorBig = valorBig;
	}
	
	@Override
	public String toString() {
		return getDescricao();
	}
}
