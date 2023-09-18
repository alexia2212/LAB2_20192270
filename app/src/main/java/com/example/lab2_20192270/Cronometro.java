package com.example.lab2_20192270;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
public class Cronometro extends AppCompatActivity {
    private TextView textViewCronometro;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCronometro = findViewById(R.id.textNumeroContando);

        Button buttonIniciar = findViewById(R.id.buttonIniciar);
        Button buttonPausar = findViewById(R.id.buttonPausar);
        Button buttonDespausar = findViewById(R.id.buttonDespausar);
        Button buttonDetener = findViewById(R.id.buttonDetener);
        Button buttonLimpiar = findViewById(R.id.buttonLimpiar);

        buttonIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarCronometro();
            }
        });

        buttonPausar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pausarCronometro();
            }
        });

        buttonDespausar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                despausarCronometro();
            }
        });

        buttonDetener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detenerCronometro();
            }
        });

        buttonLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiarCronometro();
            }
        });

        private void iniciarCronometro() {
            // Implement the logic to start the chronometer here
        }

        private void pausarCronometro() {
            // Implement the logic to pause the chronometer here
        }

        private void despausarCronometro() {
            // Implement the logic to resume the chronometer here
        }

        private void detenerCronometro() {
            // Implement the logic to stop the chronometer here
        }

        private void limpiarCronometro() {
            // Implement the logic to reset the chronometer here
        }

    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        return false;
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


}