package repository;

import model.Agendamento;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoRepository {
    private static AgendamentoRepository instance;

    private final List<Agendamento> agendamentos = new ArrayList<>();

    private AgendamentoRepository() {
    }

    public static synchronized AgendamentoRepository getInstance() {
        if (instance == null) {
            instance = new AgendamentoRepository();
        }
        return instance;
    }

    public void salvar(Agendamento agendamento) {
        agendamentos.add(agendamento);
    }

    public List<Agendamento> listarTodos() {
        return agendamentos;
    }

    public void remover(Agendamento agendamento) {
        agendamentos.remove(agendamento);
    }
}

