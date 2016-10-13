package br.ufrn.imd.monitoria_mobile;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
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
        duvidaSimplesViewHolder.vStatus.setText(list.get(i).getStatus().toString());
        duvidaSimplesViewHolder.vTitulo.setText(list.get(i).getTitulo());
        duvidaSimplesViewHolder.vDescricao.setText(list.get(i).getDescricao());
        duvidaSimplesViewHolder.vCurtidas.setText(list.get(i).getTotalCurtidas() + " curtidas");
        duvidaSimplesViewHolder.vRespostas.setText(list.get(i).getTotalRespostas() + " respostas");
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
        }
    }
}
