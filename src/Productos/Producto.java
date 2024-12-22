package Productos;

import Clientes.Cliente;
import Clientes.ClienteVIP;
import Enums.Categoria;

public abstract class Producto {
    private final long codigo;
    private String nombre;
    private double precioBase;
    private Categoria categoria;
    private static int totalProductos = 0;
    private int cantEnStock;

    public Producto(long codigo, String nombre, double precioBase, Categoria categoria, int cantEnStock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.categoria = categoria;
        this.cantEnStock = cantEnStock;
        totalProductos++;
    }
    
    public abstract double calcularPrecioFinal();
    
    public void mostrarTicket(int cantidad, Cliente cliente){
                
        if (cliente instanceof ClienteVIP)
            System.out.println("Precio por unidad: " + getPrecioBase() +
                            "\nDescuento VIP: " + ((ClienteVIP) cliente).getDescuentoVIP() +
                            "\nTotal a pagar: " + ((ClienteVIP) cliente).aplicarDescuentoVIP(this) * cantidad + "\n");
        else
            System.out.println("Precio por unidad: " + getPrecioBase() +
                            "\nTotal a pagar: " + calcularPrecioFinal() * cantidad + "\n");
    }
    
    public void mostrarInformacion(){
        System.out.println("Nombre: " + nombre + "\nCodigo: " + codigo +
                            "\nPrecio base: " + precioBase + "\nCategoria: " + categoria.toString());
    }

    public void mostrarInfoInventario(){
        mostrarInformacion();
        System.out.println("Cantidad en stock: " + cantEnStock + "\n");
    }
    
    public long getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public static int getTotalProductos() {
        return totalProductos;
    }

    public int getCantEnStock() {
        return cantEnStock;
    }

    public void restarStock(int cant) {
        cantEnStock -= cant;
    }
    
    public void sumarStock(int cant) {
        cantEnStock += cant;
    }        
    
    public boolean hayStock(int cant) {
        return cantEnStock >= cant;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }
    
    public double redondeo(double numero){
        return Math.round(numero * 100.0) / 100.0;
    }
    
}
