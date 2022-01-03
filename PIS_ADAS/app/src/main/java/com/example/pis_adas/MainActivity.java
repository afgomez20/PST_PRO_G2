package com.example.pis_adas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pis_adas.clases.Data;
import com.example.pis_adas.clases.ListPlanta;

public class MainActivity extends AppCompatActivity {
    EditText usuario;
    EditText contra;
    boolean estado = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void inicio(View view) {
        usuario=(EditText) findViewById(R.id.etUsuario);
        contra=(EditText) findViewById(R.id.etPassword);

        for(int x=0; x<Data.users.size();x++){
            if (usuario.getText().toString().equals(Data.users.get(x).getUser()) &&
                    contra.getText().toString().equals(Data.users.get(x).getClave())){
                Intent i = new Intent(this, MenuActivity.class );
                i.putExtra("usuario",Data.users.get(x));
                Toast.makeText(this,"Bienvenido "+Data.users.get(x).getUser(),Toast.LENGTH_SHORT).show();
                estado = true;
                startActivity(i);
            }
        }
        if (estado==false) {
            Toast.makeText(this, "Usuario o Contraseña Incorrecto", Toast.LENGTH_SHORT).show();
        }

    }
    public void registro(View view) {
        Intent i = new Intent(this, RegistroActivity.class );
        startActivity(i);
        finish();
    }

}