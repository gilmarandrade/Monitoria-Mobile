package br.ufrn.imd.monitoria_mobile.adapter;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import br.ufrn.imd.monitoria_mobile.R;
import br.ufrn.imd.monitoria_mobile.helper.RoundedImageView;
import br.ufrn.imd.monitoria_mobile.model.DuvidaSimples;

/**
 * Created by gilmar.andrade on 14/10/2016.
 */

public class DuvidasTurmaAdapter extends RecyclerView.Adapter<DuvidasTurmaAdapter.DuvidasTurmaViewHolder>  {
    private List<DuvidaSimples> list;
    Resources resources;

    public DuvidasTurmaAdapter(List<DuvidaSimples> dataSet) {
        this.list = dataSet;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(DuvidasTurmaAdapter.DuvidasTurmaViewHolder duvidasTurmaViewHolder, int i) {
        Drawable roundedImage = RoundedImageView.getRoundedImageView(list.get(i).getImagemUsuario(), 70, 70, 200.0f, this.resources);
        duvidasTurmaViewHolder.vFotoUsuario.setImageDrawable(roundedImage);
        duvidasTurmaViewHolder.vNomeUsuario.setText(list.get(i).getNomeUsuario());
        duvidasTurmaViewHolder.vData.setText(list.get(i).getDataCriacao());
        duvidasTurmaViewHolder.vDisciplina.setVisibility(View.INVISIBLE);
        duvidasTurmaViewHolder.vData.setVisibility(View.VISIBLE);

        if(list.get(i).getStatus() == DuvidaSimples.Status.FECHADA){
            duvidasTurmaViewHolder.vStatus.setText("RESOLVIDA");
            duvidasTurmaViewHolder.vStatus.setVisibility(View.VISIBLE);
        }else{
            duvidasTurmaViewHolder.vStatus.setVisibility(View.INVISIBLE);
        }
        duvidasTurmaViewHolder.vTitulo.setText(list.get(i).getTitulo());
        duvidasTurmaViewHolder.vDescricao.setText(list.get(i).getDescricao());
        duvidasTurmaViewHolder.vCurtidas.setText(list.get(i).getTotalCurtidas() + " curtidas");
        duvidasTurmaViewHolder.vRespostas.setText(list.get(i).getTotalRespostas() + " respostas");

        if(list.get(i).getTotalCurtidas() >=5){
            duvidasTurmaViewHolder.vBtnCurtir.setVisibility(View.GONE);
            duvidasTurmaViewHolder.vBtnDescurtir.setVisibility(View.VISIBLE);
        }else{
            duvidasTurmaViewHolder.vBtnCurtir.setVisibility(View.VISIBLE);
            duvidasTurmaViewHolder.vBtnDescurtir.setVisibility(View.GONE);
        }

        if(list.get(i).getFoto() != -1){
            Bitmap mBitmap = BitmapFactory.decodeResource(resources, list.get(i).getFoto());
            duvidasTurmaViewHolder.vFoto.setImageBitmap(mBitmap);
            duvidasTurmaViewHolder.vOptionalFoto.setVisibility(View.VISIBLE);
        }else{
            duvidasTurmaViewHolder.vOptionalFoto.setVisibility(View.GONE);
        }


        duvidasTurmaViewHolder.vCard.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Snackbar.make(v, "Ver detalhes da dúvida não implementado ainda!", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                }
        );

    }

    @Override
    public DuvidasTurmaAdapter.DuvidasTurmaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardlayout_duvidasimples, viewGroup, false);

        return new DuvidasTurmaAdapter.DuvidasTurmaViewHolder(itemView);
    }

    public static class DuvidasTurmaViewHolder extends RecyclerView.ViewHolder {
        protected TextView vNomeUsuario;
        protected ImageView vFotoUsuario;
        protected TextView vDisciplina;
        protected TextView vData;
        protected TextView vStatus;
        protected TextView vTitulo;
        protected TextView vDescricao;
        protected TextView vCurtidas;
        protected TextView vRespostas;

        protected Button vBtnCurtir;
        protected Button vBtnDescurtir;
        protected Button vBtnResponder;

        protected CardView vCard;
        protected ImageView vFoto;
        protected RelativeLayout vOptionalFoto;


        public DuvidasTurmaViewHolder(View v) {
            super(v);
            vNomeUsuario = (TextView) v.findViewById(R.id.duvidaSimples_nomeUsusario);
            vFotoUsuario = (ImageView) v.findViewById(R.id.duvidaSimples_fotoUsusario);
            vDisciplina = (TextView) v.findViewById(R.id.duvidaSimples_disciplina);
            vData = (TextView) v.findViewById(R.id.duvidaSimples_data);
            vStatus = (TextView) v.findViewById(R.id.duvidaSimples_status);
            vTitulo = (TextView) v.findViewById(R.id.duvidaSimples_titulo);
            vDescricao = (TextView) v.findViewById(R.id.duvidaSimples_descricao);
            vCurtidas = (TextView) v.findViewById(R.id.duvidaSimples_curtidas);
            vRespostas = (TextView) v.findViewById(R.id.duvidaSimples_respostas);

            vBtnCurtir = (Button) v.findViewById(R.id.duvidaSimples_btnCurtir);
            vBtnDescurtir = (Button) v.findViewById(R.id.duvidaSimples_btnDescurtir);
            vBtnResponder = (Button) v.findViewById(R.id.duvidaSimples_btnResponder);

            vCard = (CardView) v.findViewById(R.id.duvidaSimples_card);
            vOptionalFoto = (RelativeLayout) v.findViewById(R.id.duvidaSimples_opcionalImage);
            vFoto = (ImageView) v.findViewById(R.id.duvidaSimples_foto);

        }
    }
}