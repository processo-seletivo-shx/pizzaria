	package br.com.pizzaria.model.entidades.cardapio;

public enum Pizza {
	
	AMERICANA_01  (1 , "AMERICANA"     , "MOLHO DE TOMATE, MUÇARELA, BACON, CALABRESA, OVOS E CEBOLA", Categoria.CLASSICA, 29.00, 33.00, 36.00, 41.00),
	APRESUNTADA_02(2 , "APRESUNTADA"   , "MOLHO DE TOMATE, PRESUNTO E MUÇARELA", Categoria.CLASSICA,  29.00, 33.00, 36.00, 41.00),
	CROCANTE_03   (3 , "CROCANTE"      , "MOLHO DE TOMATE, MUÇARELA (2 CAMADAS), CATUPIRY, BATATA PALHA (DEPOIS DE ASSADA)", Categoria.CLASSICA, 29.00, 33.00, 36.00, 41.00),
	MILHO_04      (4 , "MILHO"         , "MOLHO DE TOMATE, MUÇARELA E MILHO", Categoria.CLASSICA, 29.00, 33.00, 36.00, 41.00),
	MUCARELA_05   (5 , "MUÇARELA"     , "MOLHO DE TOMATE E MUÇARELA (2 CAMADAS)", Categoria.CLASSICA, 29.00, 33.00, 36.00, 41.00),
	TRADICIONAL_06(6 , "TRADICIONAL"   , "MOLHO DE TOMATE, PRESUNTO, TOMATES E MUÇARELA", Categoria.CLASSICA, 29.00, 33.00, 36.00, 41.00),
	
	A_MODA_45        (45, "A MODA"        , "MOLHO DE TOMATE, PRESUNTO, MILHO, ERVILHA, CALABRESA, TOMATES, OVOS, AZEITOAS E MUÇARELA (2 CAMADAS). OBS: SABOR ÚNICO EM TODA PIZZA", Categoria.CLASSICA, 31.00, 36.00, 39.00, 46.00),
	BACON_CROCANTE_46(46, "BACON CROCANTE", "MOLHO DE TOMATE, BACON, BATATA PALHA E MUÇARELA", Categoria.CLASSICA, 31.00, 36.00, 39.00, 46.00),
	BOLONHESA_47     (47, "BOLONHESA"     , "MOLHO DE TOMATE, BOLONHESA, MOLHO PARMEGIANA, PARMESÃO E MUÇARELA", Categoria.CLASSICA, 31.00, 36.00, 39.00, 46.00),
	BROCOLIS_48      (48, "BRÓCOLIS"      , "MOLHO DE TOMATE, BACON, BRÓCOLIS REFOGADO, CHAMPIGNON, ALHO, CATUPIRY E MUÇARELA", Categoria.CLASSICA, 31.00, 36.00, 39.00, 46.00),
	FRAN_CHEDDAR_49  (49, "FRAN-CHEDDAR"  , "MOLHO DE TOMATE, MUÇARELA, FRANGO DESFIADO AO MOLHO E CHEDDAR", Categoria.CLASSICA, 31.00, 36.00, 39.00, 46.00),
	HAVAIANA_50      (50, "HAVAIANA"      , "MUÇARELA, LOMBO E ABACAXI", Categoria.CLASSICA, 31.00, 36.00, 39.00, 46.00),
	ITALIANA_51      (51, "ITALIANA"      , "MOLHO DE TOMATE, SALAME ITALIANO, TOMATES, PARMESÃO E MUÇARELA", Categoria.CLASSICA, 31.00, 36.00, 39.00, 46.00),
	PALMITO_52       (52, "PALMITO"       , "MOLHO DE TOMATE, PRESUNTO, MUÇARELA, PALMITO E AZEITONAS", Categoria.CLASSICA, 31.00, 36.00, 39.00, 46.00),
	PARMEGIANA_53    (53, "PARMEGIANA"    , "MOLHO DE TOMATE, PRESUNTO, MOLHO PARMEGIANA, PARMESÃO E MUÇARELA", Categoria.CLASSICA, 31.00, 36.00, 39.00, 46.00),
	PIZZAIOLO_54     (54, "PIZZAIOLO"     , "MOLHO DE TOMATE, MUÇARELA, FRANGO DESFIADO AO MOLHO, PALMITO, MILHO, CALABRESA E CATUPIRY", Categoria.CLASSICA, 31.00, 36.00, 39.00, 46.00),
	SICILIANA_55     (55, "SICILIANA"     , "MOLHO DE TOMATE, MUÇARELA, BACON, CHAMPIGNON, PIMENTÕES VERDES E CATUPIRY", Categoria.CLASSICA, 31.00, 36.00, 39.00, 46.00),
	TROPICAL_56      (56, "TROPICAL"      , "MOLHO DE TOMATE, MUÇARELA, FRANGO DESFIADO AO MOLHO, MILHO, ERVILHA, OVOS E CATUPIRY", Categoria.CLASSICA, 31.00, 36.00, 39.00, 46.00),
	UMITA_57         (57, "UMITA"         , "MOLHO DE TOMATE, PRESUNTO, MUÇARELA, MILHO, PALMITO E CATUPIRY", Categoria.CLASSICA, 31.00, 36.00, 39.00, 46.00),
	
