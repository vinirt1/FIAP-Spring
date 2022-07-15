package br.com.fiap.spring.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.spring.model.dto.AlunoCreateUpdateDTO;
import br.com.fiap.spring.model.dto.AlunoDTO;
import br.com.fiap.spring.model.dto.CompraDTO;
import br.com.fiap.spring.model.entity.Aluno;
import br.com.fiap.spring.repository.AlunoRepository;
import br.com.fiap.spring.service.AlunoService;

@Service
public class AlunoServiceImpl implements AlunoService {

    private AlunoRepository alunoRepository;

    public AlunoServiceImpl(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Override
    public List<AlunoDTO> listar(final String nome) {
        final List<AlunoDTO> listaTransacoes = this.alunoRepository.findAllByNomeStartsWith(nome).stream()
                .map(AlunoDTO::new).collect(Collectors.toList());

        return listaTransacoes;
    }

    @Override
    public AlunoDTO consultar(final Long id) {
        final AlunoDTO aluno = new AlunoDTO(this.findAlunoById(id));

        return aluno;
    }

    @Override
    public AlunoDTO salvar(final AlunoCreateUpdateDTO alunoCreateDTO) {
        final Aluno alunoSalvar = new Aluno(alunoCreateDTO);
        final Aluno alunoSalvo = this.alunoRepository.save(alunoSalvar);

        return new AlunoDTO(alunoSalvo);
    }

    @Override
    public AlunoDTO alterar(final Long id, final AlunoCreateUpdateDTO alunoUpdateDTO) {
        Aluno alunoAtualizar = this.findAlunoById(id);
        alunoAtualizar.setMatricula(alunoUpdateDTO.getMatricula());
        alunoAtualizar.setNome(alunoUpdateDTO.getNome());
        alunoAtualizar.setTurma(alunoUpdateDTO.getTurma());

        Aluno alunoAtualizado = this.alunoRepository.save(alunoAtualizar);
        return new AlunoDTO(alunoAtualizado);
    }

    @Override
    public void deletar(Long id) {
        this.findAlunoById(id);
        this.alunoRepository.deleteById(id);
    }

    public Aluno findAlunoById(final Long id) {
        final Aluno aluno = this.alunoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrada."));

        return aluno;
    }

    @Override
    public List<CompraDTO> compras(Long id) {
        final int ESTORNADO = 9;

        final Aluno aluno = this.findAlunoById(id);
        final List<CompraDTO> listaCompras = aluno.getCompras().stream()
                .filter(compra -> compra.getStatus() != ESTORNADO).map(CompraDTO::new)
                .collect(Collectors.toList());

        return listaCompras;
    }
}
