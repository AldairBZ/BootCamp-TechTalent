package controller;

import model.ClienteDAO;
import view.ClienteView;
import model.Cliente;

import java.util.List;

public class ClienteController {
    private ClienteDAO dao;
    private ClienteView view;

    public ClienteController(ClienteView view) {
        this.view = view;
        this.dao = new ClienteDAO();
    }

    public void mostrarClientes() {
        List<Cliente> clientes = dao.listar();
        // Aquí puedes actualizar el modelo de la tabla si quieres que sea dinámico
        // Pero para simplificar, la tabla ya tiene los datos al crear la vista.
    }
}