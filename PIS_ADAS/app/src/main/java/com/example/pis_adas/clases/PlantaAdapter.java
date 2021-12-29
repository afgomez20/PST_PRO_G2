package com.example.pis_adas.clases;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pis_adas.DatosPlantaActivity;
import com.example.pis_adas.R;

import java.util.ArrayList;

public class PlantaAdapter extends RecyclerView.Adapter<PlantaAdapter.ViewHolder> implements View.OnClickListener{
    /**
     * Adaptador para el RecyclerView
     * */
    ArrayList<ListPlanta> modelo;
    LayoutInflater inflater;

    Context context;

    //Listener
    private View.OnClickListener listener;

    public PlantaAdapter(Context context, ArrayList<ListPlanta> modelo){
        this.inflater = LayoutInflater.from(context);

        this.context = context;

        this.modelo = modelo;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_planta, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListPlanta planta = modelo.get(position);
        String nombre = modelo.get(position).getNombre();
        Float tempMin = modelo.get(position).getTempMin();
        Float humMin = modelo.get(position).getHumMin();
        int img = modelo.get(position).getImagen();
        holder.nombre.setText("Planta: "+nombre);
        holder.tempMin.setText("Temperatura minima: "+tempMin.toString());
        holder.humMin.setText("Humedad minima: "+humMin.toString());
        holder.img.setImageResource(img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(holder.itemView.getContext(), DatosPlantaActivity.class);
                i.putExtra("planta",planta);
                Toast.makeText(view.getContext(), "Seleccionaste: "+nombre, Toast.LENGTH_SHORT).show();
                holder.itemView.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return modelo.size();
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombre;
        TextView tempMin;
        TextView humMin;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombrePlanta);
            tempMin = itemView.findViewById(R.id.tempMin);
            humMin = itemView.findViewById(R.id.humMin);
            img = itemView.findViewById(R.id.imgPlanta);
        }
    }
}
