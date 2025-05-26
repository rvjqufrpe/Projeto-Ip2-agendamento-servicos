package models;

public class Especialidade {
    private String especialidade;
    private String descricao;

    public Especialidade() {}

    public Especialidade(String especialidade, String descricao) {
        this.especialidade = especialidade;
        this.descricao = descricao;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return especialidade + " - " + descricao;
    }
}
