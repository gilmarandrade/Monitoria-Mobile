package br.ufrn.imd.monitoria_mobile.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.monitoria_mobile.R;
import br.ufrn.imd.monitoria_mobile.adapter.DuvidasGeralAdapter;
import br.ufrn.imd.monitoria_mobile.model.Comentario;
import br.ufrn.imd.monitoria_mobile.model.Duvida;


public class DuvidasGeralFragment extends Fragment {
    private static final int DATASET_COUNT = 10;
    protected RecyclerView mRecyclerView;
    protected DuvidasGeralAdapter mAdapter;
    protected LinearLayoutManager mLayoutManager;
    protected List<Duvida> mDataset;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize dataset, this data would usually come from a local content provider or
        // remote server.
        initDataset();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_duvidas_geral, container, false);

        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab_adicionar_duvida_geral);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Adicionar Dúvida não implementado ainda!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        /**
         * recycleview de duvidas gerais
         * */
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView_duvidas_geral);
        mRecyclerView.setHasFixedSize(true);
        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Set CustomAdapter as the adapter for RecyclerView.
        mAdapter = new DuvidasGeralAdapter(mDataset, getContext());
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }

    /**
     * Generates Strings for RecyclerView's adapter. This data would usually come
     * from a local content provider or remote server.
     */
    private void initDataset() {
        mDataset = new ArrayList<Duvida>();

        String nomes[] = {"Maria", "João", "Ricardo Rodrigues", "Chico Mendes", "José de Oliveira", "Ana Maria", "Sanderson Melo", "Raianne Alynne", "Jobson Almeida", "Gabriel Garcia"};
        int fotosUsuario[] = {R.drawable.user1, R.drawable.user2, R.drawable.user3, R.drawable.user4, R.drawable.user5, R.drawable.user6};
        String disciplinas[] = {"DSW I - Desenvolvimento de Sistemas Web I", "FMC I - Fundamentos Matemáticos da Computação I", "CDI I - Cálculo Diferencial e Integral I", "DSDM - Desenvolvimento de Sistemas para Dispositivos Móveis"};
        int fotos[] = {R.drawable.foto1, -1, -1, R.drawable.foto2, -1, R.drawable.foto3};
        String titulos[] = {"Socorro Alguém me ajuda!", "JavaFX Threads Atualizar UI e carregar Sistema em segundo plano", "Qual a diferença entre os métodos virtual e abstract?", "Como filtrar um Texto em uma div com angular JS", "Retorno de seleção de radiobutton em C#", "Problemas com autoload"};
        String descricoes[] = {"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."};
        int qtdCurtidas[] = {1, 5, 8, 0, 0, 4, 8, 10, 5, 8, 1, 9, 4, 5, 2, 3, 9, 0, 3, 5};
        int qtdRespostas[] = {9, 0, 3, 5, 8, 8, 0, 5, 2, 1, 0, 4, 5, 0, 1, 13, 8, 5, 9, 4};
        int qtdComentarios[] = {0, 2, 3, 0, 1, 0, 3, 1, 5, 0, 0, 0, 1, 0, 4, 6, 2, 3, 0};
        Duvida.Status status[] = {Duvida.Status.ABERTA , Duvida.Status.ABERTA , Duvida.Status.FECHADA, Duvida.Status.ABERTA , Duvida.Status.FECHADA};
        String dataCriacao[] = {"23 set 07:40", "12 set 12:09", "05 ago 16:55", "15 jul 08:32"};

        for (int i = 0; i < DATASET_COUNT; i++) {
            mDataset.add(new Duvida(nomes[i%nomes.length], fotosUsuario[i%fotosUsuario.length], disciplinas[i%disciplinas.length], fotos[i%fotos.length], titulos[i%titulos.length], descricoes[i%descricoes.length], qtdCurtidas[i%qtdCurtidas.length],  qtdRespostas[i%qtdRespostas.length], status[i%status.length], dataCriacao[i%dataCriacao.length], gerarComentarios(qtdComentarios[i%qtdComentarios.length]) ));
        }
    }

    private List<Comentario> gerarComentarios(int count){
        String nomes[] = {"Maria", "João", "Ricardo Rodrigues", "Chico Mendes", "José de Oliveira", "Ana Maria", "Sanderson Melo", "Raianne Alynne", "Jobson Almeida", "Gabriel Garcia"};
        String descricoes[] = {"Tô com esse problema também", "O erro informa como resolver: adicione target-Compatibility='1.7' ao buil.gradle.", "mostre como está o seu build.gradle","Já atualizei a pergunta mostrando como está meu build.gradle", "Jorge, pode me mandar o arquivo completo (para download ou escrito), por favor??", "Antes tava dando erro pra compilar no java 8, por isso mudei para o 7.", "Abra uma nova pergunta com o erro que tava dando antes, pois provavelmente não tem relação com essa pergunta/resposta.", "Ainda não amigo, continua o mesmo erro.", "Que estranho, consigo reproduzir aqui perfeitamente... São apenas estas informações que tem em seu gradle?", "Isso mesmo amigo, com a modificação sugerida já inclusa, são todas as informações do gradle."};
        String dataCriacao[] = {"05/08 17:00", "05/08 17:31", "05/08 17:45", "05/08 17:52", "05:08 18:09", "06/08 15:02", "06/08 15:04"};

        List<Comentario> comentarios = new ArrayList<Comentario>();
        for (int i = 0; i < count; i++) {
            comentarios.add(new Comentario(nomes[i%nomes.length], descricoes[i%descricoes.length], dataCriacao[i%dataCriacao.length]));
        }
        return comentarios;
    }

}
