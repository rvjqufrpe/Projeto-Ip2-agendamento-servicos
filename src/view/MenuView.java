package view;

import controller.ProfissionalController;
import controller.ServicoController;
import controller.AgendamentoController;
import controller.ClienteController;

import model.Cliente;
import model.Servico;
import model.Profissional;

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
        int opcao = -1;
        do {
            System.out.println("\n======= MENU PRINCIPAL =======");
            System.out.println("1. Gerenciar Clientes");
            System.out.println("2. Gerenciar Profissionais");
            System.out.println("3. Gerenciar Serviços");
            System.out.println("4. Agendamentos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao) {
                    case 1 -> menuClientes();
                    case 2 -> menuProfissionais();
                    case 3 -> menuServicos();
                    case 4 -> menuAgendamentos();
                    case 0 -> System.out.println("Encerrando o sistema...");
                    default -> System.out.println("Opção inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número entre 0 e 4.");
            }
        } while (opcao != 0);
    }


    private void menuClientes() {
        int opcao = -1;
        do {
            System.out.println("\n--- CLIENTES ---");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Remover Cliente");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao) {
                    case 1 -> cadastrarCliente();
                    case 2 -> listarClientes();
                    case 3 -> removerCliente();
                    case 0 -> {}
                    default -> System.out.println("Opção inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número entre 0 e 3.");
            }
        } while (opcao != 0);
    }


    private void menuProfissionais() {
        int opcao = -1;
        do {
            System.out.println("\n--- PROFISSIONAIS ---");
            System.out.println("1. Cadastrar Profissional");
            System.out.println("2. Listar Profissionais");
            System.out.println("3. Remover Profissional");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao) {
                    case 1 -> cadastrarProfissional();
                    case 2 -> listarProfissionais();
                    case 3 -> removerProfissional();
                    case 0 -> {}
                    default -> System.out.println("Opção inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número entre 0 e 3.");
            }
        } while (opcao != 0);
    }


    private void menuServicos() {
        int opcao = -1;
        do {
            System.out.println("\n--- SERVIÇOS ---");
            System.out.println("1. Cadastrar Serviço");
            System.out.println("2. Listar Serviços");
            System.out.println("3. Remover Serviço");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao) {
                    case 1 -> cadastrarServico();
                    case 2 -> listarServicos();
                    case 3 -> removerServico();
                    case 0 -> {}
                    default -> System.out.println("Opção inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número entre 0 e 3.");
            }
        } while (opcao != 0);
    }


    private void menuAgendamentos() {
        int opcao = -1;
        do {
            System.out.println("\n--- AGENDAMENTOS ---");
            System.out.println("1. Agendar Serviço");
            System.out.println("2. Listar Agendamentos");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");

            try {
                String input = scanner.nextLine();
                opcao = Integer.parseInt(input);

                switch (opcao) {
                    case 1 -> agendarServico();
                    case 2 -> listarAgendamentos();
                    case 0 -> System.out.println("Retornando ao menu principal...");
                    default -> System.out.println("Opção inválida. Tente novamente.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número (0 a 2).");
            }

        } while (opcao != 0);
    }

    // === Métodos Clientes ===
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
            clientes.forEach(c ->
                System.out.println("ID: " + c.getIdCliente() + " | Nome: " + c.getNome())
            );
        }
    }

    private void removerCliente() {
        listarClientes();
        System.out.print("Informe o ID do cliente a remover: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        clienteController.removerCliente(id);
        System.out.println("Cliente removido.");
    }

    // === Métodos Profissionais ===
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

    private void listarProfissionais() {
        List<Profissional> profissionais = profissionalController.listar();
        if (profissionais.isEmpty()) {
            System.out.println("Nenhum profissional cadastrado.");
        } else {
            profissionais.forEach(p ->
                System.out.println("Nome: " + p.getNome() + " | Telefone: " + p.getTelefone())
            );
        }
    }

    private void removerProfissional() {
        listarProfissionais();
        System.out.print("Digite o nome do profissional a remover: ");
        String nome = scanner.nextLine();
        profissionalController.remover(nome);
        System.out.println("Profissional removido.");
    }

    // === Métodos Serviços ===
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

    private void listarServicos() {
        List<Servico> servicos = servicoController.listar();
        if (servicos.isEmpty()) {
            System.out.println("Nenhum serviço cadastrado.");
        } else {
            for (int i = 0; i < servicos.size(); i++) {
                System.out.println((i + 1) + ". " + servicos.get(i));
            }
        }
    }

    private void removerServico() {
        listarServicos();
        System.out.print("Informe o nome do serviço a remover: ");
        String nome = scanner.nextLine();
        servicoController.remover(nome);
        System.out.println("Serviço removido.");
    }

    // === Métodos Agendamentos ===
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

        int clienteIndex = -1;
        while (true) {
            System.out.print("Escolha o cliente (número): ");
            if (scanner.hasNextInt()) {
                clienteIndex = scanner.nextInt() - 1;
                scanner.nextLine(); // limpar buffer
                if (clienteIndex >= 0 && clienteIndex < clientes.size()) break;
            } else {
                scanner.nextLine(); // descartar entrada inválida
            }
            System.out.println("Entrada inválida. Tente novamente.");
        }
        Cliente clienteSelecionado = clientes.get(clienteIndex);

        System.out.println("Serviços disponíveis:");
        for (int i = 0; i < servicos.size(); i++) {
            System.out.println((i + 1) + ". " + servicos.get(i));
        }

        int servicoIndex = -1;
        while (true) {
            System.out.print("Escolha um serviço (número): ");
            if (scanner.hasNextInt()) {
                servicoIndex = scanner.nextInt() - 1;
                scanner.nextLine(); // limpar buffer
                if (servicoIndex >= 0 && servicoIndex < servicos.size()) break;
            } else {
                scanner.nextLine(); // descartar
            }
            System.out.println("Entrada inválida. Tente novamente.");
        }
        Servico servicoSelecionado = servicos.get(servicoIndex);

        int duracao = 0;
        while (true) {
            System.out.print("Informe a duração (em minutos): ");
            if (scanner.hasNextInt()) {
                duracao = scanner.nextInt();
                scanner.nextLine();
                if (duracao > 0) break;
            } else {
                scanner.nextLine();
            }
            System.out.println("Duração inválida. Informe um número positivo.");
        }

        LocalDateTime dataHora = null;
        while (true) {
            System.out.print("Data e hora (formato: AAAA-MM-DDTHH:MM Ex: 2025-07-01T14:00): ");
            String dataHoraStr = scanner.nextLine();
            try {
                dataHora = LocalDateTime.parse(dataHoraStr);
                if (dataHora.isBefore(LocalDateTime.now())) {
                    System.out.println("A data não pode estar no passado.");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Formato inválido. Exemplo válido: 2025-07-01T14:00");
            }
        }

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
