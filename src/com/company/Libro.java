package com.company;

import java.util.Scanner;

public class Libro {

    private String titulo;
    private double precio;
    private int stock;
    protected Autor autorLibro;

    public Libro(String titulo, double precio, int stock, Autor autorLibro) {
        this.titulo = titulo;
        this.precio = precio;
        this.stock = stock;
        this.autorLibro = autorLibro;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Autor getAutorLibro() {
        return autorLibro;
    }

    public void setAutorLibro(Autor autorLibro) {
        this.autorLibro = autorLibro;
    }

    public void mostrarLibro() {

        System.out.println("\nTitulo: " + titulo);
        System.out.println("Precio: " + precio);
        System.out.println("Stock: " + stock + " unidades");
        autorLibro.mostrarAutor();
    }

    public void aumentarPrecio(){
        double nuevoPrecio;
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nIngrese el nuevo precio: \t");
        nuevoPrecio=scanner.nextInt();

        this.precio=nuevoPrecio;
    }

    public void aumentarStock(){
        int nuevoStock;
        Scanner scanner= new Scanner(System.in);

        System.out.println("Ingrese la cantidad de libros en stock: \t");
        nuevoStock= scanner.nextInt();

        this.stock=nuevoStock;

    }

    public void leyendaLibro(){
        System.out.println("\nEl libro '" + titulo + "' de " + autorLibro.getNombre() + " " + autorLibro.getApellido() + ", se vende a $" + precio + ".");
    }

}
