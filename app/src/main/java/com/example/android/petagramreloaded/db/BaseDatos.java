package com.example.android.petagramreloaded.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.petagramreloaded.pojo.Mascota;

import java.util.ArrayList;

import static android.R.attr.version;

/**
 * Created by DOMINIC on 8/28/2017.
 */

public class BaseDatos extends SQLiteOpenHelper{
    private Context context;
    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" +
                ConstantesBaseDatos.TABLE_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_FOTO + " INTEGER, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE + " TEXT" +
                ")";
        String queryCrearTablaMascotaLikes = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA + "(" +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + " INTEGER, " +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_NUMERO_LIKES + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" + ConstantesBaseDatos.TABLE_MASCOTAS_ID + ")" +
                ")";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaMascotaLikes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while(registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setImgFoto(registros.getInt(1));
            mascotaActual.setNombre(registros.getString(2));

            String queryLikes = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_NUMERO_LIKES + ") as likes" +
                                " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if(registrosLikes.moveToNext()){
                mascotaActual.setNumBones(registrosLikes.getInt(0));
            } else{
                mascotaActual.setNumBones(0);
            }
            mascotas.add(mascotaActual);
        }
        db.close();

        return mascotas;
    }
    public ArrayList<Mascota> obtenerMascotasUltimas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        int i = 0;
        while(registros.moveToNext()){

            if(i >= 5) {
                Mascota mascotaActual = new Mascota();
                mascotaActual.setId(registros.getInt(0));
                mascotaActual.setImgFoto(registros.getInt(1));
                mascotaActual.setNombre(registros.getString(2));

                String queryLikes = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_NUMERO_LIKES + ") as likes" +
                        " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                        " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + "=" + mascotaActual.getId();

                Cursor registrosLikes = db.rawQuery(queryLikes, null);
                if (registrosLikes.moveToNext()) {
                    mascotaActual.setNumBones(registrosLikes.getInt(0));
                } else {
                    mascotaActual.setNumBones(0);
                }
                mascotas.add(mascotaActual);
            }
            i++;
        }
        db.close();

        return mascotas;
    }
    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues);
        db.close();
    }
    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_MASCOTA, null, contentValues);
        db.close();
    }
    public int obtenerLikesMascota(Mascota mascota){
        int likes = 0;
        //suma de los valores del campo numero_likes
        String query = "SELECT COUNT (" + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_NUMERO_LIKES + ")" +
                        " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                        " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + "=" + mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if(registros.moveToNext()){
           likes = registros.getInt(0);
        }
        db.close();

        return likes;
    }
}
