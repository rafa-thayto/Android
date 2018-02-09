package com.example.a06929749974.somdosbixos;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView cachorro;
    private ImageView gato;
    private ImageView leao;
    private ImageView macaco;
    private ImageView ovelha;
    private ImageView vaca;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cachorro = findViewById(R.id.ivCachorro);
        gato = findViewById(R.id.ivGato);
        leao = findViewById(R.id.ivLeao);
        macaco = findViewById(R.id.ivMacaco);
        ovelha = findViewById(R.id.ivOvelha);
        vaca = findViewById(R.id.ivVaca);

        cachorro.setOnClickListener(this);
        gato.setOnClickListener(this);
        leao.setOnClickListener(this);
        macaco.setOnClickListener(this);
        ovelha.setOnClickListener(this);
        vaca.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivCachorro:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.cao);
                tocarMusica();
                break;

            case R.id.ivGato:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gato);
                tocarMusica();
                break;

            case R.id.ivLeao:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.leao);
                tocarMusica();
                break;

            case R.id.ivMacaco:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.macaco);
                tocarMusica();
                break;

            case R.id.ivOvelha:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.ovelha);
                tocarMusica();
                break;

            case R.id.ivVaca:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.vaca);
                tocarMusica();
                break;

        }
    }

    public void tocarMusica() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}
