package br.com.senai.agenda;

import android.widget.EditText;
import android.widget.RatingBar;

/**
 * Created by adminLocal on 16/02/2018.
 */

public class FormularioAlunoHelper {
    private EditText nome;
    private EditText endereco;
    private EditText email;
    private EditText telefone;
    private RatingBar classificacao;
    private EditText facebook;
    private Aluno aluno;

    public FormularioAlunoHelper(FormularioAlunoActivity formularioAluno){
       nome = formularioAluno.findViewById(R.id.editNome);
       endereco = formularioAluno.findViewById(R.id.editEnd);
       email = formularioAluno.findViewById(R.id.editEmail);
       telefone = formularioAluno.findViewById(R.id.editTelefone);
       facebook = formularioAluno.findViewById(R.id.editFace);
       classificacao = formularioAluno.findViewById(R.id.ratingBar);
       aluno = new Aluno();
    }
    public Aluno pegaAluno() {
        aluno.setNome(nome.getText().toString());
        aluno.setEndereco(endereco.getText().toString());
        aluno.setEmail(email.getText().toString());
        aluno.setTelefone(telefone.getText().toString());
        aluno.setFace(facebook.getText().toString());
        aluno.setClassificacao(Double.valueOf(classificacao.getProgress()));
        return aluno;
    }
    public void preecherFormulario(Aluno aluno) {
        nome.setText(aluno.getNome());
        endereco.setText(aluno.getEndereco());
        email.setText(aluno.getEmail());
        telefone.setText(aluno.getTelefone());
        facebook.setText(aluno.getFace());
        classificacao.setProgress(aluno.getClassificacao().intValue());
        this.aluno = aluno;
    }
}
