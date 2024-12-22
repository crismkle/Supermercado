package Principal;

import Clientes.Cliente;
import Clientes.ClienteVIP;
import Empleados.Cajero;
import Empleados.Empleado;
import Empleados.Gerente;
import Enums.Uso;
import Excepciones.ClienteNoRegistradoException;
import Excepciones.ProductoNoDisponibleException;
import Productos.Producto;
import Productos.ProductoAlimenticio;
import Productos.ProductoElectronico;
import Productos.ProductoHigiene;
import Super.Supermercado;
import java.time.LocalDate;

public class GestionSupermercado {

    public static void main(String[] args) {
        /*  ENUNCIADO
            o Creación de diferentes tipos de productos.
            o Registro de clientes, incluidos clientes VIP.
            o Ejecución de compras por parte de los clientes, aplicando descuentos,
                promociones e impuestos según el producto.
            o Registro y cálculo de salarios para empleados (cajeros y gerentes).
            o Control del inventario, mostrando productos disponibles antes y después
                de las compras.
            o Manejo de excepciones cuando un producto no está disponible o el cliente
                no está registrado.
        */
        
        Supermercado supermercado = new Supermercado();
        
        /* Creación de productos */
        
        Producto producto1 = new ProductoAlimenticio(LocalDate.of(2024, 12, 29), true, 100002, "Arroz Gallo", 600F, 25);
        Producto producto2 = new ProductoAlimenticio(LocalDate.of(2025, 02, 15), true, 100003, "Galletitas Doritas", 320F, 27);
        Producto producto3 = new ProductoAlimenticio(null, false, 100004, "Miel Natura", 400F, 20);
        Producto producto4 = new ProductoAlimenticio(LocalDate.of(2024, 12, 25), true, 100005, "Harina Blanquita 000", 250F, 35);
        
        Producto producto5 = new ProductoHigiene(100011, "Lavandina Super", 500F, Uso.Domestico, 10);
        Producto producto6 = new ProductoHigiene(100012, "Detergente Espumita", 350F, Uso.Domestico, 15);
        Producto producto7 = new ProductoHigiene(100013, "Cloro Concentradin", 1200F, Uso.Profesional, 13);
        Producto producto8 = new ProductoHigiene(100014, "Jabon Limpias Manos", 200F, Uso.Personal, 30);
        
        Producto producto9 = new ProductoElectronico(3, 100021, "Televisor Sony HsD", 300000F, 8);
        Producto producto10 = new ProductoElectronico(2, 100022, "Microondas Liliana 9000", 150000F, 12);
        Producto producto11 = new ProductoElectronico(3, 100023, "Notebook SD320", 450000F, 10);
        Producto producto12 = new ProductoElectronico(3, 100024, "Celular Nokia 2000", 150000F, 10);
        
        supermercado.agregarProducto(producto1);
        supermercado.agregarProducto(producto2);
        supermercado.agregarProducto(producto3);
        supermercado.agregarProducto(producto4);
        supermercado.agregarProducto(producto5);
        supermercado.agregarProducto(producto6);
        supermercado.agregarProducto(producto7);
        supermercado.agregarProducto(producto8);
        supermercado.agregarProducto(producto9);
        supermercado.agregarProducto(producto10);
        supermercado.agregarProducto(producto11);
        supermercado.agregarProducto(producto12);
        
        
        /* Regristro de clientes */
        
        Cliente cliente1 = new Cliente("Juan Gomez", 2021210);
        Cliente cliente2 = new Cliente("Ines Perez", 3101215);
        Cliente cliente3 = new ClienteVIP("Laura Lopez", 3054542, 0.25F);
        Cliente cliente4 = new Cliente("Pablo Marmol", 3554542);
        Cliente cliente5 = new ClienteVIP("Pedro Smith", 2422454, 0.13F);
        
        // Cliente sin registrar
        Cliente cliente6 = new Cliente("Juana Zapata", 2724555);
        
        supermercado.agregarCliente(cliente1);
        supermercado.agregarCliente(cliente2);
        supermercado.agregarCliente(cliente3);
        supermercado.agregarCliente(cliente4);
        supermercado.agregarCliente(cliente5);
        
        
        /* Registro de cajeros y gerente */
        
        Empleado empleado1 = new Cajero("Martin Rojas", 30001, 400000F);
        Empleado empleado2 = new Cajero("Ana Rodriguez", 30002, 420000F);
        Empleado empleado3 = new Cajero("Nicolas Roca", 30003, 380000F);
        Empleado empleado4 = new Gerente(500000F, "Beatriz Washington", 30004, 950000F);
        
        supermercado.agregarEmpleado(empleado1);
        supermercado.agregarEmpleado(empleado2);
        supermercado.agregarEmpleado(empleado3);
        supermercado.agregarEmpleado(empleado4);
        
        
        /* Muestra inventario */
                
        supermercado.mostrarInventario();
        
        
        /* Ejecución de compras */
        
        try{
            System.out.println("\n---------------------------");
            System.out.println("---- Compras - Tickets ----");
            System.out.println("---------------------------\n");
            supermercado.registrarCompra(cliente2, 4, producto5, (Cajero)empleado3);
            supermercado.registrarCompra(cliente4, 7, producto8, (Cajero)empleado2);
            supermercado.registrarCompra(cliente3, 3, producto7, (Cajero)empleado1);
            supermercado.registrarCompra(cliente1, 3, producto1, (Cajero)empleado1);
            
        }catch (ClienteNoRegistradoException e){
            System.out.println("Error! " + e.getMessage());
        }catch (ProductoNoDisponibleException e){
            System.out.println("Error! " + e.getMessage());            
        }
        
        /* Calculo de salarios */
                
        supermercado.mostrarEmpleados();
        
        /* Clientes */
        
        supermercado.mostrarClientes();
                
        /* Muestra inventario */
                
        supermercado.mostrarInventario();
        
        /* Ejemplo con producto no disponible y cliente no registrado */
        
        try{
            System.out.println("\n---------------------------");
            System.out.println("---- Compras - Tickets ----");
            System.out.println("------- Excepciones -------");
            System.out.println("---------------------------\n");
            
            // Ejemplo cliente no registrado
            supermercado.registrarCompra(cliente6, 1, producto9, (Cajero)empleado3);
            
            // Ejemplo producto sin stock disponible
            supermercado.registrarCompra(cliente4, 7, producto5, (Cajero)empleado3);
            
        }catch (ClienteNoRegistradoException e){
            System.out.println("Error! " + e.getMessage());
        }catch (ProductoNoDisponibleException e){
            System.out.println("Error! " + e.getMessage());            
        }finally {
            System.out.println("\nGracias por su compra. Vuelva prontos!");
        }
        
    }
    
}
