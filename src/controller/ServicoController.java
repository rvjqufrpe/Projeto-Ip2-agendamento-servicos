package controller;

import model.Servico;
import repository.ServicoRepository;

import java.util.List;

public class ServicoController {
    private final ServicoRepository repo = new ServicoRepository();

    public void cadastrar(String nome, String descricao, double preco) {
        Servico servico = new Servico(nome, descricao, preco);
        repo.salvar(servico);
    }

    public List<Servico> listar() {
        return repo.listarTodos();
    }
}
