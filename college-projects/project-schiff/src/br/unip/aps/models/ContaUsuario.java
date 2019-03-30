package br.unip.aps.models;

public class ContaUsuario {
	   
	   private int matricula;
	   private String nome;
	   private String login;
	   private String senha;
	   private String tipoacesso;
	   public String administrador = "Admin";
	   
	   public ContaUsuario() {
		   
	   }
	   
	   public ContaUsuario(int matricula, String nome, String login, String senha, String tipoacesso) {
		   this.matricula = matricula;
		   this.nome = nome;
		   this.login = login;
		   this.senha = senha;
		   this.tipoacesso = tipoacesso;
	   }
	   
	   public ContaUsuario(String tipoacesso) {
		   this.tipoacesso = tipoacesso;
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
	
		public String getLogin() {
			return login;
		}
	
		public void setLogin(String login) {
			this.login = login;
		}
	
		public String getSenha() {
			return senha;
		}
	
		public void setSenha(String senha) {
			this.senha = senha;
		}
	
		public String getTipoacesso() {
			return tipoacesso;
		}
	
		public void setTipoacesso(String tipoacesso) {
			this.tipoacesso = tipoacesso;
		}

	   
		
}
