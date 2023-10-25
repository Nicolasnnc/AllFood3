package com.example.mapa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    //Declaro Variables
    EditText edtUsuario, edtContraseña;
    Spinner spSpinner;

    //Llenar de datos el Spinner
    String[] usuarios = new String[]{"Administrador","Cliente", "Visita"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        //Enlazar las variables con los ID del XML
        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtContraseña = (EditText) findViewById(R.id.edtContraseña);
        spSpinner = (Spinner) findViewById(R.id.spSpinner);

        //Poblar el Spinner
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, usuarios);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSpinner.setAdapter(spinnerAdapter);
    }

    public void Acceder(View view){
        //Obtener el usuario y contraseña ingresados
        String username = edtUsuario.getText().toString().trim();
        String password = edtContraseña.getText().toString().trim();

        //Validaciones de campos nulos
        if(username.equals("")){
            Toast.makeText(this, "Ingrese el usuario", Toast.LENGTH_LONG).show();
            return;
        }
        if (password.equals("")){
            Toast.makeText(this, "Ingrese la contraseña ", Toast.LENGTH_LONG).show();
            return;
        }

        //Validacion de Credenciales
        if(username.equals("Admin") && password.equals("1234")){
            Intent intent = new Intent(this, Crud.class);
            startActivity(intent);
            Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_LONG).show();
            return;
        }else{
            Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_LONG).show();
        }
    }
    public void Visita(View View){
        Intent intent = new Intent(this,Elementos.class);
        startActivity(intent);
    }
}