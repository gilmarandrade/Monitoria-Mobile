package br.ufrn.imd.monitoria_mobile.model;

import android.os.Bundle;

import java.util.List;

import br.ufrn.imd.monitoria_mobile.dominio.Perfil;
/**
 * Created by luciosoares on 28/11/16.
 */

public class Dados {
    private static Dados dados = new Dados();

    private static Perfil perfil;


    private static List<Duvida> duvidas;

    public static Dados getDados() {
        return dados;
    }

    public static void setDados(Dados dados) {
        Dados.dados = dados;
    }

    public static Perfil getPerfil() {
        return perfil;
    }

    public static void setPerfil(Perfil perfil) {
        Dados.perfil = perfil;
    }

    public static List<Duvida> getDuvidas() {
        return duvidas;
    }

    public static void setDuvidas(List<Duvida> duvidas) {
        Dados.duvidas = duvidas;
    }
}
