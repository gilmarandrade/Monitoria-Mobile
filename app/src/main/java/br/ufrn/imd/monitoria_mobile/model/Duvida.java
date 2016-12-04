package br.ufrn.imd.monitoria_mobile.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Duvida implements Serializable {
    private int id;
    private String nomeUsuario;
    private int imagemUsuario;
    private String disciplina;
    private String titulo;
    private String descricao;
    private int totalCurtidas;
    private int foto;
    private String dataCriacao;
    private List<Comentario> comentarios;
    private List<Resposta> respostas;
    private Status status;
    private boolean curtida;
    public Duvida() {
    }

    public Duvida(String nomeUsuario, int imagemUsuario, String disciplina, int foto, String titulo, String descricao, int totalCurtidas, Status status, String dataCriacao, List<Comentario> comentarios, List<Resposta> respostas) {
        this.nomeUsuario = nomeUsuario;
        this.imagemUsuario = imagemUsuario;
        this.disciplina = disciplina;
        this.titulo = titulo;
        this.descricao = descricao;
        this.totalCurtidas = totalCurtidas;
        this.foto = foto;
        this.status = status;
        this.dataCriacao = dataCriacao;
        this.comentarios = comentarios;
        this.respostas = respostas;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public int getImagemUsuario() {
        return imagemUsuario;
    }

    public void setImagemUsuario(int imagemUsuario) {
        this.imagemUsuario = imagemUsuario;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
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

    public int getTotalCurtidas() {
        return totalCurtidas;
    }

    public void setTotalCurtidas(int totalCurtidas) {
        this.totalCurtidas = totalCurtidas;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
        //return new ArrayList<Comentario>();
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }

    public static enum Status {
        ABERTA,
        FECHADA
    }

    public boolean isCurtida() {
        return curtida;
    }

    public void setCurtida(boolean curtida) {
        this.curtida = curtida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
