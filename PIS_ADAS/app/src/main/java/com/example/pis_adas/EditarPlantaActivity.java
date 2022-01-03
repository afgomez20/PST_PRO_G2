package com.example.pis_adas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pis_adas.clases.Data;
import com.example.pis_adas.clases.ListPlanta;
import com.example.pis_adas.clases.Usuario;

public class EditarPlantaActivity extends AppCompatActivity {
    ListPlanta planta;
    Usuario usuario;
    EditText nombre;
    EditText temp_min;
    EditText hum_min;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_planta);
        Bundle bundle = getIntent().getExtras();
        planta = (ListPlanta) bundle.getSerializable("planta");
        usuario = (Usuario) bundle.getSerializable("usuario");
        nombre = findViewById(R.id.nom_planta);
        temp_min = findViewById(R.id.tem_minima);
        hum_min = findViewById(R.id.hum_minima);

    }

    public void guardar(View view){
        Intent i = new Intent(this, MenuActivity.class);
        i.putExtra("usuario",usuario);
        planta.setNombre(nombre.getText().toString());
        planta.setTempMin(new Float(temp_min.getText().toString()));
        planta.setHumMin(new Float(hum_min.getText().toString()));
        Data.actualizarLista(planta);
        startActivity(i);
        finish();
    }
}