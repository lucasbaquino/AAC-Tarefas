package mobi.lucasborges.tarefas.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

import mobi.lucasborges.tarefas.data.DateConverter;

/**
 * Created by Lucas Borges on 31/08/17.
 */
@Entity(tableName = "tarefas")
public class Tarefa {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "titulo")
    private String titulo;

    @ColumnInfo(typeAffinity = ColumnInfo.TEXT)
    private String descricao;

    @TypeConverters(DateConverter.class)
    private Date dataRegistro;

    public Tarefa(String titulo, String descricao, Date dataRegistro) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataRegistro = dataRegistro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
}
