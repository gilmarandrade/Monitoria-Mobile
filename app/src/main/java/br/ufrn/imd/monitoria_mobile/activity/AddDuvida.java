package br.ufrn.imd.monitoria_mobile.activity;

import android.media.Image;
import android.support.design.widget.FloatingActionButton;
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

import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.monitoria_mobile.R;

public class AddDuvida extends AppCompatActivity {

    private ImageView imagemDuvida;
    private ImageButton addImageDuvida;

    private Spinner spn1;
    private List<String> nomes = new ArrayList<String>();
    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_duvida);
        imagemDuvida = (ImageView) findViewById(R.id.image_duvida);
        addImageDuvida = (ImageButton) findViewById(R.id.add_imagem_duvida);

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


}
