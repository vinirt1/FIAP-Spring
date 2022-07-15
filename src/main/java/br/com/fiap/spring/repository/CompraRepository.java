package br.com.fiap.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.spring.model.entity.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {
}
