package com.example.a06929749974.agenda;

import android.widget.EditText;
import android.widget.RatingBar;

/**
 * Created by 06929749974 on 16/02/2018.
 */

public class FormularioAlunoHelper {

    private EditText nome;
    private EditText email;
    private EditText endereco;
    private EditText telefone;
    private EditText facebook;
    private RatingBar classificacao;
    private Aluno aluno;

    @Override
    public String toString() {
        return "FormularioAlunoHelper{" +
                "nome=" + nome +
                ", email=" + email +
                ", endereco=" + endereco +
                ", telefone=" + telefone +
                ", facebook=" + facebook +
                ", classificacao=" + classificacao +
                '}';
    }


    public FormularioAlunoHelper(FormularioAlunoActivity formularioAluno) {
        nome = formularioAluno.findViewById(R.id.etNome);
        email = formularioAluno.findViewById(R.id.etEmail);
        endereco = formularioAluno.findViewById(R.id.etEnd);
        telefone = formularioAluno.findViewById(R.id.etTel);
        facebook = formularioAluno.findViewById(R.id.etFace);
        classificacao = formularioAluno.findViewById(R.id.rbClassificacao);
        aluno = new Aluno();
    }

    public Aluno pegaAluno() {
        aluno.setNome(nome.getText().toString());
        aluno.setEndereco(endereco.getText().toString());
        aluno.setTelefone(telefone.getText().toString());
        aluno.setEmail(email.getText().toString());
        aluno.setFace(facebook.getText().toString());
        aluno.setClassificacao(Double.valueOf(classificacao.getProgress()));

        return aluno;
    }

    public void preencherFornulario(Aluno aluno) {
        nome.setText(aluno.getNome());
        endereco.setText(aluno.getEndereco());
        email.setText(aluno.getEmail());
        telefone.setText(aluno.getTelefone());
        facebook.setText(aluno.getFace());
        classificacao.setProgress(aluno.getClassificacao().intValue());
        this.aluno = aluno;
    }
}
