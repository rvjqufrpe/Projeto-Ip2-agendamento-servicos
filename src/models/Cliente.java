package models;

public class Cliente extends Pessoa {
    private int idCliente;
    private StatusCliente status;

    public enum StatusCliente {
        ATIVO,
        INATIVO,
        BLOQUEADO
    }

    public Cliente() {
        super();
        this.status = StatusCliente.ATIVO;
    }

    public Cliente(String nome, String telefone, String email, int idCliente) {
        super(nome, telefone, email);
        this.idCliente = idCliente;
        this.status = StatusCliente.ATIVO;
    }


    public boolean cancelarServico() {
        return true;
    }

    public String acompanharServico() {
        return "Serviço agendado para amanhã às 14h.";
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public StatusCliente getStatus() {
        return status;
    }

    public void setStatus(StatusCliente status) {
        this.status = status;
    }
}
