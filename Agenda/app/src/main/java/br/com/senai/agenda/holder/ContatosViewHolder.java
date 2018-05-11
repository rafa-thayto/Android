package br.com.senai.agenda.holder;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.senai.agenda.FormularioActivity;
import br.com.senai.agenda.R;
import br.com.senai.agenda.adapter.ContatosAdapter;
import br.com.senai.agenda.adapter.RecyclerAdapter;
import br.com.senai.agenda.modelo.Contato;

/**
 * Created by mac12 on 22/03/2018.
 */

public class ContatosViewHolder extends RecyclerView.ViewHolder{
    private final RecyclerAdapter adapter;
    private final TextView campoNome;
    private final TextView campoTelefone;
    private final ImageView campoFoto;
    private final TextView campoNota;
    private long contatoId;


    public ContatosViewHolder(View itemView, RecyclerAdapter adapter) {
        super(itemView);
        this.adapter = adapter;

        campoNome = itemView.findViewById(R.id.item_nome);
        campoTelefone = itemView.findViewById(R.id.item_telefone);
        campoFoto = itemView.findViewById(R.id.item_foto);
        campoNota = itemView.findViewById(R.id.item_nota);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Activity context = (Activity)view.getContext();
                final Intent intent = new Intent(context, FormularioActivity.class);
                intent.putExtra("contatoId", contatoId);
                context.startActivityForResult(intent, 1);

            }
        });

    }

    public void preencher(Contato contato) {
        contatoId = contato.getId();
        campoNome.setText(contato.getNome());
        campoTelefone.setText(contato.getTelefone());
        String caminhoFoto = contato.getCaminhoFoto();
        if (caminhoFoto !=null) {
            Bitmap bitmap = BitmapFactory.decodeFile(caminhoFoto);
            Bitmap bitmapReduzido = Bitmap.createScaledBitmap(bitmap, 100, 100, true);
            campoFoto.setImageBitmap(bitmapReduzido);
            campoFoto.setScaleType(ImageView.ScaleType.FIT_XY);

        }
        campoNota.setText(contato.getClassificacao().toString());
    }
}
