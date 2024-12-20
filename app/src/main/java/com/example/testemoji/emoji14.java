package com.example.testemoji;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class emoji14 extends AppCompatActivity {

    private TextView txt;
    //private GifImageView lt;
    private ImageView lt;
    private int opc;
    MediaPlayer mediaplayer;
    boolean continueBGMusic;
    CountDownTimer countDownTime;
   // nose2 ns=new nose2();
    public String valor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        continueBGMusic=true;
        setContentView(R.layout.activity_emoji14);
        mediaplayer = MediaPlayer.create(this,R.raw.fondosonidonino);

        txt= findViewById(R.id.txt_timer6);
        lt=(ImageView) findViewById(R.id.imageFeliz);
        //lt = (GifImageView) findViewById(R.id.lot_perro);
        opc=1;
        lt.setVisibility(View.VISIBLE);
       // ns.setvalor(10);
        //nose2.start(this, R.raw.limpiando);


        long duration=TimeUnit.SECONDS.toMillis(45);

        countDownTime = new CountDownTimer(duration, 1000) {
            @Override
            public void onTick(long l) {
                //when tick
                //convertir milis a minut y seg
                String sDuration = String.format(Locale.ENGLISH, "%02d : %02d",TimeUnit.MILLISECONDS.toMinutes(l),TimeUnit.MILLISECONDS.toSeconds(l)
                        - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l)));
                txt.setText(sDuration);
                System.out.println(sDuration);
                System.out.println(valor);
            }

            @Override
            public void onFinish() {
                txt.setVisibility(View.GONE);
                Intent intent = new Intent(emoji14.this, emoji15.class);
                //intent.putExtra("dato01",i);
                //countDownTime.cancel();
                startActivity(intent);
                //Toast.makeText(getApplicationContext(),"Count down", Toast.LENGTH_LONG).show();
                //    acepta();
                finish();
            //    nose2.pause();
           //     nose2.mp=null;
            }
        }.start();
    }
    public  void acepta(View view){

        //mp.start();
        Context context = view.getContext();
        countDownTime.cancel();
        Intent intent2 = new Intent(emoji14.this, emoji15.class);
        //shouldPlay = true;
        startActivity(intent2);
        finish();
      //  nose2.pause();
      //  nose2.mp=null;

    }

    public void atras(View view){

        //mp.start();
        Context context = view.getContext();
        countDownTime.cancel();
        Intent intent2 = new Intent(emoji14.this, emoji13.class);
        //shouldPlay = true;
        startActivity(intent2);
        finish();


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
                        countDownTime.cancel();

                        finishAndRemoveTask();
                        System.exit(0);
                    }
                }).create().show();
    }

    public void onPause()
    {
        super.onPause();
        if(!continueBGMusic) {
            nose.pause();
          //  nose2.pause();
        }
    }
    public void onResume() {
        super.onResume();

        continueBGMusic = false;
        nose.start(this,R.raw.fondosonidonino);
      //  nose2.start(this, R.raw.limpiando);

    }
}