package br.ufrn.imd.monitoria_mobile.model;


public class Chat {
    private String nomeUsuario;
    private int fotoUsuario;
    private String ultimaMensagem;
    private String dataUltimaMensagem;

    public Chat(String nomeUsuario, int fotoUsuario, String ultimaMensagem, String dataUltimaMensagem) {
        this.nomeUsuario = nomeUsuario;
        this.fotoUsuario = fotoUsuario;
        this.ultimaMensagem = ultimaMensagem;
        this.dataUltimaMensagem = dataUltimaMensagem;
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

    public String getUltimaMensagem() {
        return ultimaMensagem;
    }

    public void setUltimaMensagem(String ultimaMensagem) {
        this.ultimaMensagem = ultimaMensagem;
    }

    public String getDataUltimaMensagem() {
        return dataUltimaMensagem;
    }

    public void setDataUltimaMensagem(String dataUltimaMensagem) {
        this.dataUltimaMensagem = dataUltimaMensagem;
    }
}
