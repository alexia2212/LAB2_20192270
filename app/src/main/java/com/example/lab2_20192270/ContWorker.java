package com.example.lab2_20192270;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class ContWorker extends Worker {
    public ContWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }
    @NonNull
    @Override

    public Result doWork() {
        int cont = getInputData().getInt("number",0);
        int contadorFinal = cont + 122;

        while (cont <= contadorFinal) {
            Log.d("msg-test", "contador: " + cont);
            setProgressAsync(new Data.Builder().putInt("contador",cont).build());
            cont++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return Result.failure();
            }
        }
        Data data = new Data.Builder()
                .putString("info","Worker ha finalizado")
                .build();
        return Result.success(data);
    }
}
