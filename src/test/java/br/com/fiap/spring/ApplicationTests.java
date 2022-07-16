package br.com.fiap.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.Matchers.equalTo;

import java.util.Optional;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.fiap.spring.model.dto.AlunoDTO;
import br.com.fiap.spring.model.entity.Aluno;
import br.com.fiap.spring.repository.AlunoRepository;
import br.com.fiap.spring.service.impl.AlunoServiceImpl;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ApplicationTests {

	Aluno alunoTeste = new Aluno((long) 1, 1, "teste", "turma teste");

	@Autowired
	private AlunoServiceImpl alunoServiceImpl;

	@MockBean
	private AlunoRepository alunoRepository;

	@BeforeAll
	public void setUp() {

		Mockito.when(alunoRepository.findById(alunoTeste.getId()))
				.thenReturn(Optional.of(alunoTeste));
	}

	@Test
	void contextLoads() {
		System.out.println("executeii!");
		assertEquals(1, 1);

	}

	@Test
	void findAlunoByIdTest() {
		MatcherAssert
				.assertThat(
						alunoServiceImpl.consultar(alunoTeste.getId()).getNome(),
						equalTo(new AlunoDTO(alunoTeste).getNome()));
	}

}
