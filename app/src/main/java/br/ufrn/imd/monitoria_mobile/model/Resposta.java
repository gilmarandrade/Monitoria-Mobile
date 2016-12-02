package br.ufrn.imd.monitoria_mobile.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Resposta implements Serializable {

    private String nomeUsuario;
    private int fotoUsuario;
    private String data;
    private String descricao;
    private Status Status;
    private boolean melhorResposta;
    private List<Comentario> comentarios;

    public Resposta() {
    }

    public Resposta(String nomeUsuario, int fotoUsuario, String data, String descricao, Resposta.Status status, boolean melhorResposta, List<Comentario> comentarios) {
        this.nomeUsuario = nomeUsuario;
        this.fotoUsuario = fotoUsuario;
        this.data = data;
        this.descricao = descricao;
        Status = status;
        this.melhorResposta = melhorResposta;
        this.comentarios = comentarios;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public int getFotoUsuario() {
        return fotoUsuario;
    }

    public void setFotoUsuario(int fotoUsuario) {
        this.fotoUsuario = fotoUsuario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Resposta.Status getStatus() {
        return Status;
    }

    public void setStatus(Resposta.Status status) {
        Status = status;
    }

    public boolean isMelhorResposta() {
        return melhorResposta;
    }

    public void setMelhorResposta(boolean melhorResposta) {
        this.melhorResposta = melhorResposta;
    }

    public List<Comentario> getComentarios() {
        //return comentarios;
        return new ArrayList<Comentario>();
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public static enum Status {
        APROVADA,
        AGUARDANDO,
        REPROVADA
    }
}
