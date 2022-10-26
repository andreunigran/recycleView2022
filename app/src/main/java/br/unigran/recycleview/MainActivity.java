package br.unigran.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.LinkedList;
import java.util.List;

import br.unigran.recycleview.adapter.PessoaAdapter;
import br.unigran.recycleview.dao.DBHelper;
import br.unigran.recycleview.dao.PessoaDB;
import br.unigran.recycleview.model.Pessoa;

public class MainActivity extends AppCompatActivity {
    DBHelper db;
    PessoaDB pessoaDB;
    PessoaAdapter adapter;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    List dados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayoutManager=new LinearLayoutManager(this);
        //trabalho
        dados= new LinkedList();
        db= new DBHelper(this);
        pessoaDB = new PessoaDB(db);
        pessoaDB.list(dados);
        adapter = new PessoaAdapter(dados);

        recyclerView = findViewById(R.id.idLista);
        //setar layout no recycleView
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);


    }
    public void salvar(View view){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(((EditText)findViewById(R.id.idnome)).getText().toString());
        PessoaDB pessoaDB = new PessoaDB(db);
        pessoaDB.insert(pessoa);
        pessoaDB.list(dados);
        adapter.notifyDataSetChanged();
    }
}