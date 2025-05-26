package models;

public class Atendimento {
    private int idAtendimento;
    private String dataInicio;
    private String dataTermino;
    private String observacoes;
    private Agendamento agendamento;

    public Atendimento(int idAtendimento, Agendamento agendamento) {
        this.idAtendimento = idAtendimento;
        this.agendamento = agendamento;
        this.observacoes = "";
        this.dataInicio = null;
        this.dataTermino = null;
    }

    public void registraInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void registrarTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }

    public void adicionarObservacoes(String obs) {
        if (this.observacoes.isEmpty()) {
            this.observacoes = obs;
        } else {
            this.observacoes += "\n" + obs;
        }
    }

    public int getIdAtendimento() {
        return idAtendimento;
    }

    public void setIdAtendimento(int idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }
}
