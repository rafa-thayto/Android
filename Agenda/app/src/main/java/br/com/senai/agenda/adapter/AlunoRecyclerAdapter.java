package br.com.senai.agenda.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.senai.agenda.Aluno;
import br.com.senai.agenda.MainDrawerActivity;
import br.com.senai.agenda.R;
import br.com.senai.agenda.holder.AlunosViewHolder;

/**
 * Created by adminLocal on 23/03/2018.
 */

public class AlunoRecyclerAdapter extends RecyclerView.Adapter{
    private final Context context;
    private final List<Aluno> alunos;

    public AlunoRecyclerAdapter(Context context, List<Aluno> alunos) {
        this.context = context;
        this.alunos = alunos;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_card_principal,parent,false);
        AlunosViewHolder holder = new AlunosViewHolder(view, this);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AlunosViewHolder nossoHolder = (AlunosViewHolder) holder;
        Aluno aluno = alunos.get(position);
        nossoHolder.preecher(aluno);

    }

    @Override
    public int getItemCount() {
        return alunos.size();
    }
}
