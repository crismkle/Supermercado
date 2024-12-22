package Productos;

import Clientes.Cliente;
import Clientes.ClienteVIP;
import Enums.Categoria;
import Interfaces.Promocionable;
import java.util.Random;

public class ProductoElectronico extends Producto implements Promocionable{
    private int garantia;
    private static final double COSTO_ADICIONAL = 0.05F;

    public ProductoElectronico(int garantia, long codigo, String nombre, double precioBase, int cantEnStock) {
        super(codigo, nombre, precioBase, Categoria.Electronica, cantEnStock);
        this.garantia = garantia;
    }
    
    @Override
    public double calcularPrecioFinal() {
        if (garantia > 2)
            return redondeo(aplicarDescuento());
        
        return redondeo(super.getPrecioBase());
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Garantia: " + garantia + " anios");
    }

    @Override
    public double aplicarDescuento() {
        return super.getPrecioBase() + (super.getPrecioBase() * COSTO_ADICIONAL);
    }

    @Override
    public void aplicarPromocion() {
        Random random = new Random();
        int eleccion = random.nextInt(3);
        
        switch (eleccion){
            case 0:
                System.out.println("¡Promoción 2x1! LLevas dos televisores, pagas uno");
            break;
            case 1:
                System.out.println("¡Promo 30% en productos nacionales!");
            break;
            case 2:
                System.out.println("¡Sin interes! Compras con tarjeta de credito en hasta 12 cuotas");
            break;
            default:
                System.out.println("Esta semana no hay promociones, ¡estate atento!");
        }
    }

    @Override
    public void mostrarTicket(int cantidad, Cliente cliente) {
        
        System.out.println("Garantia: " + garantia);
        if (garantia > 2)
            System.out.println("Costo adicional por garantia: " + COSTO_ADICIONAL);
        
        aplicarPromocion();
        
        super.mostrarTicket(cantidad, cliente);
    }
}
