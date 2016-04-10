package com.aspsine.fontmanager.demo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;


public class SplashActivity extends AppCompatActivity {
    /**
     * 2 seconds
     */
    private static final int SPLASH_TIME = 2 * 1000;

    private Handler mHandler = new Handler(Looper.getMainLooper());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        loadFonts();
    }

    private void loadFonts() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                FontsUtils.init(getApplicationContext());
                long useTime = System.currentTimeMillis() - start;

                final long delta = SPLASH_TIME - useTime;
                Log.i("Tag", delta+"");
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(SplashActivity.this, "Load font cost " + delta +" ms", Toast.LENGTH_SHORT).show();
                        intentToMain();
                    }
                }, delta);
            }
        }).start();
    }

    private void intentToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
