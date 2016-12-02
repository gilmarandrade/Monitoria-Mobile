package br.ufrn.imd.monitoria_mobile.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import br.ufrn.imd.monitoria_mobile.R;
import br.ufrn.imd.monitoria_mobile.dominio.*;

import br.ufrn.imd.monitoria_mobile.activity.AlunoMainActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view) {
        Intent i = new Intent(this, AlunoMainActivity.class);
        OAuthTokenRequest.getInstance().getTokenCredential(this,"http://apitestes.info.ufrn.br/authz-server",DadosApi.CLIENT_ID, DadosApi.CLIENT_SECRET, i);
    }
}
