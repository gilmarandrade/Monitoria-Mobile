package br.ufrn.imd.monitoria_mobile.activity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import br.ufrn.imd.monitoria_mobile.R;
import br.ufrn.imd.monitoria_mobile.adapter.ComentariosAdapter;
import br.ufrn.imd.monitoria_mobile.adapter.RespostasAdapter;
import br.ufrn.imd.monitoria_mobile.helper.RoundedImageView;
import br.ufrn.imd.monitoria_mobile.model.Comentario;
import br.ufrn.imd.monitoria_mobile.model.Duvida;
import br.ufrn.imd.monitoria_mobile.model.Resposta;

public class AlunoDetalhesDuvidaActivity extends AppCompatActivity {

    protected RecyclerView mRecyclerViewRespostas;
    protected RespostasAdapter mAdapterRespostas;
    protected LinearLayoutManager mLayoutManagerRespostas;
    protected List<Resposta> mDatasetRespostas;
    protected RecyclerView mRecyclerViewComentarios;
    protected ComentariosAdapter mAdapterComentarios;
    protected LinearLayoutManager mLayoutManagerComentarios;
    protected List<Comentario> mDatasetComentarios;
    private TextView vNomeUsuario;
    private ImageView vFotoUsuario;
    private TextView vDataCriacao;
    private TextView vStatus;
    private RelativeLayout vOptionalImage;
    private ImageView vFoto;
    private TextView vTitulo;
    private TextView vDescricao;
    private TextView vQtdComentarios;
    private TextView vQtdRespostas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno_detalhes_duvida);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent i = getIntent();
        final Duvida duvida = (Duvida) i.getSerializableExtra("duvida");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ResponderDuvida.class);
                i.putExtra("duvida", duvida);
                startActivity(i);
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

        vQtdComentarios = (TextView) findViewById(R.id.detalhesduvida_qtdComentarios);
        vQtdRespostas = (TextView) findViewById(R.id.detalhesduvida_qtdRespostas);


        ActionBar ab = getSupportActionBar();
        ab.setTitle(duvida.getDisciplina());

        vNomeUsuario.setText(duvida.getNomeUsuario());
        Drawable roundedImage = RoundedImageView.getRoundedImageView(duvida.getImagemUsuario(), 70, 70, 200.0f, getResources());
        vFotoUsuario.setImageDrawable(roundedImage);
        vDataCriacao.setText(duvida.getDataCriacao());

        if (duvida.getStatus() == Duvida.Status.FECHADA) {
            vStatus.setText("RESOLVIDA");
            vStatus.setVisibility(View.VISIBLE);
        } else {
            vStatus.setVisibility(View.INVISIBLE);
        }

        if (duvida.getFoto() > -1) {
            vFoto.setImageBitmap(BitmapFactory.decodeResource(getResources(), duvida.getFoto()));
        } else {
            vOptionalImage.setVisibility(View.GONE);
        }

        vTitulo.setText(duvida.getTitulo());
        vDescricao.setText(duvida.getDescricao());

        vQtdComentarios.setText(duvida.getComentarios().size() + " comentários");
        vQtdComentarios.setText(duvida.getComentarios().size() + " comentários");
        vQtdRespostas.setText(duvida.getRespostas().size() + " respostas");


        /**
         * recycleview de comentarios da duvida
         * */

        // Initialize dataset, this data would usually come from a local content provider or
        // remote server.
        mDatasetComentarios = duvida.getComentarios();

        mRecyclerViewComentarios = (RecyclerView) findViewById(R.id.recyclerView_detalhesduvida_comentarios);
        mRecyclerViewComentarios.setHasFixedSize(true);
        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        mLayoutManagerComentarios = new LinearLayoutManager(this);
        mLayoutManagerComentarios.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerViewComentarios.setLayoutManager(mLayoutManagerComentarios);

        // Set CustomAdapter as the adapter for RecyclerView.
        mAdapterComentarios = new ComentariosAdapter(mDatasetComentarios, this.getApplicationContext());
        mRecyclerViewComentarios.setAdapter(mAdapterComentarios);


        /**
         * recycleview de respostas para a duvida
         * */

        // Initialize dataset, this data would usually come from a local content provider or
        // remote server.
        mDatasetRespostas = duvida.getRespostas();

        mRecyclerViewRespostas = (RecyclerView) findViewById(R.id.recyclerView_detalhesduvida_resposta);
        mRecyclerViewRespostas.setHasFixedSize(true);
        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        mLayoutManagerRespostas = new LinearLayoutManager(this);
        mLayoutManagerRespostas.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerViewRespostas.setLayoutManager(mLayoutManagerRespostas);

        // Set CustomAdapter as the adapter for RecyclerView.
        mAdapterRespostas = new RespostasAdapter(mDatasetRespostas, this.getApplicationContext());
        mRecyclerViewRespostas.setAdapter(mAdapterRespostas);
    }

}
