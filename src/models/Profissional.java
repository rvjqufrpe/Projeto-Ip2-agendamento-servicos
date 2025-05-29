package models;

import java.util.ArrayList;
import java.util.List;

public class Profissional extends Pessoa {
    private List<Especialidade> especialidades;

    public Profissional() {
        super();
        this.especialidades = new ArrayList<>();
    }

    public Profissional(String nome, String telefone, String email) {
        super(nome, telefone, email);
        this.especialidades = new ArrayList<>();
    }

    public void adicionarEspecialidade(Especialidade especialidade) {
        if (!especialidades.contains(especialidade)) {
            especialidades.add(especialidade);
        }
    }

    public void removerEspecialidade(String nomeEspecialidade) {
        especialidades.removeIf(e -> e.getEspecialidade().equalsIgnoreCase(nomeEspecialidade));
    }

    public List<Especialidade> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidade> especialidades) {
        this.especialidades = especialidades;
    }
}