	BEIJINHO_122     (122, "BEIJINHO", "CREME DE LEITE, CHOCOLATE BRANCO, COCO RALADO E FIOS DE BISNAGA", Categoria.DOCE, 32.00, 38.00, 44.00, 51.00),
	BRIGADEIRO_123   (123, "BRIGADEIRO", "CREME DE LEITE, CHOCOLATE PRETO OU BRANCO. FIOS DE BISNAGA E GRANULADO", Categoria.DOCE, 32.00, 38.00, 44.00, 51.00),
	CALIFORNIA_124   (124, "CALIFÓRNIA", "CREME DE LEITE, FRUTAS EM CALDA E BANANA", Categoria.DOCE, 32.00, 38.00, 44.00, 51.00),
	CHOC_AMENDOIM_125(125, "CHOCOLATE COM AMENDOIM", "CREME DE LEITE, CHOCOLATE PRETO OU BRANCO, FIOS DE BISNAGA E AMENDOIM", Categoria.DOCE, 32.00, 38.00, 44.00, 51.00),
	CHOC_CEREJAS_126 (126, "CHOCOLATE COM CEREJAS", "CREME DE LEITE, CHOCOLATE PRETO OU BRANCO, CEREJAS E FIOS DE BISNAGA", Categoria.DOCE, 32.00, 38.00, 44.00, 51.00),
	CHOC_MORANGOS_127(127, "CHOCOLATE COM MORANGOS", "CREME DE LEITE, CHOCOLATE PRETO OU BRANCO, MORANGOS E FIOS DE BISNAGA", Categoria.DOCE, 32.00, 38.00, 44.00, 51.00),
	CHOC_PESSEGO_128 (128, "CHOCOLATE COM PÊSSEGO", "CREME DE LEITE, CHOCOLATE PRETO OU BRANCO, PÊSSEGOS E FIOS DE BISNAGA", Categoria.DOCE, 32.00, 38.00, 44.00, 51.00),
	CHOC_SORVETE_129 (129, "CHOCOLATE COM SORVETE", "CREME DE LEITE, CHOCOLATE PRETO OU BRANCO, SORVETE E FIOS DE BISNAGA", Categoria.DOCE, 32.00, 38.00, 44.00, 51.00),
	CONFETTI_130     (130, "CONFETTI", "CREME DE LEITE, CHOCOLATE PRETO OU BRANCO, FIOS DE BISNAGA DE CHOCOLATE E COFETTI", Categoria.DOCE, 32.00, 38.00, 44.00, 51.00),
	SENSACAO_131     (131, "SENSAÇÃO", "CREME DE LEITE, CHOCOLATE PRETO, MORANGOS AP CREME DE LEITE E LEITE CONDENSADO", Categoria.DOCE, 32.00, 38.00, 44.00, 51.00),
	
	CINCO_QUEIJ_132   (132, "CINCO QUEIJOS", "MUÇARELA, REQUEIJÃO, PROVOLONE, GORGONZOLA E PARMESÃO", Categoria.VEGETARIANA, 32.00, 38.00, 44.00, 51.00),
	MARGUERITA_133    (133, "MARGUERITA", "MUÇARELA, RODELAS DE TOMATE, PARMESÃO E FOLHAS DE MANJERICÃO", Categoria.VEGETARIANA, 32.00, 38.00, 44.00, 51.00),
	MIL_REQUEI_134    (134, "MILHO (C/ REQUEIJÃO)", "MILHO COM COBERTURA DE REQUEIJÃO", Categoria.VEGETARIANA, 32.00, 38.00, 44.00, 51.00),
	MIL_MUCARE_135    (135, "MILHO (C/ MUÇARELA)", "MILHO COM COBERTURA DE MUÇARELA", Categoria.VEGETARIANA, 32.00, 38.00, 44.00, 51.00),
	MUCARELA_136      (136, "MUÇARELA", "QUEIJO MUÇARELA", Categoria.VEGETARIANA, 32.00, 38.00, 44.00, 51.00),
	NAPOLITANA_137    (137, "NAPOLITANA", "MUÇARELA, RODELAS DE TOMATE E PARMESÃO", Categoria.VEGETARIANA, 32.00, 38.00, 44.00, 51.00),
	PALMITO_REQUEI_138(138, "PALMITO (C/ REQUEIJÃO)", "PALMITO COM COBERTURA DE REQUEIJÃO", Categoria.VEGETARIANA, 32.00, 38.00, 44.00, 51.00),
	QUATRO_QUEIJ_139  (139, "QUATRO QUEIJOS", "MUÇARELA, REQUEIJÃO, PROVOLONE E PARMESÃO", Categoria.VEGETARIANA, 32.00, 38.00, 44.00, 51.00),
	VEGETARIANA_140   (140, "VEGETARIANA", "PALMITO, BRÓCOLIS, MILHO, CHAMPIGNON E LEVE COBERTURA DE MUÇARELA", Categoria.VEGETARIANA, 32.00, 38.00, 44.00, 51.00),
	;
	private int id;
	private String descricao;
	private String ingredientes;
	private Categoria categoria;
	private double valorBroto;
	private double valorMedia;
	private double valorGrande;
	private double valorBig;
	
	private Pizza(int id, String descricao, String ingredientes, Categoria categoria, double valorBroto, double valorMedia, double valorGrande,
			double valorBig) {
		this.id = id;
		this.descricao = descricao;
		this.ingredientes = ingredientes;
		this.categoria = categoria;
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

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
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
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return this.getDescricao();
	}
}
