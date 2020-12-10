package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Encuesta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);
        Button BtnEnviar = (Button)findViewById(R.id.btnEnviar);
    }

    public void enviar(View v){
        Intent intent = new Intent(this, Activity_Administrator.class);
        startActivity(intent);
    }
}