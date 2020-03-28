
package com.company;

import java.util.Scanner;

public class LibroConArregloAutor {

    private String titulo;
    private double precio;
    private int stock;
    protected Autor[] autoresLibro;

    public LibroConArregloAutor(String titulo, double precio, int stock, Autor[] arregloAutores) {
        this.titulo = titulo;
        this.precio = precio;
        this.stock = stock;
        this.autoresLibro = arregloAutores;
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

    public Autor[] getAutoresLibro() {
        return autoresLibro;
    }

    public void setAutoresLibro(Autor[] autoresLibro) {
        this.autoresLibro = autoresLibro;
    }

    public void mostrarLibro(Autor[] arregloAutores, int cantidadAutores) {

        System.out.println("\nTitulo: " + titulo);
        System.out.println("Precio: " + precio);
        System.out.println("Stock: " + stock + " unidades");
        for (int posAutor=0; posAutor<cantidadAutores; posAutor++) {
            autoresLibro[posAutor].mostrarAutor();
        }
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

    public void leyendaLibro(int validosAutores){

        System.out.print("\nEl libro '" + titulo + "' de ");

        for (int posAutor=0; posAutor<validosAutores; posAutor++) {
            System.out.print(autoresLibro[posAutor].getNombre() + " " + autoresLibro[posAutor].getApellido());

            if (autoresLibro[posAutor + 1]!=null){
                System.out.print(", y de ");
            }
        }

        System.out.print("se vende a $" + precio + ".\n");
    }

}
