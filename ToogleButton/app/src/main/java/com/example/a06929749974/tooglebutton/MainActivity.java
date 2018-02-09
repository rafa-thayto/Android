package com.example.a06929749974.tooglebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toogleButton;
    private TextView textoPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toogleButton = findViewById(R.id.tbId);
        textoPrincipal = findViewById(R.id.txtId);

        toogleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked)
                    textoPrincipal.setText("Vai se fude viana");
                else
                    textoPrincipal.setText("throw new ThaytoViadaoException(true)");
            }
        });
    }
}
