package controller;

import model.Profissional;
import repository.ProfissionalRepository;

import java.util.List;

public class ProfissionalController {
    private final ProfissionalRepository profissionalRepo;

    public ProfissionalController() {
        this.profissionalRepo = ProfissionalRepository.getInstance();
    }

    public void cadastrar(String nome, String telefone, String email) {
        Profissional profissional = new Profissional(nome, telefone, email);
        profissionalRepo.salvar(profissional);
    }

    public List<Profissional> listar() {
        return profissionalRepo.listarTodos();
    }

    public void remover(String nome) {
        profissionalRepo.remover(nome);
    }
}
