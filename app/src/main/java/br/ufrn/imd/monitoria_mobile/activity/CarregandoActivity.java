package br.ufrn.imd.monitoria_mobile.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import br.ufrn.imd.monitoria_mobile.dominio.OAuthTokenRequest;
import br.ufrn.imd.monitoria_mobile.dominio.Perfil;

import br.ufrn.imd.monitoria_mobile.R;
import br.ufrn.imd.monitoria_mobile.model.Dados;
import br.ufrn.imd.monitoria_mobile.model.Duvida;
public class CarregandoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carregando);
        getPerfil();
    }

    private void getPerfil(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://172.20.10.4:8080/monitoria/api/entrar/"+ OAuthTokenRequest.getInstance().getCredential().getAccessToken();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new GsonBuilder().create();
                        Perfil perfil = gson.fromJson(response, Perfil.class);
                        Dados.setPerfil(perfil);
                        intent();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),
                        error.toString(), Toast.LENGTH_LONG).show();
                getPerfil();
            }
        });
        queue.add(stringRequest);
    }

    private void intent(){
        Intent i = new Intent(this, AlunoMainActivity.class);
        startActivity(i);
    }

    private void getDuvidas(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://192.168.0.6/monitoria/api/duvida/todas/"+ Dados.getPerfil().getPessoa().getId();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new GsonBuilder().create();
                        Type typeOfList = new TypeToken<List<Duvida>>() {
                        }.getType();
                        List<Duvida> duvidas = gson.fromJson(response, typeOfList);
                        Dados.setDuvidas(duvidas);
                        intent();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),
                        error.toString(), Toast.LENGTH_LONG).show();

            }
        });
        queue.add(stringRequest);

    }
}
