package br.ufrn.imd.monitoria_mobile;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

import br.ufrn.imd.monitoria_mobile.br.ufrn.imd.monitoria_mobile.helper.RoundedImageView;

import static br.ufrn.imd.monitoria_mobile.R.id.imageView;

public class AlunoMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ImageView imageViewAluno1, imageViewAluno2, imageViewAluno3;

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

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_aluno_main, new DuvidasGeralFragment());
        ft.commit();
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

        if (id == R.id.nav_duvidas_gerais) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_aluno_main, new DuvidasGeralFragment());
            ft.addToBackStack(null);//adiciona o fragment na pilha, par o botão voltar desempilhar para a activity anterior ao invés de fechar a aplicação
            ft.commit();
        } else if (id == R.id.nav_minhas_duvidas) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_aluno_main, new MinhasDuvidasFragment());
            ft.addToBackStack(null);//adiciona o fragment na pilha, par o botão voltar desempilhar para a activity anterior ao invés de fechar a aplicação
            ft.commit();
        } else if (id == R.id.nav_notificacoes) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_aluno_main, new NotificacoesFragment());
            ft.addToBackStack(null);//adiciona o fragment na pilha, par o botão voltar desempilhar para a activity anterior ao invés de fechar a aplicação
            ft.commit();
        } else if (id == R.id.nav_ranking) {
            //Snackbar.make(item.getActionView(), "Ranking não implementado ainda!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        } else if (id == R.id.nav_chat) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_aluno_main, new ChatFragment());
            ft.addToBackStack(null);//adiciona o fragment na pilha, par o botão voltar desempilhar para a activity anterior ao invés de fechar a aplicação
            ft.commit();
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
