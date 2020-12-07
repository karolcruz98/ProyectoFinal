package com.example.proyectofinal.students.asistencias;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectofinal.R;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button scanBtn, guardar, eliminar,ver;
    private EditText codeTxt,nombreTxt,claseTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_asistencias);
        scanBtn = (Button)findViewById(R.id.btnScan);
        codeTxt = (EditText)findViewById(R.id.codigo);
        nombreTxt = (EditText)findViewById(R.id.nombre);
        claseTxt = (EditText)findViewById(R.id.clase);
        scanBtn.setOnClickListener(this);
        guardar =(Button)findViewById(R.id.btnScan);
        guardar.setOnClickListener(this);
        eliminar = (Button)findViewById(R.id.btnEliminar);
        eliminar.setOnClickListener(this);
        ver = (Button)findViewById(R.id.btnVer);
        ver.setOnClickListener(this);

    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {

        super.onActivityResult(requestCode, resultCode, intent);
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if(scanningResult != null) {
            String scanContent = scanningResult.getContents();
            StringTokenizer t = new StringTokenizer(scanContent, "*");
            final String codigo = t.nextToken();
            final String nombre = t.nextToken();
            final String clase = t.nextToken();
            codeTxt.setText("" + codigo);
            nombreTxt.setText("" + nombre);
            claseTxt.setText("" + clase);
        }else{
            Toast toast = Toast.makeText(getApplicationContext(),
            "No se ha recibido datos del scaneo!", Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnScan){
            IntentIntegrator scanIntegrator =new IntentIntegrator(this);
            scanIntegrator.initiateScan();
        }
        if(v.getId()==R.id.btnGuardar){
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(MainActivity.this,"scans",null,1);
            SQLiteDatabase bd = admin.getWritableDatabase();

            ContentValues registro = new ContentValues();
            registro.put("codigo",codeTxt.getText().toString());
            registro.put("nombre",nombreTxt.getText().toString());
            registro.put("clase",claseTxt.getText().toString());
            bd.insert("asistencias",null,registro);
            bd.close();
            Toast.makeText(MainActivity.this,"Se guardaron los datos de la asistencia satisfactoriamente",Toast.LENGTH_SHORT).show();
        }
        if(v.getId()==R.id.btnVer){
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(MainActivity.this,"scans",null,1);
            SQLiteDatabase bd = admin.getWritableDatabase();
            String cdg = codeTxt.getText().toString();
            Cursor registro = bd.rawQuery("select codigo,nombre,clase from asistencias where id="+cdg,null);
            codeTxt.setText(registro.getString(0));
            nombreTxt.setText(registro.getString(1));
            claseTxt.setText(registro.getString(2));
            if(registro.moveToFirst()){

            }else {
                Toast.makeText(MainActivity.this,"No existe una asistencia con ese código",Toast.LENGTH_SHORT).show();
                bd.close();
            }

        }
        if(v.getId()==R.id.btnEliminar){
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(MainActivity.this,"scans",null,1);
            SQLiteDatabase bd = admin.getWritableDatabase();
            String cdg = codeTxt.getText().toString();
            int cant = bd.delete("asistencias","id="+cdg,null);
            bd.close();
            codeTxt.setText("");
            nombreTxt.setText("");
            claseTxt.setText("");
            if(cant==1){
                Toast.makeText(MainActivity.this,"Los datos se borraron satisfactoriamente",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(MainActivity.this,"No existe una asistencia con ese código",Toast.LENGTH_SHORT).show();

            }

        }

    }
}
