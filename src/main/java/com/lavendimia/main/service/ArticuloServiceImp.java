package com.lavendimia.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lavendimia.main.dao.IArticuloDao;
import com.lavendimia.main.entity.Articulo;

@Service
public class ArticuloServiceImp implements IArticuloService{

	@Autowired
	private IArticuloDao articuloDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Articulo> findAll() {
		return (List<Articulo>) articuloDao.findAll();
	}

	@Override
	@Transactional
	public void saveArticulo(Articulo articulo) {
		articuloDao.save(articulo);
	}

	@Override
	@Transactional
	public void updateArticulo(Articulo articulo) {
		articuloDao.save(articulo);
	}

	@Override
	@Transactional(readOnly=true)
	public Articulo findArticuloDescripcionAndModelo(Articulo articulo) {
		return (Articulo) articuloDao.findByDescripcionAndModelo(articulo.getDescripcion(), articulo.getModelo());
	}

	@Override
	@Transactional(readOnly=true)
	public String conteoArticulos() {
		/* Se declaran las variables */
		List<Articulo> listArticulos = new ArrayList<>();
		String claveArticulo = "";
		
		listArticulos = (List<Articulo>) articuloDao.findAll();
		claveArticulo = addCerosClaveArticulo(String.valueOf(listArticulos.size() + 1));
		
		return claveArticulo;
	}

	/*Metodo que se encargara de agregar ceros*/
	private String addCerosClaveArticulo(String conteo) {
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
