package com.example.a21724343.noplanetb_t2_raul;

import android.content.Intent;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

public class BLogin extends AppCompatActivity {
    private ProgressBar progressBar;
    private TextInputEditText etxNombre;
    private TextInputEditText etxPassword;
    private static final String USER_NAME = "ordasraul@gmail.com";
    private static final String PASSWORD = "1234";
    private Drawable backgroundBN;
    private ImageView background;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blogin);

        //Metodo para convertir a blanco y negro, hay que hacer copia de la foto
        /*
        backgroundBN = getDrawable(R.drawable.planetearth);
        Drawable res = convertToGrayscale(backgroundBN);
        background = findViewById(R.id.backgroundBN);
        background.setImageDrawable(res);
         */

        //Inicializamos los atributos de la clase
        progressBar = findViewById(R.id.progressBar);
        etxNombre = findViewById(R.id.etxName);
        etxPassword = findViewById(R.id.etxPassword);

        //Hacemos el progress bar invisible al comienzo
        progressBar.setVisibility(View.GONE);
    }

    //Metodo para hacer sign in
    public void signIn(View view) {

        //Si los campos estan vacios mostramos un mensaje
        if (checkEmptyFields(etxNombre) || checkEmptyFields(etxPassword)) {
            progressBar.setVisibility(View.VISIBLE);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    progressBar.setVisibility(View.GONE);
                    startActivity(new Intent(BLogin.this, BMain.class));
                }
            }, 3000);

            //Sino comprobamos si el usuario y el password son correctos
        } else {

            //Si los datos son correctos vamos al siguiente activity
            if (etxNombre.getText().toString().equals(USER_NAME) && etxPassword.getText().toString().equals(PASSWORD)) {
                progressBar.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.GONE);
                        startActivity(new Intent(BLogin.this, BMain.class));
                    }
                }, 3000);


                //Sino son correctos mostramos un error
            } else {
                mostrarSnackBar(getString(R.string.DATOS_INCORRECTOS));
            }
        }
    }

    //Metodo que devueve un booleano tras comprobar si el campo esta vacio
    public boolean checkEmptyFields(TextInputEditText etx) {
        if (etx.getText().toString().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public void mostrarSnackBar(String mensaje){
        final RelativeLayout mrelativeLayout = (RelativeLayout) findViewById(R.id.layoutLogin);
        Snackbar snackbar = Snackbar
                .make(mrelativeLayout, mensaje, Snackbar.LENGTH_LONG);

        snackbar.show();
    }

    public Drawable convertToGrayscale(Drawable drawable) {
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);

        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);

        drawable.setColorFilter(filter);

        return drawable;
    }
}
