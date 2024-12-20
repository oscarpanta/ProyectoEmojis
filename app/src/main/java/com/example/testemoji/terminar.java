package com.example.testemoji;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;

import java.util.Timer;
import java.util.TimerTask;

public class terminar extends AppCompatActivity {

    Timer timer;
    boolean continueBGMusic;
    MediaPlayer mediaplayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminar);

        mediaplayer = MediaPlayer.create(this,R.raw.fondosonidonino);
        continueBGMusic=true;
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
               // Intent intent = new Intent(terminar.this, QUESTION_01.class);
                finishAndRemoveTask();
                System.exit(0);
               // startActivity(intent);
              //  finish();
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