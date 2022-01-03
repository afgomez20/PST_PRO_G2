package com.example.pis_adas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

import com.example.pis_adas.clases.ListPlanta;
import com.example.pis_adas.clases.Usuario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DatosPlantaActivity extends AppCompatActivity {
    ListPlanta planta;
    TextView tempAmbiente,humTierra,humAmbiente;
    ProgressBar progressBar_TA,progressBar_HA,progressBar_HT;
    private Switch b_manual,b_auto;
    private Float tempA_actual,humA_actual,humT_actual;
    DatabaseReference myRefServo;
    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_planta);
        Bundle bundle = getIntent().getExtras();
        planta = (ListPlanta) bundle.getSerializable("planta");
        usuario = (Usuario) bundle.getSerializable("usuario");

        b_manual = (Switch)findViewById(R.id.b_manual);
        b_auto = (Switch)findViewById(R.id.b_auto);

        tempAmbiente = (TextView) findViewById(R.id.status_TA);
        humTierra = (TextView)findViewById(R.id.status_HT);
        humAmbiente = (TextView)findViewById(R.id.status_HA);

        progressBar_TA = (ProgressBar)findViewById(R.id.progressBar_TA);
        progressBar_HT = (ProgressBar)findViewById(R.id.progressBar_HT);
        progressBar_HA = (ProgressBar)findViewById(R.id.progressBar_HA);


        //progressBar_HT.setProgress((int)planta.humMin);
        //progressBar_HA.setProgress(25);
        //progressBar_TA.setProgress((int)planta.getTempMin());
        //tempAmbiente.setText(String.valueOf(planta.getTempMin()));
        //humTierra.setText(String.valueOf(planta.humMin));


        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRefTA = database.getReference("PLANTAS/ID_0001/DHT11/TA");
        DatabaseReference myRefHA = database.getReference("PLANTAS/ID_0001/DHT11/HA");
        DatabaseReference myRefHT = database.getReference("PLANTAS/ID_0001/M_SENSOR/HT");
        myRefServo = database.getReference("PLANTAS/ID_0001/SERVOMOTOR/ESTADO");


        //TEMPERATURA_AMBIENTE
        myRefTA.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue().toString();
                tempAmbiente.setText(value+"c°");
                progressBar_TA.setProgress(Math.round(Float.parseFloat(value)));
                tempA_actual = Float.parseFloat(value);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });

        //HUMEDAD_AMBIENTE
        myRefHA.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue().toString();
                humAmbiente.setText(value+"%");
                progressBar_HA.setProgress(Integer.parseInt(value));
                humA_actual = Float.parseFloat(value);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });

        //HUMEDAD_TIERRA
        myRefHT.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue().toString();
                humTierra.setText(value+"%");
                progressBar_HT.setProgress(Integer.parseInt(value));
                humT_actual = Float.parseFloat(value);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });

        //SERVOMOTOR
        //manual
        b_manual.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    myRefServo.setValue(180);
                }
                else{
                    myRefServo.setValue(0);
                }
            }
        });

        //automatico
        b_auto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    if(tempA_actual>planta.getTempMin() && humA_actual<planta.getHumMin()){
                        myRefServo.setValue(180);
                    }
                    else{
                        myRefServo.setValue(0);
                    }
                }
                else{
                    myRefServo.setValue(0);
                }
            }
        });
        myRefServo.setValue(0);
    }

    public void menu(View view){
        myRefServo.setValue(0);
        finish();
    }

    public void editar(View view){
        Intent i = new Intent(this, EditarPlantaActivity.class);
        i.putExtra("planta",planta);
        i.putExtra("usuario",usuario);
        startActivity(i);
        finish();
    }


}
