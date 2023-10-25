package com.example.mapa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DataHelper extends SQLiteOpenHelper {
    //Parametros de la base de datos
    public DataHelper(@Nullable Context context,
                      @Nullable String name,
                      @Nullable SQLiteDatabase.CursorFactory factory,
                      int version){
        super(context, name, factory, version);
    }
    //Creacion de las Tablas
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE alumno(rut INTEGER PRIMARY KEY, nom TEXT, dir TEXT, com TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS alumno");
        db.execSQL("CREATE TABLE alumno(rut INTEGER PRIMARY KEY, nom TEXT, dir TEXT, com TEXT)");
    }
}
