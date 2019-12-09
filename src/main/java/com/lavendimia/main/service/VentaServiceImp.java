package com.lavendimia.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lavendimia.main.dao.IVentaDao;
import com.lavendimia.main.entity.Venta;

@Service
public class VentaServiceImp implements IVentaService{

	@Autowired
	private IVentaDao ventaDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Venta> findAll() {
		return (List<Venta>) ventaDao.findAll();
	}

	@Override
	@Transactional
	public void saveVenta(Venta venta) {
		ventaDao.save(venta);
	}

	@Override
	@Transactional(readOnly=true)
	public String conteoVentas() {
		/* Se declaran las variables */
		List<Venta> listVentas = new ArrayList<>();
		String folioVenta = "";
		
		listVentas = (List<Venta>) ventaDao.findAll();
		folioVenta = addCerosClaveVenta(String.valueOf(listVentas.size() + 1));
		
		return folioVenta;
	}
	
	/*Metodo que se encargara de agregar ceros*/
	private String addCerosClaveVenta(String conteo) {
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
