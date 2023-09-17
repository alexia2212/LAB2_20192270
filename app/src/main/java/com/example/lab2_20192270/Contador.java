package com.example.lab2_20192270;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.lab2_20192270.databinding.ActivityContadorBinding;

public class Contador extends AppCompatActivity {


    private ActivityContadorBinding binding;
    int i = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContadorBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        binding.buttonIniciarContador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for(int i = 1; i<=10; i++){
                    binding.contadorVal.setText(String.valueOf(i));
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                }

            }
        });
    }
}