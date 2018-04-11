package br.com.senai.agenda.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.senai.agenda.Aluno;
import br.com.senai.agenda.MainActivity;
import br.com.senai.agenda.R;

/**
 * Created by adminLocal on 21/03/2018.
 */

public class AlunosAdapter extends BaseAdapter{
    private final Context context;
    private final List<Aluno> alunos;

    public AlunosAdapter(Context context, List<Aluno> alunos) {
        this.context = context;
        this.alunos = alunos;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }
    @Override
    public Object getItem(int position) {
        return alunos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return alunos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Aluno aluno = alunos.get(position);

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.lista_principal, null);

        TextView campoNome = view.findViewById(R.id.item_nome);
        campoNome.setText(aluno.getNome());

        TextView campoEmail = view.findViewById(R.id.item_email);
        campoEmail.setText(aluno.getEmail());

        TextView campoTelefone = view.findViewById(R.id.item_telefone);
        campoTelefone.setText(aluno.getTelefone());

        TextView campoNota = view.findViewById(R.id.item_nota);
        campoNota.setText(aluno.getClassificacao().toString());

        TextView campoEnd = view.findViewById(R.id.item_endereco);
        if (campoEnd != null) {
            campoEnd.setText(aluno.getEndereco());
        }

        return view;
    }
}
