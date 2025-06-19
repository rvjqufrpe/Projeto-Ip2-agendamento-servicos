package repository;

import model.Agendamento;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoRepository {
    private final List<Agendamento> agendamentos = new ArrayList<>();

    public void salvar(Agendamento agendamento) {
        agendamentos.add(agendamento);
    }

    public List<Agendamento> listarTodos() {
        return agendamentos;
    }
}
