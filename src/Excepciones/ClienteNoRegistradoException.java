package Excepciones;

import Clientes.Cliente;

public class ClienteNoRegistradoException extends Exception {
    
    public ClienteNoRegistradoException(Cliente cliente){
        super("Cliente no registrado! El cliente " + cliente.getNombre() + " no se encuentra registrado en el sistema.");
    }
}
