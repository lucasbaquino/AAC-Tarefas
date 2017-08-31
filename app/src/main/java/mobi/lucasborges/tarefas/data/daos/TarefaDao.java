package mobi.lucasborges.tarefas.data.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;
import android.arch.persistence.room.Update;

import java.util.List;

import mobi.lucasborges.tarefas.data.DateConverter;
import mobi.lucasborges.tarefas.models.Tarefa;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by Lucas Borges on 31/08/17.
 */
@Dao
@TypeConverters(DateConverter.class)
public interface TarefaDao {
    @Query("select * from tarefas")
    LiveData<List<Tarefa>> recuperarTodasAsTarefas();

    @Query("select * from tarefas where id = :id")
    LiveData<Tarefa> recuperarTarefa(int id);

    @Insert(onConflict = REPLACE)
    void inserirTarefa(Tarefa tarefa);

    @Update
    void atualizarTarefa(Tarefa tarefa);
}
