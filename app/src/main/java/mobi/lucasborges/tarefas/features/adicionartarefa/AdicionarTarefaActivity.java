package mobi.lucasborges.tarefas.features.adicionartarefa;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import mobi.lucasborges.tarefas.R;
import mobi.lucasborges.tarefas.models.Tarefa;

/**
 * Created by Lucas Borges on 31/08/17.
 */
public class AdicionarTarefaActivity extends LifecycleActivity {

    private AdicionarTarefaViewModel viewModel;
    private Button btnSalvarTarefa;
    private EditText edtTitulo, edtDescricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);
        viewModel = ViewModelProviders.of(this).get(AdicionarTarefaViewModel.class);

        btnSalvarTarefa = (Button) findViewById(R.id.btnSalvarTarefa);
        edtTitulo = (EditText) findViewById(R.id.edtTitulo);
        edtDescricao = (EditText) findViewById(R.id.edtDescricao);

        // Ação do botão Salvar
        btnSalvarTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.salvarTarefa(edtTitulo.getText().toString(), edtDescricao.getText().toString());

                edtTitulo.setText("");
                edtDescricao.setText("");
            }
        });

        viewModel.getApplicationDatabase().tarefaDao().recuperarTodasAsTarefas().observe(this, new Observer<List<Tarefa>>() {
            @Override
            public void onChanged(@Nullable List<Tarefa> tarefas) {
                Toast.makeText(AdicionarTarefaActivity.this, "Tabela de Tarefas alterada", Toast.LENGTH_SHORT).show();
            }
        });

        // Observa por mudança no estado do LiveData
        viewModel.getEventoTarefaSalva().observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void v) {
                Toast.makeText(AdicionarTarefaActivity.this, "Tarefa salva!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
