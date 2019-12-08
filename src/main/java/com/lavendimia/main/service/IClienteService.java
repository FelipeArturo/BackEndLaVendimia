package com.lavendimia.main.service;

import java.util.List;

import com.lavendimia.main.entity.Cliente;

public interface IClienteService {
	public List<Cliente> findAll();
	
	public void saveCliente(Cliente cliente);
	
	public void updateCliente(Cliente cliente);
	
	public Cliente findCliente(Cliente cliente);
	
	public Cliente findClienteRfcAndId(Cliente cliente);
	
	public String conteoClientes();
}
