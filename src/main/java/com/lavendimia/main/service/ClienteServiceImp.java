package com.lavendimia.main.service;

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

}
