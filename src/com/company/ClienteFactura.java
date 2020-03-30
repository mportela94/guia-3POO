package com.company;

import java.util.UUID;

public class ClienteFactura {

   /*     Nos contratan para hacer un programa que lleve el control de las ventas de un
        local. Para esto es necesario modelar la clase Cliente, que posee un atributo id
        como identificador del cliente, el mismo debe ser un valor compuesto por letras y
        números aleatorios que se generan automáticamente al crear un Cliente. El Cliente
        también posee un nombre, un email y un porcentaje de descuento.*/

    private UUID idCliente=UUID.randomUUID();
    private String nombre;
    private String email;
    protected int descuento;

    public ClienteFactura(String nombre, String email, int descuento){
        this.nombre=nombre;
        this.email=email;
        this.descuento=descuento;
    }

    public UUID getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public void mostrarCliente(){
        System.out.println("ID Cliente: " + idCliente);
        System.out.println("Nombre: " + nombre);
        System.out.println("Email: " + email);
        System.out.println("Descuento: " + descuento + "%");
    }



}
