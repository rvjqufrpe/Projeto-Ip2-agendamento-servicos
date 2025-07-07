package repository;

import model.Servico;

import java.util.ArrayList;
import java.util.List;

public class ServicoRepository {
    private static ServicoRepository instance;

    private final List<Servico> servicos = new ArrayList<>();

    private ServicoRepository() {
    }

    public static synchronized ServicoRepository getInstance() {
        if (instance == null) {
            instance = new ServicoRepository();
        }
        return instance;
    }

    public void salvar(Servico servico) {
        servicos.add(servico);
    }

    public List<Servico> listarTodos() {
        return servicos;
    }

    public void remover(String nome) {
        servicos.removeIf(s -> s.getNome().equalsIgnoreCase(nome));
    }
}

