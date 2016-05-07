package com.arubaapps.idiomas;

/**
 * Created by Antonio_2 on 07/05/2016.
 */
public class Usuario {
    String nombre;
    String mail;
    Integer id;

    public Usuario ()
    {
    }

    public Usuario(Integer id, String mail, String nombre) {
        this.id = id;
        this.mail = mail;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
