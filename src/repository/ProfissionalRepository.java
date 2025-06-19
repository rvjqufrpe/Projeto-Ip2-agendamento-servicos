package repository;

import model.Profissional;
import java.util.ArrayList;
import java.util.List;

public class ProfissionalRepository {
    private final List<Profissional> profissionais = new ArrayList<>();

    public void salvar(Profissional profissional) {
        profissionais.add(profissional);
    }

    public List<Profissional> listarTodos() {
        return profissionais;
    }
}


