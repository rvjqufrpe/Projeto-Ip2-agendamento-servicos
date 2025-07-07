package view;

import controller.*;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import model.*;

import java.io.IOException;

public class MainViewController {

    // Tabelas Clientes
    @FXML private TableView<Cliente> tabelaClientes;
    @FXML private TableColumn<Cliente, String> colClienteNome;
    @FXML private TableColumn<Cliente, String> colClienteTelefone;
    @FXML private TableColumn<Cliente, String> colClienteEmail;

    // Tabelas Profissionais
    @FXML private TableView<Profissional> tabelaProfissionais;
    @FXML private TableColumn<Profissional, String> colProfNome;
    @FXML private TableColumn<Profissional, String> colProfTelefone;
    @FXML private TableColumn<Profissional, String> colProfEmail;

    // Tabelas Serviços
    @FXML private TableView<Servico> tabelaServicos;
    @FXML private TableColumn<Servico, String> colServicoNome;
    @FXML private TableColumn<Servico, String> colServicoDescricao;
    @FXML private TableColumn<Servico, Double> colServicoPreco;

    // Tabelas Agendamentos
    @FXML private TableView<Agendamento> tabelaAgendamentos;
    @FXML private TableColumn<Agendamento, String> colAgendamentoCliente;
    @FXML private TableColumn<Agendamento, String> colAgendamentoServico;
    @FXML private TableColumn<Agendamento, String> colAgendamentoDataHora;

    private final ClienteController clienteController = new ClienteController();
    private final ProfissionalController profissionalController = new ProfissionalController();
    private final ServicoController servicoController = new ServicoController();
    private final AgendamentoController agendamentoController = new AgendamentoController();

    // ObservableLists para ligação com as tabelas
    private ObservableList<Cliente> clientesObsList = FXCollections.observableArrayList();
    private ObservableList<Profissional> profissionaisObsList = FXCollections.observableArrayList();
    private ObservableList<Servico> servicosObsList = FXCollections.observableArrayList();
    private ObservableList<Agendamento> agendamentosObsList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Configurar colunas Clientes
        colClienteNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colClienteTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        colClienteEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        // Configurar colunas Profissionais
        colProfNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colProfTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        colProfEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        // Configurar colunas Serviços
        colServicoNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colServicoDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        colServicoPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));

        // Configurar colunas Agendamentos
        colAgendamentoCliente.setCellValueFactory(data ->
            new ReadOnlyStringWrapper(data.getValue().getCliente().getNome()));
        colAgendamentoServico.setCellValueFactory(data ->
            new ReadOnlyStringWrapper(data.getValue().getServico().getNome()));
        colAgendamentoDataHora.setCellValueFactory(data ->
            new ReadOnlyStringWrapper(data.getValue().getDataHora().toString()));

        // Link ObservableLists às tabelas
        tabelaClientes.setItems(clientesObsList);
        tabelaProfissionais.setItems(profissionaisObsList);
        tabelaServicos.setItems(servicosObsList);
        tabelaAgendamentos.setItems(agendamentosObsList);

        // Carregar dados iniciais
        carregarDados();
    }

    public void carregarDados() {
        clientesObsList.setAll(clienteController.listarClientes());
        profissionaisObsList.setAll(profissionalController.listar());
        servicosObsList.setAll(servicoController.listar());
        agendamentosObsList.setAll(agendamentoController.listar());
    }

    @FXML
    public void abrirClientes() {
        abrirJanelaModal("/view/ClienteView.fxml", "Gerenciar Clientes");
    }

    @FXML
    public void abrirProfissionais() {
        abrirJanelaModal("/view/ProfissionalView.fxml", "Gerenciar Profissionais");
    }

    @FXML
    public void abrirServicos() {
        abrirJanelaModal("/view/ServicoView.fxml", "Gerenciar Serviços");
    }

    @FXML
    public void abrirAgendamentos() {
        abrirJanelaModal("/view/AgendamentoView.fxml", "Gerenciar Agendamentos");
    }

    /**
     * Abre janela modal e aguarda fechar para atualizar tabelas
     */
    private void abrirJanelaModal(String caminhoFXML, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(caminhoFXML));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);  // Faz a janela modal
            stage.showAndWait();  // Espera fechar

            // Atualiza tabelas quando fechar a janela
            carregarDados();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
