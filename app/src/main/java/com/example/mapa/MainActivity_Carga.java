package com.example.mapa;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity_Carga extends AppCompatActivity {

    //Declaro Variables
    TextView textView;
    ImageView imageView;

    Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga);

        //Enlazo las variables con los ID del XML
        textView = findViewById(R.id.textView);
        imageView  = findViewById(R.id.imageView);
        button3 = findViewById(R.id.button3);
        //Instancio el metodo asincrono y la inicio
        MyAsyncTask asyncTask = new MyAsyncTask();
        asyncTask.execute();


        //conectamos id del xml con una variable

        VideoView mivideo = findViewById(R.id.video1);

        //busco la ruta del video
        String video = "android.resource://" + getPackageName() + "/" + R.raw.promo;

        Uri uri = Uri.parse(video);

        //Establezco la Uri del video en el video view

        mivideo.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        mivideo.setMediaController(mediaController);
        // Reproduce el video automáticamente cuando esté preparado
        mivideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mivideo.start();
            }
        });
        //animaciones
        //1 . de chico se amplia a grande
        Animation animation = new ScaleAnimation(0.0f,1.0f,0.0f,1.0f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        animation.setDuration(1000);
        mivideo.startAnimation(animation);

        //2. se mueve de abajo hacia arriva
        //Animation animation= new TranslateAnimation(0,0,300,0);
        //animation.setDuration(3000);
        //mivideo.startAnimation(animation);


        // se reproduce el video automaticamente
    }
    public class MyAsyncTask extends AsyncTask<Void, Void, String>{
        @Override
        protected String doInBackground(Void... voids){
            //Inicio la actividad en segundo plano
            //Le indicamos que debe esperar 10 segundos
            try{
                Thread.sleep(10000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return "Operacion Completo";
        }
        @Override
        protected void onPostExecute(String result) {
            textView.setText(result);
            imageView.setVisibility(View.VISIBLE);
            // Oculta el botón button3 por 5 segundos
            button3.setVisibility(View.INVISIBLE);

            // Usamos un Handler para volver a hacer visible el botón después de un tiempo
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    button3.setVisibility(View.VISIBLE);
                }
            }, 1000); // 5000 milisegundos (5 segundos)
        }
    }


    public void Siguiente(View View) {
        Intent intent =new Intent(this, MainActivity_mapa.class);
        startActivity(intent);
    }
}