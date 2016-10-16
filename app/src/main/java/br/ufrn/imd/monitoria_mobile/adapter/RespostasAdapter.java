package br.ufrn.imd.monitoria_mobile.adapter;


import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
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
import br.ufrn.imd.monitoria_mobile.model.Comentario;
import br.ufrn.imd.monitoria_mobile.model.Resposta;

public class RespostasAdapter extends RecyclerView.Adapter<RespostasAdapter.RespostasViewHolder>{

    private List<Resposta> list;
    private Context context;


    private static final int DATASET_COUNT = 10;
    protected RecyclerView mRecyclerView;
    protected ComentariosAdapter mAdapter;
    protected LinearLayoutManager mLayoutManager;
    protected List<Comentario> mDataset;

    public RespostasAdapter(List<Resposta> dataSet, Context context) {
        this.list = dataSet;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    @Override
    public void onBindViewHolder(RespostasAdapter.RespostasViewHolder respostasViewHolder, int i) {
        Drawable roundedImage = RoundedImageView.getRoundedImageView(list.get(i).getFotoUsuario(), 70, 70, 200.0f, this.context.getResources());
        respostasViewHolder.vFotoUsuario.setImageDrawable(roundedImage);
        respostasViewHolder.vNomeUsuario.setText(list.get(i).getNomeUsuario());
        respostasViewHolder.vData.setText(list.get(i).getData());
        if(list.get(i).getStatus() == Resposta.Status.REPROVADA){
            respostasViewHolder.vStatus.setTextColor(Color.rgb(229, 57,53));
        }else if(list.get(i).getStatus() == Resposta.Status.APROVADA){
            respostasViewHolder.vStatus.setTextColor(Color.rgb(67, 160,61));
        }else{
            respostasViewHolder.vStatus.setTextColor(Color.rgb(153, 153, 153));
        }
        respostasViewHolder.vStatus.setText(list.get(i).getStatus().toString());
        respostasViewHolder.vDescricao.setText(list.get(i).getDescricao());

        if(list.get(i).isMelhorResposta()){
            respostasViewHolder.vRespostaItem.setBackgroundColor(Color.rgb(220,237, 200));
            respostasViewHolder.vStatus.setText("MELHOR RESPOSTA");
        }else{
            respostasViewHolder.vRespostaItem.setBackgroundColor(Color.rgb(255,255, 255));
        }



        // Initialize dataset, this data would usually come from a local content provider or
        // remote server.
        initDataset(list.get(i).getComentarios());

        /**
         * recycleview de comentarios da resposta
         * */
        mRecyclerView = (RecyclerView) respostasViewHolder.viewRoot.findViewById(R.id.recyclerView_resposta_comentarios);
        mRecyclerView.setHasFixedSize(true);
        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        mLayoutManager = new LinearLayoutManager(this.context);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Set CustomAdapter as the adapter for RecyclerView.
        mAdapter = new ComentariosAdapter(mDataset, this.context.getApplicationContext());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public RespostasAdapter.RespostasViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardlayout_resposta, viewGroup, false);

        return new RespostasAdapter.RespostasViewHolder(itemView);
    }

    public static class RespostasViewHolder extends RecyclerView.ViewHolder {
        protected TextView vNomeUsuario;
        protected ImageView vFotoUsuario;
        protected TextView vData;
        protected TextView vStatus;
        protected TextView vDescricao;


        protected RelativeLayout vRespostaItem;

        protected View viewRoot;


        public RespostasViewHolder(View v) {
            super(v);
            vNomeUsuario = (TextView) v.findViewById(R.id.resposta_nomeUsusario);
            vFotoUsuario = (ImageView) v.findViewById(R.id.resposta_fotoUsusario);
            vData = (TextView) v.findViewById(R.id.resposta_data);
            vStatus = (TextView) v.findViewById(R.id.resposta_status);
            vDescricao = (TextView) v.findViewById(R.id.resposta_descricao);

            vRespostaItem = (RelativeLayout) v.findViewById(R.id.resposta_resposta);

            viewRoot = v;

        }
    }


    /**
     * Generates Strings for RecyclerView's adapter. This data would usually come
     * from a local content provider or remote server.
     */
    private void initDataset(List<Comentario> comentarios) {
        mDataset = comentarios;
    }

}
