package com.example.lab2_20192270;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.lab2_20192270.databinding.ActivityDashboardBinding;

public class Dashboard extends AppCompatActivity {
    private ActivityDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String nombre = intent.getStringExtra("name");
        String apellidos = intent.getStringExtra("apellido");
        String foto = intent.getStringExtra("foto");

        setContentView(binding.getRoot());
        binding.buttonContador.setOnClickListener(view -> {
            Intent intent1 = new Intent(Dashboard.this, Contador.class);
            startActivity(intent1);
        });

        binding.buttonCronometro.setOnClickListener(view -> {
            Intent intent2 = new Intent(Dashboard.this, Cronometro.class);
            startActivity(intent2);
        });


        Glide.with(this).load(foto).into(binding.imageView7);
        binding.textPerfilNombre.setText(nombre);
        binding.textPerfilApellido.setText(apellidos);
        binding.textUsername.setText(username);

    }
}