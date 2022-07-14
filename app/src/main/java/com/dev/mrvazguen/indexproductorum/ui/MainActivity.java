package com.dev.mrvazguen.indexproductorum.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.dev.mrvazguen.indexproductorum.R;
import com.dev.mrvazguen.indexproductorum.ui.fragment.autentification.LoginFragment;

public class MainActivity extends AppCompatActivity
{
    private static final int SPLASH_TIME_OUT = 3300;
    Animation topAnim, bottomAnim;
    ImageView imageView;
    Button textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("Activity", "Main Activity");

        topAnim    = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        imageView  = findViewById(R.id.imageView);
        textView   = findViewById(R.id.btnEntrar);

        imageView.setAnimation(topAnim);
        textView.setAnimation(bottomAnim);

        new Handler().postDelayed(() -> {
            startActivity(new Intent(MainActivity.this, LoginFragment.class));
            finish();
        }, SPLASH_TIME_OUT);

        //TODO: Comprobar si no existe el database crear nuevo y anadir los datos de usuarios
    }
}