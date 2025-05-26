import java.time.LocalDateTime;

import models.Agendamento;
import models.Atendimento;
import models.Cliente;
import models.HistoricoAgendamento;
import models.Servico;

public class Main {
    public static void main(String[] args) {

        // Criar Cliente
        Cliente cliente = new Cliente("Maria Silva", "11987654321", "maria@email.com", 1);

        // Criar Serviço
        Servico servico = new Servico("Consulta Médica", "Consulta geral com clínico", 200.00);
        servico.cadastrar();

        // Criar Agendamento
        LocalDateTime dataAgendamento = LocalDateTime.now().plusDays(3).withHour(14).withMinute(30);
        Agendamento agendamento = new Agendamento(dataAgendamento, 60, cliente, servico);
        agendamento.agendar();

        // Alterar agendamento
        LocalDateTime novaData = dataAgendamento.plusDays(1);
        agendamento.alterar(novaData, 45);

        // Criar Atendimento para o agendamento
        agendamento.criarAtendimento(101);

        // Iniciar atendimento
        agendamento.iniciarAtendimento();
        agendamento.getAtendimento().registraInicio(novaData.toString());
        agendamento.getAtendimento().adicionarObservacoes("Paciente chegou pontualmente.");

        // Concluir atendimento
        agendamento.concluirAtendimento();
        agendamento.getAtendimento().registrarTermino(novaData.plusMinutes(45).toString());
        agendamento.getAtendimento().adicionarObservacoes("Atendimento realizado com sucesso.");

        // Imprimir informações
        System.out.println("=== Detalhes do Agendamento ===");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Serviço: " + servico.getNome());
        System.out.println("Data/Hora: " + agendamento.getDataHora());
        System.out.println("Duração: " + agendamento.getDuracao() + " minutos");
        System.out.println("Status do agendamento: " + agendamento.getStatus());

        System.out.println("\n=== Histórico do Agendamento ===");
        for (HistoricoAgendamento h : agendamento.getHistoricos()) {
            System.out.println(h);
        }

        System.out.println("\n=== Detalhes do Atendimento ===");
        Atendimento atendimento = agendamento.getAtendimento();
        System.out.println("Início: " + atendimento.getDataInicio());
        System.out.println("Término: " + atendimento.getDataTermino());
        System.out.println("Observações: " + atendimento.getObservacoes());
    }
}
