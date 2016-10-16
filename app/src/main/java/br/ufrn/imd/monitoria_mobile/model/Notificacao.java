package br.ufrn.imd.monitoria_mobile.model;


import java.io.Serializable;

public class Notificacao implements Serializable{
    private int fotoUsuario;
    private String titulo;
    private String descricao;
    private String data;
    private String disciplina;

    public Notificacao() {
    }

    public Notificacao(int fotoUsuario, String titulo, String descricao, String disciplina, String data) {
        this.fotoUsuario = fotoUsuario;
        this.titulo = titulo;
        this.descricao = descricao;
        this.disciplina = disciplina;
        this.data = data;
    }

    public int getFotoUsuario() {
        return fotoUsuario;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public void setFotoUsuario(int fotoUsuario) {
        this.fotoUsuario = fotoUsuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
