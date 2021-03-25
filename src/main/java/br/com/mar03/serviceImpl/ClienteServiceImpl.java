package br.com.mar03.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.mar03.dto.ClienteDto;
import br.com.mar03.model.Cliente;
import br.com.mar03.repository.ClienteRepository;
import br.com.mar03.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
    @Override
	public List<ClienteDto> buscarListaDeClientesDTO() {
		List<Cliente> clientes = clienteRepository.findAll();
		return ClienteDto.converter(clientes);
	}

	@Override
	public ClienteDto salvarClienteDto(Cliente cliente) {
		Cliente clienteSalvo = clienteRepository.save(cliente);
		return new ClienteDto(clienteSalvo) ;
	}

	@Override
	public ClienteDto procurarClientePorNome(String nome) {
		Cliente clientePorNome = clienteRepository.findByNome(nome);
		return new ClienteDto(clientePorNome);
	}

	@Override
	public Page<ClienteDto> buscarListaDeClientesDTOPageable(Pageable paginacao) {
		Page<Cliente> clientes = this.clienteRepository.findAll(paginacao);
		return ClienteDto.converterPage(clientes);
	}

}
