package br.unip.aps.models;

public class Pessoa {
	
	private int matricula;
	private String nome;
	private String endereco;
	private String telefone;
	private String email;
	private String rg;
	private String cpf_cnpj;
	private String status;
	private String tipo;
	private String tipo_emp;
	private String depto;
	private String cargo;
	
	public Pessoa() {
		
	}

	public Pessoa(int matricula, String nome, String endereco, String telefone, String email, String rg,
			String cpf_cnpj, String status, String tipo, String tipo_emp, String depto, String cargo) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.rg = rg;
		this.cpf_cnpj = cpf_cnpj;
		this.status = status;
		this.tipo = tipo;
		this.tipo_emp = tipo_emp;
		this.depto = depto;
		this.cargo = cargo;
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

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
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

	public String getTipo_emp() {
		return tipo_emp;
	}

	public void setTipo_emp(String tipo_emp) {
		this.tipo_emp = tipo_emp;
	}

	public String getDepto() {
		return depto;
	}

	public void setDepto(String depto) {
		this.depto = depto;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	

}
