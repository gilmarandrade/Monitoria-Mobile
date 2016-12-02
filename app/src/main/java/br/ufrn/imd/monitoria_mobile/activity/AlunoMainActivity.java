package br.ufrn.imd.monitoria_mobile.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.*;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import br.ufrn.imd.monitoria_mobile.R;
import br.ufrn.imd.monitoria_mobile.dominio.Disciplina;
import br.ufrn.imd.monitoria_mobile.dominio.OAuthTokenRequest;
import br.ufrn.imd.monitoria_mobile.fragment.RecyclerViewFragment;
import br.ufrn.imd.monitoria_mobile.fragment.ChatFragment;
import br.ufrn.imd.monitoria_mobile.fragment.DuvidasGeralFragment;
import br.ufrn.imd.monitoria_mobile.fragment.DuvidasTurmaFragment;
import br.ufrn.imd.monitoria_mobile.fragment.MinhasDuvidasFragment;
import br.ufrn.imd.monitoria_mobile.fragment.NotificacoesFragment;

import br.ufrn.imd.monitoria_mobile.dominio.Perfil;
import br.ufrn.imd.monitoria_mobile.model.Dados;

public class AlunoMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;
    private Menu menu;
    private TextView menuNomeAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        this.menu = navigationView.getMenu();
        int order = 0;
        for(Disciplina d : Dados.getPerfil().getDisciplinas()){
            menu.getItem(5).getSubMenu().add(0,d.getId(),order, d.getDescricao());
            order++;
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_aluno_main, new DuvidasGeralFragment());
        ft.commit();

        ActionBar ab = getSupportActionBar();
        ab.setTitle("Dúvidas");


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.aluno_main, menu);
        menuNomeAluno = (TextView) findViewById(R.id.menuNomeAluno);
        menuNomeAluno.setText(Dados.getPerfil().getPessoa().getNome());
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        ActionBar ab = getSupportActionBar();

        if (id == R.id.nav_duvidas_gerais) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_aluno_main, new DuvidasGeralFragment());
            //ft.addToBackStack(null);//adiciona o fragment na pilha, par o botão voltar desempilhar para a activity anterior ao invés de fechar a aplicação
            ft.commit();

            ab.setTitle("Dúvidas");
        } else if (id == R.id.nav_minhas_duvidas) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_aluno_main, new MinhasDuvidasFragment());
            //ft.addToBackStack(null);//adiciona o fragment na pilha, par o botão voltar desempilhar para a activity anterior ao invés de fechar a aplicação
            ft.commit();

            ab.setTitle("Minhas Dúvidas");
        } else if (id == R.id.nav_notificacoes) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_aluno_main, new NotificacoesFragment());
            //ft.addToBackStack(null);//adiciona o fragment na pilha, par o botão voltar desempilhar para a activity anterior ao invés de fechar a aplicação
            ft.commit();

            ab.setTitle("Notificações");
        } else if (id == R.id.nav_ranking) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_aluno_main, new RecyclerViewFragment());
            //ft.addToBackStack(null);//adiciona o fragment na pilha, par o botão voltar desempilhar para a activity anterior ao invés de fechar a aplicação
            ft.commit();

            ab.setTitle("RecyclerViewFragment");
        } else if (id == R.id.nav_chat) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_aluno_main, new ChatFragment());
            //ft.addToBackStack(null);//adiciona o fragment na pilha, par o botão voltar desempilhar para a activity anterior ao invés de fechar a aplicação
            ft.commit();

            ab.setTitle("Chat");
        } else {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            DuvidasTurmaFragment fragment = new DuvidasTurmaFragment();

            Bundle args = new Bundle();
            args.putString("disciplina", item.getItemId()+"");
            fragment.setArguments(args);
            ft.replace(R.id.content_aluno_main, fragment);
            ft.commit();

            ab.setTitle(Dados.getPerfil().getDisciplinas().get(item.getGroupId()).getCodigo());
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_LONG).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "portrait", Toast.LENGTH_LONG).show();
        }
    }

}
