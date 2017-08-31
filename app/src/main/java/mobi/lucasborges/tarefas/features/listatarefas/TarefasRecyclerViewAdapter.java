package mobi.lucasborges.tarefas.features.listatarefas;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import mobi.lucasborges.tarefas.R;
import mobi.lucasborges.tarefas.models.Tarefa;

/**
 * Created by Lucas Borges on 31/08/17.
 */
public class TarefasRecyclerViewAdapter extends RecyclerView.Adapter<TarefasRecyclerViewAdapter.TarefaViewHolder> {

    private List<Tarefa> tarefasList;

    public TarefasRecyclerViewAdapter(List<Tarefa> tarefasList){
        this.tarefasList = tarefasList;
    }

    @Override
    public TarefaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new TarefaViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tarefa, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(TarefaViewHolder viewHolder, int pos) {
        Tarefa tarefa = tarefasList.get(pos);
        viewHolder.getTxtDescricao().setText(String.valueOf(tarefa.getTitulo()));
        viewHolder.getTxtTitulo().setText(String.valueOf(tarefa.getDescricao()));
        viewHolder.getTxtData().setText(tarefa.getDataRegistro().toString());
    }

    @Override
    public int getItemCount() {
        return tarefasList != null ? tarefasList.size() : 0;
    }

    public void setItems(List<Tarefa> tarefas) {
        this.tarefasList = tarefas;
        notifyDataSetChanged();
    }

    class TarefaViewHolder extends RecyclerView.ViewHolder {

        private TextView txtTitulo, txtDescricao, txtData;


        public TarefaViewHolder(View itemView) {
            super(itemView);
            txtTitulo = (TextView) itemView.findViewById(R.id.txtConteudoTitulo);
            txtDescricao = (TextView) itemView.findViewById(R.id.txtConteudoDescricao);
            txtData = (TextView) itemView.findViewById(R.id.txtConteudoDataRegistro);
        }

        public TextView getTxtTitulo() {
            return txtTitulo;
        }

        public TextView getTxtDescricao() {
            return txtDescricao;
        }

        public TextView getTxtData() {
            return txtData;
        }
    }
}
