package mobi.lucasborges.tarefas.features.listatarefas;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import java.util.List;

import mobi.lucasborges.tarefas.data.ApplicationDatabase;
import mobi.lucasborges.tarefas.models.Tarefa;

/**
 * Created by Lucas Borges on 07/07/17.
 */
public class TarefasViewModel extends AndroidViewModel {

    private final LiveData<List<Tarefa>> scoresList;
    private ApplicationDatabase applicationDatabase;

    public TarefasViewModel(Application application){
        super(application);
        applicationDatabase = ApplicationDatabase.getDatabase(this.getApplication());
        scoresList = applicationDatabase.tarefaDao().recuperarTodasAsTarefas();
    }

    public LiveData<List<Tarefa>> getListaTarefas() {
        return scoresList;
    }

    public ApplicationDatabase getApplicationDatabase() {
        return applicationDatabase;
    }
}