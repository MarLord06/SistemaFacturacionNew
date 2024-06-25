package ec.edu.puce.facturacion;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class FrmFacturacion extends JInternalFrame {
    private JComboBox<Cliente> cmbClientes;
    private JComboBox<Producto> cmbProductos;
    private JButton btnAgregarProducto;
    private JButton btnCalcularTotal;
    private JTable tableDetalle;	
    private DefaultTableModel model;
    private Factura factura;
    private JButton btnSalir;

    public FrmFacturacion(ArrayDatos arrayDatos, ArrayProductos arrayProductos) {
    	getContentPane().setBackground(new Color(255, 255, 255));
        setTitle("Facturación");
        setBounds(100, 100, 600, 400);
        getContentPane().setLayout(null);

        JLabel lblCliente = new JLabel("Cliente:");
        lblCliente.setBounds(20, 20, 70, 20);
        getContentPane().add(lblCliente);

        cmbClientes = new JComboBox<>();
        cmbClientes.setBounds(100, 20, 200, 20);
        for (Cliente cliente : arrayDatos.getListaClientes()) {
            cmbClientes.addItem(cliente);
        }
        getContentPane().add(cmbClientes);

        JLabel lblProducto = new JLabel("Producto:");
        lblProducto.setBounds(20, 60, 70, 20);
        getContentPane().add(lblProducto);

        cmbProductos = new JComboBox<>();
        cmbProductos.setBounds(100, 60, 200, 20);
        for (Producto producto : arrayProductos.getListaClientes()) {
            cmbProductos.addItem(producto);
        }
        getContentPane().add(cmbProductos);

        btnAgregarProducto = new JButton("Agregar Producto");
        btnAgregarProducto.setForeground(new Color(0, 0, 0));
        btnAgregarProducto.setBackground(new Color(0, 255, 0));
        btnAgregarProducto.setBounds(320, 60, 150, 20);
        getContentPane().add(btnAgregarProducto);

        btnCalcularTotal = new JButton("Calcular Total");
        btnCalcularTotal.setBackground(new Color(255, 128, 64));
        btnCalcularTotal.setBounds(320, 100, 150, 20);
        getContentPane().add(btnCalcularTotal);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBackground(new Color(255, 128, 255));
        scrollPane.setBounds(20, 140, 550, 200);
        getContentPane().add(scrollPane);

        tableDetalle = new JTable();
        model = new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Articulo", "Precio"}
        );
        tableDetalle.setModel(model);
        scrollPane.setViewportView(tableDetalle);
        
        btnSalir = new JButton("Salir");
        btnSalir.setBackground(new Color(255, 0, 0));
        btnSalir.setBounds(485, 11, 89, 23);
        getContentPane().add(btnSalir);
        btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});

        btnAgregarProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarProducto();
            }
        });

        btnCalcularTotal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularTotal();
            }
        });

        factura = new Factura();
    }

    private void agregarProducto() {
        Producto producto = (Producto) cmbProductos.getSelectedItem();
        factura.agregarProducto(producto);
        actualizarTabla();
    }

    private void calcularTotal() {
        float subtotal = factura.getSubtotal();
        float iva = factura.getIva();
        float total = factura.getTotal();
        JOptionPane.showMessageDialog(this, "Subtotal: $" + subtotal + "\nIVA: $" + iva + "\nTotal: $" + total, "Total de la Factura", JOptionPane.INFORMATION_MESSAGE);
    }

    private void actualizarTabla() {
        model.setRowCount(0);
        for (Producto producto : factura.getProductos()) {
            Object[] fila = new Object[]{producto.getId(), producto.getArticulo_nombre(), producto.getPrecio()};
            model.addRow(fila);
        }
    }
}
