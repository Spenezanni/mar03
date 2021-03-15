package br.com.mar03.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mar03.model.Cliente;

public class ClienteDto {

	private String nome;
	private String descricao;

	public ClienteDto() {

	}

	public ClienteDto(Cliente cliente) {

		this.nome = cliente.getNome();
		this.descricao = cliente.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static List<ClienteDto> converter(List<Cliente> clientes) {
		return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
	}

}
