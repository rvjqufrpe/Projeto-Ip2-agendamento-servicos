package models;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

public class Agendamento {

    private LocalDateTime dataHora;
    private int duracao; // minutos
    private StatusAgendamento status;
    private String motivoCancelamento;

    private Cliente cliente;
    private Servico servico;

    private List<HistoricoAgendamento> historicos;
    private Atendimento atendimento;

    public enum StatusAgendamento {
        AGENDADO,
        ACONTECENDO,
        CONCLUIDO,
        CANCELADO
    }

    public Agendamento(LocalDateTime dataHora, int duracao, Cliente cliente, Servico servico) {
        this.dataHora = dataHora;
        this.duracao = duracao;
        this.cliente = cliente;
        this.servico = servico;
        this.status = StatusAgendamento.AGENDADO;
        this.motivoCancelamento = "";
        this.historicos = new ArrayList<>();
        this.atendimento = null;
    }

    public void agendar() {
        this.status = StatusAgendamento.AGENDADO;
        registrarHistorico("Agendamento criado");
    }

    public void alterar(LocalDateTime novaDataHora, int novaDuracao) {
        if (this.status == StatusAgendamento.AGENDADO) {
            this.dataHora = novaDataHora;
            this.duracao = novaDuracao;
            registrarHistorico("Agendamento alterado para data: " + novaDataHora + ", duração: " + novaDuracao + " minutos");
        }
    }

    public void cancelar(String motivo) {
        this.status = StatusAgendamento.CANCELADO;
        this.motivoCancelamento = motivo;
        registrarHistorico("Agendamento cancelado. Motivo: " + motivo);
    }

    public void iniciarAtendimento() {
        if (this.status == StatusAgendamento.AGENDADO) {
            this.status = StatusAgendamento.ACONTECENDO;
            registrarHistorico("Atendimento iniciado");
        }
    }

    public void concluirAtendimento() {
        if (this.status == StatusAgendamento.ACONTECENDO) {
            this.status = StatusAgendamento.CONCLUIDO;
            registrarHistorico("Atendimento concluído");
        }
    }


    public void registrarHistorico(String servicoAlteracao) {
        String dataAlteracao = LocalDateTime.now().toString();
        String clienteResponsavel = cliente != null ? cliente.getNome() : "Desconhecido";
        HistoricoAgendamento historico = new HistoricoAgendamento(dataAlteracao, servicoAlteracao, clienteResponsavel);
        historicos.add(historico);
    }

    public List<HistoricoAgendamento> getHistoricos() {
        return historicos;
    }


    public void criarAtendimento(int idAtendimento) {
        if (this.atendimento == null) {
            this.atendimento = new Atendimento(idAtendimento, this);
            registrarHistorico("Atendimento criado com ID: " + idAtendimento);
        }
    }

    public Atendimento getAtendimento() {
        return atendimento;
    }


    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public StatusAgendamento getStatus() {
        return status;
    }

    public void setStatus(StatusAgendamento status) {
        this.status = status;
    }

    public String getMotivoCancelamento() {
        return motivoCancelamento;
    }

    public void setMotivoCancelamento(String motivoCancelamento) {
        this.motivoCancelamento = motivoCancelamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }
}

