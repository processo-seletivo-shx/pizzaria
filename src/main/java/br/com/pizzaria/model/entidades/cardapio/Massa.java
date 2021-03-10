package br.com.pizzaria.model.entidades.cardapio;

public enum Massa {
	TRADICIONAL_150(150, "TRADICIONAL", 0.00, 0.00, 0.00, 0.00),
	INTEGRAL_151   (151, "INTEGRAL"   , 1.00, 1.50, 1.80, 2.00),
	ERVAS_FINAS_152(152, "ERVAS FINAS", 2.00, 3.00, 4.00, 5.00),
	;
	private int id;
	private String descricao;
	private double valorBroto;
	private double valorMedia;
	private double valorGrande;
	private double valorBig;
	
	private Massa(int id, String descricao, double valorBroto, double valorMedia, double valorGrande,
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
