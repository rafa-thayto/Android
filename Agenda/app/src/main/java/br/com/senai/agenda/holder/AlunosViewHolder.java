package br.com.senai.agenda.holder;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import br.com.senai.agenda.Aluno;
import br.com.senai.agenda.FormularioAlunoActivity;
import br.com.senai.agenda.R;
import br.com.senai.agenda.adapter.AlunoRecyclerAdapter;

/**
 * Created by adminLocal on 23/03/2018.
 */

public class AlunosViewHolder extends RecyclerView.ViewHolder{
    private TextView campoNome;
    private TextView campoEmail;
    private TextView campoTelefone;
    private TextView campoNota;
    private TextView campoEndereco;
    private Long alunoId;
    public AlunosViewHolder(View view, AlunoRecyclerAdapter adapter) {
        super(view);

        campoNome = view.findViewById(R.id.item_nome);
        campoEmail = view.findViewById(R.id.item_email);
        campoTelefone = view.findViewById(R.id.item_telefone);
        campoNota = view.findViewById(R.id.item_nota);
        campoEndereco = view.findViewById(R.id.item_endereco);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               final Activity context = (Activity) v.getContext();
                final Intent intent = new Intent(context, FormularioAlunoActivity.class);
                intent.putExtra("alunoId", alunoId)   ;
                context.startActivityForResult(intent, 1);
            }
        });

    }

    public void preecher(Aluno aluno) {
        alunoId = aluno.getId();
        campoNome.setText(aluno.getNome());
        campoEmail.setText(aluno.getEmail());
        campoTelefone.setText(aluno.getTelefone());
        campoNota.setText(aluno.getClassificacao().toString());
        if (campoEndereco != null) {
            campoEndereco.setText(aluno.getEndereco());
        }
    }
}
