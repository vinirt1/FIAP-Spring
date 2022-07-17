package br.com.fiap.spring.model.dto;

import br.com.fiap.spring.model.entity.Aluno;

public class AlunoDTO {

    private Long id;

    private Integer matricula;

    private String nome;

    private String turma;

    public AlunoDTO() {
    }

    public AlunoDTO(Long id, Integer matricula, String nome, String turma) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.turma = turma;
    }

    public AlunoDTO(Aluno aluno) {
        this.id = aluno.getId();
        this.matricula = aluno.getMatricula();
        this.nome = aluno.getNome();
        this.turma = aluno.getTurma();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
