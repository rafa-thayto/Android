package br.com.senai.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FormularioAlunoActivity extends AppCompatActivity {

    private Button botaoAdicionarAluno;
    private FormularioAlunoHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);

        botaoAdicionarAluno = findViewById(R.id.btnCadastrar);
        helper = new FormularioAlunoHelper(this);

        Intent intent = getIntent();
        Aluno aluno = (Aluno) intent.getSerializableExtra("aluno");

        if(aluno != null){
            helper.preecherFormulario(aluno);
        }
        botaoAdicionarAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlunoDAO dao = new AlunoDAO(FormularioAlunoActivity.this);
                Aluno aluno = helper.pegaAluno();

                if (aluno.getId() != null){
                    dao.alterar(aluno);
                }else{
                    dao.insere(aluno);
                }

                dao.close();
                Toast.makeText(getApplicationContext(),"Aluno :"+ aluno.getNome()+" Salvo!", Toast.LENGTH_LONG).show();

               finish();
            }
        });
    }
}
