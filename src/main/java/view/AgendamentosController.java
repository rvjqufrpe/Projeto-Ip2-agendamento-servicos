package view;

import controller.AgendamentoController;
import controller.ClienteController;
import controller.ServicoController;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Agendamento;
import model.Cliente;
import model.Servico;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDateTime;
import java.util.List;

public class AgendamentosController {

    @FXML private ComboBox<Cliente> comboClientes;
    @FXML private ComboBox<Servico> comboServicos;
    @FXML private TextField duracaoField;
    @FXML private TextField dataHoraField;
    @FXML private Button btnAgendar;
    @FXML private Button btnRemover;

    @FXML private TableView<Agendamento> tabelaAgendamentos;
    @FXML private TableColumn<Agendamento, String> colCliente;
    @FXML private TableColumn<Agendamento, String> colServico;
    @FXML private TableColumn<Agendamento, String> colDataHora;

    private final ClienteController clienteController = new ClienteController();
    private final ServicoController servicoController = new ServicoController();
    private final AgendamentoController agendamentoController = new AgendamentoController();

    @FXML
    public void initialize() {
        comboClientes.setItems(FXCollections.observableArrayList(clienteController.listarClientes()));
        comboServicos.setItems(FXCollections.observableArrayList(servicoController.listar()));

        colCliente.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getCliente().getNome()));
        colServico.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getServico().getNome()));
        colDataHora.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDataHora().toString()));

        atualizarTabela();

        btnAgendar.setOnAction(e -> agendar());
        btnRemover.setOnAction(e -> removerSelecionado());
    }

    private void agendar() {
        Cliente cliente = comboClientes.getValue();
        Servico servico = comboServicos.getValue();

        try {
            int duracao = Integer.parseInt(duracaoField.getText());
            LocalDateTime dataHora = LocalDateTime.parse(dataHoraField.getText());

            if (cliente != null && servico != null && duracao > 0) {
                agendamentoController.agendar(dataHora, duracao, cliente, servico);
                atualizarTabela();
                limparCampos();
            } else {
                mostrarAlerta("Campos obrigatórios faltando.");
            }

        } catch (Exception e) {
            mostrarAlerta("Erro: verifique os campos. Ex: data no formato 2025-07-10T14:30");
        }
    }

    private void atualizarTabela() {
        List<Agendamento> agendamentos = agendamentoController.listar();
        ObservableList<Agendamento> obs = FXCollections.observableArrayList(agendamentos);
        tabelaAgendamentos.setItems(obs);
    }

    private void limparCampos() {
        duracaoField.clear();
        dataHoraField.clear();
        comboClientes.getSelectionModel().clearSelection();
        comboServicos.getSelectionModel().clearSelection();
    }

    private void removerSelecionado() {
    //     Agendamento selecionado = tabelaAgendamentos.getSelectionModel().getSelectedItem();
    //     if (selecionado != null) {
    //         agendamentoController.remover(selecionado.get);
    //         atualizarTabela();
    //     }
    }

    private void mostrarAlerta(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText(msg);
        alert.show();
    }
}
