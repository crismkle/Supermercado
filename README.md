# Supermercado
Trabajo final de Sistema de gestión de supermercado del curso de Java 1 de UTN Regional Mendoza.

## Enunciado

### Proyecto Final
Desarrollar un sistema de gestión para un supermercado que permita manejar diferentes tipos de productos, gestionar a los clientes, aplicar descuentos especiales a clientes VIP, gestionar compras, manejar inventarios y gestionar empleados. Además, el sistema debe permitir el manejo de diferentes tipos de promociones y calcular impuestos dependiendo de los productos.

Requisitos:
1. Clase abstracta Producto:
    - Atributos:
      - codigo: Código único del producto.
      - nombre: Nombre del producto.
      - precio: Precio base del producto.
      - categoria: Categoría del producto (alimentación, higiene, electrónica, etc.).
      - Variable estática totalProductos: contador de productos en el sistema.
      - Constructor:
        -  Inicializa los atributos y aumenta el contador estático.
    
    - Métodos abstractos:
      - calcularPrecioFinal(): Calcula el precio final considerando impuestos, descuentos, y promociones.
      - mostrarInformacion(): Muestra la información del producto (esto será implementado en cada subclase).
    - Métodos concretos:
      - getNombre(), getCodigo(), getCategoria(), etc.
      - Métodos de acceso y modificación (setters y getters) para los atributos.

2. Subclases que extienden Producto:
    - Clase ProductoAlimenticio:
      - Atributos adicionales:
        - fechaCaducidad: Fecha de caducidad del producto.
        - esPerecedero: Booleano que indica si el producto es perecedero.
      - Constructor:
        - Inicializa los atributos del producto y determina si es perecedero.
      - Implementación de calcularPrecioFinal():
        - Si el producto está cerca de la fecha de caducidad (menos de 5 días), aplica un descuento del 30%.
    
    - Clase ProductoElectronico:
      - Atributos adicionales:
        - garantia: Años de garantía del producto.
      - Constructor:
        - Inicializa el código, nombre, precio y años de garantía.
      - Implementación de calcularPrecioFinal():
        - Si el producto tiene más de 2 años de garantía, aplica un costo adicional por garantía extendida (5% del precio base).
  
      - Clase ProductoHigiene:
        - Atributos adicionales:
          - tipoDeUso: Tipo de uso del producto (personal, doméstico, etc.).
        - Constructor:
          - Inicializa el tipo de uso.
        - Implementación de calcularPrecioFinal():
          - Aplica impuestos específicos según la categoría de higiene (10%).

3. Interfaz Promocionable:
    - Métodos:
      - aplicarDescuento(double porcentaje): Aplica un descuento específico a un producto.
      - aplicarPromocion(String tipoPromocion): Permite aplicar una promoción específica a un producto (por ejemplo: 2x1, 50% en la segunda unidad, etc.).

Herencia Múltiple con la interfaz Promocionable:

- Las clases de productos pueden implementar la interfaz Promocionable para incluir promociones y descuentos.

4. Interfaz ImpuestoAplicable:
    - Método:
      - calcularImpuesto(double porcentaje): Calcula el impuesto a aplicar sobre el producto. Diferentes productos pueden tener diferentes tipos de impuestos.

5. Clase Cliente:
    - Atributos:
      - nombre: Nombre del cliente.
      - dni: Identificación del cliente.
      - Variable estática totalClientes: contador de clientes en el sistema.
    - Métodos:
      - comprar(Producto producto): Permite que el cliente compre un producto.
      - mostrarCompras(): Muestra el historial de compras del cliente.
    - Subclase ClienteVIP (extiende Cliente):
      - Atributos adicionales:
        - descuentoVIP: Porcentaje de descuento especial para clientes VIP.
      - Constructor:
        - Inicializa los atributos del cliente VIP y el porcentaje de descuento.
      - Métodos:
        - aplicarDescuentoVIP(Producto producto): Aplica el descuento VIP a los productos que el cliente VIP compre.

6. Clase abstracta Empleado:
    - Atributos:
      - nombre: Nombre del empleado.
      - idEmpleado: ID único del empleado.
      - salarioBase: Salario base del empleado.
    - Métodos abstractos:
      - calcularSalario(): Método abstracto que cada tipo de empleado implementará para calcular su salario final (con comisiones o bonos).
    - Subclase Cajero (extiende Empleado):
      - Atributos adicionales:
        - ventasRealizadas: Ventas que ha procesado el cajero.
      - Implementación de calcularSalario():
        - Calcula el salario base más comisiones por ventas realizadas.
    - Subclase Gerente (extiende Empleado):
      - Atributos adicionales:
        - bonoGerencial: Bono especial para los gerentes.
      - Implementación de calcularSalario():
        - Calcula el salario base más un bono gerencial.

7. Clase Supermercado:
    - Atributos:
      - Lista de productosDisponibles: Lista de productos que el supermercado tiene en inventario.
      - Lista de clientes: Clientes registrados en el supermercado.
      - Lista de empleados: Empleados que trabajan en el supermercado.
    - Métodos:
      - agregarProducto(Producto producto): Agrega un nuevo producto al inventario.
      - agregarCliente(Cliente cliente): Registra un nuevo cliente.
      - registrarCompra(Cliente cliente, Producto producto): Registra la compra de un cliente.
      - mostrarInventario(): Muestra los productos disponibles en el supermercado.
      - mostrarClientes(): Muestra los clientes registrados en el sistema.

8. Excepciones Personalizadas:
    - ProductoNoDisponibleException:
      - Se lanza cuando un producto no está disponible en el inventario.
    - ClienteNoRegistradoException:
      - Se lanza cuando un cliente intenta realizar una compra pero no está registrado en el sistema.

9. Clase Principal Main:
    - Creación de diferentes tipos de productos.
    - Registro de clientes, incluidos clientes VIP.
    - Ejecución de compras por parte de los clientes, aplicando descuentos, promociones e impuestos según el producto.
    - Registro y cálculo de salarios para empleados (cajeros y gerentes).
    - Control del inventario, mostrando productos disponibles antes y después de las compras.
    - Manejo de excepciones cuando un producto no está disponible o el cliente no está registrado.

