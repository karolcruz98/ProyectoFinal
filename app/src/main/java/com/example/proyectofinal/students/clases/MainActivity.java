package com.example.proyectofinal.students.clases;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectofinal.R;

public class MainActivity extends AppCompatActivity {
    Button watch;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_dashboard);
        watch =(Button) findViewById(R.id.btnScan);
        watch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),PlayerActivity.class);
                startActivity(intent);
            }
        });
    }

}
