package com.example.a06929749974.agenda;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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

        contruirLista();
        listaAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Aluno aluno = (Aluno) listaAlunos.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, FormularioAlunoActivity.class);
                intent.putExtra("aluno", aluno);
                startActivity(intent);
                // Toast.makeText(getApplicationContext(), "Aluno: " + aluno.getNome(), Toast.LENGTH_LONG).show();
            }
        });

        btnAdicionar = findViewById(R.id.btnAdicionar);
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(MainActivity.this, FormularioAlunoActivity.class);
                startActivity(intent);
            }
        });

        registerForContextMenu(listaAlunos);

    } // Fim OnCreate

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem remover = menu.add("Remover");
        MenuItem editar = menu.add("Editar");
        MenuItem compartilhar = menu.add("Compartilhar");

        remover.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Aluno aluno = (Aluno) listaAlunos.getItemAtPosition(info.position);

                AlunoDAO dao = new AlunoDAO(MainActivity.this);
                dao.remover(aluno);
                dao.close();

                contruirLista();

                Toast.makeText(getApplicationContext(), "Aluno: " + aluno.getNome() + " deletado", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        // Perfil facebook
        MenuItem facebook = menu.add("Perfil Facebook");
        Intent intentFace = new Intent(Intent.ACTION_VIEW);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        Aluno aluno = (Aluno) listaAlunos.getItemAtPosition(info.position);
        String endFace = aluno.getFace();
        if (!endFace.startsWith("http://www.facebook.com/")) {
            endFace = "http://www.facebook.com/" + endFace;
        }
        intentFace.setData(Uri.parse(endFace));
        startActivity(intentFace);
        // fim facebook

        // SMS
        MenuItem sms = menu.add("Enviar SMS");
        Intent intentSMS = new Intent(Intent.ACTION_VIEW);
        intentSMS.setData(Uri.parse("Sms: " + aluno.getTelefone()));
        sms.setIntent(intentSMS);
        // Fim SMS

        // Localização
        MenuItem GPS = menu.add("Mostrar no mapa");
        Intent intentGPS = new Intent(Intent.ACTION_VIEW);
        intentGPS.setData(Uri.parse("geo:0,0?q=" + aluno.getEndereco()));
        GPS.setIntent(intentGPS);
        // Fim localização

        // Ligação
        MenuItem ligar = menu.add("Ligar");
        Intent intentLigar = new Intent(Intent.ACTION_VIEW);
        intentLigar.setData(Uri.parse("Tel: " + aluno.getTelefone()));
        ligar.setIntent(intentLigar);
    }

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
