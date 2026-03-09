package com.example.entregable.activities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.entregable.R;
import com.example.entregable.database.DbHelper;

import java.util.ArrayList;

public class ReporteActivity extends AppCompatActivity {

    ListView listaResiduos;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte);

        listaResiduos = findViewById(R.id.listaResiduos);

        dbHelper = new DbHelper(this);

        mostrarResiduos();
    }

    private void mostrarResiduos() {

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM residuos", null);

        ArrayList<String> lista = new ArrayList<>();

        if (cursor.moveToFirst()) {

            do {

                String tipo = cursor.getString(1);
                String cantidad = cursor.getString(2);
                String ubicacion = cursor.getString(3);

                lista.add(tipo + " - " + cantidad + "kg - " + ubicacion);

            } while (cursor.moveToNext());
        }

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1,
                        lista);

        listaResiduos.setAdapter(adapter);
    }
}