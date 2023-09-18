package com.example.lab2_20192270;

import android.content.Context;
import android.os.Vibrator;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;


public class Contador extends Worker {

    private int contador = 104;
    private boolean aumentar = true;
    public Contador(Context context, WorkerParameters parameters){
        super(context, parameters);
    }
    @NonNull
    @Override
    public Result doWork() {
        if (aumentar) {
            // Contar hacia arriba desde 104 hasta 226
            while (contador <= 226) {
                Log.d("msg-test", "contador: " + contador);
                contador++;
                try {
                    Thread.sleep(10000); // Aumentar cada 10 segundos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return Result.failure();
                }
            }
        } else {
            // Contar hacia abajo desde 226 hasta 104
            while (contador >= 104) {
                Log.d("msg-test", "contador: " + contador);
                contador--;
                try {
                    Thread.sleep(10000); // Disminuir cada 10 segundos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return Result.failure();
                }
            }
        }

        // Vibrar cuando termine la cuenta
        if (contador == 227) {
            Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
            if (vibrator != null) {
                vibrator.vibrate(1000); // Vibración de 1 segundo
            }
        }

        return Result.success();
    }

}