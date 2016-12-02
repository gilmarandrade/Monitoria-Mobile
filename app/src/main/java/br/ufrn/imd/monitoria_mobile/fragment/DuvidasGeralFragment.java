package br.ufrn.imd.monitoria_mobile.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.monitoria_mobile.R;
import br.ufrn.imd.monitoria_mobile.activity.AddDuvida;
import br.ufrn.imd.monitoria_mobile.adapter.DuvidasGeralAdapter;
import br.ufrn.imd.monitoria_mobile.model.Comentario;
import br.ufrn.imd.monitoria_mobile.model.Dados;
import br.ufrn.imd.monitoria_mobile.model.Duvida;
import br.ufrn.imd.monitoria_mobile.model.Resposta;


public class DuvidasGeralFragment extends Fragment {
    private static final int DATASET_COUNT = 10;
    protected RecyclerView mRecyclerView;
    protected DuvidasGeralAdapter mAdapter;
    protected LinearLayoutManager mLayoutManager;
    protected List<Duvida> mDataset;

    private SwipeRefreshLayout mSwipeRefreshLayout;


    protected ProgressDialog progressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize dataset, this data would usually come from a local content provider or
        // remote server.
        //initDataset();
        progressDialog = ProgressDialog.show(getActivity(), "Aguarde ...", "Atualizando Duvidas...", true);
        progressDialog.setCancelable(true);
        mDataset = new ArrayList<>();
        getDuvidas(true);
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

                Intent i = new Intent(getActivity(), AddDuvida.class);
                startActivity(i);
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
        mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipeRefresh_geral);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getDuvidas(false);
            }
        });

        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        return rootView;
    }

    private void getDuvidas(final boolean progress){
        RequestQueue queue = Volley.newRequestQueue(getContext());
        String url = "http://172.20.10.4:8080/monitoria/api/duvida/todas/"+ Dados.getPerfil().getPessoa().getId();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new GsonBuilder().create();
                        Type typeOfList = new TypeToken<List<Duvida>>() {
                        }.getType();
                        List<Duvida> duvidas = gson.fromJson(response, typeOfList);
                        Dados.setDuvidas(duvidas);
                        mDataset = Dados.getDuvidas();
                        mAdapter.setList(mDataset);
                        mAdapter.notifyDataSetChanged();
                        if(progress)
                            progressDialog.dismiss();
                        else
                            mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),
                        error.toString(), Toast.LENGTH_LONG).show();
                if(progress)
                    progressDialog.dismiss();
                else
                    mSwipeRefreshLayout.setRefreshing(false);
            }
        });
        queue.add(stringRequest);

    }

}
