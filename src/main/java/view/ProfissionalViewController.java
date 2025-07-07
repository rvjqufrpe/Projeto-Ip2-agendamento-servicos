package view;

import controller.ProfissionalController;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Profissional;

import java.util.List;

public class ProfissionalViewController {

    @FXML private TextField nomeField;
    @FXML private TextField telefoneField;
    @FXML private TextField emailField;
    @FXML private Button btnCadastrar;
    @FXML private TableView<Profissional> tabelaProfissionais;
    @FXML private TableColumn<Profissional, String> colNome;
    @FXML private TableColumn<Profissional, String> colTelefone;
    @FXML private TableColumn<Profissional, String> colEmail;
    @FXML private Button btnRemover;

    private final ProfissionalController profissionalController = new ProfissionalController();

    @FXML
    public void initialize() {
        colNome.setCellValueFactory(p -> new javafx.beans.property.SimpleStringProperty(p.getValue().getNome()));
        colTelefone.setCellValueFactory(p -> new javafx.beans.property.SimpleStringProperty(p.getValue().getTelefone()));
        colEmail.setCellValueFactory(p -> new javafx.beans.property.SimpleStringProperty(p.getValue().getEmail()));

        atualizarTabela();

        btnCadastrar.setOnAction(e -> cadastrarProfissional());
        btnRemover.setOnAction(e -> removerSelecionado());
    }

    private void atualizarTabela() {
        List<Profissional> lista = profissionalController.listar();
        tabelaProfissionais.setItems(FXCollections.observableArrayList(lista));
    }

    private void cadastrarProfissional() {
        String nome = nomeField.getText().trim();
        String telefone = telefoneField.getText().trim();
        String email = emailField.getText().trim();

        if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty()) {
            mostrarAlerta("Erro", "Todos os campos são obrigatórios.");
            return;
        }

        profissionalController.cadastrar(nome, telefone, email);
        mostrarAlerta("Sucesso", "Profissional cadastrado.");

        nomeField.clear();
        telefoneField.clear();
        emailField.clear();

        atualizarTabela();
    }

    private void removerSelecionado() {
        Profissional selecionado = tabelaProfissionais.getSelectionModel().getSelectedItem();
        if (selecionado == null) {
            mostrarAlerta("Aviso", "Selecione um profissional para remover.");
            return;
        }

        profissionalController.remover(selecionado.getNome());
        mostrarAlerta("Sucesso", "Profissional removido.");
        atualizarTabela();
    }

    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
