package com.example.proyectofinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class Auth_Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button botnIngresar;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        firebaseAuth = FirebaseAuth.getInstance();
        emailEditText = (EditText)findViewById(R.id.email);
        passwordEditText = (EditText)findViewById(R.id.password);
        botnIngresar =(Button) findViewById(R.id.btnIngresar);
        progressDialog = new ProgressDialog(this);
        botnIngresar.setOnClickListener(this);
    }

    private void loguearUsuario(){
        final String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
            Toast.makeText(this, "Por favor llene todos los campos", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "Por favor ingrese una contraseña", Toast.LENGTH_LONG).show();
            return;

        }
            progressDialog.setMessage("Realizando consulta en línea...");
            progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    int pos = email.indexOf("@");
                    String user = email.substring(0, pos);
                    Toast.makeText(Auth_Activity.this,"Bienvenido: " + user, Toast.LENGTH_LONG).show();
                    Intent intencion = new Intent(getApplication(), Activity_Administrator.class);
                    intencion.putExtra(Activity_Administrator.user, user);
                    startActivity(intencion);
                    Toast.makeText(Auth_Activity.this,"Haz ingresado con exito",Toast.LENGTH_LONG).show();
                }
                else{
                    if(task.getException() instanceof FirebaseAuthUserCollisionException){ //Si se presenta una colisión
                        Toast.makeText(Auth_Activity.this, "Ese usuario ya existe", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(Auth_Activity.this, "No se pudo registrar el usuario", Toast.LENGTH_LONG).show();
                    }
                }
                progressDialog.dismiss();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnIngresar:
                loguearUsuario();
                break;
        }
    }
}
