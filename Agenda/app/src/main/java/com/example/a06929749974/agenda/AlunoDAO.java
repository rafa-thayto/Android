package com.example.a06929749974.agenda;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 06929749974 on 21/02/2018.
 */

public class AlunoDAO extends SQLiteOpenHelper {


    public AlunoDAO(Context context) {
        super(context, "Agenda", null,2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Aluno(id INTEGER PRIMARY KEY, " +
                                        "nome TEXT NOT NULL, " +
                                        "endereco TEXT NOT NULL, " +
                                        "telefone TEXT NOT NULL," +
                                        "email TEXT NOT NULL, " +
                                        "facebook TEXT NOT NULL" +
                                        "classificacao REAL)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF NOT EXISTS Aluno";
        db.execSQL(sql);
    }

    public void insere(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValues(aluno);

        db.insert("Aluno", null, dados);
    }

    @NonNull
    private ContentValues getContentValues(Aluno aluno) {
        ContentValues dados = new ContentValues();
        dados.put("nome", aluno.getNome());
        dados.put("endereco", aluno.getEndereco());
        dados.put("telefone", aluno.getTelefone());
        dados.put("email", aluno.getEmail());
        dados.put("facebook", aluno.getFace());
        dados.put("classificacao", aluno.getClassificacao());
        return dados;
    }

    public List<Aluno> buscarAlunos() {
        String sql = "SELECT * FROM Aluno";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);
        List<Aluno> alunos = new ArrayList<Aluno>();

        while (c.moveToNext()) {
            Aluno aluno = new Aluno();
            aluno.setId(c.getLong(c.getColumnIndex("id")));
            aluno.setNome(c.getString(c.getColumnIndex("nome")));
            aluno.setEndereco(c.getString(c.getColumnIndex("endereco")));
            aluno.setTelefone(c.getString(c.getColumnIndex("telefone")));
            aluno.setEmail(c.getString(c.getColumnIndex("email")));
            aluno.setFace(c.getString(c.getColumnIndex("facebook")));
            aluno.setClassificacao(c.getDouble(c.getColumnIndex("classificacao")));

            alunos.add(aluno);
        }

        return alunos;
    }

    public void remover(Aluno aluno) {
        SQLiteDatabase db = getReadableDatabase();
        String[] parametros = { aluno.getId().toString() };
        db.delete("Aluno", "id = ?", parametros);
    }

    public void alterar(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValues(aluno);
        String[] parametros = {aluno.getId().toString()};
        db.update("Aluno", dados, "id = ?", parametros);
    }
}
