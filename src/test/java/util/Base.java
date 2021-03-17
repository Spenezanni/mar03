package util;

import java.util.ArrayList;
import java.util.List;

import br.com.mar03.model.Cliente;

public class Base {
	
	public static List<Cliente> criarListaCliente() {
		
		List<Cliente> clientes = new ArrayList<>();
		
		Cliente cliente = new Cliente(1l, "Maria", "123456", "granted");
		Cliente cliente2 = new Cliente(2l, "José", "123456", "granted");
		Cliente cliente3 = new Cliente(3l, "Joao", "123456", "granted");
		Cliente cliente4 = new Cliente(4l, "Tereza", "123456", "granted");
		
		clientes.add(cliente);
		clientes.add(cliente2);
		clientes.add(cliente3);
		clientes.add(cliente4);
		
		return clientes;
		
	}

}
