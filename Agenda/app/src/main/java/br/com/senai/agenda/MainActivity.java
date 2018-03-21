package br.com.senai.agenda;

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

    private ListView listaDeAlunos;
    private Button botaoCadastrarNovo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaDeAlunos = findViewById(R.id.lvListaAluno);

        carregarLista();


        listaDeAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Aluno aluno = (Aluno) listaDeAlunos.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, FormularioAlunoActivity.class);
                intent.putExtra("aluno", aluno);
                startActivity(intent);
                // Toast.makeText(getApplicationContext(),"Aluno: "+aluno.getNome(),Toast.LENGTH_LONG).show();
            }
        });

        botaoCadastrarNovo = findViewById(R.id.btnCadastrarNovo);
        botaoCadastrarNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FormularioAlunoActivity.class);
                startActivity(intent);
            }
        });

        registerForContextMenu(listaDeAlunos);

    }//Fim OnCreate

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
      MenuItem remover = menu.add("Remover");
      remover.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
          @Override
          public boolean onMenuItemClick(MenuItem item) {
              AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
              Aluno aluno = (Aluno) listaDeAlunos.getItemAtPosition(info.position);
              AlunoDAO dao = new AlunoDAO(MainActivity.this);
              dao.remover(aluno);
              dao.close();

              carregarLista();

              Toast.makeText(getApplicationContext(),"Aluno: "+ aluno.getNome()+" Deletado", Toast.LENGTH_LONG).show();
              return false;
          }
      });
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        Aluno aluno = (Aluno) listaDeAlunos.getItemAtPosition(info.position);

        //perfil Facebook
      MenuItem facebook = menu.add("Perfil Facebook");
      Intent intentFace = new Intent(Intent.ACTION_VIEW);
      String endFace = aluno.getFace();
      if (!endFace.startsWith("http://www.facebook.com/")){
          endFace = "http://www.facebook.com/"+ endFace;
      }
      intentFace.setData(Uri.parse(endFace));
      facebook.setIntent(intentFace);
      //fim facebook
      //Sms
      MenuItem sms = menu.add("Enviar SMS");
      Intent intentSMS = new Intent(Intent.ACTION_VIEW);
      intentSMS.setData(Uri.parse("sms:"+aluno.getTelefone()));
      sms.setIntent(intentSMS);
      //fim SMS
      //Localização
      MenuItem GPS = menu.add("Mostrar no Mapa");
      Intent intentGPS = new Intent(Intent.ACTION_VIEW);
      intentGPS.setData(Uri.parse("geo:0,0?q="+aluno.getEndereco()));
      GPS.setIntent(intentGPS);
      //fim localização
        //licação
        MenuItem ligar = menu.add("Ligar");
        Intent intentLigar = new Intent(Intent.ACTION_VIEW);
        intentLigar.setData(Uri.parse("tel:"+aluno.getTelefone()));
        ligar.setIntent(intentLigar);
        //fim ligação



    }//on Create menu

    private void carregarLista() {
        AlunoDAO dao = new AlunoDAO(this);
        List<Aluno> alunos =  dao.buscarAlunos();
        ArrayAdapter<Aluno> adaptador = new ArrayAdapter<Aluno>(this, android.R.layout.simple_list_item_1,alunos);
        listaDeAlunos.setAdapter(adaptador);
    }
    @Override
    protected void onResume() {
        super.onResume();
        carregarLista();
    }

    /*@Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(getApplicationContext(),"onStart",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),"onStop",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"onDestroy",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),"onPause",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),"onResume",Toast.LENGTH_SHORT).show();
    }
    */
}
