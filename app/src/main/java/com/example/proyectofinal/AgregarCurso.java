package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AgregarCurso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_curso);
    }

    public void añadir(View v){
        Intent i = new Intent(this, CursoAdmin.class);
        startActivity(i);
        Toast.makeText(this, "Curso ha sido registrado con exito", Toast.LENGTH_LONG).show();
    }
}