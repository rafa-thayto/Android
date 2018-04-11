package br.com.senai.galeriadeimagens.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

import br.com.senai.galeriadeimagens.R;
import br.com.senai.galeriadeimagens.model.Imagem;

/**
 * Created by adminLocal on 06/04/2018.
 */

public class ImagemAdapter extends BaseAdapter{

    private final Context context;
    private final List<Imagem> imagens;
    private ImageView imagemDaLista;

    public ImagemAdapter(Context context, List<Imagem> imagens) {
        this.context = context;
        this.imagens = imagens;
    }

    @Override
    public int getCount() {
        return imagens.size();
    }

    @Override
    public Object getItem(int position) {
        return imagens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return imagens.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Imagem imagem = imagens.get(position);
        View view = convertView;
        LayoutInflater inflater = LayoutInflater.from(context);
        if (view == null){
            view = inflater.inflate(R.layout.lista_imagens, parent, false);
        }
        imagemDaLista = view.findViewById(R.id.imagemLista);
        String caminhoImagem = imagem.getCaminhoImagem();
        if(caminhoImagem != null){
            Bitmap imagemRetornada = BitmapFactory.decodeFile(caminhoImagem);
            imagemDaLista.setImageBitmap(imagemRetornada);
        }
        return view;
    }
}
