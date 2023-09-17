package com.example.lab2_20192270;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab2_20192270.DTO.Persona;
import com.example.lab2_20192270.DTO.Result;
import com.example.lab2_20192270.databinding.ActivityCrearCuentaBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CrearCuenta extends AppCompatActivity {

    private EditText editTextNombre;
    private EditText editTextApellido;
    private EditText editTextCorreo;
    private EditText editTextContrasena;
    private Button buttonRegistrar;
    private CheckBox checkBox;
    Persona persona;


    private ActivityCrearCuentaBinding binding;

    TypicodeService typicodeService = new Retrofit.Builder()
            .baseUrl("https://randomuser.me")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TypicodeService.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCrearCuentaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        editTextNombre = findViewById(R.id.editTextName);
        editTextApellido = findViewById(R.id.editTextApellido);
        editTextCorreo = findViewById(R.id.editTextTextEmailAddress);
        editTextContrasena = findViewById(R.id.editTextTextPassword);
        checkBox = findViewById(R.id.checkBox);

        typicodeService.getResult().enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                persona = response.body().getResults().get(0);
                editTextNombre.setText(persona.getName().getFirst());
                editTextApellido.setText(persona.getName().getLast());
                editTextCorreo.setText(persona.getEmail());
                editTextContrasena.setText(persona.getLogin().getPassword());
            }
            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });
        binding.buttonCrear.setOnClickListener(view -> {
            Log.d("valida","botón presionado");
            Intent intent = new Intent(CrearCuenta.this, Dashboard.class);
            intent.putExtra("foto", persona.getPicture().getThumbnail());
            intent.putExtra("username", persona.getLogin().getUsername());
            intent.putExtra("name", persona.getName().getFirst());
            intent.putExtra("apellido", persona.getName().getLast());
            startActivity(intent);
        });
        editTextCorreo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!editTextApellido.getText().toString().isEmpty() &&
                        !editTextContrasena.getText().toString().isEmpty() &&
                        !editTextNombre.getText().toString().isEmpty() &&
                        !editTextCorreo.getText().toString().isEmpty() &&
                        checkBox.isChecked()
                ) {
                    Toast.makeText(CrearCuenta.this, "Terminos y condiciones aceptados", Toast.LENGTH_SHORT).show();
                    binding.buttonCrear.setEnabled(true);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) { }
        });
        editTextApellido.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!editTextApellido.getText().toString().isEmpty() &&
                        !editTextContrasena.getText().toString().isEmpty() &&
                        !editTextNombre.getText().toString().isEmpty() &&
                        !editTextCorreo.getText().toString().isEmpty() &&
                        checkBox.isChecked()
                ){
                    Toast.makeText(CrearCuenta.this, "Terminos y condiciones aceptados", Toast.LENGTH_SHORT).show();
                    binding.buttonCrear.setEnabled(true);

                }
            }
            @Override
            public void afterTextChanged(Editable editable) { }
        });
        editTextNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!editTextApellido.getText().toString().isEmpty() &&
                        !editTextContrasena.getText().toString().isEmpty() &&
                        !editTextNombre.getText().toString().isEmpty() &&
                        !editTextCorreo.getText().toString().isEmpty() &&
                        checkBox.isChecked()
                ){
                    Toast.makeText(CrearCuenta.this, "Terminos y condiciones aceptados", Toast.LENGTH_SHORT).show();
                    binding.buttonCrear.setEnabled(true);

                }
            }
            @Override
            public void afterTextChanged(Editable editable) { }
        });
        editTextContrasena.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!editTextApellido.getText().toString().isEmpty() &&
                        !editTextContrasena.getText().toString().isEmpty() &&
                        !editTextNombre.getText().toString().isEmpty() &&
                        !editTextCorreo.getText().toString().isEmpty() &&
                        checkBox.isChecked()
                ){
                    Toast.makeText(CrearCuenta.this, "Terminos y condiciones aceptados", Toast.LENGTH_SHORT).show();
                    binding.buttonCrear.setEnabled(true);

                }
            }
            @Override
            public void afterTextChanged(Editable editable) { }
        });
        if (checkBox.isChecked()){
            if (!editTextApellido.getText().toString().isEmpty() &&
                    !editTextContrasena.getText().toString().isEmpty() &&
                    !editTextNombre.getText().toString().isEmpty() &&
                    !editTextCorreo.getText().toString().isEmpty()
            ){
                Toast.makeText(CrearCuenta.this, "Terminos y condiciones aceptados", Toast.LENGTH_SHORT).show();
                binding.buttonCrear.setEnabled(true);

            }
        }
    }
}