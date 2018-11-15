package br.com.unip.models;

public class Evento {
	private int id;
	private String nome;
	private String descricao;
	private String palestrante;
	private String local;
	private String data;
	
	public Evento() {

	}

	public Evento(int id, String nome, String descricao, String palestrante, String local, String data) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.palestrante = palestrante;
		this.local = local;
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPalestrante() {
		return palestrante;
	}

	public void setPalestrante(String palestrante) {
		this.palestrante = palestrante;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
}
