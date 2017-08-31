package mobi.lucasborges.tarefas.features.listatarefas;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import mobi.lucasborges.tarefas.R;
import mobi.lucasborges.tarefas.features.adicionartarefa.AdicionarTarefaActivity;
import mobi.lucasborges.tarefas.models.Tarefa;

/**
 * Created by Lucas Borges on 31/08/17.
 */
public class TarefasActivity extends LifecycleActivity {

    private RecyclerView recyclerview;
    private TarefasViewModel tarefasViewModel;
    private TarefasRecyclerViewAdapter adapter;
    private FloatingActionButton fabAddTarefa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefas);

        tarefasViewModel = ViewModelProviders.of(this).get(TarefasViewModel.class);
        recyclerview = findViewById(R.id.recyclerview);
        fabAddTarefa = findViewById(R.id.fabAddTarefa);
        setupRecyclerView();

        tarefasViewModel.getListaTarefas().observe(this, new Observer<List<Tarefa>>() {
            @Override
            public void onChanged(@Nullable List<Tarefa> tarefas) {
                setupItems(tarefas);
            }
        });

        fabAddTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActivityAdicionarTarefa();
            }
        });
    }

    private void abrirActivityAdicionarTarefa() {
        Intent intentAdicionarTarefa = new Intent(this, AdicionarTarefaActivity.class);
        startActivity(intentAdicionarTarefa);
    }

    private void setupRecyclerView() {
        adapter = new TarefasRecyclerViewAdapter(new ArrayList<Tarefa>());
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(adapter);
    }

    private void setupItems(List<Tarefa> tarefas) {
        adapter.setItems(tarefas);
    }
}
