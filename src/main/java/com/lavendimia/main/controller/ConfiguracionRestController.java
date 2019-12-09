package com.lavendimia.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lavendimia.main.collections.ObjetoHttpStatus;
import com.lavendimia.main.collections.ObjetoRespuestaGeneral;
import com.lavendimia.main.entity.Configuracion;
import com.lavendimia.main.service.IConfiguracionService;

@RestController
@RequestMapping("/api/Configuracion")
public class ConfiguracionRestController {
	
	@Autowired
	private IConfiguracionService configuracionService;
	
	@GetMapping("/getConfiguracion")
	@CrossOrigin(origins="*")
	public ObjetoRespuestaGeneral getConfiguracion(){
		/* Se crea la varible que contendra toda la informacion de respuesta */
		ObjetoRespuestaGeneral objRespuesta = new ObjetoRespuestaGeneral();
		ObjetoHttpStatus objStatus = new ObjetoHttpStatus();
		Configuracion objConfiguracion = new Configuracion();
		/* Se realiza la peticion al service para obtener el listado de clientes */
		objConfiguracion = configuracionService.findConfiguracionById(1L);
		/* validacion para determinar si se encontro informacion o no */
	
		/* Se asigna el listado al objeto general de respuesta */
		objRespuesta.setObjConfiguracion(objConfiguracion);
		/* Se regresa el objeto general de respuesta */
		return objRespuesta;
	}
	
	@PostMapping("/guardarConfiguracion")
	@CrossOrigin(origins="*")
	public ObjetoRespuestaGeneral addConfiguracion(@RequestBody Configuracion configuracion){
		/* Se crea la varible que contendra toda la informacion de respuesta */
		ObjetoRespuestaGeneral objRespuesta = new ObjetoRespuestaGeneral();
		ObjetoHttpStatus objetoStatus = new ObjetoHttpStatus();
		/* Se realiza el registro de la configuracion */
		configuracionService.saveConfiguracion(configuracion);
		//return new ResponseEntity<Object>(HttpStatus.CREATED);
		objetoStatus.setCodigoError(HttpStatus.CREATED.toString());
		objetoStatus.setMensajeError("Bien Hecho. La configuración ha sido registrada correctamente.");
		/* Se asigna el objeto status al objeto respuesta general */
		objRespuesta.setObjetoStatus(objetoStatus);
		/* Se regresa el objeto respuesta general */
		return objRespuesta;
	}
	
	@PostMapping("/actualizarConfiguracion")
	@CrossOrigin(origins="*")
	public ObjetoRespuestaGeneral updateConfiguracion(@RequestBody Configuracion configuracion) {
		/* Se crea la varible que contendra toda la informacion de respuesta */
		ObjetoRespuestaGeneral objRespuesta = new ObjetoRespuestaGeneral();
		ObjetoHttpStatus objetoStatus = new ObjetoHttpStatus();
		/* Se realiza la actualizacion de la configuracion */
		configuracionService.updateConfiguracion(configuracion);
		//return new ResponseEntity<Object>(HttpStatus.CREATED);
		objetoStatus.setCodigoError(HttpStatus.CREATED.toString());
		objetoStatus.setMensajeError("Bien Hecho. La configuración ha sido actualizada correctamente.");
		/* Se asigna el objeto status al objeto respuesta general */
		objRespuesta.setObjetoStatus(objetoStatus);
		/* Se regresa el objeto respuesta general */
		return objRespuesta;
	}
}
