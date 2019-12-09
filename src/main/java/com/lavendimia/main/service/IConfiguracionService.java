package com.lavendimia.main.service;

import com.lavendimia.main.entity.Configuracion;

public interface IConfiguracionService {
	public Configuracion findConfiguracionById(Long id);
	
	public void saveConfiguracion(Configuracion configuracion);
	
	public void updateConfiguracion(Configuracion configuracion);
}
