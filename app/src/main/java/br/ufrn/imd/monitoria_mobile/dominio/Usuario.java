package br.ufrn.imd.monitoria_mobile.dominio;


public class Usuario {
	/**
	 * Atributo identificador da classe Usuario 
	 */
	private int id;

	private Integer idSigaa;
	
	/**
	 * Atributo que guarda o login do Usuario
	 */

	private String login;
	
	/**
	 * Atributo que guarda a senha do Usuario
	 */
	private String senha;
	
	private Boolean ativo;
	
	private Pessoa pessoa;
	
	private String accessToken;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public int getIdSigaa() {
		return idSigaa;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public void setIdSigaa(Integer idSigaa) {
		this.idSigaa = idSigaa;
	}
	
	
	
}
