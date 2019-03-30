package br.unip.aps.models;

public class Carga {
	
	private int id;
	private String descricao;
	private int responsavel_matricula;
	private String responsavel_nome;
	private int transportador;
	private String transportador_nome;
	private String tipo_carga;
	private String tempotransporte;
	
	public Carga() {
		super();
	}

	public Carga(int id, String descricao, int responsavel_matricula, int transportador,
			String tipo_carga, String tempotransporte) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.responsavel_matricula = responsavel_matricula;
		this.transportador = transportador;
		this.tipo_carga = tipo_carga;
		this.tempotransporte = tempotransporte;
	}
	
	public Carga(int id, String descricao, int responsavel_matricula, String responsavel_nome, int transportador,
			String transportador_nome, String tipo_carga, String tempotransporte) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.responsavel_matricula = responsavel_matricula;
		this.responsavel_nome = responsavel_nome;
		this.transportador = transportador;
		this.transportador_nome = transportador_nome;
		this.tipo_carga = tipo_carga;
		this.tempotransporte = tempotransporte;
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

	public int getResponsavel_matricula() {
		return responsavel_matricula;
	}

	public void setResponsavel_matricula(int responsavel_matricula) {
		this.responsavel_matricula = responsavel_matricula;
	}

	public String getResponsavel_nome() {
		return responsavel_nome;
	}

	public void setResponsavel_nome(String responsavel_nome) {
		this.responsavel_nome = responsavel_nome;
	}

	public int getTransportador() {
		return transportador;
	}

	public void setTransportador(int transportador) {
		this.transportador = transportador;
	}

	public String getTransportador_nome() {
		return transportador_nome;
	}

	public void setTransportador_nome(String transportador_nome) {
		this.transportador_nome = transportador_nome;
	}

	public String getTipo_carga() {
		return tipo_carga;
	}

	public void setTipo_carga(String tipo_carga) {
		this.tipo_carga = tipo_carga;
	}

	public String getTempotransporte() {
		return tempotransporte;
	}

	public void setTempotransporte(String tempotransporte) {
		this.tempotransporte = tempotransporte;
	}
	
}
