package com.example.pis_adas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pis_adas.clases.Data;
import com.example.pis_adas.clases.ListPlanta;
import com.example.pis_adas.clases.PlantaAdapter;
import com.example.pis_adas.clases.Usuario;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    PlantaAdapter plantas;
    RecyclerView recyclerView;
    ArrayList<ListPlanta> plantasList = new ArrayList<>();
    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Bundle bundle = getIntent().getExtras();
        usuario = (Usuario) bundle.getSerializable("usuario");
        init();
    }

    public void init(){
        recyclerView = findViewById(R.id.recyclerView);
        for (ListPlanta p :Data.plantasList){
            if(p.getId_user()== usuario.getId()){
                plantasList.add(p);
            }
        }
        //plantasList = Data.plantasList;
        //Mostramos datos
        mostrarDatos();
    }

    /**
     * Funcion en cargada de mostrar los datos necesarios para el cardview
     * */
    public void mostrarDatos(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        plantas = new PlantaAdapter(this,plantasList,usuario);
        recyclerView.setAdapter(plantas);
        /*plantas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), DatosPlantaActivity.class);
                i.putExtra("planta",plantasList);
                String nombre = plantasList.get(recyclerView.getChildAdapterPosition(view)).getNombre();
                Toast.makeText(view.getContext(), "Seleccionaste: "+nombre, Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });*/
    }

    public void registro(View view){
        Intent i = new Intent(this,IngresoPlantaActivity.class);
        i.putExtra("usuario",usuario);
        startActivity(i);
        finish();
    }


}