package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ejercicio1();



    }

    public static void ejercicio1(){
        /*1. Es necesario modelar el objeto de tipo Libro con las siguientes caracteristicas, titulo,
            precio, stock y Autor, este último posee las características de nombre, apellido,
            email y genero ( ‘M’ o ‘F’ ). Para este ejercicio vamos a asumir que un libro tiene un
            único autor. Ejecute las siguientes instrucciones:
                    a. Inicialice un objeto de tipo Autor, “Joshua”, “Bloch”, “joshua@email.com”, ’M’.
                    b. Imprima por pantalla al autor previamente instanciado.
                    c. Inicialice el libro “Effective Java” del Autor “Joshua Bloch” que cuesta 450
                    pesos con una cantidad de 150 copias.
                    d. Imprima por pantalla el libro instanciado.
                    e. Modifique el precio del libro “Effective Java” a 500 pesos y aumente la
                    cantidad en 50 copias.
                    f. Imprima por pantalla los atributos del Autor Joshua, accediendo desde el
                    Libro “Effective Java”.
                    g. Agregue un método a la clase Libro que posibilite imprimir en pantalla el
                    siguiente mensaje:
                    “El libro, {título} de {nombre del autor}. Se vende a {precio} pesos.”
                    h. Modificar la clase Libro, para que acepte más de 1 Autor. Y realizar los
                    cambios necesarios en el método del punto g, para imprimir un nuevo
                    mensaje que liste los autores que contribuyeron a ese libro.*/

        /*1.A*/
        Autor primerAutor=new Autor("Joshua", "Bloch", "joshua@email.com", 'M');
        /*1.B*/
        primerAutor.mostrarAutor();
        /*1.C*/
        Libro primerLibro = new Libro("Effective Java", 450, 150, primerAutor);
        /*1.D*/
        primerLibro.mostrarLibro();
        /*1.E*/
        primerLibro.aumentarPrecio();
        primerLibro.aumentarStock();

        primerLibro.mostrarLibro();

        /*1.F*/
        primerLibro.autorLibro.mostrarAutor();
        /*1.G*/
        primerLibro.leyendaLibro();

        /*1.H*/
        /*Autor segundoAutor=new Autor("Matias", "Portela", "matiasportela@email.com", 'M');*/


    }
}
