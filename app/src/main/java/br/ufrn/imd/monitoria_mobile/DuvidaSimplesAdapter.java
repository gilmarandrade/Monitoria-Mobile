package br.ufrn.imd.monitoria_mobile;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.ufrn.imd.monitoria_mobile.model.DuvidaSimples;

/**
 * Created by gilmar.andrade on 13/10/2016.
 */

public class DuvidaSimplesAdapter  extends RecyclerView.Adapter<DuvidaSimplesAdapter.DuvidaSimplesViewHolder> {
    private List<DuvidaSimples> list;

    public DuvidaSimplesAdapter(List<DuvidaSimples> dataSet) {
        this.list = dataSet;
    }

    @Override
    public int getItemCount() {
        return list.size()
    }

    @Override
    public void onBindViewHolder(DuvidaSimplesAdapter.DuvidaSimplesViewHolder duvidaSimplesViewHolder, int i) {

        duvidaSimplesViewHolder.vCardIndice.setText(list[i]);
    }

    @Override
    public DuvidaSimplesAdapter.DuvidaSimplesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.cardLayout_duvidaSimples, viewGroup, false);

        return new DuvidaSimplesAdapter.DuvidaSimplesViewHolder(itemView);
    }

    public static class DuvidaSimplesViewHolder extends RecyclerView.ViewHolder {
        protected TextView vCardIndice;

        public DuvidaSimplesViewHolder(View v) {
            super(v);
            vCardIndice = (TextView) v.findViewById(R.id.card_indice);
        }
    }
}
