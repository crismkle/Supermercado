package Productos;

import Clientes.Cliente;
import Clientes.ClienteVIP;
import Enums.Categoria;
import Interfaces.Promocionable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class ProductoAlimenticio extends Producto implements Promocionable{
    private LocalDate fechaCaducidad;
    private boolean esPerecedero;
    private static final double DESCUENTO_CADUCIDAD = 0.3F;

    public ProductoAlimenticio(LocalDate fechaCaducidad, boolean esPerecedero, long codigo,
                                String nombre, double precioBase, int cantEnStock) {
        super(codigo, nombre, precioBase, Categoria.Alimentacion, cantEnStock);
        this.fechaCaducidad = fechaCaducidad;
        this.esPerecedero = esPerecedero;
    }
    
    @Override
    public double calcularPrecioFinal() {
        if (ChronoUnit.DAYS.between(LocalDate.now(), fechaCaducidad) < 5)
            return redondeo(aplicarDescuento());
        
        return redondeo(super.getPrecioBase());
    }

    @Override
    public void mostrarInformacion() {
        String result;
        if (esPerecedero)
            result = "Si";
        else
            result = "No";
        
        super.mostrarInformacion();
        if (fechaCaducidad != null)
            System.out.println("Es perecedero? " + result +
                                "\nFecha de caducidad: " + fechaCaducidad.toString());
        else
            System.out.println("Es perecedero? " + result);
    }

    @Override
    public double aplicarDescuento() {
        return super.getPrecioBase() - (super.getPrecioBase() * DESCUENTO_CADUCIDAD);
    }

    @Override
    public void aplicarPromocion() {
        Random random = new Random();
        int eleccion = random.nextInt(4);
        
        switch (eleccion){
            case 0:
                System.out.println("Promocion: 2x1! LLevas dos paquetes de galletitas, pagas uno");
            break;
            case 1:
                System.out.println("Promocion: Promo 50% en segunda unidad de gaseosas!");
            break;
            case 2:
                System.out.println("Promocion: Sin interes! Compras con tarjeta de credito en hasta 12 cuotas");
            break;
            case 3:
                System.out.println("Promocion: Compra el combo cerveza, papitas y salamin y te sale 30% mas barato");
            break;
            default:
                System.out.println("Promocion: Compras y te llevas un producto gratis");
        }
    }

    @Override
    public void mostrarTicket(int cantidad, Cliente cliente) {
        
        
        if (ChronoUnit.DAYS.between(LocalDate.now(), fechaCaducidad) < 5)
            System.out.println("Descuento por caducidad: " + DESCUENTO_CADUCIDAD);

        aplicarPromocion();       
        
        super.mostrarTicket(cantidad, cliente);
    }
    
}
