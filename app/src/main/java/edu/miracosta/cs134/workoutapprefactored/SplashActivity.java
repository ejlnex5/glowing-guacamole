package edu.miracosta.cs134.workoutapprefactored;

import android.app.LauncherActivity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SplashActivity extends AppCompatActivity {
    private static final int SPLASH_DELAY = 5000;
    private ImageView img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        // Load the ImageView that will host the animation and
        // set its background to our AnimationDrawable XML resource.
        img = (ImageView)findViewById(R.id.armImageView);
        img.setBackgroundResource(R.drawable.arm_animation);
        // Get the background, which has been compiled to an AnimationDrawable object.
        AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();
        // Start the animation (looped playback by default).
        frameAnimation.start();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, Login.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_DELAY);
    }
}
