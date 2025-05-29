import java.time.LocalDateTime;

import models.Agendamento;
import models.Atendimento;
import models.Cliente;
import models.Servico;

public class Main {
    public static void main(String[] args) {

        // Criando cliente e serviço
        Cliente cliente = new Cliente("Maria Silva", "11987654321", "maria@email.com", 1);
        Servico servico = new Servico("Consulta Médica", "Consulta geral com clínico", 200.00);

        // Criando o agendamento
        LocalDateTime dataAgendamento = LocalDateTime.now().plusDays(3).withHour(14).withMinute(30);
        Agendamento agendamento = new Agendamento(dataAgendamento, 60, cliente, servico);

        // Registrando o atendimento
        agendamento.registrarAtendimento(1); // ID do atendimento
        Atendimento atendimento = agendamento.getAtendimento();

        // Simulando início e término do atendimento
        LocalDateTime dataInicio = dataAgendamento.plusDays(1); // simulação
        LocalDateTime dataTermino = dataInicio.plusMinutes(45);

        atendimento.registraInicio(dataInicio.toString());
        atendimento.adicionarObservacoes("Paciente chegou pontualmente.");

        agendamento.concluirAtendimento();

        atendimento.registrarTermino(dataTermino.toString());
        atendimento.adicionarObservacoes("Atendimento realizado com sucesso.");

        // Exibindo os detalhes
        System.out.println("=== Detalhes do Agendamento ===");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Serviço: " + servico.getNome());
        System.out.println("Data/Hora do Agendamento: " + agendamento.getDataHora());
        System.out.println("Duração: " + agendamento.getDuracao() + " minutos");
        System.out.println("Status do Agendamento: " + agendamento.getStatus());

        System.out.println("\n=== Detalhes do Atendimento ===");
        System.out.println("Início: " + atendimento.getDataInicio());
        System.out.println("Término: " + atendimento.getDataTermino());
        System.out.println("Observações: " + atendimento.getObservacoes());
    }
}

