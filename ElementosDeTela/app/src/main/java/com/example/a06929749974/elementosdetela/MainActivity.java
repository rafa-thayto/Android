package com.example.a06929749974.elementosdetela;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox opcaoLobo;
    private CheckBox opcaoGato;
    private Button btnVotar;
    private TextView tvResult;
    private AlertDialog.Builder dialog;
    private ImageView respostaImagem;
    private SeekBar seekLobo;
    private SeekBar seekGato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        opcaoGato = findViewById(R.id.cbGato);
        opcaoLobo = findViewById(R.id.cbLobo);
        btnVotar = findViewById(R.id.btnVotar);
        respostaImagem = findViewById(R.id.ivResposta);
//        seekLobo = findViewById(R.id.sbLobo);
//        seekGato = findViewById(R.id.sbGato);

        btnVotar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itensSelecionados = "";

//                itensSelecionados += "Item: " + opcaoLobo.getText() + " Status: " + opcaoLobo.isChecked() + "\n";
//                itensSelecionados += "Item: " + opcaoGato.getText() + " Status: " + opcaoGato.isChecked() + "\n";

                // tvResult.setText(itensSelecionados);

                dialog = new AlertDialog.Builder(MainActivity.this);
                // Setting title
                dialog.setTitle("Atenção");

                // Setting the mensage
                dialog.setMessage("Você realmente gosta desses animais?" + itensSelecionados);
                // Setting the confirm button
                dialog.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "Você clicou um SIM", Toast.LENGTH_LONG).show();
                        if (opcaoGato.isChecked() && opcaoLobo.isChecked()) {
                            respostaImagem.setImageResource(R.drawable.gato_lobo);
                        }
                        else if(opcaoLobo.isChecked()) {
                            respostaImagem.setImageResource(R.drawable.lobo);
                        }
                        else if(opcaoGato.isChecked()) {
                            respostaImagem.setImageResource(R.drawable.gato);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Seleciona um desgraça", Toast.LENGTH_LONG).show();
                        }
                    }
                });
                dialog.setNegativeButton("NÂO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "Você clicou em NÃO", Toast.LENGTH_LONG).show();
                    }
                });
                dialog.create();
                dialog.show();
            } // Fim Click no Btn
        });
    }
}
