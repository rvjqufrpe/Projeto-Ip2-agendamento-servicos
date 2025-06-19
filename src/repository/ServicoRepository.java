package repository;

import model.Servico;
import java.util.ArrayList;
import java.util.List;

public class ServicoRepository {
    private final List<Servico> servicos = new ArrayList<>();

    public void salvar(Servico servico) {
        servicos.add(servico);
    }

    public List<Servico> listarTodos() {
        return servicos;
    }
}
