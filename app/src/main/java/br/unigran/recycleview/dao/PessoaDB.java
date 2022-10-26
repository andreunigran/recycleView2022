package br.unigran.recycleview.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import br.unigran.recycleview.model.Pessoa;

public class PessoaDB {
    DBHelper db;
    private SQLiteDatabase conexao;
    public PessoaDB(DBHelper db) {
        this.db = db;
    }

    public void insert(Pessoa p) {
        conexao = db.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nome", p.getNome());

        conexao.insertOrThrow("pessoa", null, values);
        conexao.close();
    }

    public void list(List data) {
        data.clear();
        conexao = db.getReadableDatabase();

        String names[] = {"id", "nome"};
        Cursor query = conexao.query(
                "pessoa", names, null, null, null, null,
                null
        );

        while(query.moveToNext()) {
            Pessoa cliente = new Pessoa();
            cliente.setId(Integer.parseInt(query.getString(0)));
            cliente.setNome(query.getString(1));

            data.add(cliente);
        }

        conexao.close();
    }

    public void remove(Integer id) {
        conexao = db.getWritableDatabase();
        conexao.delete("pessoa", "id=?", new String[]{ id+"" });
        conexao.close();
    }
}
