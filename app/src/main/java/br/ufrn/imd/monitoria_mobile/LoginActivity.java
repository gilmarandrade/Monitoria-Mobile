package br.ufrn.imd.monitoria_mobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.ufrn.imd.monitoria_mobile.helper.OAuthTokenRequest;

import br.ufrn.imd.monitoria_mobile.activity.AlunoMainActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void logar(View view) {
        Intent i = new Intent(this, AlunoMainActivity.class);
        OAuthTokenRequest.getInstance().getTokenCredential(this,"http://api.info.ufrn.br/authz-server","client_id", "client_secret", i);
    }
}
