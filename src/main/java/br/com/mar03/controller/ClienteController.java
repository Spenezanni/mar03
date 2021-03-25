package br.com.mar03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mar03.dto.ClienteDto;
import br.com.mar03.model.Cliente;
import br.com.mar03.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping
	// @PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<ClienteDto> salvarUsuario(@RequestBody Cliente cliente) {
		ClienteDto clienteDto = clienteService.salvarClienteDto(cliente);
		return ResponseEntity.ok().body(clienteDto);
	}

	@GetMapping
	// @PreAuthorize("hasRole('USER')")
	public List<ClienteDto> listTodosClientes() {
		return this.clienteService.buscarListaDeClientesDTO();
	}
	
	@GetMapping("/page")
	// @PreAuthorize("hasRole('USER')")
	public Page<ClienteDto> listTodosClientesDtoPageable(@RequestParam int page, int qtd) {
		Pageable paginacao = PageRequest.of(page, qtd);
		return this.clienteService.buscarListaDeClientesDTOPageable(paginacao);
	}
			
	@GetMapping("/{nome}")
	// @PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<ClienteDto> procurarClientePorNome(@PathVariable String nome) {
		ClienteDto clienteDto = clienteService.procurarClientePorNome(nome);
		return ResponseEntity.ok().body(clienteDto);
	}

}
