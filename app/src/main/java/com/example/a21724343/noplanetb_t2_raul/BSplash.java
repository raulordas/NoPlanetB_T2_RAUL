package com.example.a21724343.noplanetb_t2_raul;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mikhaellopez.circularimageview.CircularImageView;

public class BSplash extends AppCompatActivity {
    private CircularImageView imageRocket;
    private ImageView backgroundSplash;
    private TextView tvNombre;
    private TextView tvSlogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bsplash);

        //Inicializamos el Circular Image View y aplicamos la animacion
        imageRocket = findViewById(R.id.imgLogo);
        Animation animRocket = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        imageRocket.startAnimation(animRocket);

        //Inicializamos el background y aplicamos la animacion
        backgroundSplash = findViewById(R.id.backgroundSplash);

        //Cargamos el drawable utilizando glide
        Glide.with(this).load(R.drawable.planetearth).into(backgroundSplash);

        //Realizamos la animacion para el background
        Animation animBackground = AnimationUtils.loadAnimation(this, R.anim.anim_slow_rotation);
        backgroundSplash.startAnimation(animBackground);

        //Inicializamos el nombre de la app y aplicamos la animacion
        tvNombre = findViewById(R.id.tvNombre);
        Animation animNombre = AnimationUtils.loadAnimation(this, R.anim.anim_left_to_right);
        tvNombre.startAnimation(animNombre);

        //Inicializamos el slogan y aplicamos la animacion
        tvSlogan = findViewById(R.id.tvSlogan);
        Animation animSlogan = AnimationUtils.loadAnimation(this, R.anim.anim_right_to_left);
        tvSlogan.startAnimation(animSlogan);

        //Metodo que lanza el nuevo activity con retardo de 6 segundos
        launchLoginActivity();
    }

    public void launchLoginActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(BSplash.this, BLogin.class));
            }
        }, 4000);
    }
}
