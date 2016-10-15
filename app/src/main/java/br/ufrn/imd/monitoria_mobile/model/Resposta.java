package br.ufrn.imd.monitoria_mobile.model;

import java.io.Serializable;
import java.util.List;

public class Resposta implements Serializable {

    private String nomeUsuario;
    private int fotoUsuario;
    private String data;
    private String descricao;
    private Status Status;
    private boolean melhorResposta;
    private List<Comentario> comentarios;

    public static enum Status {
        APROVADA,
        AGUARDANDO,
        REPROVADA
    }

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
}
