package br.com.fiap.spring.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.fiap.spring.model.dto.AlunoCreateUpdateDTO;

@Entity
@Table(name = "TB_ALUNO")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MATRICULA", unique = true)
    private Integer matricula;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "TURMA")
    private String turma;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "aluno")
    private List<Compra> compras = new ArrayList<Compra>();

    public Aluno() {
    }

    public Aluno(AlunoCreateUpdateDTO alunoCreateUpdateDTO) {
        this.matricula = alunoCreateUpdateDTO.getMatricula();
        this.nome = alunoCreateUpdateDTO.getNome();
        this.turma = alunoCreateUpdateDTO.getTurma();
    }

    public Aluno(Long id, Integer matricula, String nome, String turma) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.turma = turma;
    }

    public Aluno(Long id, Integer matricula, String nome, String turma, List<Compra> compras) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.turma = turma;
        this.compras = compras;
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

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

    public void adicionarCompra(Compra compra) {
        this.compras.add(compra);
    }

}
