package com.example.testemoji;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity2 extends AppCompatActivity {
    Timer timer;
    boolean continueBGMusic;
    MediaPlayer mediaplayer;
    public String valor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mediaplayer = MediaPlayer.create(this,R.raw.fondosonidonino);
        continueBGMusic=true;
        timer = new Timer();
        recibir();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(valor.equals("1")){
                   // System.out.println(x1);
                    Intent intent = new Intent(MainActivity2.this, Emoji1.class);
                    startActivity(intent);
                    finish();
                }
                /*else{
                    Intent intent = new Intent(MainActivity2.this, emoji13.class);
                    startActivity(intent);
                    finish();
                }*/

            }
        },5000);
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

    public void recibir(){
        Bundle extras= getIntent().getExtras();
        String x1=extras.getString("opc");

        valor = x1;
    }

    public void onPause()
    {
        super.onPause();
        if(!continueBGMusic)
            nose.pause();
    }
    public void onResume()
    {
        super.onResume();

        continueBGMusic=false;
        nose.start(this,R.raw.fondosonidonino);
    }
}