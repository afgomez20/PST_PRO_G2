package com.example.pis_adas.clases;

import com.example.pis_adas.R;

public class Data {
    /**
     * Base de datos porvisional del sistema
     * */
    /*libros = {Nombre, Temp min, Hum min}*/
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

    public static final int[] plantasImg = {R.drawable.cactus,R.drawable.rosas,R.drawable.margaritas, R.drawable.girasoles, R.drawable.girasoles, R.drawable.cactus,R.drawable.rosas,R.drawable.margaritas,};

    private
    Data() {}
}
