package br.ufrn.imd.monitoria_mobile.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import br.ufrn.imd.monitoria_mobile.ChatFragment;
import br.ufrn.imd.monitoria_mobile.DuvidasTurmaFragment;
import br.ufrn.imd.monitoria_mobile.MinhasDuvidasFragment;
import br.ufrn.imd.monitoria_mobile.NotificacoesFragment;
import br.ufrn.imd.monitoria_mobile.R;
import br.ufrn.imd.monitoria_mobile.RecyclerViewFragment;
import br.ufrn.imd.monitoria_mobile.fragment.DuvidasGeralFragment;

public class AlunoMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ImageView imageViewAluno1, imageViewAluno2, imageViewAluno3;
    private ImageView nav_imageView_usuario;

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


/*
        imageViewAluno1 = (ImageView) findViewById(R.id.imageViewAluno1);
        imageViewAluno2 = (ImageView) findViewById(R.id.imageViewAluno2);
        imageViewAluno3 = (ImageView) findViewById(R.id.imageViewAluno3);

       Drawable roundedImage1 = RoundedImageView.getRoundedImageView(R.drawable.user3, 200.0f, getResources());
        imageViewAluno1.setImageDrawable(roundedImage1);
        Drawable roundedImage2 = RoundedImageView.getRoundedImageView(R.drawable.user5, 200.0f, getResources());
        imageViewAluno2.setImageDrawable(roundedImage2);
        Drawable roundedImage3 = RoundedImageView.getRoundedImageView(R.drawable.user2, 200.0f, getResources());
        imageViewAluno3.setImageDrawable(roundedImage3);
*/
  /*      nav_imageView_usuario = (ImageView) findViewById(R.id.nav_imageView_usuario);
        Drawable roundedImage_usuario = RoundedImageView.getRoundedImageView(R.drawable.user3, 200.0f, getResources());
        nav_imageView_usuario.setImageDrawable(roundedImage_usuario);

        nav_imageView_usuario = (ImageView) findViewById(R.id.nav_imageView_usuario);
        Bitmap  mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.user3);
        nav_imageView_usuario.setImageBitmap(mBitmap);
       */
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
        } else if (id == R.id.nav_duvidas_turma1) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_aluno_main, new DuvidasTurmaFragment());
            //ft.addToBackStack(null);//adiciona o fragment na pilha, par o botão voltar desempilhar para a activity anterior ao invés de fechar a aplicação
            ft.commit();

            ab.setTitle("FMC II");
        } else if (id == R.id.nav_duvidas_turma2) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_aluno_main, new DuvidasTurmaFragment());
            //ft.addToBackStack(null);//adiciona o fragment na pilha, par o botão voltar desempilhar para a activity anterior ao invés de fechar a aplicação
            ft.commit();

            ab.setTitle("DSDM");
        } else if (id == R.id.nav_duvidas_turma3) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_aluno_main, new DuvidasTurmaFragment());
            //ft.addToBackStack(null);//adiciona o fragment na pilha, par o botão voltar desempilhar para a activity anterior ao invés de fechar a aplicação
            ft.commit();

            ab.setTitle("CDI I");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(this, "landscape", Toast.LENGTH_LONG).show();
        }else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait", Toast.LENGTH_LONG).show();
        }
    }
}
