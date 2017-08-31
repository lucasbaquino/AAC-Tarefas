package mobi.lucasborges.tarefas.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import mobi.lucasborges.tarefas.data.daos.TarefaDao;
import mobi.lucasborges.tarefas.models.Tarefa;

/**
 * Created by Lucas Borges on 31/08/17.
 */
@Database(version = 1, entities = {Tarefa.class})
public abstract class ApplicationDatabase extends RoomDatabase {

    private static ApplicationDatabase applicationDatabaseInstance;
    private static String DATABASE_NAME = "tarefas.db";

    public static ApplicationDatabase getDatabase(Context context){
        if(applicationDatabaseInstance == null){
            applicationDatabaseInstance = Room.databaseBuilder(context.getApplicationContext(), ApplicationDatabase.class, DATABASE_NAME).build();
        }
        return applicationDatabaseInstance;
    }

    public abstract TarefaDao tarefaDao();
}
