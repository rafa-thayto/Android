package br.com.senai.galeriadeimagens.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.senai.galeriadeimagens.model.Imagem;

/**
 * Created by adminLocal on 06/04/2018.
 */

public class ImagemDAO extends SQLiteOpenHelper{
    public ImagemDAO(Context context) {
        super(context, "galeriaImagensSete", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Imagens(id INTEGER PRIMARY KEY, caminhoimagem TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Imagens";
        db.execSQL(sql);
    }

    public void inserir(Imagem imagem) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = new ContentValues();
        dados.put("caminhoimagem", imagem.getCaminhoImagem());
        db.insert("Imagens", null, dados);
    }

    public List<Imagem> buscarImagens() {
        String sql = "SELECT * FROM Imagens";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);
        List<Imagem> imagens = new ArrayList<>();
        while (c.moveToNext()){
            Imagem imagem = new Imagem();
            imagem.setId(c.getLong(c.getColumnIndex("id")));
            imagem.setCaminhoImagem(c.getString(c.getColumnIndex("caminhoimagem")));
            imagens.add(imagem);
        }
        c.close();
        return imagens;
    }
}
