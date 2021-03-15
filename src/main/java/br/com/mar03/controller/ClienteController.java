package br.com.mar03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mar03.dto.ClienteDto;
import br.com.mar03.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	
	@GetMapping("/cliente")
	// @PreAuthorize("hasRole('USER')")
	public List<ClienteDto> listTodosClientes() {
		return this.clienteService.buscarListaDeClientesDTO();
	}

}
