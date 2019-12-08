package com.lavendimia.main.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lavendimia.main.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente,Long>{
	public Optional<Cliente> findById(Long id);
	
	public Cliente findByRfc(String rfc);
	
	@Query("Select c from Cliente c where c.rfc = ?1 and c.id <> ?2")
	public Cliente findByRfcAndId(String rfc,Long id);
}
