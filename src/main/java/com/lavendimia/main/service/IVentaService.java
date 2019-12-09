package com.lavendimia.main.service;

import java.util.List;

import com.lavendimia.main.entity.Venta;

public interface IVentaService {
	public List<Venta> findAll();
	
	public void saveVenta(Venta venta);
	
	public String conteoVentas();
}
