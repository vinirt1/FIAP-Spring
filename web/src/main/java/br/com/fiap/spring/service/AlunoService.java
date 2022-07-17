package br.com.fiap.spring.service;

import java.util.List;

import br.com.fiap.spring.model.dto.AlunoCreateUpdateDTO;
import br.com.fiap.spring.model.dto.AlunoDTO;
import br.com.fiap.spring.model.dto.CompraDTO;

public interface AlunoService {
    List<AlunoDTO> listar(final String nome);

    AlunoDTO consultar(final Long id);

    AlunoDTO salvar(final AlunoCreateUpdateDTO compra);

    AlunoDTO alterar(final Long id, final AlunoCreateUpdateDTO compra);

    void deletar(final Long id);

    List<CompraDTO> compras(final Long id);
}
