package ec.edu.puce.facturacion;

import java.util.ArrayList;
import java.util.List;

public class ArrayProductos {
    private List<Producto> datosProductos;

    public ArrayProductos() {
        this.datosProductos = new ArrayList<>();
    }

    public List<Producto> getListaClientes() {
        return datosProductos;
    }

    public void agregarProducto(Producto producto) {
        datosProductos.add(producto);
    }


}