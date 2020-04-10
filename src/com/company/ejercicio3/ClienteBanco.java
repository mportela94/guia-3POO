package com.company.ejercicio3;

import java.util.UUID;

public class ClienteBanco {

    private UUID idCliente = UUID.randomUUID();
    private String nombre;
    private char genero;

    public ClienteBanco(String nombreUsuario, char generoUsuario){
        this.nombre=nombreUsuario;
        this.genero=generoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public void mostrarCliente(){
        System.out.println("ID Cliente: " + idCliente);
        System.out.println("Nombre y Apellido: " + nombre);
        System.out.println("Genero: " + genero);
    }

    @Override
    public String toString() {
        return "\n idCliente=" + idCliente +
                "\n, nombre='" + nombre + '\'' +
                "\n, genero=" + genero +
                '\n';
    }
}
