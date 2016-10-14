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
import br.ufrn.imd.monitoria_mobile.adapter.ChatAdapter;
import br.ufrn.imd.monitoria_mobile.model.Chat;

public class ChatFragment extends Fragment {
    private static final int DATASET_COUNT = 10;
    protected RecyclerView mRecyclerView;
    protected ChatAdapter mAdapter;
    protected LinearLayoutManager mLayoutManager;
    protected List<Chat> mDataset;
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
        View rootView = inflater.inflate(R.layout.fragment_chat, container, false);

        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab_adicionar_chat);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Adicionar Chat não implementado ainda!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        /**
         * recycleview de chat
         * */
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView_chat);
        mRecyclerView.setHasFixedSize(true);
        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Set CustomAdapter as the adapter for RecyclerView.
        mAdapter = new ChatAdapter(mDataset);
        mAdapter.setResources(resources);
        mRecyclerView.setAdapter(mAdapter);


        return rootView;
    }

    /**
     * Generates Strings for RecyclerView's adapter. This data would usually come
     * from a local content provider or remote server.
     */
    private void initDataset() {
        mDataset = new ArrayList<Chat>();

        String nomes[] = {"Maria", "João", "Ricardo Rodrigues", "Chico Mendes", "José de Oliveira", "Ana Maria", "Sanderson Melo", "Raianne Alynne", "Jobson Almeida", "Gabriel Garcia"};
        int fotosUsuario[] = {R.drawable.user1, R.drawable.user2, R.drawable.user3, R.drawable.user4, R.drawable.user5, R.drawable.user6};
        String mensagem[] = {"Ei, quando você estará disponível para a gente conversar sobre aquela dúvida?", "pode ser amanhã na monitoria?", "Sandra Adams - Ainda hoje até as 5h", "Eu disse que era fácil :P", "kkkk", "Clicando com o botão direito no ícone você vai ver as opções exibidas no canto inferior da tela"};
        String dataCriacao[] = {"09:30", "09:35", "10:11", "14/09", "07/09", "01/08"};

        for (int i = 0; i < DATASET_COUNT; i++) {
            mDataset.add( new Chat(nomes[i%10], fotosUsuario[i%6], mensagem[i%6], dataCriacao[i%6]));
        }
    }


}
