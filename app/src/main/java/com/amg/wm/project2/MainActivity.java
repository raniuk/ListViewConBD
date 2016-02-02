package com.amg.wm.project2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.amg.wm.project2.utils.ArrayAdapterobj;
import com.amg.wm.project2.utils.LVObjects;
import com.amg.wm.project2.model.TestDataBase;
import com.amg.wm.project2.model.ListObj;
import com.dacorp.database.error.EjecutionDBExcepcion;
import com.dacorp.database.sql.cond.Condition;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<LVObjects> objetos;
    private ListView lvCont;
    private ArrayAdapterobj adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCont = (ListView) findViewById(R.id.lvgeneral);

        insertDataBase();
        objetos = new ArrayList<LVObjects>();
        insertValues(objetos);
        adapter = new ArrayAdapterobj(MainActivity.this, objetos);
        lvCont.setAdapter(adapter);
        lvCont.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Click on " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void insertValues(ArrayList<LVObjects> objetos) {
        //Se crea el Objeto TestDataBase
        TestDataBase data = new TestDataBase(this);
        try{
            data.connect();//Realiza la conexion a la BD

            //Creamos un LIST de tipo LISTOBJ y asignamos la consulta realiza a la BD, de la siguiente
            //manera: SELECT * FROM basedatos
            List<ListObj> mObjects = data.select(ListObj.class);

            //Hacemos el recorrido por cada uno de los Items con un FOR
            for (ListObj items : mObjects) {
                //Asignamos al OBJETO LISTVIEW sacando de la BD el TITULO y tambien pasamos una imagen boton.png
                objetos.add(new LVObjects(items.getTitulo(), R.drawable.boton));
            }
        } catch (EjecutionDBExcepcion ejecutionDBExcepcion) {
            ejecutionDBExcepcion.printStackTrace();
        }
        data.close();//Cerramos la conexion a la BD
    }

    protected void insertDataBase(){
        TestDataBase data = new TestDataBase(this);
        try{
            data.connect();
            List<ListObj> mObj = data.select(ListObj.class);
            for (ListObj items : mObj) {
                data.delete(ListObj.class, new Condition("idlist=" + items.getIdList()));
            }
            ListObj object = new ListObj();
            for (int i = 0; i <= 10; i++){
                object.setTitulo("Item db " + i);
                data.insert(object);
            }
        } catch (EjecutionDBExcepcion ejecutionDBExcepcion) {
            ejecutionDBExcepcion.printStackTrace();
        }
    }
}
