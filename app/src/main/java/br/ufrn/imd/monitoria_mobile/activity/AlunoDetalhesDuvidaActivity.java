package br.ufrn.imd.monitoria_mobile.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import br.ufrn.imd.monitoria_mobile.R;
import br.ufrn.imd.monitoria_mobile.helper.RoundedImageView;
import br.ufrn.imd.monitoria_mobile.model.Duvida;

public class AlunoDetalhesDuvidaActivity extends AppCompatActivity {
    private TextView vNomeUsuario;
    private ImageView vFotoUsuario;
    private TextView vDataCriacao;
    private TextView vStatus;

    private RelativeLayout vOptionalImage;
    private ImageView vFoto;

    private TextView vTitulo;
    private TextView vDescricao;

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



        vNomeUsuario = (TextView) findViewById(R.id.detalhesduvida_nomeUsuario);
        vFotoUsuario = (ImageView) findViewById(R.id.detalhesduvida_fotoUsusario);
        vDataCriacao = (TextView) findViewById(R.id.detalhesduvida_data);
        vStatus = (TextView) findViewById(R.id.detalhesduvida_status);

        vOptionalImage = (RelativeLayout) findViewById(R.id.detalhesduvida_opcionalImage);
        vFoto = (ImageView) findViewById(R.id.detalhesduvida_foto);

        vTitulo = (TextView) findViewById(R.id.detalhesduvida_titulo);
        vDescricao = (TextView) findViewById(R.id.detalhesduvida_descricao);


        Intent i = getIntent();
        Duvida duvida = (Duvida) i.getSerializableExtra("duvida");

        ActionBar ab = getSupportActionBar();
        ab.setTitle(duvida.getDisciplina());

        vNomeUsuario.setText(duvida.getNomeUsuario());
        Drawable roundedImage = RoundedImageView.getRoundedImageView(duvida.getImagemUsuario(), 70, 70, 200.0f, getResources());
        vFotoUsuario.setImageDrawable(roundedImage);
        vDataCriacao.setText(duvida.getDataCriacao());

        if(duvida.getStatus() == Duvida.Status.FECHADA){
            vStatus.setText("RESOLVIDA");
            vStatus.setVisibility(View.VISIBLE);
        }else{
            vStatus.setVisibility(View.INVISIBLE);
        }

        if(duvida.getFoto() > -1){
            vFoto.setImageBitmap(BitmapFactory.decodeResource(getResources(), duvida.getFoto()));
        }else{
            vOptionalImage.setVisibility(View.GONE);
        }

        vTitulo.setText(duvida.getTitulo());
        vDescricao.setText(duvida.getDescricao());




    }
}
