package br.com.fiap.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.spring.model.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    List<Aluno> findAllByNomeStartsWith(String nome);
}
