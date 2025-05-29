package models;

import java.time.LocalDateTime;

public class Agendamento {

    private LocalDateTime dataHora; 
    private int duracao;
    private StatusAgendamento status;
    private String motivoCancelamento;

    private Cliente cliente;
    private Servico servico;
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
        this.atendimento = null;
    }

    public void registrarAtendimento(int idAtendimento) {
        if (this.atendimento == null && this.status == StatusAgendamento.AGENDADO) {
            this.atendimento = new Atendimento(idAtendimento, this);
            this.status = StatusAgendamento.ACONTECENDO;
        }
    }

    public LocalDateTime dataSolicitacaoAgendamento() {
        return this.dataHora;
    }

    public LocalDateTime dataRealizacaoAtendimento() {
        if (this.status == StatusAgendamento.CONCLUIDO && this.atendimento != null) {
            return this.dataHora;
        }
        return null;
    }

    public void cancelar(String motivo) {
        if (this.status == StatusAgendamento.AGENDADO || this.status == StatusAgendamento.ACONTECENDO) {
            this.status = StatusAgendamento.CANCELADO;
            this.motivoCancelamento = motivo;
        }
    }

    public void concluirAtendimento() {
        if (this.status == StatusAgendamento.ACONTECENDO) {
            this.status = StatusAgendamento.CONCLUIDO;
        }
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

    public Atendimento getAtendimento() {
        return atendimento;
    }
}
