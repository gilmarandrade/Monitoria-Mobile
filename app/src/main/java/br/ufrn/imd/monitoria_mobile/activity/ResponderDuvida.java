package br.ufrn.imd.monitoria_mobile.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import br.ufrn.imd.monitoria_mobile.R;
import br.ufrn.imd.monitoria_mobile.model.Duvida;

public class ResponderDuvida extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1888;
    private TextView duvidaAluno;
    private ImageView imagemResposta;
    private ImageButton addImagemResposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_responder_duvida);

        duvidaAluno = (TextView) findViewById(R.id.duvida_aluno);
        Intent i = getIntent();
        Duvida duvida = (Duvida) i.getSerializableExtra("duvida");
        imagemResposta = (ImageView) findViewById(R.id.image_resposta);
        duvidaAluno.setText(duvida.getDescricao());
        addImagemResposta = (ImageButton) findViewById(R.id.add_imagem_resposta);

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
        Snackbar.make(view, "Salvar Resposta não implementado ainda!", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
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
