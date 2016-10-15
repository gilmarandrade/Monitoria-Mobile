package br.ufrn.imd.monitoria_mobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import br.ufrn.imd.monitoria_mobile.R;

public class AlunoDetalhesDuvidaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno_detalhes_duvida);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Responder dúvida não implementado ainda", Snackbar.LENGTH_LONG)
                       .setAction("Action", null).show();
            }
        });

        ActionBar ab = getSupportActionBar();
        ab.setTitle("DSDM - Desenvolvimento de Sistemas para Dispositivos Móveis");
    }
}
