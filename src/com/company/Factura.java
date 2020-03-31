package com.company;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public class Factura {

    /*Por otro lado vamos a tener el objeto Factura que representa una venta del
    local, cada Factura posee un identificador de las mismas características que el
    usado en Cliente. A su vez cada factura posee un monto total, una fecha y el Cliente
    que generó la compra. Para la fecha de la venta se le va a asignar la fecha y hora al
    momento de creación del objeto Factura. El tipo Factura debe contar con un
    método que calcule el monto final luego de aplicarle el descuento que posee el
    cliente.*/

    private UUID idFactura;
    private double montoTotal;
    private Date fecha;
    private ClienteFactura unClienteFactura;

    public Factura(double montoTotal, ClienteFactura unClienteFactura){
        this.idFactura=UUID.randomUUID();
        this.fecha=new Date();
        this.montoTotal=montoTotal;
        this.unClienteFactura = unClienteFactura;
    }

    public UUID getIdFactura() {
        return idFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double totalFactura) {
        this.montoTotal=totalFactura;
    }

    public ClienteFactura getUnClienteFactura() {
        return unClienteFactura;
    }

    public void setUnClienteFactura(ClienteFactura unClienteFactura) {
        this.unClienteFactura = unClienteFactura;
    }

    public void imprimirFactura(){
        System.out.println("\nID Factura: " + idFactura);
        System.out.println("Fecha: " + fecha);
        System.out.println("Monto Total: $" + montoTotal);
        System.out.println("Monto Final con Descuento: $" + aplicarDescuento(montoTotal));
        unClienteFactura.mostrarCliente();
    }

    public double aplicarDescuento(double totalSinDescuento){
        double totalConDescuento=totalSinDescuento;
        if (unClienteFactura.descuento>0){
            totalConDescuento = totalSinDescuento * ((100-(double) unClienteFactura.descuento)/100);
        }

        return totalConDescuento;
    }


}
