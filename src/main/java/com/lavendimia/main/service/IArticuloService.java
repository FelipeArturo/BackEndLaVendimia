package com.lavendimia.main.service;

import java.util.List;

import com.lavendimia.main.entity.Articulo;

public interface IArticuloService {
	public List<Articulo> findAll();
	
	public void saveArticulo(Articulo articulo);
	
	public void updateArticulo(Articulo articulo);
	
	public Articulo findArticuloDescripcionAndModelo(Articulo articulo);
	
	public String conteoArticulos();
}
