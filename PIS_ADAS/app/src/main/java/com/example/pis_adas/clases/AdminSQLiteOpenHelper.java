package com.example.pis_adas.clases;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pis_adas.R;

import java.util.ArrayList;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
/*
    public  final String[][] plantas = {
            {"Cactus","12","25"},
            {"Rosas","15","29"},
            {"Margaritas","22","14"},
            {"Girasoles","15","25"}/*,
            {"Girasoles","12","25"},
            {"Cactus","12","25"},
            {"Rosas","12","25"},
            {"Margaritas","12","25"}*/

   // };

  //  public  ArrayList<ListPlanta> plantasList =  new ArrayList<>();


    /*users = {User, Clave, Nombre,Correo}*/
    //public  ArrayList<Usuario> users = new ArrayList<>();
    //(new Usuario("Admin","123","Mr Admin","correo"));

    //public  final int[] plantasImg = {R.drawable.cactus,R.drawable.rosas,R.drawable.margaritas, R.drawable.girasoles, R.drawable.girasoles, R.drawable.cactus,R.drawable.rosas,R.drawable.margaritas,};


    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //cargarLista();
        db.execSQL("create table plantas(id int primary key,nombre text,tempMin real,humMin real,imagen int,id_user int)");
       /* for(ListPlanta p:plantasList){
            db.execSQL("insert into plantas (id,nombre,tempMin,humMin,imagen,id_user) values ("+p.getId()+",'"+p.getNombre()+"',"+p.getTempMin()+","+p.getHumMin()+","+p.getImagen()+","+p.getId_user()+")");
        }*/
        db.execSQL("create table usuarios(id int primary key,user text,clave text,nombre text,correo text)");
       /* for(Usuario u:users){
            db.execSQL("insert into usuarios (id,user,clave,nombre,correo) values ("+u.getId()+",'"+u.getUser()+"','"+u.getClave()+"','"+u.getNombre()+"','"+u.getCorreo()+"')");
        }*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

/*
    public  void cargarLista(){
        for(int i = 0; i< plantas.length; i++){
            plantasList.add(new ListPlanta(plantas[i][0], new Float(plantas[i][1]),new Float(plantas[i][2]), plantasImg[i]));
        }
        users.add(new Usuario("admin","123","admin","none"));
    }

    public void cargarDataUser(SQLiteDatabase bd){
        Cursor fila = bd.rawQuery(
                "select * from usuarios", null);
        if (fila.moveToFirst()) {
            while(!fila.isAfterLast()){
                Data.users.add(new Usuario(fila.getInt(0),fila.getString(1),
                        fila.getString(2),fila.getString(3),fila.getString(4)));
                System.out.println(fila.getString(1));
                fila.moveToNext();
            }
        }
        bd.close();
    }

    public void cargarDataPlant(SQLiteDatabase bd){
        Cursor fila = bd.rawQuery(
                "select * from plantas", null);
        if (fila.moveToFirst()) {
            while(!fila.isAfterLast()){
                Data.plantasList.add(new ListPlanta(fila.getInt(0),fila.getString(1),
                        fila.getFloat(2),fila.getFloat(3),fila.getInt(4), fila.getInt(5)));
                //System.out.println(fila.getString(1));
                fila.moveToNext();
            }
        }
        bd.close();
    }

    public void ingresarUser(SQLiteDatabase db,Usuario u){
        db.execSQL("insert into usuarios (id,user,clave,nombre,correo) values ("+u.getId()+",'"+u.getUser()+"','"+u.getClave()+"','"+u.getNombre()+"','"+u.getCorreo()+"')");

    }
*/


}