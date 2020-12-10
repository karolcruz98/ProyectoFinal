package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AgregarSalon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_salon);
    }

    public void añadir(View v){
        Intent i = new Intent(this, SalonAdmin.class);
        startActivity(i);
        Toast.makeText(this, "El salón ha sido registrado con éxito", Toast.LENGTH_LONG).show();
    }
}