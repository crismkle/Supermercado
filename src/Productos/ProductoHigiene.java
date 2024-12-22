package Productos;

import Clientes.Cliente;
import Clientes.ClienteVIP;
import Enums.Uso;
import Enums.Categoria;
import Interfaces.ImpuestoAplicable;

public class ProductoHigiene extends Producto implements ImpuestoAplicable{
    private Uso tipoDeUso;
    private static final double IMPUESTO_BASE = 0.1F;
    
    public ProductoHigiene(long codigo, String nombre, double precioBase, Uso tipoDeUso, int cantEnStock) {
        super(codigo, nombre, precioBase, Categoria.Higiene, cantEnStock);
        this.tipoDeUso = tipoDeUso;
    }

    @Override
    public double calcularPrecioFinal() {

        return redondeo(super.getPrecioBase() + (super.getPrecioBase() * calcularImpuesto()));
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Tipo de uso: " + tipoDeUso.toString());
    }

    @Override
    public double calcularImpuesto() {
        double ret;
        switch (tipoDeUso){
            case tipoDeUso.Domestico:
                ret = IMPUESTO_BASE;
            break;
            case tipoDeUso.Personal:
                ret = IMPUESTO_BASE + 0.15F;
            break;
            case tipoDeUso.Profesional:
                ret = IMPUESTO_BASE + 0.35F;
            break;
            default:
                ret = IMPUESTO_BASE + 0.05F;
        }
        return ret;
    }

    @Override
    public void mostrarTicket(int cantidad, Cliente cliente) {
        
        if (cliente instanceof ClienteVIP)
            System.out.println("Impuesto: " + redondeo(calcularImpuesto()));
        else
            System.out.println("Impuesto: " + redondeo(calcularImpuesto()));
        
        super.mostrarTicket(cantidad, cliente);
    }

    
}
