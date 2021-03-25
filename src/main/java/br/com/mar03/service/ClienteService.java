package br.com.mar03.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.mar03.dto.ClienteDto;
import br.com.mar03.model.Cliente;

public interface ClienteService {
	

	public List<ClienteDto> buscarListaDeClientesDTO();

	public ClienteDto salvarClienteDto(Cliente cliente);

	public ClienteDto procurarClientePorNome(String nome);

	public Page<ClienteDto> buscarListaDeClientesDTOPageable(Pageable paginacao);

}
