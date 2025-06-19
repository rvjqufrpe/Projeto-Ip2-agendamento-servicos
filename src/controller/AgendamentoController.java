package controller;

import model.Agendamento;
import model.Cliente;
import model.Servico;
import repository.AgendamentoRepository;

import java.time.LocalDateTime;
import java.util.List;

public class AgendamentoController {
    private final AgendamentoRepository repo = new AgendamentoRepository();

    public void agendar(LocalDateTime dataHora, int duracao, Cliente cliente, Servico servico) {
        Agendamento agendamento = new Agendamento(dataHora, duracao, cliente, servico);
        repo.salvar(agendamento);
    }

    public List<Agendamento> listar() {
        return repo.listarTodos();
    }
}

