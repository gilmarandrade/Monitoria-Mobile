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

public class DuvidasGeralAdapter extends RecyclerView.Adapter<DuvidasGeralAdapter.DuvidasGeralViewHolder> {
    private List<DuvidaSimples> list;
    Resources resources;

    public DuvidasGeralAdapter(List<DuvidaSimples> dataSet) {
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
    public void onBindViewHolder(DuvidasGeralViewHolder duvidaSimplesViewHolder, int i) {
        Drawable roundedImage = RoundedImageView.getRoundedImageView(list.get(i).getImagemUsuario(), 70, 70, 200.0f, this.resources);
        duvidaSimplesViewHolder.vFotoUsuario.setImageDrawable(roundedImage);
        duvidaSimplesViewHolder.vNomeUsuario.setText(list.get(i).getNomeUsuario());
        duvidaSimplesViewHolder.vDisciplina.setText(list.get(i).getDisciplina());

        if(list.get(i).getStatus() == DuvidaSimples.Status.FECHADA){
            duvidaSimplesViewHolder.vStatus.setText("RESOLVIDA");
            duvidaSimplesViewHolder.vStatus.setVisibility(View.VISIBLE);
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

        if(list.get(i).getFoto() != -1){
            Bitmap mBitmap = BitmapFactory.decodeResource(resources, list.get(i).getFoto());
            duvidaSimplesViewHolder.vFoto.setImageBitmap(mBitmap);
            duvidaSimplesViewHolder.vOptionalFoto.setVisibility(View.VISIBLE);
        }else{
            duvidaSimplesViewHolder.vOptionalFoto.setVisibility(View.GONE);
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
    public DuvidasGeralViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
       View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardlayout_duvidasimples, viewGroup, false);

        return new DuvidasGeralViewHolder(itemView);
    }

    public static class DuvidasGeralViewHolder extends RecyclerView.ViewHolder {
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
        protected ImageView vFoto;
        protected RelativeLayout vOptionalFoto;


        public DuvidasGeralViewHolder(View v) {
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
            vOptionalFoto = (RelativeLayout) v.findViewById(R.id.duvidaSimples_opcionalImage);
            vFoto = (ImageView) v.findViewById(R.id.duvidaSimples_foto);

        }
    }
}
