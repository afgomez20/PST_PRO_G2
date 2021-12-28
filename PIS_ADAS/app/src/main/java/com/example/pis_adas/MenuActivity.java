package com.example.pis_adas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.pis_adas.clases.Data;
import com.example.pis_adas.clases.ListPlanta;
import com.example.pis_adas.clases.PlantaAdapter;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    PlantaAdapter plantas;
    RecyclerView recyclerView;
    ArrayList<ListPlanta> plantasList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        init();
    }

    public void init(){
        recyclerView = findViewById(R.id.recyclerView);
        plantasList = Data.plantasList;
        /*//Cargamos la lista
        cargarLista();*/
        //Mostramos datos
        mostrarDatos();
    }

    /**
     * Funcion que se encarga de cargar la lista de datos de la clase Data y convertirlas en objeto librosList
     * */
/**
    public void cargarLista(){
        for(int i = 0; i< Data.plantas.length; i++){
            plantasList.add(new ListPlanta(Data.plantas[i][0], new Float(Data.plantas[i][1]),new Float(Data.plantas[i][2]),Data.plantasImg[i]));
        }
    }**/
    /**
     * Funcion en cargada de mostrar los datos necesarios para el cardview
     * */
    public void mostrarDatos(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        plantas = new PlantaAdapter(this,plantasList);
        recyclerView.setAdapter(plantas);
        plantas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = plantasList.get(recyclerView.getChildAdapterPosition(view)).getNombre();
                Toast.makeText(view.getContext(), "Seleccionaste: "+nombre, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void registro(View view){
        Intent i = new Intent(this,IngresoPlantaActivity.class);
        startActivity(i);
        finish();
    }
}