package br.unip.aps.models;

public class Embarcacao {

	private int id;
	private String descricao;
	private String fabricante;
	private String ano_fab;
	private String tamanho;
	private String porte;
	private String nivelgasto_combustivel;
	private int responsavel;
	private String responsavel_nome;

	

	public Embarcacao() {
		super();
	}


public Embarcacao(int id, String descricao, String fabricante, String ano_fab, String tamanho, int responsavel) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.fabricante = fabricante;
		this.ano_fab = ano_fab;
		this.tamanho = tamanho;
		this.responsavel = responsavel;
}

	
	public Embarcacao(int id, String descricao, String fabricante, String ano_fab, String tamanho, String porte,
			String nivelgasto_combustivel, int responsavel, String responsavel_nome) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.fabricante = fabricante;
		this.ano_fab = ano_fab;
		this.tamanho = tamanho;
		this.porte = porte;
		this.nivelgasto_combustivel = nivelgasto_combustivel;
		this.responsavel = responsavel;
		this.responsavel_nome = responsavel_nome;
	}	


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getFabricante() {
		return fabricante;
	}


	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}


	public String getAno_fab() {
		return ano_fab;
	}


	public void setAno_fab(String ano_fab) {
		this.ano_fab = ano_fab;
	}


	public String getTamanho() {
		return tamanho;
	}


	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPorte() {
		return porte;
	}


	public void setPorte(String porte) {
		this.porte = porte;
	}


	public String getNivelgasto_combustivel() {
		return nivelgasto_combustivel;
	}


	public void setNivelgasto_combustivel(String nivelgasto_combustivel) {
		this.nivelgasto_combustivel = nivelgasto_combustivel;
	}


	public int getResponsavel() {
		return responsavel;
	}


	public void setResponsavel(int responsavel) {
		this.responsavel = responsavel;
	}


	public String getResponsavel_nome() {
		return responsavel_nome;
	}


	public void setResponsavel_nome(String responsavel_nome) {
		this.responsavel_nome = responsavel_nome;
	}	
	
	
}
