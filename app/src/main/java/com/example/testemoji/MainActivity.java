package com.example.testemoji;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaplayer;
    Button btn_musica;
    boolean continueBGMusic;
    private Button b1;
    //private Button b2;
    private LottieAnimationView anim;
    String i;
    //private GifImageView gf;
    //public static boolean shouldPlay = false;
    //MediaPlayer mediaplayer;
    //Button btn_musica;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b1 = (Button) findViewById(R.id.btn_aceptar);
       // b2 = (Button) findViewById(R.id.btn_noaceptar);

        mediaplayer = MediaPlayer.create(this,R.raw.fondosonidonino);

        System.out.println(1);

    }
    public  void acepta(View view){

        //mp.start();
        i="1";
        Context context = view.getContext();
        Intent intent2 = new Intent(MainActivity.this, MainActivity2.class);
        intent2.putExtra("opc",i);
        //shouldPlay = true;
        startActivity(intent2);
        finish();

    }
  /*  public  void noacepta(View view){
    //        System.exit(0);
        i="2";
        Context context = view.getContext();
        Intent intent2 = new Intent(MainActivity.this, MainActivity2.class);
        intent2.putExtra("opc",i);
        //shouldPlay = true;
        startActivity(intent2);
        finish();

    }*/
  public  void noacepta(View view){
      System.exit(0);
      // finish();
  }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("¿Salir?")
                .setMessage("¿Estas seguro que deseas salir?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        // finish(); //finaliza Activity.


                        finishAndRemoveTask();
                        System.exit(0);
                    }
                }).create().show();
    }

    public void onPause() {
        //super.onPause();
        super.onPause();
        if(!continueBGMusic)
            nose.pause();
        //stopService(new Intent(this, Servicio.class));



    }


    public void onResume() {
        //super.onResume();
        //startService(new Intent(this, Servicio.class));

        super.onResume();

        continueBGMusic=false;
        nose.start(this,R.raw.fondosonidonino);

    }



    }
