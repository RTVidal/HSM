package hsm.modelo;

public enum Estado {
	
	SP("São Paulo"),
	RJ("Rio de Janeiro"),
	PR("Paraná"),
	SC("Santa Catarina"),
	MG("Minas Gerais");
		
	private String descricao;
	
	private Estado(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
