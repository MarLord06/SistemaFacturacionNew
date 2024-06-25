package ec.edu.puce.facturacion;

import java.util.ArrayList;
import java.util.List;

public class ArrayDatos {
    private List<Cliente> datosClientes;

    public ArrayDatos() {
        this.datosClientes = new ArrayList<>();
    }

    public List<Cliente> getListaClientes() {
        return datosClientes;
    }
    

    public void agregarCliente(Cliente cliente) {
        datosClientes.add(cliente);
    }

}