package view;

import controller.ClienteController;
import model.Cliente;

import java.util.Scanner;

public class ClienteView {
    private final ClienteController controller = new ClienteController();
    private final Scanner scanner = new Scanner(System.in);

    public void menu() {
        int opcao = 0;
        do {
            System.out.println("== MENU CLIENTE ==");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1 -> cadastrar();
                case 2 -> listar();
            }
        } while (opcao != 3);
    }

    private void cadastrar() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        controller.cadastrarCliente(nome, telefone, email);
        System.out.println("Cliente cadastrado!");
    }

    private void listar() {
        for (Cliente c : controller.listarClientes()) {
            System.out.println("ID: " + c.getIdCliente() + " | Nome: " + c.getNome());
        }
    }
}
