package com.lavendimia.main.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lavendimia.main.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente,Long>{
	public List<Cliente> findByClienteId(Long id);
	
	public Cliente findByRfc(String rfc);
}
