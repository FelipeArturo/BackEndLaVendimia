package com.lavendimia.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lavendimia.main.dao.IClienteDao;
import com.lavendimia.main.entity.Cliente;

@Service
public class ClienteServiceImp implements IClienteService{

	@Autowired
	private IClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional
	public void saveCliente(Cliente cliente) {
		clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void updateCliente(Cliente cliente) {
		clienteDao.save(cliente);
	}

	@Override
	@Transactional(readOnly=true)
	public Cliente findCliente(Cliente cliente) {
		return (Cliente) clienteDao.findByRfc(cliente.getRfc());
	}

	@Override
	@Transactional(readOnly=true)
	public String conteoClientes() {
		/* Se declaran las variables */
		List<Cliente> listClientes = new ArrayList<>();
		String claveCliente = "";
		
		listClientes = (List<Cliente>) clienteDao.findAll();
		claveCliente = addCerosClaveCliente(String.valueOf(listClientes.size() + 1));
		
		return claveCliente;
	}

	@Override
	@Transactional(readOnly=true)
	public Cliente findClienteRfcAndId(Cliente cliente) {
		return (Cliente)  clienteDao.findByRfcAndId(cliente.getRfc(), cliente.getId());
	}

	/*Metodo que se encargara de agregar ceros*/
	private String addCerosClaveCliente(String conteo) {
		/* Variable donde se guardara el concatenado */
		String concatenado = "";
		/* Empieza la validacion */
		if(conteo.length() == 1) {
			concatenado = "00".concat(conteo);
		}else {
			if(conteo.length() == 2) {
				concatenado = "0".concat(conteo);
			}else {
				concatenado = conteo;
			}
		}
		/* Se regresa el resultado concatenado */
		return concatenado;
	}
}
