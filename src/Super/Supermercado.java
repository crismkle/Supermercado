package Super;

import Empleados.Empleado;
import Clientes.Cliente;
import Empleados.Cajero;
import Excepciones.ClienteNoRegistradoException;
import Excepciones.ProductoNoDisponibleException;
import Productos.Producto;
import java.util.ArrayList;
import java.util.List;

public class Supermercado {

    List<Producto> productosDisponibles;
    List<Cliente> clientes;
    List<Empleado> empleados;
    List<Compra> comprasTotales;

    public Supermercado() {
        productosDisponibles = new ArrayList<>();
        clientes = new ArrayList<>();
        empleados = new ArrayList<>();
        comprasTotales = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productosDisponibles.add(producto);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public boolean clienteRegistrado(Cliente cliente) {
        return clientes.contains(cliente);
    }
    
    public void agregarEmpleado(Empleado empleado){
        empleados.add(empleado);
    }

    public void registrarCompra(Cliente cliente, int cantidad, Producto producto, Cajero cajero) throws ProductoNoDisponibleException, ClienteNoRegistradoException {

        if (!clienteRegistrado(cliente))
            throw new ClienteNoRegistradoException(cliente);
        
        if (!producto.hayStock(cantidad))
            throw new ProductoNoDisponibleException(producto);
            
        Compra compra = new Compra(producto, cantidad, cliente, cajero);
        cajero.agregarVenta(compra);
        cliente.comprar(compra);
        comprasTotales.add(compra);
        
    }

    public void mostrarInventario() {
        System.out.println("\n\n-----------------------------------");
        System.out.println("------ Productos disponibles ------");
        System.out.println("-----------------------------------\n");
        for (Producto producto : productosDisponibles) {
            if (producto.getCantEnStock() > 0)
                producto.mostrarInfoInventario();
        }
    }

    public void mostrarClientes() {
        System.out.println("\n\n---------------------");
        System.out.println("------ Clientes ------");
        System.out.println("---------------------\n");
        System.out.println("\nTotal de clientes: " + Cliente.getTotalClientes());
        for (Cliente cliente : clientes) {
            cliente.mostrarCliente();
        }
    }
    
    public void mostrarEmpleados(){
        System.out.println("\n\n-----------------------");
        System.out.println("------ Empleados ------");
        System.out.println("-----------------------\n");
        for(Empleado empleado : empleados){
            empleado.mostrarInformacion();
        }
    }

}
