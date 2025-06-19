package controller;

import java.util.List;

import repository.ClienteRepository;
import model.Cliente;

public class ClienteController {
    private final ClienteRepository clienteRepo;

    public ClienteController() {
        this.clienteRepo = new ClienteRepository();
    }

    public void cadastrarCliente(String nome, String telefone, String email) {
        Cliente cliente = new Cliente(nome, telefone, email, 0);
        clienteRepo.salvar(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepo.listarTodos();
    }

    public void atualizarCliente(Cliente cliente) {
        clienteRepo.atualizar(cliente);
    }

    public void removerCliente(int id) {
        clienteRepo.remover(id);
    }

    public Cliente buscarCliente(int id) {
        return clienteRepo.buscarPorId(id).orElse(null);
    }
}
