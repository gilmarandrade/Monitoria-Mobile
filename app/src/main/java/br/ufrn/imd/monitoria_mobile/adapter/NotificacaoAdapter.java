package br.ufrn.imd.monitoria_mobile.adapter;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import br.ufrn.imd.monitoria_mobile.R;
import br.ufrn.imd.monitoria_mobile.helper.RoundedImageView;
import br.ufrn.imd.monitoria_mobile.model.Notificacao;

public class NotificacaoAdapter extends RecyclerView.Adapter<NotificacaoAdapter.NotificacaoViewHolder> {
    private List<Notificacao> list;
    private Context context;

    public NotificacaoAdapter(List<Notificacao> dataSet, Context context) {
        this.list = dataSet;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(NotificacaoAdapter.NotificacaoViewHolder notificacaoViewHolder, int i) {
        Drawable roundedImage = RoundedImageView.getRoundedImageView(list.get(i).getFotoUsuario(), 70, 70, 200.0f, this.context.getResources());
        notificacaoViewHolder.vFotoUsuario.setImageDrawable(roundedImage);
        notificacaoViewHolder.vTitulo.setText(list.get(i).getTitulo());
        notificacaoViewHolder.vDescricao.setText(list.get(i).getDescricao());
        notificacaoViewHolder.vData.setText(list.get(i).getData());


        notificacaoViewHolder.vNotificacaoItem.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Snackbar.make(v, "Ver notificação não implementado ainda!", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                }
        );

    }

    @Override
    public NotificacaoAdapter.NotificacaoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.notificacao_item_layout, viewGroup, false);

        return new NotificacaoAdapter.NotificacaoViewHolder(itemView);
    }

    public static class NotificacaoViewHolder extends RecyclerView.ViewHolder {
        protected RelativeLayout vNotificacaoItem;
        protected ImageView vFotoUsuario;
        protected TextView vTitulo;
        protected TextView vDescricao;
        protected TextView vData;

        public NotificacaoViewHolder(View v) {
            super(v);
            vNotificacaoItem = (RelativeLayout) v.findViewById(R.id.notificacaoitem_item);
            vFotoUsuario = (ImageView) v.findViewById(R.id.notificacaoitem_fotoUsuario);
            vTitulo = (TextView) v.findViewById(R.id.notificacaoitem_titulo);
            vDescricao = (TextView) v.findViewById(R.id.notificacaoitem_descricao);
            vData = (TextView) v.findViewById(R.id.notificacaoitem_data);
        }
    }

}
