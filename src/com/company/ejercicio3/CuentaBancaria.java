package com.company.ejercicio3;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;
import java.util.UUID;

public class CuentaBancaria {

    private UUID idCuenta;
    private ClienteBanco cliente;
    private double balance;
    private double saldoDeudor;
    private String[] movimientosCuenta;
    private int validosMovimientos;

    public CuentaBancaria(ClienteBanco unCliente, double depositoInicial){
        this.idCuenta=UUID.randomUUID();
        this.cliente=unCliente;
        this.balance=depositoInicial;
        this.saldoDeudor=2000;
        this.movimientosCuenta=new String[10];
        this.validosMovimientos=0;
    }

    public void setCliente(ClienteBanco unCliente){
        this.cliente=unCliente;
    }
    public ClienteBanco getCliente(){
        return cliente;
    }

    public void setBalance(double montoBalance){
        this.balance=montoBalance;
    }
    public double getBalance(){
        return balance;
    }

    public void setSaldoDeudor (double nuevoSaldoDeudor){
        this.saldoDeudor=nuevoSaldoDeudor;
    }
    public double getSaldoDeudor(){
        return saldoDeudor;
    }

    public String[] getMovimientosCuenta() {
        return movimientosCuenta;
    }

    public void setMovimientosCuenta(String[] movimientosCuenta) {
        this.movimientosCuenta = movimientosCuenta;
    }

    public int getValidosMovimientos() {
        return validosMovimientos;
    }

    public void setValidosMovimientos(int validosMovimientos) {
        this.validosMovimientos = validosMovimientos;
    }

    public void mostrarCuenta(){
        System.out.println("\nNumero de Cuenta: " + idCuenta);
        System.out.println("Balance de Cuenta: " + balance);
        System.out.println("Saldo deudor: " + saldoDeudor);
        cliente.mostrarCliente();
    }

    public void depositoEnCuenta (double deposito){
        double dineroDisponible;

        if (saldoDeudor<2000){  //SI HA UTILIZADO EL SALDO DEUDOR
            double saldoAdeudado = 2000-saldoDeudor;    //SETEA LA PLATA QUE DEBE EL CLIENTE AL BANCO
            dineroDisponible= balance + (deposito-saldoAdeudado);   //SUMA AL BALANCE EL DEPOSITO MENOS LA DEUDA QUE PROVOCO USAR EL SALDO DEUDOR
            if (dineroDisponible<0){    //ESTOQ QUIERE DECIR QUE EL CLIENTE DEPOSITO MENOS QUE LA DEUDA DEL SALDO DEUDOR (SALDO DEUDOR 500$, DEPOSITO DE $100)
                setSaldoDeudor(2000+dineroDisponible);  //LE SUMA EL DEPOSITO AL SALDO DEUDOR
                setBalance(0);  //EL CLIENTE NO TERMINO DE PAGAR EL SALDO ADEUDADO
            }else{
                setSaldoDeudor(2000);   //SI EL DEPOSITO ES MAYOR AL SALDO ADEUDADO, EL SALDO DEUDOR DISPONIBLE SE REINICIA
                setBalance(dineroDisponible);   //SETEA EL BALANCE NUEVO
            }
        }else{
            dineroDisponible = balance+deposito;    //SI NO UTILIZO EL SALDO DEUDOR, DIRECTAMENTE SUMA EL DEPOSITO AL BALANCE
            setBalance(dineroDisponible);
        }

        cargarArregloDeposito(cliente, deposito);
    }

    public void extraccionDeCuenta (double extraccion){
        if (balance<extraccion){    //EN ESTE CASO SI EL MONTO QUE SE QUIERE EXTRAER ES MAYOR QUE EL QUE TIENE DISPONIBLE EN LA CUENTA
            if ((balance+saldoDeudor)<extraccion || saldoDeudor==0){ //SE FIJA SI TIENE SALDO DEUDOR DISPONIBLE PARA HACER LA EXTRACCION
                System.out.println("\nNo es posible hacer la extraccion por falta de fondos.");
            }else{  //SI PUEDE USAR EL SALDO DEUDOR
                double prestamoExtraccion=balance-extraccion;   //CANTIDAD DE SALDO DEUDOR UTILIZADO
                setSaldoDeudor(saldoDeudor+prestamoExtraccion); //CANTIDAD DE SALDO DEUDOR DISPONIBLE DESPUES DE LA EXTRACCION
                setBalance(0);  //COMO USO SU BALANCE+SALDO DEUDOR EL BALANCE DE CUENTA ES IGUAL A CERO
            }
        }else{
            double dineroDisponible = balance - extraccion; //SI NO ES NECESARIO EL SALDO DEUDOR O ES MENOR LA CANTIDAD EXTRAIDA A LA DISPONIBLE DIRECTAMENTE RESTO LA EXTRACCION DEL BALANCE
            setBalance(dineroDisponible); //SETEO EL BALANCE CON LA CANTIDAD DE DINERO QUE HAYA QUEDADO DESPUES DE LA EXTRACCION
        }

        cargarArregloExtraccion(cliente, extraccion);
    }

