package com.example.pis_adas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.pis_adas.clases.AdminSQLiteOpenHelper;
import com.example.pis_adas.clases.Data;
import com.example.pis_adas.clases.Usuario;

public class SplashActivity extends AppCompatActivity {


    private final int DURACION_SPLASH = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        setContentView(R.layout.activity_splash);
        Data.users.add(new Usuario("admin","123","admin","none"));
        Data.cargarLista();
        /*//crearDataBase();
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getReadableDatabase();

        admin.cargarDataUser(bd);*/
        new Handler().postDelayed(new Runnable() {
            @Override

            public void run() {
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        }, DURACION_SPLASH);
    }


}