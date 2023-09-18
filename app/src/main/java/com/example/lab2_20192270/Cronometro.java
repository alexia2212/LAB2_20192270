package com.example.lab2_20192270;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Worker;
import androidx.work.WorkerParameters;


public class Cronometro extends Worker {
    public Cronometro(Context context, WorkerParameters parameters){
        super(context, parameters);
    }

    @NonNull
    @Override
    public Result doWork(){
        int contador = 1;
        while (contador <= 10){
            Log.d("msg-test", "contador: "+ contador);
            contador++;
            try{
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
                return Result.failure();
            }
        }
        return Result.success();
    }


}