package ec.edu.puce.facturacion;


import java.util.ArrayList;
import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Producto> productos;
    private float subtotal;
    private float iva;
    private float total;

    public Factura() {
        this.productos = new ArrayList<>();
        this.cliente = null;
        this.subtotal = 0;
        this.iva = 0;
        this.total = 0;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
        subtotal += Float.parseFloat(producto.getPrecio());
        iva = subtotal * 0.15f;
        total = subtotal + iva;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public float getIva() {
        return iva;
    }

    public float getTotal() {
        return total;
    }

    public List<Producto> getProductos() {
        return productos;
    }
}

