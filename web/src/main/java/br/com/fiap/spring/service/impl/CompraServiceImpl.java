package br.com.fiap.spring.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.spring.model.dto.CompraCreateDTO;
import br.com.fiap.spring.model.dto.CompraDTO;
import br.com.fiap.spring.model.dto.CompraValorDTO;
import br.com.fiap.spring.model.entity.Aluno;
import br.com.fiap.spring.model.entity.Compra;
import br.com.fiap.spring.repository.AlunoRepository;
import br.com.fiap.spring.repository.CompraRepository;
import br.com.fiap.spring.service.CompraService;

@Service
public class CompraServiceImpl implements CompraService {

    private CompraRepository compraRepository;
    private AlunoRepository alunoRepository;

    public CompraServiceImpl(CompraRepository compraRepository, AlunoRepository alunoRepository) {
        this.compraRepository = compraRepository;
        this.alunoRepository = alunoRepository;
    }

    @Override
    public List<CompraDTO> listar() {
        final List<CompraDTO> listaTransacoes = this.compraRepository.findAll().stream()
                .map(CompraDTO::new).collect(Collectors.toList());

        return listaTransacoes;
    }

    @Override
    public CompraDTO consultar(final Long id) {
        final CompraDTO compra = new CompraDTO(this.findCompraById(id));

        return compra;
    }

    @Override
    public CompraDTO salvar(final CompraCreateDTO compraCreateDTO) {
        final Aluno aluno = this.findAlunoById(compraCreateDTO.getIdAluno());

        Compra compraSalvar = new Compra(compraCreateDTO);
        compraSalvar.setAluno(aluno);

        final Compra compraSalva = this.compraRepository.save(compraSalvar);

        return new CompraDTO(compraSalva);
    }

    @Override
    public CompraDTO estornar(final Long id) {
        Compra compra = this.findCompraById(id);
        compra.setStatus(9);

        Compra compraAtualizada = this.compraRepository.save(compra);
        return new CompraDTO(compraAtualizada);
    }

    @Override
    public CompraDTO alterarValor(final Long id, final CompraValorDTO compraValorDTO) {
        Compra compra = this.findCompraById(id);
        compra.setValor(compraValorDTO.getValor());

        Compra compraAtualizada = this.compraRepository.save(compra);
        return new CompraDTO(compraAtualizada);
    }

    private Compra findCompraById(final Long id) {
        final Compra compra = this.compraRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Transação não encontrada."));

        return compra;
    }

    private Aluno findAlunoById(final Long id) {
        final Aluno aluno = this.alunoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrada."));

        return aluno;
    }
}
