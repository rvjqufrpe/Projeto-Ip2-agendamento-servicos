package controller;

import model.Servico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ServicoController {
    private final List<Servico> servicos = new ArrayList<>();

    public void cadastrar(String nome, String descricao, double preco) {
        Servico s = new Servico(nome, descricao, preco);
        servicos.add(s);
    }

    public List<Servico> listar() {
        return servicos;
    }

    public void remover(String nome) {
        Iterator<Servico> iterator = servicos.iterator();
        while (iterator.hasNext()) {
            Servico s = iterator.next();
            if (s.getNome().equalsIgnoreCase(nome)) {
                iterator.remove();
                break;
            }
        }
    }
}
