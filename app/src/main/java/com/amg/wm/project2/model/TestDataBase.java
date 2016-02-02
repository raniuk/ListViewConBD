package com.amg.wm.project2.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.dacorp.database.ConectorDB;
import com.dacorp.database.Configuration;
import com.dacorp.database.error.EjecutionDBExcepcion;
import com.dacorp.database.event.DataBaseListener;

import java.io.File;

public class TestDataBase extends ConectorDB {
    public TestDataBase(Context context) {
        super(context, new Configuration(context.getDir("database", Context.MODE_PRIVATE).getAbsolutePath()
                        + File.separator + "test.sqlitle"),
                new DataBaseListener() {

                    @Override
                    public void refreshTables(SQLiteDatabase arg0) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void createTables(SQLiteDatabase liteDatabase) {
                        // TODO Auto-generated method stub
                        try {
                            //liteDatabase.execSQL(ConectorDB.generateSQLCreateTable(Telefono.class));
                            liteDatabase.execSQL(ConectorDB.generateSQLCreateTable(ListObj.class));
                            //liteDatabase.execSQL(ConectorDB.generateSQLCreateTable(Fotos.class));


                        } catch (EjecutionDBExcepcion e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}