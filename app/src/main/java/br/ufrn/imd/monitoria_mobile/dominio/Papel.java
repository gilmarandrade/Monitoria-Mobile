package br.ufrn.imd.monitoria_mobile.dominio;


public class Papel {

	private int id;

	private String descricao;

	private String role;
	
	public Papel() {
		// TODO Auto-generated constructor stub
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public static final int ROLE_ALUNO = 1;
	
	public static final int ROLE_DOCENTE = 2;
	
	public static final int ROLE_MONITOR = 3;
	
}
