package repository;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteRepository {
    private final List<Cliente> clientes = new ArrayList<>();
    private int proximoId = 1;

    public void salvar(Cliente cliente) {
        cliente.setIdCliente(proximoId++);
        clientes.add(cliente);
    }

    public List<Cliente> listarTodos() {
        return clientes;
    }

    public Optional<Cliente> buscarPorId(int id) {
        return clientes.stream().filter(c -> c.getIdCliente() == id).findFirst();
    }

    public void remover(int id) {
        clientes.removeIf(c -> c.getIdCliente() == id);
    }

    public void atualizar(Cliente clienteAtualizado) {
        buscarPorId(clienteAtualizado.getIdCliente()).ifPresent(cliente -> {
            cliente.setNome(clienteAtualizado.getNome());
            cliente.setEmail(clienteAtualizado.getEmail());
            cliente.setTelefone(clienteAtualizado.getTelefone());
            cliente.setStatus(clienteAtualizado.getStatus());
        });
    }
}
