package view;

import model.Cliente;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ClienteTableModel extends AbstractTableModel {
    private List<Cliente> clientes;
    private final String[] columnas = {"ID", "Nombre", "Apellido", "Dirección", "DNI", "Fecha"};

    public ClienteTableModel(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente c = clientes.get(rowIndex);
        switch (columnIndex) {
            case 0: return c.getId();
            case 1: return c.getNombre();
            case 2: return c.getApellido();
            case 3: return c.getDireccion();
            case 4: return c.getDni();
            case 5: return c.getFecha();
            default: return null;
        }
    }
}