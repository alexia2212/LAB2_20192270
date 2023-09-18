package com.example.lab2_20192270;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
public class Cronometro extends AppCompatActivity {
    private Chronometer chronometer;
    private long pauseOffset;
    private boolean correr;
    private boolean cero = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronometro);
        Toast.makeText(this, "Current Activity: " + getClass().getSimpleName(), Toast.LENGTH_SHORT).show();
        chronometer = findViewById(R.id.cronometer);
        Button iniciar = findViewById(R.id.buttonIniciar);
        Button pausar = findViewById(R.id.buttonPausar);
        Button continuar = findViewById(R.id.buttonDespausar);
        Button limpiar = findViewById(R.id.buttonLimpiar);

        iniciar.setOnClickListener(view -> {
            if(!correr && cero){
                chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
                chronometer.start();
                correr = true;
                cero = false;
            }
        });

        pausar.setOnClickListener(view -> {
            if(correr && !cero){
                chronometer.stop();
                pauseOffset = SystemClock.elapsedRealtime()-chronometer.getBase();
                correr = false;
            }
        });

        continuar.setOnClickListener(view -> {
            if(!correr && !cero){
                chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
                chronometer.start();
                correr = true;
            }
        });

        limpiar.setOnClickListener(view -> {
            chronometer.setBase(SystemClock.elapsedRealtime());
            pauseOffset = 0;
            cero = true;
        });
    }
}