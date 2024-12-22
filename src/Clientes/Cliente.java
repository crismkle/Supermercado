package Clientes;

import Super.Compra;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private final String nombre;
    private final int dni;
    private static int totalClientes = 0;
    private List<Compra> compras;

    public Cliente(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
        compras = new ArrayList<>();
        totalClientes++;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    public static int getTotalClientes() {
        return totalClientes;
    }
    
    public void comprar(Compra compra){        
        compras.add(compra);
    }
    
    public void mostrarCompras(){
        for(Compra compra : compras){
            System.out.println(compra.toString());
        }
    }
    
    public void mostrarCliente(){
        System.out.println("Nombre: " + nombre + "\nDNI: " + dni + "\n");
    }
        
}
