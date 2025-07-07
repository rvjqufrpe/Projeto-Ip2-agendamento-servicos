package controller;

import model.Agendamento;
import model.Cliente;
import model.Servico;
import repository.AgendamentoRepository;

import java.time.LocalDateTime;
import java.util.List;

public class AgendamentoController {
    private final AgendamentoRepository agendamentoRepo;

    public AgendamentoController() {
        this.agendamentoRepo = AgendamentoRepository.getInstance();
    }

    public void agendar(LocalDateTime dataHora, int duracao, Cliente cliente, Servico servico) {
        Agendamento agendamento = new Agendamento(dataHora, duracao, cliente, servico);
        agendamentoRepo.salvar(agendamento);
    }

    public List<Agendamento> listar() {
        return agendamentoRepo.listarTodos();
    }
}


