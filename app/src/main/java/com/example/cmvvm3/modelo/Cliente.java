package com.example.cmvvm3.modelo;

public class Cliente {
    private long dni;
    private String apellido;
    private String nombre;
    private String domicilio;

    public Cliente(long dni, String apellido, String nombre, String domicilio) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.domicilio = domicilio;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
}
