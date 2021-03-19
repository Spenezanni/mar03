package br.com.mar03.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import br.com.mar03.model.Cliente;
import util.Base;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ClienteRepositoryTest {

	@Autowired
	private ClienteRepository clienteRepository;

	@Test
	void deveriacarregartodososclientes() {
		List<Cliente> clientes = clienteRepository.findAll();
		Assert.notEmpty(clientes);
	}

	@Test
	void deveriacarregartodososclientecvs() {
		ClienteRepository mock = Mockito.mock(ClienteRepository.class);
		List<Cliente> clientes = mock.findAll();
		assertTrue(clientes.isEmpty());
	}

	@Test
	void deveriacarregartodososclientesUtilizando() {
		ClienteRepository mock = Mockito.mock(ClienteRepository.class);
		List<Cliente> clientes = Base.criarListaCliente();
		Mockito.when(mock.findAll()).thenReturn(clientes);
		assertTrue(!clientes.isEmpty());
	}
	
	@Test 
	void procurarClientePorNome() {
		String clienteNome = "Mara";
		Cliente cliente = clienteRepository.findByNome(clienteNome);
		assertNotNull(cliente);
		assertEquals(clienteNome, cliente.getNome());
	}
	
}
