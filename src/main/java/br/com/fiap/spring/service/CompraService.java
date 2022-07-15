package br.com.fiap.spring.service;

import java.util.List;

import br.com.fiap.spring.model.dto.CompraCreateDTO;
import br.com.fiap.spring.model.dto.CompraDTO;
import br.com.fiap.spring.model.dto.CompraValorDTO;

public interface CompraService {
    List<CompraDTO> listar();

    CompraDTO consultar(final Long id);

    CompraDTO salvar(final CompraCreateDTO compra);

    CompraDTO estornar(final Long id);

    CompraDTO alterarValor(final Long id, final CompraValorDTO compra);
}
