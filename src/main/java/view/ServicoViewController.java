package view;

import controller.ServicoController;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Servico;

import java.util.List;

public class ServicoViewController {

    @FXML private TextField nomeField;
    @FXML private TextField descricaoField;
    @FXML private TextField precoField;
    @FXML private Button btnCadastrar;
    @FXML private TableView<Servico> tabelaServicos;
    @FXML private TableColumn<Servico, String> colNome;
    @FXML private TableColumn<Servico, String> colDescricao;
    @FXML private TableColumn<Servico, String> colPreco;
    @FXML private Button btnRemover;

    private final ServicoController servicoController = new ServicoController();

    @FXML
    public void initialize() {
        colNome.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNome()));
        colDescricao.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDescricao()));
        colPreco.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(String.valueOf(data.getValue().getPreco())));

        atualizarLista();

        btnCadastrar.setOnAction(e -> cadastrarServico());
        btnRemover.setOnAction(e -> removerSelecionado());
    }

    private void atualizarLista() {
        List<Servico> servicos = servicoController.listar();
        tabelaServicos.setItems(FXCollections.observableArrayList(servicos));
    }

    private void cadastrarServico() {
        String nome = nomeField.getText().trim();
        String descricao = descricaoField.getText().trim();
        String precoText = precoField.getText().trim();

        if (nome.isEmpty() || descricao.isEmpty() || precoText.isEmpty()) {
            alert("Erro", "Preencha todos os campos.");
            return;
        }

        double preco;
        try {
            preco = Double.parseDouble(precoText);
        } catch (NumberFormatException ex) {
            alert("Erro", "Preço inválido.");
            return;
        }

        servicoController.cadastrar(nome, descricao, preco);
        alert("Sucesso", "Serviço cadastrado!");

        nomeField.clear();
        descricaoField.clear();
        precoField.clear();

        atualizarLista();
    }

    private void removerSelecionado() {
        Servico s = tabelaServicos.getSelectionModel().getSelectedItem();
        if (s == null) {
            alert("Aviso", "Selecione um serviço.");
            return;
        }

        servicoController.remover(s.getNome());
        alert("Sucesso", "Serviço removido.");

        atualizarLista();
    }

    private void alert(String titulo, String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(titulo);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }
}
