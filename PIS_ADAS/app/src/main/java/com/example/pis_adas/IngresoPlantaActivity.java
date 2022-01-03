package com.example.pis_adas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pis_adas.clases.Data;
import com.example.pis_adas.clases.ListPlanta;
import com.example.pis_adas.clases.Usuario;

public class IngresoPlantaActivity extends AppCompatActivity {
    Integer indice;
    EditText tem_minina;
    EditText hum_minima;
    EditText nom_planta;
    Usuario usuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_planta);
        Bundle bundle = getIntent().getExtras();
        usuario = (Usuario) bundle.getSerializable("usuario");
    }

    public void registrado(View view){
        tem_minina = (EditText)findViewById(R.id.tem_minima);
        hum_minima = (EditText)findViewById(R.id.hum_minima);
        nom_planta = (EditText)findViewById(R.id.nom_planta);
        Intent in = new Intent(this,MenuActivity.class);

        for(int i = 0; i< Data.plantas.length; i++){
            if(Data.plantas[i][0].toUpperCase().equals(nom_planta.getText().toString().toUpperCase())){
                indice = i;

            }

        }
        if (indice == null){
            Toast.makeText(this,"Tipo de planta no valida.",Toast.LENGTH_SHORT).show();
            startActivity(in);
            finish();
            return;
        }
        Data.plantasList.add(new ListPlanta(nom_planta.getText().toString(),new Float(tem_minina.getText().toString()),new Float(hum_minima.getText().toString()),Data.plantasImg[indice],usuario.getId()));
        Toast.makeText(this,"Planta ingresada con éxito",Toast.LENGTH_SHORT).show();
        in.putExtra("usuario",usuario);
        startActivity(in);
        finish();
    }
}