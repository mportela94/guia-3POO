package com.company;

import com.company.ejercicio3.ClienteBanco;
import com.company.ejercicio3.CuentaBancaria;

public class Main {

    public static void main(String[] args) {

        /*ejercicio1();

        ejercicio2();
        */
        ejercicio3();


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

        LibroConArregloAutor otroLibro = new com.company.LibroConArregloAutor("Effective Java", 450, 150, arregloAutores);
        otroLibro.leyendaLibro(posAutor);

    }

    public static void ejercicio2(){
            /*2.
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

        /*1.B*/
        ClienteFactura unClienteFactura =new ClienteFactura("Juan Arias", "jarias@gmail.com", 10);
        unClienteFactura.mostrarCliente();

        /*1.C*/
        Factura unaFactura=new Factura(1000, unClienteFactura);
        double importe=unaFactura.getMontoTotal();

        System.out.println("\nMonto Total: " + importe);
        System.out.println("\nMonto Final con Descuento: " + unaFactura.aplicarDescuento(importe));

        /*1.D*/
        unaFactura.imprimirFactura();


    }

    public static void ejercicio3(){
        /*3. Necesitamos crear un programa para manejar los datos de una Cuenta bancaria de
            un Cliente. Para esto identificamos los atributos id, nombre y género (M o F) para el
            Cliente. Por otro lado tenemos el tipo Cuenta que también posee un identificador,
            un balance y un Cliente que es el dueño de la cuenta. La Cuenta debe exponer los
            métodos depositar y extraer que modifican el balance de la misma. Algo a tener en
            cuenta es que el método extraer no puede extraer dinero si el balance total no lo
            permite, si esto sucede se debe imprimir un mensaje por pantalla que indique que
            la cuenta no posee saldo suficiente.
                    a. Crear un Cliente e imprimirlo en pantalla.
                    b. Crear una Cuenta bancaria para el Cliente anterior con un saldo inicial de
                    10000.
                    c. Realizar operaciones de depósito y extracción para probar esa
                    funcionalidad.
                    d. Es necesario agregar una variante de Cuenta que permita un saldo deudor,
                    de máximo 2000 pesos. Esto significa que la cuenta puede aceptar un
                    balance negativo con un máximo de - 2000. Realice los cambios y pruebas
                    necesarias.
                    e. Analice cómo implementaría con las herramientas conocidas hasta el
                    momento, llevar un registro de como máximo 10 operaciones de depósito y
                    extracción que se realizaron en la cuenta. En donde se almacene en
                    memoria de alguna forma la siguiente cadena de texto:
                        i. Depósito: "El {NombreCliente}, depositó {MontoDepositado}"
                        ii. Extracción: "El {NombreCliente}, retiró {MontoRetirado}"*/

        /*1.A*/
        ClienteBanco nuevoCliente = new ClienteBanco("Matias Portela", 'M');
        nuevoCliente.mostrarCliente();

        /*1.B*/
        CuentaBancaria nuevaCuenta = new CuentaBancaria(nuevoCliente, 10000);
        nuevaCuenta.mostrarCuenta();

        /*1.C*/

        nuevaCuenta.depositoEnCuenta(5000);
        System.out.println("\nCuenta despues de un deposito:");
        nuevaCuenta.mostrarCuenta();

        nuevaCuenta.extraccionDeCuenta(3000);
        System.out.println("\nCuenta despues de una extraccion:");
        nuevaCuenta.mostrarCuenta();

        /*1.D*/

        nuevaCuenta.extraccionDeCuenta(13000);
        System.out.println("\nCuenta despues de una extraccion:");
        nuevaCuenta.mostrarCuenta();

        nuevaCuenta.extraccionDeCuenta(1000);
        System.out.println("\nCuenta despues de otra extraccion:");
        nuevaCuenta.mostrarCuenta();

        nuevaCuenta.depositoEnCuenta(3000);
        System.out.println("\nCuenta despues de otro deposito:");
        nuevaCuenta.mostrarCuenta();

        /*1.E*/
        nuevaCuenta.mostrarMovimientos();

    }
}
