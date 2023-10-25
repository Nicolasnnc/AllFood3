package com.example.mapa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Tarjeta extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarjeta);
    }

    public void onClickPagar(View View){
        Intent intent =new Intent(this, MainActivity_Carga.class);
        startActivity(intent);
    }
}
