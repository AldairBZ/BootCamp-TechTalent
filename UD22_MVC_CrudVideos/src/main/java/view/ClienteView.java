package view;

import model.Cliente;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ClienteView extends JFrame {
    private JTable tableClientes;

    public ClienteView(List<Cliente> clientes) {
        setTitle("Listado de Clientes");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ClienteTableModel model = new ClienteTableModel(clientes);
        tableClientes = new JTable(model);

        add(new JScrollPane(tableClientes), BorderLayout.CENTER);
    }
}