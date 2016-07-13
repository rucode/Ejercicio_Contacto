package com.rubach.ejercicio_contactos;

/**
 * Created by Ronald on 12/07/16.
 */
public class Contacto {

    private String nombre;
    private String telefono;
    private String email;
    private String FechaNacimiento;
    private String Comentario;

    public Contacto(String nombre, String telefono, String email, String fechaNacimiento, String comentario) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        FechaNacimiento = fechaNacimiento;
        Comentario = comentario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String comentario) {
        Comentario = comentario;
    }
}