package com.example.testemoji;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

public class nose1 {
    static final int MUSIC_PREVIOUS = -1;
    private static final String TAG = "MusicManager";
    static MediaPlayer mp;
    private static int perro;
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
            if (perro == 1) {
                mp = MediaPlayer.create(context, R.raw.perro); //Ur BackGround Music
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
        this.perro=var1;
    }
    public Integer getvalor(){
        return this.perro;
    }

}
