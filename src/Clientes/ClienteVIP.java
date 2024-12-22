package Clientes;

import Productos.Producto;

public class ClienteVIP extends Cliente{
    private double descuentoVIP;

    public ClienteVIP(String nombre, int dni, double descuentoVIP) {
        super(nombre, dni);
        this.descuentoVIP = descuentoVIP;
    }

    public double getDescuentoVIP() {
        return descuentoVIP;
    }
    
    public double aplicarDescuentoVIP(Producto producto){
        return producto.calcularPrecioFinal() - (producto.calcularPrecioFinal() * descuentoVIP);
    }
    
    public void mostrarCliente(){
        System.out.println("Cliente VIP");
        super.mostrarCliente();
    }
}
