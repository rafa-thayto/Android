package br.com.senai.galeriadeimagens;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import br.com.senai.galeriadeimagens.dao.ImagemDAO;
import br.com.senai.galeriadeimagens.model.Imagem;

public class FormularioActivity extends AppCompatActivity {

    public static final int PERMISSAO_REQUEST = 1;
    public static final int GALERIA_CODE = 1;
    private Button botaoGaleria;
    private ImageView imagemCarregada;
    private Button botaoSalvar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        botaoGaleria = findViewById(R.id.btn_galeria);
        imagemCarregada = findViewById(R.id.imgCarregada);
        botaoSalvar = findViewById(R.id.btn_salvar);


        botaoGaleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, GALERIA_CODE);
            }
        });
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Imagem imagem = new Imagem();
                imagem.setCaminhoImagem(imagemCarregada.getTag().toString());
                ImagemDAO dao = new ImagemDAO(FormularioActivity.this);
                dao.inserir(imagem);
                finish();
            }
        });

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSAO_REQUEST);
            }
        }
    }//fim OnCreate

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == GALERIA_CODE){
            Uri uri = data.getData();
            String[] caminhoDoArquivo = {MediaStore.Images.Media.DATA};
            Cursor c = getContentResolver().query(uri, caminhoDoArquivo,null,null,null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(caminhoDoArquivo[0]);
            String caminhoDaImagem = c.getString(columnIndex);
            c.close();
            Bitmap imagemRetornada = (BitmapFactory.decodeFile(caminhoDaImagem));
            imagemCarregada.setImageBitmap(imagemRetornada);
            imagemCarregada.setTag(caminhoDaImagem);

        }

    }

    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == PERMISSAO_REQUEST) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // / A permissão foi concedida. Pode continuar

            } else{
                // A permissão foi negada. Precisa ver o que deve ser desabilitado
            }
            return;
        }

    }

}
