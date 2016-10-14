package br.ufrn.imd.monitoria_mobile.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.ufrn.imd.monitoria_mobile.R;

public class DuvidasTurmaFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_duvidas_turma, container, false);

        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fab_adicionar_duvida_turma);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Adicionar Dúvida na turma não implementado ainda!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        return v;
    }
}
