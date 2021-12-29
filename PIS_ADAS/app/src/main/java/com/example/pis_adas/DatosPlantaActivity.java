package com.example.pis_adas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pis_adas.clases.ListPlanta;

public class DatosPlantaActivity extends AppCompatActivity {
    ListPlanta planta;
    TextView tempAmbiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_planta);
        Bundle bundle = getIntent().getExtras();
        planta = (ListPlanta) bundle.getSerializable("planta");
        tempAmbiente = (TextView) findViewById(R.id.tem_ambiente);
        tempAmbiente.setText(String.valueOf(planta.getTempMin()));
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