    public void cargarArregloDeposito(@NotNull ClienteBanco cliente, double monto){
        int posMovimiento=getValidosMovimientos();

        if (posMovimiento==10) {
            moverString();
            posMovimiento--;
            movimientosCuenta[posMovimiento] = "El cliente " + cliente.getNombre() + ", deposito $" + monto;
        }else{
            movimientosCuenta[posMovimiento] = "El cliente " + cliente.getNombre() + ", deposito $" + monto;
            setValidosMovimientos(posMovimiento + 1);
        }
    }

    public void cargarArregloExtraccion(@NotNull ClienteBanco cliente, double monto) {
        int posMovimiento = getValidosMovimientos();

        if (posMovimiento == 10) { //EN CASO DE QUE EL ARREGLO ESTE LLENO
            moverString();          // MUEVO EL STRING UNA POSICION PARA ATRAS BORRANDO EL STRING GUARDADO EN POS=0
            posMovimiento--;        // VUELVO UN LUGAR PARA ATRAS PARA SETEARME EN LA ULTIMA POSICION DEL ARREGLO
            movimientosCuenta[posMovimiento] = "El cliente " + cliente.getNombre() + ", extrajo $" + monto; //GUARDO EL NUEVO MOVIMIENTO
        } else {    // SI EL ARREGLO NO ESTA LLENO
            movimientosCuenta[posMovimiento] = "El cliente " + cliente.getNombre() + ", extrajo $" + monto; //CARGO EN LA POSICION QUE ESTOY PARADO
            setValidosMovimientos(posMovimiento + 1);   //MUEVO UN ESPACIO PARA QUE LA PROXIMA QUE TENGA QUE CARGAR YA ESTE PARADO EN DONDE DEBE

        }
    }

    public void mostrarMovimientos(){
        int movimientosValidos=getValidosMovimientos();
        System.out.println("");
        for(int i=0; i<movimientosValidos;i++){
            System.out.println(movimientosCuenta[i]);
        }
    }

    public void moverString(){
        for (int pos=0; pos<9; pos++){
            movimientosCuenta[pos]=movimientosCuenta[pos+1];    //SI EL STRING ESTA LLENO MUEVO LA INFORMACION UN ESPACIO PARA ATRAS PARA DEJAR UN ESPACIO LIBRE Y SIEMPRE ME MUESTRE LOS ULTIMOS 10 MOVIMIENTOS
        }

    }

    /*hecho para sacarme el aburrimiento*/
    public void subprogramaCajeroAutomatico(){
        char control='s';
        char opcion;
        double monto;
        Scanner scanOpcion= new Scanner(System.in);
        Scanner scanMonto= new Scanner(System.in);

        while (control=='s' || control=='S') {
            System.out.println("Ingrese E para extraccion, D para deposito");
            opcion=scanOpcion.next().charAt(0);
            if (opcion == 'E' || opcion == 'e') {
                System.out.println("Ingrese el monto que quiere extraer:");
                monto=scanMonto.nextDouble();
                extraccionDeCuenta(monto);
                control=devuelveControl();
            } else if (opcion == 'D' || opcion == 'd') {
                System.out.println("Ingrese el monto que quiere depositar:");
                monto=scanMonto.nextDouble();
                depositoEnCuenta(monto);
                control=devuelveControl();
            } else {
                System.out.println("Ingrese una opcion correcta (E o D)");
            }
        }
    }

    public char devuelveControl(){
        Scanner scanControl=new Scanner(System.in);
        char control;

        System.out.println("Quiere hacer otra operatoria? S/N");
        control= scanControl.next().charAt(0);
        return control;

    }
}
