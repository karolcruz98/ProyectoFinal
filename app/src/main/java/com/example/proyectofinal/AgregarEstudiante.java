package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AgregarEstudiante extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_estudiante);
    }

    public void añadir(View v){
        Intent i = new Intent(this, EstudianteAdmin.class);
        startActivity(i);
        Toast.makeText(this, "El estudiante ha sido registrado con éxito", Toast.LENGTH_LONG).show();
    }
}