package com.example.pis_adas.clases;

import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.pis_adas.R;

import java.util.ArrayList;

public class Data {
    /**
     * Base de datos porvisional del sistema
     * */
    /*plantas = {Nombre, Temp min, Hum min}*/
    public static final String[][] plantas = {
            {"Cactus","12","25"},
            {"Rosas","15","29"},
            {"Margaritas","22","14"},
            {"Girasoles","15","25"},
            {"Girasoles","12","25"},
            {"Cactus","12","25"},
            {"Rosas","12","25"},
            {"Margaritas","12","25"}};

    public static ArrayList<ListPlanta> plantasList =  new ArrayList<>();


    /*users = {User, Clave, Nombre,Correo}*/
    public static ArrayList<Usuario> users = new ArrayList<>();

    public static final int[] plantasImg = {R.drawable.cactus,R.drawable.rosas,R.drawable.margaritas, R.drawable.girasoles, R.drawable.girasoles, R.drawable.cactus,R.drawable.rosas,R.drawable.margaritas,};

    private Data() {}

    public static void cargarLista(){
        for(int i = 0; i< Data.plantas.length; i++){
            plantasList.add(new ListPlanta(Data.plantas[i][0], new Float(Data.plantas[i][1]),new Float(Data.plantas[i][2]), Data.plantasImg[i]));
        }
    }

    public static ListPlanta comprobar(ListPlanta planta){
        for( ListPlanta e : plantasList){
            if (e.equals(planta)){
                return e;
            }
        }
        return null;
    }

    public static void actualizarLista(ListPlanta planta){
        ListPlanta plantaComprobada = comprobar(planta);
        int indice = plantasList.indexOf(plantaComprobada);
        System.out.println("imprimire el indice si lo encuentra");
        System.out.println(indice);
        System.out.println("Listo");
        plantasList.get(indice).setHumMin(planta.getHumMin());
        plantasList.get(indice).setNombre(planta.getNombre());
        plantasList.get(indice).setTempMin(planta.getTempMin());
    }
}
