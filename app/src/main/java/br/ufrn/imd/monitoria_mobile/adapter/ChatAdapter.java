package br.ufrn.imd.monitoria_mobile.adapter;


import android.content.res.Resources;
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
import br.ufrn.imd.monitoria_mobile.model.Chat;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {
    private List<Chat> list;
    Resources resources;

    public ChatAdapter(List<Chat> dataSet) {
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
    public void onBindViewHolder(ChatAdapter.ChatViewHolder chatViewHolder, int i) {
        Drawable roundedImage = RoundedImageView.getRoundedImageView(list.get(i).getFotoUsuario(), 70, 70, 200.0f, this.resources);
        chatViewHolder.vFotoUsuario.setImageDrawable(roundedImage);
        chatViewHolder.vTitulo.setText(list.get(i).getNomeUsuario());
        chatViewHolder.vDescricao.setText(list.get(i).getUltimaMensagem());
        chatViewHolder.vData.setText(list.get(i).getDataUltimaMensagem());


        chatViewHolder.vChatItem.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Snackbar.make(v, "Ver chat não implementado ainda!", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                }
        );

    }

    @Override
    public ChatAdapter.ChatViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_item_layout, viewGroup, false);

        return new  ChatAdapter.ChatViewHolder(itemView);
    }

    public static class ChatViewHolder extends RecyclerView.ViewHolder {
        protected RelativeLayout vChatItem;
        protected ImageView vFotoUsuario;
        protected TextView vTitulo;
        protected TextView vDescricao;
        protected TextView vData;

        public ChatViewHolder(View v) {
            super(v);
            vChatItem = (RelativeLayout) v.findViewById(R.id.chatitem_item);
            vFotoUsuario = (ImageView) v.findViewById(R.id.chatitem_fotoUsuario);
            vTitulo = (TextView) v.findViewById(R.id.chatitem_titulo);
            vDescricao = (TextView) v.findViewById(R.id.chatitem_descricao);
            vData = (TextView) v.findViewById(R.id.chatitem_data);
        }
    }
}
