package br.ufrn.imd.monitoria_mobile.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ufrn.imd.monitoria_mobile.R;
import br.ufrn.imd.monitoria_mobile.dominio.Disciplina;
import br.ufrn.imd.monitoria_mobile.model.Dados;
import br.ufrn.imd.monitoria_mobile.model.Duvida;

public class AddDuvida extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1888;
    private ImageView imagemDuvida;
    private ImageButton addImageDuvida;
    private Spinner spn1;
    private List<String> nomes = new ArrayList<String>();
    private Disciplina disciplina;
    private Bitmap bitmap;
    private EditText assunto;
    private EditText descricao;

    protected ProgressDialog progressDialog;

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

        //for(Duvida duvida: Dados.getPerfil().getDisciplinas())
        assunto = (EditText) findViewById(R.id.assunto_add);
        descricao = (EditText) findViewById(R.id.descricao_add);
        //Identifica o Spinner no layout
        spn1 = (Spinner) findViewById(R.id.spinner_t);
        //Cria um ArrayAdapter usando um padrão de layout da classe R do android, passando o ArrayList nomes
        ArrayAdapter<Disciplina> arrayAdapter = new ArrayAdapter<Disciplina>(this, android.R.layout.simple_spinner_dropdown_item, Dados.getPerfil().getDisciplinas());
        ArrayAdapter<Disciplina> spinnerArrayAdapter = arrayAdapter;
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spn1.setAdapter(spinnerArrayAdapter);

        //Método do Spinner para capturar o item selecionado
        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                disciplina = (Disciplina) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void abrirCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (REQUEST_IMAGE_CAPTURE == requestCode && resultCode == RESULT_OK) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imagemDuvida.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imagemDuvida.setImageBitmap(bitmap);
            imagemDuvida.setMaxHeight(200);
            imagemDuvida.setMinimumHeight(200);

        }
    }


    public void salvarDuvida(View view) {
        progressDialog = ProgressDialog.show(this, "Aguarde ...", "Cadastrando Duvida", true);
        progressDialog.setCancelable(true);
        setDuvida();
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

    private void intent(){
        Intent i = new Intent(this, AlunoMainActivity.class);
        startActivity(i);
    }
    private void setDuvida(){


        Map<String,String> params = new HashMap<String, String>();
        params.put("idPessoa", Dados.getPerfil().getPessoa().getId()+"");
        params.put("assunto",assunto.getText().toString());
        params.put("descricao", descricao.getText().toString());
        params.put("idDisciplina", disciplina.getId()+"");

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                "http://172.20.10.4:8080/monitoria/api/duvida/post", new JSONObject(params),
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        progressDialog.dismiss();
                        intent();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                intent();
                progressDialog.dismiss();
            }
        }) {

            /**
             * Passing some request headers
             * */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }



        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjReq);
    }
}
