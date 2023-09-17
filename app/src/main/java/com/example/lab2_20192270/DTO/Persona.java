package com.example.lab2_20192270.DTO;

import com.example.lab2_20192270.DTO.ImagenPerfil;
import com.example.lab2_20192270.DTO.Login;
import com.example.lab2_20192270.DTO.Nombre;

public class Persona {
    private Nombre name;
    private String email;
    private Login login;
    private ImagenPerfil picture;

    public Nombre getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Login getLogin() {
        return login;
    }

    public ImagenPerfil getPicture() {
        return picture;
    }
}
