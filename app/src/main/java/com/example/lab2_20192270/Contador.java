package com.example.lab2_20192270;
import android.util.Log;
import androidx.work.Data;
import androidx.appcompat.app.AppCompatActivity;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.UUID;
public class Contador extends AppCompatActivity {
    private boolean start = true;
    UUID uuid = UUID.randomUUID();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador);
        Toast.makeText(this, "Current Activity: " + getClass().getSimpleName(), Toast.LENGTH_SHORT).show();

        Button button = findViewById(R.id.buttonIniciarContador);
        TextView textView = findViewById(R.id.contadorVal);

        String numStr = textView.getText().toString();

        int number = Integer.parseInt(numStr);
        button.setOnClickListener(view -> {
            if(start){
                start=false;
                Data dataBuilder = new Data.Builder()
                        .putInt("number", number)
                        .build();
                WorkRequest workRequest = new OneTimeWorkRequest.Builder(ContWorker.class)
                        .setId(uuid)
                        .setInputData(dataBuilder)
                        .build();
                WorkManager.getInstance(Contador.this.getApplicationContext())
                        .enqueue(workRequest);
            }else{

            }
        });
        WorkManager.getInstance(Contador.this.getApplicationContext())
                .getWorkInfoByIdLiveData(uuid)
                .observe(Contador.this, workInfo -> {
                    if(workInfo != null){
                        if(workInfo.getState() == WorkInfo.State.RUNNING){
                            Data progress = workInfo.getProgress();
                            int contador = progress.getInt("contador", 0);
                            Log.d("msg-test", "progress: " + contador);
                            textView.setText(String.format("%d", contador));
                        } else if (workInfo.getState() == WorkInfo.State.SUCCEEDED) {
                            Data outputData = workInfo.getOutputData();
                            String texto = outputData.getString("info");
                            assert texto != null;
                            Log.d("msg-test", texto);
                        }
                    }else{
                        Log.d("msg-test", "work info == null ");
                    }
                });
    }
    @Override
    protected void onResume() {
        super.onResume();
        TextView textView = findViewById(R.id.contadorVal);
        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String uuidString = preferences.getString("uuid", null);
        if (uuidString != null) {
            UUID storedUUID = UUID.fromString(uuidString);
            observe(textView,storedUUID);
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("uuid", uuid.toString()); // Store the UUID as a string
        editor.apply();
    }
    @Override
    public void onBackPressed() {
        finish();
    }
    private void observe(TextView textView, UUID uuid1){
        WorkManager.getInstance(Contador.this.getApplicationContext())
                .getWorkInfoByIdLiveData(uuid1)
                .observe(Contador.this, workInfo -> {
                    if(workInfo != null){
                        if(workInfo.getState() == WorkInfo.State.RUNNING){
                            Data progress = workInfo.getProgress();
                            int contador = progress.getInt("contador", 0);
                            Log.d("msg-test", "progress: " + contador);
                            textView.setText(String.format("%d", contador));
                        } else if (workInfo.getState() == WorkInfo.State.SUCCEEDED) {
                            Data outputData = workInfo.getOutputData();
                            String texto = outputData.getString("info");
                            assert texto != null;
                            Log.d("msg-test", texto);
                        }
                    }else{
                        Log.d("msg-test", "work info == null ");
                    }
                });
    }
}