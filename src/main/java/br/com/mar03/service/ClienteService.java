package br.com.mar03.service;

import java.util.List;

import br.com.mar03.dto.ClienteDto;
import br.com.mar03.model.Cliente;

public interface ClienteService {
	

	public List<ClienteDto> buscarListaDeClientesDTO();

	public ClienteDto salvarClienteDto(Cliente cliente);

	public ClienteDto procurarClientePorNome(String nome);

}
