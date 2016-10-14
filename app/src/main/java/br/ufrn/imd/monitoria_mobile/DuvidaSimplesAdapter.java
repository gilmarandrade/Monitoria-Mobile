package br.ufrn.imd.monitoria_mobile;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.ufrn.imd.monitoria_mobile.br.ufrn.imd.monitoria_mobile.helper.RoundedImageView;
import br.ufrn.imd.monitoria_mobile.model.DuvidaSimples;

public class DuvidaSimplesAdapter  extends RecyclerView.Adapter<DuvidaSimplesAdapter.DuvidaSimplesViewHolder> {
    private List<DuvidaSimples> list;
    Resources resources;

    public DuvidaSimplesAdapter(List<DuvidaSimples> dataSet) {
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
    public void onBindViewHolder(DuvidaSimplesAdapter.DuvidaSimplesViewHolder duvidaSimplesViewHolder, int i) {
        Drawable roundedImage = RoundedImageView.getRoundedImageView(list.get(i).getImagemUsuario(), 80, 80, 200.0f, this.resources);
        duvidaSimplesViewHolder.vFotoUsuario.setImageDrawable(roundedImage);
        duvidaSimplesViewHolder.vNomeUsuario.setText(list.get(i).getNomeUsuario());
        duvidaSimplesViewHolder.vDisciplina.setText(list.get(i).getDisciplina());

        if(list.get(i).getStatus() == DuvidaSimples.Status.FECHADA){
            duvidaSimplesViewHolder.vStatus.setText("RESOLVIDA");
        }else{
            duvidaSimplesViewHolder.vStatus.setVisibility(View.INVISIBLE);
        }
        duvidaSimplesViewHolder.vTitulo.setText(list.get(i).getTitulo());
        duvidaSimplesViewHolder.vDescricao.setText(list.get(i).getDescricao());
        duvidaSimplesViewHolder.vCurtidas.setText(list.get(i).getTotalCurtidas() + " curtidas");
        duvidaSimplesViewHolder.vRespostas.setText(list.get(i).getTotalRespostas() + " respostas");

        if(list.get(i).getTotalCurtidas() >=5){
            duvidaSimplesViewHolder.vBtnCurtir.setVisibility(View.GONE);
            duvidaSimplesViewHolder.vBtnDescurtir.setVisibility(View.VISIBLE);
        }else{
           duvidaSimplesViewHolder.vBtnCurtir.setVisibility(View.VISIBLE);
           duvidaSimplesViewHolder.vBtnDescurtir.setVisibility(View.GONE);
        }

        duvidaSimplesViewHolder.vCard.setOnClickListener(
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
    public DuvidaSimplesAdapter.DuvidaSimplesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
       View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardlayout_duvidasimples, viewGroup, false);

        return new DuvidaSimplesAdapter.DuvidaSimplesViewHolder(itemView);
    }

    public static class DuvidaSimplesViewHolder extends RecyclerView.ViewHolder {
        protected TextView vNomeUsuario;
        protected ImageView vFotoUsuario;
        protected TextView vDisciplina;
        protected TextView vStatus;
        protected TextView vTitulo;
        protected TextView vDescricao;
        protected TextView vCurtidas;
        protected TextView vRespostas;

        protected Button vBtnCurtir;
        protected Button vBtnDescurtir;
        protected Button vBtnResponder;

        protected CardView vCard;


        public DuvidaSimplesViewHolder(View v) {
            super(v);
            vNomeUsuario = (TextView) v.findViewById(R.id.duvidaSimples_nomeUsusario);
            vFotoUsuario = (ImageView) v.findViewById(R.id.duvidaSimples_fotoUsusario);
            vDisciplina = (TextView) v.findViewById(R.id.duvidaSimples_disciplina);
            vStatus = (TextView) v.findViewById(R.id.duvidaSimples_status);
            vTitulo = (TextView) v.findViewById(R.id.duvidaSimples_titulo);
            vDescricao = (TextView) v.findViewById(R.id.duvidaSimples_descricao);
            vCurtidas = (TextView) v.findViewById(R.id.duvidaSimples_curtidas);
            vRespostas = (TextView) v.findViewById(R.id.duvidaSimples_respostas);

            vBtnCurtir = (Button) v.findViewById(R.id.duvidaSimples_btnCurtir);
            vBtnDescurtir = (Button) v.findViewById(R.id.duvidaSimples_btnDescurtir);
            vBtnResponder = (Button) v.findViewById(R.id.duvidaSimples_btnResponder);

            vCard = (CardView) v.findViewById(R.id.duvidaSimples_card);
        }
    }
}