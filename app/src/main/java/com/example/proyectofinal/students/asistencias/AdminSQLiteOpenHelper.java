package com.example.proyectofinal.students.asistencias;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{

    public AdminSQLiteOpenHelper(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table asistencias(id PRIMARY KEY AUTOINCREMENT, codigo integer, nombre text, clase texto)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists asistencias");
        db.execSQL("create table asistencias(id PRIMARY KEY AUTOINCREMENT, codigo integer, nombre text, clase texto)");

    }
}

