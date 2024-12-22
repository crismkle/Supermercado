package Empleados;

import Super.Compra;
import java.util.ArrayList;
import java.util.List;

public class Cajero extends Empleado{
    private static final double COMISION = 0.05F;
    private static final int CANT_MIN_COMISION = 2;
    List<Compra> ventasRealizadas;
    
    public Cajero(String nombre, long idEmpleado, double salarioBase) {
        super(nombre, idEmpleado, salarioBase);
        ventasRealizadas = new ArrayList<>();
    }
    
    public void agregarVenta(Compra compra){
        ventasRealizadas.add(compra);
    }
        
    @Override
    public double calcularSalario() {
        
        if (ventasRealizadas.size() > CANT_MIN_COMISION){
            return super.getSalarioBase() + calcularComisiones();
        }else
            return super.getSalarioBase();
    }

    private double calcularComisiones() {
        double suma = 0;
        
        for(int i = CANT_MIN_COMISION; i<ventasRealizadas.size(); i++){
            Compra compra = ventasRealizadas.get(i);
            suma = suma + (compra.getPrecioFinal() * compra.getCantidad()) * COMISION;
        }
        return suma;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Tipo: cajero \nComision: " + redondeo(COMISION) + " p/venta" +
                            "\nSalario: " + redondeo(calcularSalario()));
    }
    
}
