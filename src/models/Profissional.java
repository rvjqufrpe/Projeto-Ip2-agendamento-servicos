package models;

import java.util.ArrayList;
import java.util.List;

public class Profissional extends Pessoa {
    private List<Especialidade> especialidades;

    public Profissional() {
        super();
        this.especialidades = new ArrayList<>();
    }

    public Profissional(String nome, int telefone, String email) {
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

    public String verificarAgenda() {
        return "Agenda do profissional: livre de 8h às 12h.";
    }

    public boolean cancelarServico() {
        return true;
    }

    public List<Especialidade> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidade> especialidades) {
        this.especialidades = especialidades;
    }
}

