package br.com.rp.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;

import br.com.rp.AbstractTest;
import br.com.rp.domain.Pessoa2;

public class PessoalRepositoryImplTest extends AbstractTest {

	@Inject
	private PessoaRepository repository;

	@Test
	public void deveSalvarPessoaComSucesso() throws Throwable {
		Pessoa2 pessoa = new Pessoa2();
		pessoa.setNome("Rodrigo");
		pessoa.setIdade(22);
		Pessoa2 pessoaSalva = repository.save(pessoa);
		assertNotNull(pessoaSalva.getId());
	}

	@Test
	public void deveNaoSalvarPessoaPoisFaltamCamposObrigatorios() throws Throwable {
		Pessoa2 pessoa = new Pessoa2();
		pessoa.setIdade(22);
		try {
			repository.save(pessoa);
		} catch (Throwable e) {
			assertTrue(true);
			return;
		}
		assertTrue("Pessoa nao deveria ser salva pois nao tem nome", false);
	}

	@Test
	@UsingDataSet("db/pessoa.xml")
	public void deveRecuperarRegistrosDePessoasComSucesso() throws Throwable {
		List<Pessoa2> pessoas = repository.getAll();
		assertEquals(1, pessoas.size());
		assertEquals("Fernanda", pessoas.get(0).getNome());
	}
	
	@Test
	@UsingDataSet("db/pessoa.xml")
	public void deveRecuperarPessoaPorNome() throws Throwable {
		List<Pessoa2> pessoas = repository.findPessoaPorNome("Fer");
		assertEquals(1, pessoas.size());
		assertEquals("Fernanda", pessoas.get(0).getNome());
	}
}
