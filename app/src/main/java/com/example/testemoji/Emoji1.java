package com.example.testemoji;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
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

public class Emoji1 extends AppCompatActivity {


    private TextView txt;
    //private GifImageView lt;
    private ImageView lt;
    /*private GifImageView lt2;
    private GifImageView lt3;
    private GifImageView lt4;
    private GifImageView lt5;
    private GifImageView lt6;*/
    private int opc;
    MediaPlayer mediaplayer;
    boolean continueBGMusic;
    CountDownTimer countDownTime;
    //nose2 ns=new nose2();
    public String valor;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        continueBGMusic=true;
        setContentView(R.layout.activity_emoji1);
        mediaplayer = MediaPlayer.create(this,R.raw.fondosonidonino);

        txt= findViewById(R.id.txt_timer6);
        lt=(ImageView) findViewById(R.id.imageFeliz);
        dialog = new Dialog(this);
       // lt = (GifImageView) findViewById(R.id.lot_perro);
     /*   lt2= (GifImageView) findViewById(R.id.lot_ave);

        lt3 = (GifImageView) findViewById(R.id.lot_gato);
        lt4= (GifImageView) findViewById(R.id.lot_mariposa);
        lt5 = (GifImageView) findViewById(R.id.lot_caballo);
        lt6 = (GifImageView) findViewById(R.id.lot_pez);*/

        //  recibir();
        opc=1;
        lt.setVisibility(View.VISIBLE);
       // ns.setvalor(1);
        //nose2.start(this, R.raw.ninagigle);

        /*if(valor.equals("1")) {
            opc=1;
           // nose3 ns=new nose3();
            //ns.modificarValorVar1();
            ns.setvalor(1);
            nose3.start(this, R.raw.perro);


            //color las 5
            lt.setVisibility(View.VISIBLE);
        //    lt.loop(true);
          //  lt.setRepeatCount(LottieDrawable.INFINITE);
            //lt.playAnimation();
        }
        else if(valor.equals("2")){
            opc=2;
            ns.setvalor(2);
            nose3.start(this, R.raw.ave);


        }
        else if(valor.equals("3")){
            opc=3;

            ns.setvalor(3);
            nose3.start(this, R.raw.gato);

            lt.setVisibility(View.INVISIBLE);

        }
        else if(valor.equals("4")){
            opc=4;

            ns.setvalor(4);
            nose3.start(this, R.raw.mariposa);
            lt.setVisibility(View.INVISIBLE);

        }
        else if(valor.equals("5")){

            opc=5;

            ns.setvalor(5);
            nose3.start(this, R.raw.caballo00);
            lt.setVisibility(View.INVISIBLE);

        }
        else{
            opc=6;

            ns.setvalor(6);
            nose3.start(this, R.raw.pez);
            lt.setVisibility(View.INVISIBLE);

        }*/

        //long duration = TimeUnit.MINUTES.toMillis(1);
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
                Intent intent = new Intent(Emoji1.this, emoji2.class);
                //intent.putExtra("dato01",i);
                //countDownTime.cancel();
                startActivity(intent);
                //Toast.makeText(getApplicationContext(),"Count down", Toast.LENGTH_LONG).show();
                //    acepta();
                finish();
             //   nose2.pause();
              //  nose2.mp=null;
            }
        }.start();
    }
    public  void acepta(View view){

        //mp.start();
        Context context = view.getContext();
        countDownTime.cancel();
        Intent intent2 = new Intent(Emoji1.this, emoji2.class);
        //shouldPlay = true;
        startActivity(intent2);
        finish();
       // nose2.pause();
       // nose2.mp=null;


    }
    /*
    public void atras(View view){

        //mp.start();
        Context context = view.getContext();
        countDownTime.cancel();
        Intent intent2 = new Intent(question03_espera.this, question03.class);
        //shouldPlay = true;
        startActivity(intent2);
        finish();
        nose3.pause();
        nose3.mp= null;

    }*/

  /*  @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==event.KEYCODE_BACK){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("¿Desea Salir de la Sesión?")
                    .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            /*Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);*/
     /*                       countDownTime.cancel();

                            finishAndRemoveTask();
                            System.exit(0);
                        }
                    })
                    .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                        }
                    });
            builder.show();
        }

        return super.onKeyDown(keyCode, event);
    }*/

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
    /*public void recibir(){
        Bundle extras= getIntent().getExtras();
        String x1=extras.getString("dato03");

        valor = x1;
    }*/

    public void onPause()
    {
        super.onPause();
        if(!continueBGMusic) {
            nose.pause();
           // nose2.pause();
        }

    }
    public void onResume()
    {
        super.onResume();

        continueBGMusic=false;
        nose.start(this,R.raw.fondosonidonino);
      //  nose2.start(this, R.raw.ninagigle);
     /*   if(opc==1) {
            nose3.start(this, R.raw.perro);
        }else if(opc==2) {
            nose3.start(this, R.raw.ave);
        }else if(opc==3) {
            nose3.start(this, R.raw.gato);
        }
        else if(opc==4) {
            nose3.start(this, R.raw.mariposa);
        }else if(opc==5) {
            nose3.start(this, R.raw.caballo00);
        }else{
            nose3.start(this, R.raw.pez);
        }*/

    }

}