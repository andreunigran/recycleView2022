package br.unigran.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import br.unigran.recycleview.dao.DBHelper;
import br.unigran.recycleview.dao.PessoaDB;
import br.unigran.recycleview.model.Pessoa;

public class MainActivity extends AppCompatActivity {
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db= new DBHelper(this);
    }
    public void salvar(View view){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(((EditText)findViewById(R.id.idnome)).getText().toString());
        PessoaDB pessoaDB = new PessoaDB(db);
        pessoaDB.insert(pessoa);
    }
}