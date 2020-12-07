package com.example.proyectofinal.students;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectofinal.R;

public class dashboard extends AppCompatActivity {
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_dashboard);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setTitle("Dashboard");
    }
    public void showTest(View view){
        Intent testDash= new Intent();
        getIntent().setComponent(new ComponentName("com.example","com.example.proyectofinal.students.encuesta.MainActivity"));
        startActivity(testDash);
        finish();
    }
    public void showInfoCl(View view){
        Intent testDash= new Intent();
        getIntent().setComponent(new ComponentName("com.example","com.example.proyectofinal.students.clases.MainActivity"));
        startActivity(testDash);
        finish();
    }
    public void showGPS(View view){
        Intent testDash= new Intent();
        getIntent().setComponent(new ComponentName("com.example","com.example.proyectofinal.students.localizacion.MainActivity"));
        startActivity(testDash);
        finish();
    }
    public void showAsist(View view){
        Intent testDash= new Intent();
        getIntent().setComponent(new ComponentName("com.example","com.example.proyectofinal.students.asistencia.MainActivity"));
        startActivity(testDash);
        finish();
    }
    @Override
    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        startActivity(a);
    }
}
