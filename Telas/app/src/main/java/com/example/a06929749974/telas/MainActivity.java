package com.example.a06929749974.telas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnSegundaTela;
    private ImageView btnTerceiraTela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSegundaTela = findViewById(R.id.btnSegundaTela);
        btnTerceiraTela = findViewById(R.id.ivTerceiraTela);

        btnSegundaTela.setOnClickListener(this);
        btnTerceiraTela.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSegundaTela:
                startActivity();
        }
    }
}
