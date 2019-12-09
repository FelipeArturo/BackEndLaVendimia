package com.lavendimia.main.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lavendimia.main.entity.Configuracion;

public interface IConfiguracionDao extends CrudRepository<Configuracion,Long>{
	
	@Query("Select C from Configuracion C where C.id = ?1")
	public Configuracion findByIdSQL(Long id);
}
