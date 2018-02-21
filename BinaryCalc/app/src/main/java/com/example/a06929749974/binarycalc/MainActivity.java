package com.example.a06929749974.binarycalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etNumber;
    private TextView tvResponse;
    private Button btnCalcular;
    private Button btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber = findViewById(R.id.etNumberId);
        tvResponse = findViewById(R.id.tvResponseId);
        btnCalcular = findViewById(R.id.btnCalcularId);
        btnLimpar = findViewById(R.id.btnLimparId);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etNumber.setText(null);
            }
        });
    }
}
