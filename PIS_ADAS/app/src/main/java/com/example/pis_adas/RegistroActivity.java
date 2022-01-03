package com.example.pis_adas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pis_adas.clases.AdminSQLiteOpenHelper;
import com.example.pis_adas.clases.Data;
import com.example.pis_adas.clases.Usuario;

public class RegistroActivity extends AppCompatActivity {
    EditText nombre;
    EditText user;
    EditText correo;
    EditText clave;
    //Usuario u;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }
    public void registro(View view){
        user=(EditText) findViewById(R.id.etUser);
        clave=(EditText) findViewById(R.id.etclave);
        nombre=(EditText) findViewById(R.id.etNombre);
        correo=(EditText) findViewById(R.id.etcorreo);
        /*u = new Usuario(user.getText().toString(),
                clave.getText().toString(),
                nombre.getText().toString(),
                correo.getText().toString());
        //Data.users.add(u);
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(SplashActivity.,
                "administracion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        db.execSQL("insert into usuarios (id,user,clave,nombre,correo) values ("+u.getId()+",'"+u.getUser()+"','"+u.getClave()+"','"+u.getNombre()+"','"+u.getCorreo()+"')");
        db.close();*/
        Data.users.add(new Usuario(user.getText().toString(),
                clave.getText().toString(),
                nombre.getText().toString(),
                correo.getText().toString()));
        Toast.makeText(this,"Se creo correctamente",Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        finish();


    }

}