package com.example.a06929749974.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.LogPrinter;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnTocarMusica;
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTocarMusica = findViewById(R.id.btnPlay);

        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.musica);

        btnTocarMusica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()) {
                    pausarMusica();
                } else {
                    tocarMusica();
                }
            }
        });
    } // Fim do create

    private void tocarMusica() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
            btnTocarMusica.setText(R.string.pause);
        }
    }

    private void pausarMusica() {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            btnTocarMusica.setText(R.string.play);
        }
    }

}
