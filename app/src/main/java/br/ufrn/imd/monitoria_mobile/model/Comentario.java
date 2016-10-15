package br.ufrn.imd.monitoria_mobile.model;

import java.io.Serializable;

public class Comentario implements Serializable{
    private String descricao;
    private String nomeUsuario;
    private String dataCriacao;

    public Comentario(String descricao, String nomeUsuario, String dataCriacao) {
        this.descricao = descricao;
        this.nomeUsuario = nomeUsuario;
        this.dataCriacao = dataCriacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
