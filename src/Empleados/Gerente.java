package Empleados;

public class Gerente extends Empleado{
    private double bonoGerencial;

    public Gerente(double bonoGerencial, String nombre, long idEmpleado, double salarioBase) {
        super(nombre, idEmpleado, salarioBase);
        this.bonoGerencial = bonoGerencial;
    }
  
    @Override
    public double calcularSalario() {
        return super.getSalarioBase() + bonoGerencial;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();        
        System.out.println("Tipo: Gerente\nBono gerencial: " + bonoGerencial +
                            "\nSalario: " + redondeo(calcularSalario()));
    }
    
    
}
