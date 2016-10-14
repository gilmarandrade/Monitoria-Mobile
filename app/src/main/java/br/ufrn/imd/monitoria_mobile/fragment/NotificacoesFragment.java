package br.ufrn.imd.monitoria_mobile.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.monitoria_mobile.R;
import br.ufrn.imd.monitoria_mobile.adapter.NotificacaoAdapter;
import br.ufrn.imd.monitoria_mobile.model.Notificacao;

public class NotificacoesFragment extends Fragment {
    private static final int DATASET_COUNT = 10;
    protected RecyclerView mRecyclerView;
    protected NotificacaoAdapter mAdapter;
    protected LinearLayoutManager mLayoutManager;
    protected List<Notificacao> mDataset;
    //necessário para o RoundedImageView gerar bitmap
    Resources resources;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize dataset, this data would usually come from a local content provider or
        // remote server.
        initDataset();

        resources =  getActivity().getResources();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_notificacoes, container, false);

        /**
         * recycleview de chat
         * */
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView_notificacoes);
        mRecyclerView.setHasFixedSize(true);
        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Set CustomAdapter as the adapter for RecyclerView.
        mAdapter = new NotificacaoAdapter(mDataset);
        mAdapter.setResources(resources);
        mRecyclerView.setAdapter(mAdapter);


        return rootView;
    }

    /**
     * Generates Strings for RecyclerView's adapter. This data would usually come
     * from a local content provider or remote server.
     */
    private void initDataset() {
        mDataset = new ArrayList<Notificacao>();

        int fotosUsuario[] = {R.drawable.user1, R.drawable.user2, R.drawable.user3, R.drawable.user4, R.drawable.user5, R.drawable.user6};
        String titulos[] = {"Ei, o que é mesmo um Framework?", "Exercício de Revisão", "Dúvida sobre prova por absurdo", "Erro ao compilar Android"};
        String descricoes[] = {"respondeu sua dúvida", "aprovou sua resposta", "comentou sua dúvida", "reprovou sua resposta", "fechou sua dúvida","curtiu sua dúvida"};
        String nomes[] = {"Maria", "João", "Ricardo Rodrigues", "Chico Mendes", "José de Oliveira", "Ana Maria", "Sanderson Melo", "Raianne Alynne", "Jobson Almeida", "Gabriel Garcia"};
        String disciplinas[] = {"DSDM", "CDI I", "FMC II", "DSW II"};
        String datas[] = {"1 min", "2 min", "15 min", "43 min", "2 h", "1 d"};

        for (int i = 0; i < DATASET_COUNT; i++) {
            mDataset.add(new Notificacao(fotosUsuario[i%6], titulos[i%4], nomes[i%10] + " " + descricoes[i%6], disciplinas[i%4], datas[i%6]) );
        }
    }
}
