package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity_Administrator extends AppCompatActivity {

    public static final String user = "names";
    TextView txtUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator);
    }

    public void profesor(View v){
        Intent i = new Intent(this, ProfesorAdmin.class);
        startActivity(i);
    }

    public void estudiante(View v){
        Intent i = new Intent(this, EstudianteAdmin.class);
        startActivity(i);
    }

    public void salon(View v){
        Intent i = new Intent(this, SalonAdmin.class);
        startActivity(i);
    }

    public void curso(View v){
        Intent i = new Intent(this, CursoAdmin.class);
        startActivity(i);
    }

    public void logout(View v){
        Intent i =  new Intent(this, Auth_Activity.class);
        startActivity(i);
    }
}
