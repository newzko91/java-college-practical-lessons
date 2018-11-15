package br.com.unip.models;

public class Participante {
	private int id;
	private String nome;
	private String pessoa;
	private String matricula;
	
	public Participante() {
		super();
	}

	public Participante(int id, String nome, String pessoa,String matricula) {
		super();
		this.id = id;
		this.nome = nome;
		this.pessoa = pessoa;
		this.matricula = matricula;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPessoa() {
		return pessoa;
	}

	public void setPessoa(String pessoa) {
		this.pessoa = pessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	
}
