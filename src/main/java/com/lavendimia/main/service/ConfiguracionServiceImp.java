package com.lavendimia.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lavendimia.main.dao.IConfiguracionDao;
import com.lavendimia.main.entity.Configuracion;

@Service
public class ConfiguracionServiceImp implements IConfiguracionService{

	@Autowired
	private IConfiguracionDao configuracionDao;

	@Override
	@Transactional(readOnly=true)
	public Configuracion findConfiguracionById(Long id) {
		return (Configuracion) configuracionDao.findByIdSQL(id);
	}

	@Override
	public void saveConfiguracion(Configuracion configuracion) {
		configuracionDao.save(configuracion);
	}

	@Override
	public void updateConfiguracion(Configuracion configuracion) {
		configuracionDao.save(configuracion);
	}

}
