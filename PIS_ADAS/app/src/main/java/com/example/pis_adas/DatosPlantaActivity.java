package com.example.pis_adas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.pis_adas.clases.Data;
import com.example.pis_adas.clases.PlantaAdapter;

public class DatosPlantaActivity extends AppCompatActivity {
    private ProgressBar progressBar_HA, progressBar_TA, progressBar_HT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_planta);
        progressBar_HA = (ProgressBar) findViewById(R.id.progressBar_HA);
        progressBar_HT = (ProgressBar) findViewById(R.id.progressBar_HT);
        progressBar_TA = (ProgressBar) findViewById(R.id.progressBar_TA);
        progressBar_HA.setProgress(25);
        progressBar_HT.setProgress(25);
        progressBar_TA.setProgress(25);


    }

    public void menu(View view){
        finish();
    }

    public void editar(View view){
        Intent i = new Intent(this, EditarPlantaActivity.class);
        startActivity(i);
    }


}
