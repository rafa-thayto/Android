package br.com.senai.agenda;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adminLocal on 20/02/2018.
 */

public class AlunoDAO extends SQLiteOpenHelper{


    public AlunoDAO(Context context) {
        super(context, "AgendaTardeDez", null,2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Aluno(id INTEGER PRIMARY KEY, nome TEXT NOT NULL," +
                "endereco TEXT, telefone TEXT, email TEXT, face TEXT, classificacao REAL)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Aluno";
        db.execSQL(sql);
    }

    public void insere(Aluno aluno) {
     SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = pegarDadosDoAluno(aluno);


     db.insert("Aluno",null, dados);
    }

    @NonNull
    private ContentValues pegarDadosDoAluno(Aluno aluno) {
        ContentValues dados = new ContentValues();
        dados.put("nome", aluno.getNome());
        dados.put("endereco", aluno.getEndereco());
        dados.put("telefone", aluno.getTelefone());
        dados.put("email", aluno.getEmail());
        dados.put("face", aluno.getFace());//Essa Linha
        dados.put("classificacao", aluno.getClassificacao());
        return dados;
    }

    public List<Aluno> buscarAlunos() {
    String sql = "SELECT * FROM Aluno";
    SQLiteDatabase db = getReadableDatabase();
    Cursor c = db.rawQuery(sql, null);
    List<Aluno> alunos = new ArrayList<Aluno>();

    while (c.moveToNext()){
        Aluno aluno = new Aluno();
        aluno.setId(c.getLong(c.getColumnIndex("id")));
        aluno.setNome(c.getString(c.getColumnIndex("nome")));
        aluno.setEndereco(c.getString(c.getColumnIndex("endereco")));
        aluno.setTelefone(c.getString(c.getColumnIndex("telefone")));
        aluno.setEmail(c.getString(c.getColumnIndex("email")));
        aluno.setFace(c.getString(c.getColumnIndex("face")));//essa linha
        aluno.setClassificacao(c.getDouble(c.getColumnIndex("classificacao")));

        alunos.add(aluno);
    }

    return alunos;
    }
    public Aluno localizar(Long alunoId) {
        String sql = "SELECT * FROM Aluno WHERE id = ?";
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery(sql,new String[]{String.valueOf(alunoId)});
        c.moveToFirst();
        Aluno alunoLocalizado = new Aluno();
        alunoLocalizado.setId(c.getLong(c.getColumnIndex("id")));
        alunoLocalizado.setNome(c.getString(c.getColumnIndex("nome")));
        alunoLocalizado.setEndereco(c.getString(c.getColumnIndex("endereco")));
        alunoLocalizado.setTelefone(c.getString(c.getColumnIndex("telefone")));
        alunoLocalizado.setEmail(c.getString(c.getColumnIndex("email")));
        alunoLocalizado.setFace(c.getString(c.getColumnIndex("face")));//essa linha
        alunoLocalizado.setClassificacao(c.getDouble(c.getColumnIndex("classificacao")));
        db.close();
        return alunoLocalizado;
    }

    public void remover(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();
        String[] parametros = {aluno.getId().toString()};
        db.delete("Aluno","id = ?",parametros);
    }

    public void alterar(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = pegarDadosDoAluno(aluno);
        String[] parametros = {aluno.getId().toString()};
        db.update("Aluno", dados,"id = ?", parametros);
    }


    public List<Aluno> buscarPorNome(String textoPesquisado) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            String sql = "SELECT * FROM Aluno WHERE nome Like'"+textoPesquisado+"%'";
            Cursor c = db.rawQuery(sql, null);
            List<Aluno> alunoPesquisado = new ArrayList<>();
            while (c.moveToNext()){
                Aluno aluno = new Aluno();
                aluno.setId(c.getLong(c.getColumnIndex("id")));
                aluno.setNome(c.getString(c.getColumnIndex("nome")));
                aluno.setEndereco(c.getString(c.getColumnIndex("endereco")));
                aluno.setTelefone(c.getString(c.getColumnIndex("telefone")));
                aluno.setEmail(c.getString(c.getColumnIndex("email")));
                aluno.setFace(c.getString(c.getColumnIndex("face")));//essa linha
                aluno.setClassificacao(c.getDouble(c.getColumnIndex("classificacao")));

                alunoPesquisado.add(aluno);
            }
            c.close();
            return  alunoPesquisado;

        }finally {
            db.close();
        }
    }
}
