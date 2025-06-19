package view;

import controller.ProfissionalController;
import controller.ServicoController;
import controller.AgendamentoController;
import controller.ClienteController;

import model.Cliente;
import model.Servico;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class MenuView {
    private final Scanner scanner = new Scanner(System.in);
    private final ProfissionalController profissionalController = new ProfissionalController();
    private final ServicoController servicoController = new ServicoController();
    private final AgendamentoController agendamentoController = new AgendamentoController();
    private final ClienteController clienteController = new ClienteController();

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Cadastrar Profissional");
            System.out.println("4. Cadastrar Serviço");
            System.out.println("5. Agendar Serviço");
            System.out.println("6. Listar Agendamentos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1 -> cadastrarCliente();
                case 2 -> listarClientes();
                case 3 -> cadastrarProfissional();
                case 4 -> cadastrarServico();
                case 5 -> agendarServico();
                case 6 -> listarAgendamentos();
            }

        } while (opcao != 0);
    }

    private void cadastrarCliente() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        clienteController.cadastrarCliente(nome, telefone, email);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private void listarClientes() {
        List<Cliente> clientes = clienteController.listarClientes();
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (Cliente c : clientes) {
                System.out.println("ID: " + c.getIdCliente() + " | Nome: " + c.getNome());
            }
        }
    }

    private void cadastrarProfissional() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        profissionalController.cadastrar(nome, telefone, email);
        System.out.println("Profissional cadastrado!");
    }

    private void cadastrarServico() {
        System.out.print("Nome do serviço: ");
        String nome = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        servicoController.cadastrar(nome, descricao, preco);
        System.out.println("Serviço cadastrado!");
    }

    private void agendarServico() {
        List<Cliente> clientes = clienteController.listarClientes();
        if (clientes.isEmpty()) {
            System.out.println("Cadastre ao menos um cliente primeiro.");
            return;
        }

        List<Servico> servicos = servicoController.listar();
        if (servicos.isEmpty()) {
            System.out.println("Cadastre ao menos um serviço primeiro.");
            return;
        }

        System.out.println("Clientes disponíveis:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i).getNome());
        }

        System.out.print("Escolha o cliente (número): ");
        int clienteIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        Cliente clienteSelecionado = clientes.get(clienteIndex);

        System.out.println("Serviços disponíveis:");
        for (int i = 0; i < servicos.size(); i++) {
            System.out.println((i + 1) + ". " + servicos.get(i));
        }

        System.out.print("Escolha um serviço: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();
        Servico servicoSelecionado = servicos.get(escolha - 1);

        System.out.print("Informe a duração (em minutos): ");
        int duracao = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Data e hora (AAAA-MM-DDTHH:MM): ");
        String dataHoraStr = scanner.nextLine();
        LocalDateTime dataHora = LocalDateTime.parse(dataHoraStr);

        agendamentoController.agendar(dataHora, duracao, clienteSelecionado, servicoSelecionado);
        System.out.println("Agendamento realizado com sucesso!");
    }

    private void listarAgendamentos() {
        agendamentoController.listar().forEach(a -> {
            System.out.println("Cliente: " + a.getCliente().getNome() +
                    " | Serviço: " + a.getServico().getNome() +
                    " | Data: " + a.getDataHora());
        });
    }
}
