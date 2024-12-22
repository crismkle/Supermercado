package Super;

import Clientes.Cliente;
import Empleados.Cajero;
import Productos.Producto;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Compra {
    private final Producto producto;
    private final LocalDateTime fechaHora;
    private final int cantidad;
    private final Cliente cliente;
    private final Cajero cajero;

    public Compra(Producto producto, int cantidad, Cliente cliente, Cajero cajero) {
        this.producto = producto;
        this.fechaHora = LocalDateTime.now();
        this.cantidad = cantidad;
        this.cliente = cliente;
        this.cajero = cajero;
        producto.restarStock(cantidad);
        generarTicket();
    }

    public Producto getProducto() {
        return producto;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public Cajero getCajero() {
        return cajero;
    }

    public double getPrecioFinal(){
        return producto.calcularPrecioFinal();
    }

    private void generarTicket() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        
        producto.mostrarInformacion();
        System.out.println("Fecha y hora: " + fechaHora.format(formatter) +
                            "\nCliente: " + cliente.getNombre() +
                            "\nCajero: " + cajero.getNombre() +
                            "\nCantidad: " + cantidad);
        producto.mostrarTicket(cantidad, cliente);

        
    }
    
}
