package controller;

import model.Profissional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProfissionalController {
    private final List<Profissional> profissionais = new ArrayList<>();

    public void cadastrar(String nome, String telefone, String email) {
        Profissional p = new Profissional(nome, telefone, email);
        profissionais.add(p);
    }

    public List<Profissional> listar() {
        return profissionais;
    }

    public void remover(String nome) {
        Iterator<Profissional> iterator = profissionais.iterator();
        while (iterator.hasNext()) {
            Profissional p = iterator.next();
            if (p.getNome().equalsIgnoreCase(nome)) {
                iterator.remove();
                break;
            }
        }
    }
}
