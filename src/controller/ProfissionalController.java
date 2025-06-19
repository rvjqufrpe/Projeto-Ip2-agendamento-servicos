package controller;

import model.Profissional;
import repository.ProfissionalRepository;

import java.util.List;

public class ProfissionalController {
    private final ProfissionalRepository repo = new ProfissionalRepository();

    public void cadastrar(String nome, String telefone, String email) {
        Profissional p = new Profissional(nome, telefone, email);
        repo.salvar(p);
    }

    public List<Profissional> listar() {
        return repo.listarTodos();
    }
}
