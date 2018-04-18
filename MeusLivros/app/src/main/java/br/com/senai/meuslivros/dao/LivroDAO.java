package br.com.senai.meuslivros.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.senai.meuslivros.model.Livro;

/**
 * Created by adminLocal on 13/04/2018.
 */

public class LivroDAO extends SQLiteOpenHelper {
    public LivroDAO(Context context) {
        super(context, "LivrariaTarde", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Livros(id INTEGER PRIMARY KEY, caminhoCapa TEXT, tituloLivro TEXT, nomeAutor TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Livros";
        db.execSQL(sql);
    }

    public void inserir(Livro livro) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = new ContentValues();
        dados.put("caminhoCapa", livro.getCaminhoDaCapa());
        dados.put("tituloLivro", livro.getTituloDoLivro());
        dados.put("nomeAutor", livro.getAutorDoLivro());

        db.insert("Livros", null, dados);
    }

    public List<Livro> buscaLivros() {
        String sql = "SELECT * FROM Livros";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);
        List<Livro> livros = new ArrayList<>();
        while(c.moveToNext()){
            Livro livro = new Livro();
            livro.setId(c.getLong(c.getColumnIndex("id")));
            livro.setCaminhoDaCapa(c.getString(c.getColumnIndex("caminhoCapa")));
            livro.setTituloDoLivro(c.getString(c.getColumnIndex("tituloLivro")));
            livro.setAutorDoLivro(c.getString(c.getColumnIndex("nomeAutor")));
            livros.add(livro);
        }
        return livros;
    }
}
