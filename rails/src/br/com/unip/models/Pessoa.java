package br.com.unip.models;

public class Pessoa {
	private int matricula;
	private String nome;
	private String endereco;
	private String telefone;
	private String email;
	private String rg;
	private String cpf;
	private String cnpj;
	private String status;
	private String tipo;
	private String tipo_acesso;


	public Pessoa() {

	}

	
	public Pessoa(int matricula, String nome, String endereco, String telefone, String email, String rg, String cpf,
			String cnpj, String status, String tipo, String tipo_acesso) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.rg = rg;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.status = status;
		this.tipo = tipo;
		this.tipo_acesso = tipo_acesso;
	}




	public int getMatricula() {
		return matricula;
	}


	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getRg() {
		return rg;
	}


	public void setRg(String rg) {
		this.rg = rg;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getTipo_acesso() {
		return tipo_acesso;
	}


	public void setTipo_acesso(String tipo_acesso) {
		this.tipo_acesso = tipo_acesso;
	}
}
