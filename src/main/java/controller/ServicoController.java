package controller;

import model.Servico;
import repository.ServicoRepository;

import java.util.List;

public class ServicoController {
    private final ServicoRepository servicoRepo;

    public ServicoController() {
        this.servicoRepo = ServicoRepository.getInstance();
    }

    public void cadastrar(String nome, String descricao, double preco) {
        Servico servico = new Servico(nome, descricao, preco);
        servicoRepo.salvar(servico);
    }

    public List<Servico> listar() {
        return servicoRepo.listarTodos();
    }

    public void remover(String nome) {
        servicoRepo.remover(nome);
    }
}
