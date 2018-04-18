package br.com.senai.meuslivros.holder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.senai.meuslivros.R;
import br.com.senai.meuslivros.adapter.LivroAdapter;
import br.com.senai.meuslivros.model.Livro;

public class LivroHolder extends RecyclerView.ViewHolder {

    private LivroAdapter adapter;
    private ImageView capaDoLivro;
    private TextView tituloDoLivro;
    private TextView autorDoLivro;
    private Long livroId;

    public LivroHolder(View itemView, LivroAdapter adapter) {
        super(itemView);
        this.adapter = adapter;

        capaDoLivro = itemView.findViewById(R.id.item_capa);
        tituloDoLivro = itemView.findViewById(R.id.item_titulo);
        autorDoLivro = itemView.findViewById(R.id.item_autor);
    }


    public void preecher(Livro livro) {
        livroId = livro.getId();
        tituloDoLivro.setText(livro.getTituloDoLivro());
        autorDoLivro.setText(livro.getAutorDoLivro());
        
        Bitmap capaRetornada = BitmapFactory.decodeFile(livro.getCaminhoDaCapa());
        capaDoLivro.setImageBitmap(capaRetornada);
    }
}
