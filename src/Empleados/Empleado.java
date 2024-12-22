package Empleados;

public abstract class Empleado {
    private final String nombre;
    private final long idEmpleado;
    private double salarioBase;

    public Empleado(String nombre, long idEmpleado, double salarioBase) {
        this.nombre = nombre;
        this.idEmpleado = idEmpleado;
        this.salarioBase = salarioBase;
    }
    
    public abstract double calcularSalario();
    
    public void mostrarInformacion(){
        System.out.println("\nNombre: " + nombre + "\nId: " + idEmpleado +
                            "\nSalario base: " + salarioBase);
    }

    public String getNombre() {
        return nombre;
    }

    public long getIdEmpleado() {
        return idEmpleado;
    }

    public double getSalarioBase() {
        return salarioBase;
    }
    
    public double redondeo(double numero){
        return Math.round(numero * 100.0) / 100.0;
    }
    
}
