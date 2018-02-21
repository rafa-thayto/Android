package com.example.a06929749974.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listaAlunos;
    private Button btnAdicionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaAlunos= findViewById(R.id.lvListaAlunos);
        btnAdicionar = findViewById(R.id.btnAdicionar);

        contruirLista();

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(MainActivity.this, FormularioAlunoActivity.class);
                startActivity(intent);
            }
        });
    } // Fim OnCreate

    private void contruirLista() {
        AlunoDAO dao = new AlunoDAO(this);
        List<Aluno> alunos = dao.buscarAlunos();
        ArrayAdapter<Aluno> adaptador = new ArrayAdapter<Aluno>(this, android.R.layout.simple_list_item_1, alunos);
        listaAlunos.setAdapter(adaptador);
    }

    @Override
    protected void onResume() {
        super.onResume();
        contruirLista();

    }
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Toast.makeText(getApplicationContext(), "onStart", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Toast.makeText(getApplicationContext(), "onStop", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Toast.makeText(getApplicationContext(), "onDestroy", Toast.LENGTH_LONG).show();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Toast.makeText(getApplicationContext(), "onPause", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Toast.makeText(getApplicationContext(), "onResume", Toast.LENGTH_SHORT).show();
//    }
}
