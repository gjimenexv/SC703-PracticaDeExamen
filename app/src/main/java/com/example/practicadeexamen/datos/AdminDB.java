package com.example.practicadeexamen.datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminDB extends SQLiteOpenHelper {
    public AdminDB(@Nullable Context context,
                   @Nullable String name,
                   @Nullable SQLiteDatabase.CursorFactory factory,
                   int version) {
        super(context, name, factory, version);
    }

    //El onCreate se ejecuta sólo 1 vez cuando se crea la Base de Datos
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table usuarios (id int primary key, nombre text, edad int, rol text, cantidadLogin real)");
        db.execSQL("insert into usuarios values(1,'Juan',18,'Admin',5)");
        db.execSQL("insert into usuarios values(2,'Pedro',19,'Responsable',1)");
        db.execSQL("insert into usuarios values(3,'Maria',20,'Admin',10)");
        db.execSQL("insert into usuarios values(4,'Rebeca',21,'Encargado',4)");
        db.execSQL("insert into usuarios values(5,'Valeria',21,'Admin',8)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("create table usuarios (id int primary key, nombre text, edad int, rol text, cantidadLogin real)");
        db.execSQL("insert into usuarios values(1,'Juan',18,'Admin',5)");
        db.execSQL("insert into usuarios values(2,'Pedro',19,'Responsable',1)");
        db.execSQL("insert into usuarios values(3,'Maria',20,'Admin',10)");
        db.execSQL("insert into usuarios values(4,'Rebeca',21,'Encargado',4)");
        db.execSQL("insert into usuarios values(5,'Valeria',21,'Admin',8)");
    }
}


