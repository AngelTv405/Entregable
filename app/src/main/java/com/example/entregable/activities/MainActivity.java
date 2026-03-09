package com.example.entregable.activities;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.entregable.R;
import com.example.entregable.database.DbHelper;

public class MainActivity extends AppCompatActivity {

    Spinner spTipoResiduo;
    EditText etCantidad, etUbicacion;
    Button btnGuardar, btnReporte;

    DbHelper dbHelper;

    String[] tipos = {
            "Orgánico",
            "Plástico",
            "Papel",
            "Vidrio",
            "Metal"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spTipoResiduo = findViewById(R.id.spTipoResiduo);
        etCantidad = findViewById(R.id.etCantidad);
        etUbicacion = findViewById(R.id.etUbicacion);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnReporte = findViewById(R.id.btnReporte);

        dbHelper = new DbHelper(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                tipos
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTipoResiduo.setAdapter(adapter);

        btnGuardar.setOnClickListener(v -> guardarResiduo());

        btnReporte.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ReporteActivity.class);
            startActivity(intent);
        });
    }

    private void guardarResiduo() {

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("tipo", spTipoResiduo.getSelectedItem().toString());
        values.put("cantidad", etCantidad.getText().toString());
        values.put("ubicacion", etUbicacion.getText().toString());
        values.put("fecha", "2026-03-07");

        db.insert("residuos", null, values);

        Toast.makeText(this, "Residuo guardado correctamente", Toast.LENGTH_SHORT).show();

        etCantidad.setText("");
        etUbicacion.setText("");
    }
}