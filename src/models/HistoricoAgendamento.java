package models;

public class HistoricoAgendamento {
    private String dataAlteracao;
    private String servicoAlteracao;
    private String clienteResponsavel;

    public HistoricoAgendamento(String dataAlteracao, String servicoAlteracao, String clienteResponsavel) {
        this.dataAlteracao = dataAlteracao;
        this.servicoAlteracao = servicoAlteracao;
        this.clienteResponsavel = clienteResponsavel;
    }

    public String getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(String dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public String getServicoAlteracao() {
        return servicoAlteracao;
    }

    public void setServicoAlteracao(String servicoAlteracao) {
        this.servicoAlteracao = servicoAlteracao;
    }

    public String getClienteResponsavel() {
        return clienteResponsavel;
    }

    public void setClienteResponsavel(String clienteResponsavel) {
        this.clienteResponsavel = clienteResponsavel;
    }

    @Override
    public String toString() {
        return "Data: " + dataAlteracao + ", Serviço: " + servicoAlteracao + ", Cliente Responsável: " + clienteResponsavel;
    }
}

