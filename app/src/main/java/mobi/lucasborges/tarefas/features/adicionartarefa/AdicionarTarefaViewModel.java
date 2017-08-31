package mobi.lucasborges.tarefas.features.adicionartarefa;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;

import java.util.Date;

import mobi.lucasborges.tarefas.data.ApplicationDatabase;
import mobi.lucasborges.tarefas.models.Tarefa;
import mobi.lucasborges.tarefas.utils.SingleLiveEvent;

/**
 * Created by Lucas Borges on 31/08/17.
 */
public class AdicionarTarefaViewModel extends AndroidViewModel {

    private SingleLiveEvent<Void> eventoTarefaSalva = new SingleLiveEvent<>();
    private ApplicationDatabase applicationDatabase;

    public AdicionarTarefaViewModel(Application application){
        super(application);
        applicationDatabase = ApplicationDatabase.getDatabase(this.getApplication());
    }

    public void salvarTarefa(String tituloTarefa, String descricaoTarefa){
        Tarefa tarefa = new Tarefa(tituloTarefa, descricaoTarefa, new Date());
        new SalvarTarefaAsync(applicationDatabase).execute(tarefa);
    }

    public ApplicationDatabase getApplicationDatabase() {
        return applicationDatabase;
    }

    public SingleLiveEvent<Void> getEventoTarefaSalva() {
        return eventoTarefaSalva;
    }

    private class SalvarTarefaAsync extends AsyncTask<Tarefa, Void, Void> {
        private ApplicationDatabase applicationDatabase;

        SalvarTarefaAsync(ApplicationDatabase applicationDatabase){
            this.applicationDatabase = applicationDatabase;
        }

        @Override
        protected Void doInBackground(final Tarefa... params){
            applicationDatabase.tarefaDao().inserirTarefa(params[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void result){
            eventoTarefaSalva.call();
        }
    }
}
