package com.amg.wm.project2.model;

import com.dacorp.database.annot.Column;
import com.dacorp.database.annot.Table;
import com.dacorp.database.data.enu.Schema;

@Table(schema = Schema.PUBLIC)
public class ListObj {
    @Column(primary_key = true, auto_incrementing = true)
    private long idlist;
    @Column
    private String Titulo;

    public long getIdList() {
        return idlist;
    }

    public void setIdlist(long idlist) {
        this.idlist = idlist;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        this.Titulo = titulo;
    }

    @Override
    public String toString() {
        return "ListObj{" +
                "idlist=" + idlist +
                ", Titulo='" + Titulo + '\'' +
                '}';
    }
}