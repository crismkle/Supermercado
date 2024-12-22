package Excepciones;

import Productos.Producto;

public class ProductoNoDisponibleException extends Exception {
    
    public ProductoNoDisponibleException(Producto producto){
        super("Sin stock disponible! Falta stock para el producto " + producto.getNombre());
    }
}
