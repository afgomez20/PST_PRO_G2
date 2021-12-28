package com.example.pis_adas.clases;

import com.example.pis_adas.R;

import java.lang.reflect.Array;
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
            {"Margaritas","12","25"}

    };
    /*users = {User, Clave, Nombre,Correo}*/
    public static ArrayList<Usuario> users =new ArrayList<>();
            //(new Usuario("Admin","123","Mr Admin","correo"));

    public static final int[] plantasImg = {R.drawable.cactus,R.drawable.rosas,R.drawable.margaritas, R.drawable.girasoles, R.drawable.girasoles, R.drawable.cactus,R.drawable.rosas,R.drawable.margaritas,};

    private
    Data() {}
}
