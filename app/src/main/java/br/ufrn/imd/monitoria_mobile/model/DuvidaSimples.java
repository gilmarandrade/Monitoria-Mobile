package br.ufrn.imd.monitoria_mobile.model;

public class DuvidaSimples {

    private String nomeUsuario;
    private int imagemUsuario;
    private String disciplina;
    private String titulo;
    private String descricao;
    private int totalCurtidas;
    private int totalRespostas;

    public static enum Status {
        ABERTA,
        FECHADA
    }

    private Status status;

    public DuvidaSimples(String nomeUsuario, int imagemUsuario, String disciplina, String titulo, String descricao, int totalCurtidas, int totalRespostas, Status status) {
        this.nomeUsuario = nomeUsuario;
        this.imagemUsuario = imagemUsuario;
        this.disciplina = disciplina;
        this.titulo = titulo;
        this.descricao = descricao;
        this.totalCurtidas = totalCurtidas;
        this.totalRespostas = totalRespostas;
        this.status = status;
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

    public int getTotalRespostas() {
        return totalRespostas;
    }

    public void setTotalRespostas(int totalRespostas) {
        this.totalRespostas = totalRespostas;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
