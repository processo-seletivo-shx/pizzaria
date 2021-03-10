package br.com.pizzaria.model.entidades.cardapio;

public enum Adicional {
	BACON_141         (141, "BACON"         , 5.00, 7.00, 8.00, 10.00),
	REQUEIJAO_142     (142, "REQUEIJÃO"     , 8.00, 9.00, 10.00, 11.00),
	MILHO_143         (143, "MILHO"         , 2.50, 2.80, 3.20, 3.50),
	AZEITONA_PRETA_144(144, "AZEITONA PRETA", 3.20, 3.50, 3.80, 4.00),
	;
	
	private int id;
	private String descricao;
	private double valorBroto;
	private double valorMedia;
	private double valorGrande;
	private double valorBig;
	
	private Adicional(int id, String descricao, double valorBroto, double valorMedia, double valorGrande,
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
