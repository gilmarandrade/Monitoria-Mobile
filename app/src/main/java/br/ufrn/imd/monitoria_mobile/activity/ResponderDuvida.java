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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import br.ufrn.imd.monitoria_mobile.R;
import br.ufrn.imd.monitoria_mobile.model.Dados;
import br.ufrn.imd.monitoria_mobile.model.Duvida;

public class ResponderDuvida extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1888;
    private TextView duvidaAluno;
    private ImageView imagemResposta;
    private ImageButton addImagemResposta;
    private EditText descricao;
    private Duvida duvida;

    protected ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_responder_duvida);

        duvidaAluno = (TextView) findViewById(R.id.duvida_aluno);
        Intent i = getIntent();
        duvida = (Duvida) i.getSerializableExtra("duvida");
        imagemResposta = (ImageView) findViewById(R.id.image_resposta);
        duvidaAluno.setText(duvida.getDescricao());
        addImagemResposta = (ImageButton) findViewById(R.id.add_imagem_resposta);
        descricao = (EditText) findViewById(R.id.descricao_res);
        addImagemResposta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCamera();
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
            imagemResposta.setImageBitmap(bitmap);
            imagemResposta.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    public void salvarResposta(View view) {
        progressDialog = ProgressDialog.show(this, "Aguarde ...", "Cadastrando Resposta", true);
        progressDialog.setCancelable(true);
        setResposta();
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

    private void setResposta(){


        Map<String,String> params = new HashMap<String, String>();
        params.put("idPessoa", Dados.getPerfil().getPessoa().getId()+"");
        params.put("descricao",descricao.getText().toString());
        params.put("idDuvida", duvida.getId()+"");

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                "http://172.20.10.4:8080/monitoria/api/resposta/post", new JSONObject(params),
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        progressDialog.dismiss();
                        intent();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
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
