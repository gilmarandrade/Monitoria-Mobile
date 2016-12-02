package br.ufrn.imd.monitoria_mobile.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import br.ufrn.imd.monitoria_mobile.R;
import br.ufrn.imd.monitoria_mobile.model.Comentario;

public class ComentariosAdapter extends RecyclerView.Adapter<ComentariosAdapter.ComentariosViewHolder> {
    private List<Comentario> list;
    private Context context;

    public ComentariosAdapter(List<Comentario> dataSet, Context context) {
        this.list = dataSet;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(ComentariosAdapter.ComentariosViewHolder comentarioViewHolder, int i) {
        //utiliza a classe Spannable para modificar a cor de partes do texto
        comentarioViewHolder.vDescricao.setText(list.get(i).getDescricao() + " - " + list.get(i).getNomeUsuario() + " " + list.get(i).getDataCriacao(), TextView.BufferType.SPANNABLE);
        Spannable s = (Spannable) comentarioViewHolder.vDescricao.getText();
        int start = list.get(i).getDescricao().length() + 3;
        int end = start + list.get(i).getNomeUsuario().length();
        s.setSpan(new ForegroundColorSpan(Color.rgb(49, 165, 226)), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        start = end + 1;
        end = start + list.get(i).getDataCriacao().length();
        s.setSpan(new ForegroundColorSpan(Color.rgb(102, 110, 93)), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        comentarioViewHolder.vDescricao.setTextSize(14);
    }

    @Override
    public ComentariosAdapter.ComentariosViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.comentario_item_layout, viewGroup, false);

        return new ComentariosAdapter.ComentariosViewHolder(itemView);
    }

    public static class ComentariosViewHolder extends RecyclerView.ViewHolder {
        protected RelativeLayout vComentarioItem;
        protected TextView vDescricao;

        public ComentariosViewHolder(View v) {
            super(v);
            vComentarioItem = (RelativeLayout) v.findViewById(R.id.comentarioitem_item);
            vDescricao = (TextView) v.findViewById(R.id.comentarioitem_descricao);
        }
    }
}
