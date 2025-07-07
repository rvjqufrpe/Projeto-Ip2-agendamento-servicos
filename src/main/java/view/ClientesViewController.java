package view;

import controller.ClienteController;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import model.Cliente;

import java.util.List;

public class ClientesViewController {

    @FXML
    private TextField nomeField;

    @FXML
    private TextField telefoneField;

    @FXML
    private TextField emailField;

    @FXML
    private Button btnCadastrar;

    @FXML
    private TableView<Cliente> tabelaClientes;

    @FXML
    private TableColumn<Cliente, String> colNome;

    @FXML
    private TableColumn<Cliente, String> colTelefone;

    @FXML
    private TableColumn<Cliente, String> colEmail;

    @FXML
    private Button btnRemover;

    private final ClienteController clienteController = new ClienteController();

    @FXML
    public void initialize() {
        // Configura as colunas da tabela
        colNome.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNome()));
        colTelefone.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getTelefone()));
        colEmail.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getEmail()));

        atualizarListaClientes();

        btnCadastrar.setOnAction(e -> cadastrarCliente());
        btnRemover.setOnAction(e -> removerClienteSelecionado());
    }

    private void atualizarListaClientes() {
        List<Cliente> clientes = clienteController.listarClientes();
        tabelaClientes.setItems(FXCollections.observableArrayList(clientes));
    }

    private void cadastrarCliente() {
        String nome = nomeField.getText().trim();
        String telefone = telefoneField.getText().trim();
        String email = emailField.getText().trim();

        if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty()) {
            alert("Erro", "Por favor preencha todos os campos.");
            return;
        }

        clienteController.cadastrarCliente(nome, telefone, email);
        alert("Sucesso", "Cliente cadastrado com sucesso!");

        // Limpa os campos
        nomeField.clear();
        telefoneField.clear();
        emailField.clear();

        atualizarListaClientes();
    }

    private void removerClienteSelecionado() {
        Cliente selecionado = tabelaClientes.getSelectionModel().getSelectedItem();
        if (selecionado == null) {
            alert("Aviso", "Selecione um cliente para remover.");
            return;
        }

        clienteController.removerCliente(selecionado.getIdCliente());
        alert("Sucesso", "Cliente removido.");

        atualizarListaClientes();
    }

    private void alert(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
