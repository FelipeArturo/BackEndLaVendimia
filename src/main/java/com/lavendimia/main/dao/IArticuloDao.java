package com.lavendimia.main.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lavendimia.main.entity.Articulo;

public interface IArticuloDao extends CrudRepository<Articulo, Long>{
	public Optional<Articulo> findById(Long id);
	
	public Articulo findByModelo(String modelo);
	
	@Query("Select A from Articulo A where A.descripcion=?1 and A.modelo=?2")
	public Articulo findByDescripcionAndModelo(String descripcion, String modelo);
	
	@Query("Select A from Articulo A where A.id=?1")
	public Articulo findByIdSql(Long id);
}
