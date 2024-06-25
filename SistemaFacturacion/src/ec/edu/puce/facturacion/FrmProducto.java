package ec.edu.puce.facturacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmProducto extends JInternalFrame {
    private JTextField txtNombreProducto;
    private JTextField txtPrecio;
    private JTextField txtStock;
    private JTable table;
    private DefaultTableModel model;
    private boolean abierto = false;
    private ArrayProductos infoProductos;

    
    public FrmProducto(ArrayProductos infoProductos) {
    	initialize();
    	this.infoProductos = infoProductos; 
	} 
    public void initialize() {
        setTitle("Productos");
        setBounds(100, 100, 450, 558);
        getContentPane().setLayout(null);

        JLabel lblNombre = new JLabel("Nombre del Producto");
        lblNombre.setBounds(12, 24, 70, 15);
        getContentPane().add(lblNombre);

        JLabel lblPrecio = new JLabel("Precio");
        lblPrecio.setBounds(12, 51, 70, 15);
        getContentPane().add(lblPrecio);
        
        JLabel lblStock = new JLabel("Stock");
        lblStock.setBounds(12, 78, 70, 15);
        getContentPane().add(lblStock);


        txtNombreProducto = new JTextField();
        txtNombreProducto.setBounds(105, 22, 114, 19);
        getContentPane().add(txtNombreProducto);
        txtNombreProducto.setColumns(10);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(105, 49, 114, 19);
        getContentPane().add(txtPrecio);
        txtPrecio.setColumns(10);
        
        txtStock = new JTextField();
        txtStock.setBounds(105, 76, 114, 19);
        getContentPane().add(txtStock);
        txtStock.setColumns(10);

        JButton btnNuevo = new JButton("Nuevo");
        btnNuevo.setBounds(23, 206, 117, 25);
        getContentPane().add(btnNuevo);
        btnNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crearProducto();
            }
        });
        btnGuardar.setBounds(152, 206, 117, 25);
        getContentPane().add(btnGuardar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(281, 206, 117, 25);
        getContentPane().add(btnCancelar);

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                abierto = false;
            }
        });

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(23, 257, 375, 237);
        getContentPane().add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] { "ID", "Articulo", "Precio", "Stock"}
        ));
        scrollPane.setViewportView(table);
        model = (DefaultTableModel) table.getModel();
    }

    private void limpiarCampos() {
        txtNombreProducto.setText(null);
        txtPrecio.setText(null);
    }

    private void crearProducto() {
    	
    	Producto producto = new Producto();
    	producto.setid();
    	producto.setArticulo_Nombre(txtNombreProducto.getText());
    	producto.setPrecio(txtPrecio.getText());
    	producto.setStock(txtStock.getText());
    	
    	agregarFila(producto);
    	infoProductos.agregarProducto(producto);

       
    }

    private void agregarFila(Producto producto) {
        Object[] fila = new Object[4];
        fila[0] = producto.getId();
        fila[1] = producto.getArticulo_nombre();
        fila[2] = producto.getPrecio();
        fila[3] = producto.getStock();
        model.addRow(fila);
    }
    
    public void setAbierto(Boolean abierto){
    	this.abierto = abierto;
    }
    public boolean getAbierto() {
    	return this.abierto;
    }
}