package br.unigran.recycleview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.unigran.recycleview.R;
import br.unigran.recycleview.model.Pessoa;

public class PessoaAdapter extends RecyclerView.Adapter<PessoaAdapter.PessoaHolder> {

    List<Pessoa> dados;

    public PessoaAdapter(List<Pessoa> dados) {
        this.dados = dados;
    }
    @NonNull
    @Override
    public PessoaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.linha,parent,false);
        return new PessoaHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull PessoaHolder pessoaHolder, int position) {
        pessoaHolder.nome.setText(dados.get(position).getNome());
        pessoaHolder.nome2.setText("testando");
    }
    @Override
    public int getItemCount() {
        return dados.size();
    }

    public class PessoaHolder extends RecyclerView.ViewHolder {
        public TextView nome;
        public TextView nome2;
        public Button editar;
        public PessoaHolder(@NonNull View itemView) {
            super(itemView);
            nome =itemView.findViewById(R.id.idNome);
            nome2 =itemView.findViewById(R.id.idNome2);
            editar =itemView.findViewById(R.id.idEditar);
        }

    }
}
