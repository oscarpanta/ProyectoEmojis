package com.example.testemoji;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

public class nose2 {
    static final int MUSIC_PREVIOUS = -1;
    private static final String TAG = "MusicManager";
    static MediaPlayer mp;
   // private static int perro;
    private static int emoji;
    //private int perro=0;
    private static int currentMusic = -1;
    private static int previousMusic = -1;


    public static void start(Context context, int music) {
        start(context, music, false);
    }

    public static void start(Context context, int music, boolean force) {
        if (!force && currentMusic > -1) {
// already playing some music and not forced to change
            return;
        }

        if (music == MUSIC_PREVIOUS) {
            Log.d(TAG, "Using previous music [" + previousMusic + "]");
            music = previousMusic;
        }
        if (currentMusic == music) {
// already playing this music
            return;
        }
        if (currentMusic != -1) {
            previousMusic = currentMusic;
            Log.d(TAG, "Previous music was [" + previousMusic + "]");
// playing some other music, pause it and change
            pause();
        }
        currentMusic = music;
        Log.d(TAG, "Current music is now [" + currentMusic + "]");
        if (mp != null) {
            if (!mp.isPlaying()) {
                mp.start();
            }
        } else {
            if (emoji == 1) {
                mp = MediaPlayer.create(context, R.raw.ninagigle); //Ur BackGround Music
            }
            else if(emoji==2){
                mp = MediaPlayer.create(context, R.raw.pajaros);
            }
            else if(emoji==3){
                mp = MediaPlayer.create(context, R.raw.ninoriendosuave);
            }
            else if(emoji==4){
                mp = MediaPlayer.create(context, R.raw.ninarisa);
            }
            else if(emoji==5){
                mp = MediaPlayer.create(context, R.raw.aire);
            }
            else if(emoji==6){
                mp = MediaPlayer.create(context, R.raw.ninosescuela);
            }
            else if(emoji==7){
                mp = MediaPlayer.create(context, R.raw.ninosriendo);
            }
            else if(emoji==8){
                mp = MediaPlayer.create(context, R.raw.ninosescuela2);
            }
            else if(emoji==9){
                mp = MediaPlayer.create(context, R.raw.pajaro3);
            }
            else if(emoji==10){
                mp = MediaPlayer.create(context, R.raw.limpiando);
            }
            else if(emoji==11){
                mp = MediaPlayer.create(context, R.raw.olas);
            }
            else if(emoji==12){
                mp = MediaPlayer.create(context, R.raw.ninosriendo3);
            }
            else if(emoji==13){
                mp = MediaPlayer.create(context, R.raw.ninoswo);
            }
            else if(emoji==14){
                mp = MediaPlayer.create(context, R.raw.ninosjugandopaisaje);
            }
            else if(emoji==15){
                mp = MediaPlayer.create(context, R.raw.ninosjugando);
            }
            else if(emoji==16){
                mp = MediaPlayer.create(context, R.raw.ninosjugando2);
            }
            else if(emoji==17){
                mp = MediaPlayer.create(context, R.raw.ninosriendo2);
            }
            else if(emoji==18){
                mp = MediaPlayer.create(context, R.raw.ninosjugando3);
            }
            else if(emoji==19){
                mp = MediaPlayer.create(context, R.raw.ninosriendo4);
            }
            else if(emoji==20){
                mp = MediaPlayer.create(context, R.raw.pajaros2);
            }
            else if(emoji==21){
                mp = MediaPlayer.create(context, R.raw.toys);
            }
            else{
                mp = MediaPlayer.create(context, R.raw.pajaro3);
            }

        }

        if (mp == null) {
            Log.e(TAG, "player was not created successfully");
        } else {
            try {
                mp.setLooping(true);
                mp.start();
            } catch (Exception e) {
                Log.e(TAG, e.getMessage(), e);
            }
        }
    }

    public static void pause() {
        if (mp != null) {
            if (mp.isPlaying()) {
                mp.pause();
            }
        }

// previousMusic should always be something valid
        if (currentMusic != -1) {
            {
                previousMusic = currentMusic;
                Log.d(TAG, "Previous music was [" + previousMusic + "]");
            }
            currentMusic = -1;
            Log.d(TAG, "Current music is now [" + currentMusic + "]");
        }
    }

    public static void release() {
        Log.d(TAG, "Releasing media players");
        try {
            if (mp != null) {
                if (mp.isPlaying()) {
                    mp.stop();
                }
                mp.release();
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
        }

        if (currentMusic != -1) {
            previousMusic = currentMusic;
            Log.d(TAG, "Previous music was [" + previousMusic + "]");
        }
        currentMusic = -1;
        Log.d(TAG, "Current music is now [" + currentMusic + "]");
    }

    public void setvalor(Integer var1){
        this.emoji=var1;
    }
    public Integer getvalor(){
        return this.emoji;
    }
}
