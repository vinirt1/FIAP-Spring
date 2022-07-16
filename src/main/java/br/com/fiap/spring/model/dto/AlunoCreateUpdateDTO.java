package br.com.fiap.spring.model.dto;

import br.com.fiap.spring.model.entity.Aluno;

public class AlunoCreateUpdateDTO {

    private Integer matricula;

    private String nome;

    private String turma;

    public AlunoCreateUpdateDTO(Integer matricula, String nome, String turma) {
        this.matricula = matricula;
        this.nome = nome;
        this.turma = turma;
    }

    public AlunoCreateUpdateDTO(Aluno aluno) {
        this.matricula = aluno.getMatricula();
        this.nome = aluno.getNome();
        this.turma = aluno.getTurma();
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

}
