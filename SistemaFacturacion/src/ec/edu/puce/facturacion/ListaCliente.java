package ec.edu.puce.facturacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListaCliente extends JInternalFrame {
    private JTable table;
    private ArrayDatos infoclientes;
    private DefaultTableModel model;
    private Boolean abierto;

    public ListaCliente(ArrayDatos infoclientes) {
        this.infoclientes = infoclientes;
        this.abierto = false;
        setTitle("Clientes");
        setBounds(100, 100, 450, 500);
        getContentPane().setLayout(null);

        JButton btnCancelar = new JButton("Salir");
        btnCancelar.setBounds(283, 390, 117, 25);
        getContentPane().add(btnCancelar);

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                abierto = false;
            }
        });

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(23, 11, 375, 350);
        getContentPane().add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] { "Cédula", "Nombres", "Apellidos", "Dirección", "Teléfono", "Email" }
        ));
        scrollPane.setViewportView(table);
        model = (DefaultTableModel) table.getModel();

    
        cargarClientes();
    }

    private void cargarClientes() {
        model.setRowCount(0); 
        List<Cliente> listaClientes = infoclientes.getListaClientes();
        for (Cliente cliente : listaClientes) {
            agregarFila(cliente);
        }
    }

    private void agregarFila(Cliente cliente) {
        Object[] fila = new Object[6];
        fila[0] = cliente.getCedula();
        fila[1] = cliente.getNombre();
        fila[2] = cliente.getApellido();
        fila[3] = cliente.getDireccion();
        fila[4] = cliente.getTelefono();
        fila[5] = cliente.getEmail();
        model.addRow(fila);
    }
    public void setAbierto(Boolean abierto){
    	this.abierto = abierto;
    }
    public boolean getAbierto() {
    	return this.abierto;
    }
}