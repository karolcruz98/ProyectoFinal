package com.example.proyectofinal.students.encuesta;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectofinal.R;

public class MainActivity extends AppCompatActivity {
    CheckBox sint1,sint2,sint3,sint4,sint5,sint6;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_test);
        sint1 = (CheckBox)findViewById(R.id.chb2);
        sint2 = (CheckBox)findViewById(R.id.chb3);
        sint3 = (CheckBox)findViewById(R.id.chb4);
        sint4 = (CheckBox)findViewById(R.id.chb5);
        sint5 = (CheckBox)findViewById(R.id.chb6);
        sint6 = (CheckBox)findViewById(R.id.chb7);
        Button btn = (Button)findViewById(R.id.getBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sint1.isChecked()){
                    AlertDialog.Builder alerta = new AlertDialog.Builder(null);
                    alerta.setMessage("Si presentas síntomas graves, busca atención médica inmediata.\n" +
                            " Sin embargo, siempre debes llamar a tu doctor o centro de atención sanitaria antes de presentarte en el lugar en cuestión.\n" +
                            "Lo recomendable es que las personas que sufran síntomas leves y tengan un buen estado de salud general se confinen en casa.");
                    alerta.setCancelable(true).setTitle("Síntomas");
                    alerta.create().show();

                }
                if(sint2.isChecked()){
                    AlertDialog.Builder alerta = new AlertDialog.Builder(null);
                    alerta.setMessage("Si presentas síntomas graves, busca atención médica inmediata.\n" +
                            " Sin embargo, siempre debes llamar a tu doctor o centro de atención sanitaria antes de presentarte en el lugar en cuestión.\n" +
                            "Lo recomendable es que las personas que sufran síntomas leves y tengan un buen estado de salud general se confinen en casa.");
                    alerta.setCancelable(true).setTitle("Síntomas");
                    alerta.create().show();

                }
                if(sint3.isChecked()){
                    AlertDialog.Builder alerta = new AlertDialog.Builder(null);
                    alerta.setMessage("Si presentas síntomas graves, busca atención médica inmediata.\n" +
                            " Sin embargo, siempre debes llamar a tu doctor o centro de atención sanitaria antes de presentarte en el lugar en cuestión.\n" +
                            "Lo recomendable es que las personas que sufran síntomas leves y tengan un buen estado de salud general se confinen en casa.");
                    alerta.setCancelable(true).setTitle("Síntomas");
                    alerta.create().show();

                }
                if(sint4.isChecked()){
                    AlertDialog.Builder alerta = new AlertDialog.Builder(null);
                    alerta.setMessage("Si presentas síntomas graves, busca atención médica inmediata.\n" +
                            " Sin embargo, siempre debes llamar a tu doctor o centro de atención sanitaria antes de presentarte en el lugar en cuestión.\n" +
                            "Lo recomendable es que las personas que sufran síntomas leves y tengan un buen estado de salud general se confinen en casa.");
                    alerta.setCancelable(true).setTitle("Síntomas");
                    alerta.create().show();

                }
                if(sint5.isChecked()){
                    AlertDialog.Builder alerta = new AlertDialog.Builder(null);
                    alerta.setMessage("Si presentas síntomas graves, busca atención médica inmediata.\n" +
                            " Sin embargo, siempre debes llamar a tu doctor o centro de atención sanitaria antes de presentarte en el lugar en cuestión.\n" +
                            "Lo recomendable es que las personas que sufran síntomas leves y tengan un buen estado de salud general se confinen en casa.");
                    alerta.setCancelable(true).setTitle("Síntomas");
                    alerta.create().show();

                }
                if(sint6.isChecked()){
                    AlertDialog.Builder alerta = new AlertDialog.Builder(null);
                    alerta.setMessage("Utiliza mascarilla\n" +
                            "Lávate las manos\n" +
                            "Mantén una distancia segura");
                    alerta.setCancelable(true).setTitle("Sin síntomas");
                    alerta.create().show();

                }
            }
        });


    }
}
