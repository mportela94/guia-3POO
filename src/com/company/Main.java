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
        int posAutor=0;
        int cantAutores=3;
        Autor[] arregloAutores= new Autor[cantAutores];

        arregloAutores[posAutor]=primerAutor;
        posAutor++;

        Autor segundoAutor=new Autor("Maria", "Juana", "maryjane@email.com", 'F');
        arregloAutores[posAutor]=segundoAutor;
        posAutor++;

        LibroConArregloAutor otroLibro = new LibroConArregloAutor("Effective Java", 450, 150, arregloAutores);
        otroLibro.leyendaLibro(posAutor);

    }

    public static void ejercicio2(){
        /*2.    Nos contratan para hacer un programa que lleve el control de las ventas de un
            local. Para esto es necesario modelar la clase Cliente, que posee un atributo id
            como identificador del cliente, el mismo debe ser un valor compuesto por letras y
            números aleatorios que se generan automáticamente al crear un Cliente. El Cliente
            también posee un nombre, un email y un porcentaje de descuento.
                Por otro lado vamos a tener el objeto Factura que representa una venta del
            local, cada Factura posee un identificador de las mismas características que el
            usado en Cliente. A su vez cada factura posee un monto total, una fecha y el Cliente
            que generó la compra. Para la fecha de la venta se le va a asignar la fecha y hora al
            momento de creación del objeto Factura. El tipo Factura debe contar con un
            método que calcule el monto final luego de aplicarle el descuento que posee el
            cliente.
                    a. Investigue la clase UUID y sus métodos estáticos para la generación de los
                    ids. Investigue la clase LocalDate y sus métodos estáticos para la generación
                    de la fecha.
                    b. Cree un objeto de tipo Cliente, imprima sus detalles por pantalla. Para esto
                    haga uso de un método que facilite la impresión del mismo.
                    Cliente[id=?, nombre=?, email=?, descuento=?]
                    c. Cree un objeto de tipo Factura que posea al Cliente anteriormente creado.
                    Una vez hecho esto, imprima por pantalla el monto total de esta Factura y el
                    monto total luego de aplicarle el descuento.
                    d. Cree un método que facilite la impresión del objeto de tipo Factura y que
                    siga el siguiente formato.
                    Factura[id=?, fecha=?, monto=?, montoDesc=?, Cliente[id=?, nombre=?,
                    email=?, descuento=?]]
                    e. Analizar de agregar el tipo ItemVenta, que representa un producto que
                    forma parte de la venta. El mismo contiene un id, un nombre, descripción y
                    precio unitario. Considere las modificaciones necesarias en el tipo Factura
                    para que el mismo pueda almacenar múltiples Ítems de venta y a su vez
                    calcular los montos totales con y sin el descuento aplicado.*/
    }
}
