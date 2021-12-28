package com.example.pis_adas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DatosPlantaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_planta);
    }

    public void menu(View view){
        finish();
    }

    public void editar(View view){
        Intent i = new Intent(this, EditarPlantaActivity.class);
        startActivity(i);
    }


}
