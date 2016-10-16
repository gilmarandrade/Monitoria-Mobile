package br.ufrn.imd.monitoria_mobile.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.Image;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.monitoria_mobile.R;

public class AddDuvida extends AppCompatActivity {

    private ImageView imagemDuvida;
    private ImageButton addImageDuvida;

    private Spinner spn1;
    private List<String> nomes = new ArrayList<String>();
    private String nome;
    private Bitmap bitmap;

    private static final int REQUEST_IMAGE_CAPTURE = 1888;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_duvida);
        imagemDuvida = (ImageView) findViewById(R.id.image_duvida);
        addImageDuvida = (ImageButton) findViewById(R.id.add_imagem_duvida);

        addImageDuvida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCamera();
            }
        });

        nomes.add("FMC II - Fundamentos Matematicos");
        nomes.add("DSDM - Desenvolvimento de Sistema");
        nomes.add("CDI - Calculo Diferencial I");

        //Identifica o Spinner no layout
        spn1 = (Spinner) findViewById(R.id.spinner_t);
        //Cria um ArrayAdapter usando um padrão de layout da classe R do android, passando o ArrayList nomes
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, nomes);
        ArrayAdapter<String> spinnerArrayAdapter = arrayAdapter;
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spn1.setAdapter(spinnerArrayAdapter);

        //Método do Spinner para capturar o item selecionado
        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                nome = adapterView.getItemAtPosition(i).toString();
//                Toast.makeText(AddDuvida.this, "Nome Selecionado: " + nome, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void abrirCamera(){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(REQUEST_IMAGE_CAPTURE == requestCode && resultCode == RESULT_OK){
            Bitmap bitmap = (Bitmap)data.getExtras().get("data");
            imagemDuvida.setImageBitmap(bitmap);
        }
    }



    public void salvarDuvida(View view) {
        Snackbar.make(view, "Adicionar Dúvida não implementado ainda!", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
