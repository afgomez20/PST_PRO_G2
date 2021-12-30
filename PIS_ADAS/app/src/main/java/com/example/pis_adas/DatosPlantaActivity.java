package com.example.pis_adas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.pis_adas.clases.ListPlanta;

public class DatosPlantaActivity extends AppCompatActivity {
    ListPlanta planta;
    TextView tempAmbiente,humTierra;
    ProgressBar progressBar_TA,progressBar_HA,progressBar_HT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_planta);
        Bundle bundle = getIntent().getExtras();
        planta = (ListPlanta) bundle.getSerializable("planta");
        tempAmbiente = (TextView) findViewById(R.id.status_TA);
        humTierra = (TextView)findViewById(R.id.status_HT);
        progressBar_TA = (ProgressBar)findViewById(R.id.progressBar_TA);
        progressBar_HT = (ProgressBar)findViewById(R.id.progressBar_HT);
        progressBar_HA = (ProgressBar)findViewById(R.id.progressBar_HA);
        progressBar_HT.setProgress((int)planta.humMin);
        progressBar_HA.setProgress(25);
        progressBar_TA.setProgress((int)planta.getTempMin());
        tempAmbiente.setText(String.valueOf(planta.getTempMin()));
        humTierra.setText(String.valueOf(planta.humMin));
    }

    public void menu(View view){
        finish();
    }

    public void editar(View view){
        Intent i = new Intent(this, EditarPlantaActivity.class);
        i.putExtra("planta",planta);
        startActivity(i);
        finish();
    }


}
