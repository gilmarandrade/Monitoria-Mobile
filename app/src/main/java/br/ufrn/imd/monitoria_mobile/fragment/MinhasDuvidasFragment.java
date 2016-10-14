package br.ufrn.imd.monitoria_mobile.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.monitoria_mobile.R;
import br.ufrn.imd.monitoria_mobile.adapter.MinhasDuvidasAdapter;
import br.ufrn.imd.monitoria_mobile.model.DuvidaSimples;


public class MinhasDuvidasFragment extends Fragment {
    private static final int DATASET_COUNT = 10;
    protected RecyclerView mRecyclerView;
    protected MinhasDuvidasAdapter mAdapter;
    protected LinearLayoutManager mLayoutManager;
    protected List<DuvidaSimples> mDataset;
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
        View rootView = inflater.inflate(R.layout.fragment_minhas_duvidas, container, false);

        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab_adicionar_duvida_minhas);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Adicionar Dúvida não implementado ainda!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        /**
         * recycleview de minhas duvidas
         * */
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView_minhas_duvidas);
        mRecyclerView.setHasFixedSize(true);
        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Set CustomAdapter as the adapter for RecyclerView.
        mAdapter = new MinhasDuvidasAdapter(mDataset);
        mAdapter.setResources(resources);
        mRecyclerView.setAdapter(mAdapter);


        return rootView;
    }

    /**
     * Generates Strings for RecyclerView's adapter. This data would usually come
     * from a local content provider or remote server.
     */
    private void initDataset() {
        mDataset = new ArrayList<DuvidaSimples>();

        String nomes[] = {"John Connor"};
        int fotosUsuario[] = {R.drawable.user1};
        String disciplinas[] = {"DSW I - Desenvolvimento de Sistemas Web I", "FMC I - Fundamentos Matemáticos da Computação I", "CDI I - Cálculo Diferencial e Integral I", "DSDM - Desenvolvimento de Sistemas para Dispositivos Móveis"};
        int fotos[] = {-1, -1, R.drawable.foto2, R.drawable.foto1, -1, R.drawable.foto3};
        String titulos[] = {"Socorro Alguém me ajuda!", "JavaFX Threads Atualizar UI e carregar Sistema em segundo plano", "Qual a diferença entre os métodos virtual e abstract?", "Como filtrar um Texto em uma div com angular JS", "Retorno de seleção de radiobutton em C#", "Problemas com autoload"};
        String descricoes[] = {"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."};
        int curtidas[] = {1, 5, 8, 0, 0, 4, 8, 10, 5, 8, 1, 9, 4, 5, 2, 3, 9, 0, 3, 5};
        int respostas[] = {9, 0, 3, 5, 8, 8, 0, 5, 2, 1, 0, 4, 5, 0, 1, 13, 8, 5, 9, 4};
        DuvidaSimples.Status status[] = {DuvidaSimples.Status.ABERTA , DuvidaSimples.Status.ABERTA , DuvidaSimples.Status.FECHADA, DuvidaSimples.Status.ABERTA , DuvidaSimples.Status.FECHADA};

        for (int i = 0; i < DATASET_COUNT; i++) {
            mDataset.add(new DuvidaSimples(nomes[i%1], fotosUsuario[i%1], disciplinas[i%4], fotos[i%6], titulos[i%6], descricoes[i%3], curtidas[i%20],  respostas[i%20], status[i%5] ));
        }
    }
}
