package br.ufrn.imd.monitoria_mobile.dominio;

import java.util.List;

public class Perfil {
	

	private int id;
	

	private boolean ativo;

	private Integer id_sigaa;

	private String curso;

	private Pessoa pessoa;

	private Papel papel;
	

    private List<Disciplina> disciplinas;
	

	private String matricula;
	
	public Perfil() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Papel getPapel() {
		return papel;
	}

	public void setPapel(Papel papel) {
		this.papel = papel;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Integer getId_sigaa() {
		return id_sigaa;
	}

	public void setId_sigaa(Integer id_sigaa) {
		this.id_sigaa = id_sigaa;
	}
	
	
	
	
}
