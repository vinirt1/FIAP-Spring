package br.com.fiap.spring;

import static org.hamcrest.Matchers.equalTo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.fiap.spring.model.dto.AlunoCreateUpdateDTO;
import br.com.fiap.spring.model.dto.AlunoDTO;
import br.com.fiap.spring.model.entity.Aluno;
import br.com.fiap.spring.model.entity.Compra;
import br.com.fiap.spring.repository.AlunoRepository;
import br.com.fiap.spring.service.impl.AlunoServiceImpl;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ApplicationTests {

	Aluno alunoTeste;

	List<Compra> compras = new ArrayList<Compra>();

	@Autowired
	private AlunoServiceImpl alunoServiceImpl;

	@MockBean
	private AlunoRepository alunoRepository;

	@BeforeEach
	public void setUp() {

		createTestObjects();
		Mockito.when(alunoRepository.findById(alunoTeste.getId()))
				.thenReturn(Optional.of(alunoTeste));
		Mockito.when(alunoRepository.save(Mockito.any(Aluno.class)))
				.thenReturn(alunoTeste);
	}

	@Test
	void findAlunoByIdTest() {
		MatcherAssert
				.assertThat(
						alunoServiceImpl.consultar(alunoTeste.getId()).getNome(),
						equalTo(new AlunoDTO(alunoTeste).getNome()));
	}

	@Test
	void salvarTest() {

		MatcherAssert
				.assertThat(
						alunoServiceImpl.salvar(new AlunoCreateUpdateDTO(alunoTeste)).getNome(),
						equalTo(alunoTeste.getNome()));
	}

	@Test
	void comprasTest() {
		MatcherAssert
				.assertThat(
						alunoServiceImpl.compras(alunoTeste.getId()).size(),
						equalTo(alunoTeste.getCompras().size()));

	}

	void createTestObjects() {
		alunoTeste = new Aluno((long) 1, 1, "teste", "turma teste");
		for (int i = 0; i < 3; i++) {
			compras.add(new Compra((long) i, (long) i, "bandeira de teste", "Estabelecimento",
					BigDecimal.valueOf(100 * i), LocalDateTime.now(), (Integer) 0, alunoTeste));
		}
		alunoTeste.setCompras(compras);
	}
}
