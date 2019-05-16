package br.ufma.ecp.pp.dados.atv1bd;

// Classe POJO(Plain and Old Java Object)
public class Usuario {
	
	public Usuario(){
	}
	
	private String id;
	private String nome;
	private String email;
	private String usuario;
	private String senha;
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public Usuario(String id, String nome, String email, String usuario, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.usuario = usuario;
		this.senha = senha;
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", usuario=" + usuario + ", senha=" + senha
				+ "]";
	}
		

}
