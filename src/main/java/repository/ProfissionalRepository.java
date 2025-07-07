package repository;

import model.Profissional;
import java.util.ArrayList;
import java.util.List;

public class ProfissionalRepository {
    private static ProfissionalRepository instance;

    private final List<Profissional> profissionais = new ArrayList<>();

    private ProfissionalRepository() {
    }

    public static synchronized ProfissionalRepository getInstance() {
        if (instance == null) {
            instance = new ProfissionalRepository();
        }
        return instance;
    }

    public void salvar(Profissional profissional) {
        profissionais.add(profissional);
    }

    public List<Profissional> listarTodos() {
        return profissionais;
    }

    public void remover(String nome) {
        profissionais.removeIf(p -> p.getNome().equalsIgnoreCase(nome));
    }
}



