package com.company.ejercicio3;

import org.jetbrains.annotations.NotNull;

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

        if (saldoDeudor<2000){
            double saldoAdeudado = 2000-saldoDeudor;
            dineroDisponible= balance + (deposito-saldoAdeudado);
            if (dineroDisponible<0){
                setSaldoDeudor(2000+dineroDisponible);
                setBalance(0);
            }else{
                setSaldoDeudor(2000);
                setBalance(dineroDisponible);
            }
        }else{
            dineroDisponible = balance+deposito;
            setBalance(dineroDisponible);
        }

        cargarArregloDeposito(cliente, deposito);
    }

    public void extraccionDeCuenta (double extraccion){
        if (balance<extraccion){
            if ((balance+saldoDeudor)<extraccion || saldoDeudor==0){
                System.out.println("\nNo es posible hacer la extraccion por falta de fondos.");
            }else{
                double prestamoExtraccion=balance-extraccion;
                setSaldoDeudor(saldoDeudor+prestamoExtraccion);
                setBalance(0);
            }
        }else{
            double dineroDisponible = balance - extraccion;
            setBalance(dineroDisponible);
        }

        cargarArregloExtraccion(cliente, extraccion);
    }

    public void cargarArregloDeposito(@NotNull ClienteBanco cliente, double monto){
        int posMovimiento=getValidosMovimientos();

        movimientosCuenta[posMovimiento]="El cliente " + cliente.getNombre() + ", deposito $" + monto;
        setValidosMovimientos(posMovimiento+1);
    }

    public void cargarArregloExtraccion(@NotNull ClienteBanco cliente, double monto){
        int posMovimiento=getValidosMovimientos();

        movimientosCuenta[posMovimiento]="El cliente " + cliente.getNombre() + ", extrajo $" + monto;
        setValidosMovimientos(posMovimiento+1);
    }

    public void mostrarMovimientos(){
        int movimientosValidos=getValidosMovimientos();
        System.out.println("");
        for(int i=0; i<movimientosValidos;i++){
            System.out.println(movimientosCuenta[i]);
        }
    }


}
