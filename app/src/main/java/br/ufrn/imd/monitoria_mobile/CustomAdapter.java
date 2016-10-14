package br.ufrn.imd.monitoria_mobile;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


@Deprecated
public class CustomAdapter  extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    private String[] list;

    public CustomAdapter(String[] dataSet) {
        this.list = dataSet;
    }

    @Override
    public int getItemCount() {
        return list.length;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder contactViewHolder, int i) {

        contactViewHolder.vCardIndice.setText(list[i]);
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_layout, viewGroup, false);

        return new CustomViewHolder(itemView);
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView vCardIndice;

        public CustomViewHolder(View v) {
            super(v);
            vCardIndice = (TextView) v.findViewById(R.id.card_indice);
        }
    }
}
