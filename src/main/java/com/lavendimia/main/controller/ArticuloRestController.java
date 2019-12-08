package com.lavendimia.main.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.lavendimia.main.entity.Articulo;
import com.lavendimia.main.service.IArticuloService;

@RestController
@RequestMapping("/api/Articulos")
public class ArticuloRestController {
	
	@Autowired
	private IArticuloService articuloService;
	
	@GetMapping("/getAllArticulos")
	@CrossOrigin(origins="*")
	public ObjetoRespuestaGeneral getArticulos(){
		/* Se crea la varible que contendra toda la informacion de respuesta */
		ObjetoRespuestaGeneral objRespuesta = new ObjetoRespuestaGeneral();
		List<Articulo> listArticulos = new ArrayList<>();
		/* Se realiza la peticion al service para obtener el listado de clientes */
		listArticulos = articuloService.findAll();
		/* Se asigna el listado al objeto general de respuesta */
		objRespuesta.setListadoArticulos(listArticulos);
		/* Se regresa el objeto general de respuesta */
		return objRespuesta;
	}
	
	@PostMapping("/guardarArticulo")
	@CrossOrigin(origins="*")
	public ObjetoRespuestaGeneral addArticulo(@RequestBody Articulo articulo){
		/* Se crea la varible que contendra toda la informacion de respuesta */
		ObjetoRespuestaGeneral objRespuesta = new ObjetoRespuestaGeneral();
		ObjetoHttpStatus objetoStatus = new ObjetoHttpStatus();
		/* Se realiza la validacion para determinar si existe el cliente*/
		if(articuloService.findArticuloDescripcionAndModelo(articulo) == null) {
			articuloService.saveArticulo(articulo);;
			//return new ResponseEntity<Object>(HttpStatus.CREATED);
			objetoStatus.setCodigoError(HttpStatus.CREATED.toString());
			objetoStatus.setMensajeError("Bien Hecho. El articulo ha sido registrado correctamente.");
		}else {
			objetoStatus.setCodigoError(HttpStatus.CONFLICT.toString());
			objetoStatus.setMensajeError("No se registro, ya existe un articulo con la misma descripción y modelo.");
		}
		
		/* Se asigna el objeto status al objeto respuesta general */
		objRespuesta.setObjetoStatus(objetoStatus);
		/* Se regresa el objeto respuesta general */
		return objRespuesta;
	}
	
	@PostMapping("/actualizarArticulo")
	@CrossOrigin(origins="*")
	public ObjetoRespuestaGeneral updateArticulo(@RequestBody Articulo articulo) {
		/* Se crea la varible que contendra toda la informacion de respuesta */
		ObjetoRespuestaGeneral objRespuesta = new ObjetoRespuestaGeneral();
		ObjetoHttpStatus objetoStatus = new ObjetoHttpStatus();
		
		/** Se valida si el rfc que se esta ingresando ya existe o no*/
		if(articuloService.findArticuloDescripcionAndModelo(articulo) == null) {
			articuloService.saveArticulo(articulo);
			//return new ResponseEntity<Object>(HttpStatus.CREATED);
			objetoStatus.setCodigoError(HttpStatus.CREATED.toString());
			objetoStatus.setMensajeError("Bien Hecho. El articulo ha sido actualizado correctamente.");
		}else {
			objetoStatus.setCodigoError(HttpStatus.CONFLICT.toString());
			objetoStatus.setMensajeError("No se actualizo, ya existe un articulo con la misma descripción y modelo.");
		}
		
		/* Se asigna el objeto status al objeto respuesta general */
		objRespuesta.setObjetoStatus(objetoStatus);
		/* Se regresa el objeto respuesta general */
		return objRespuesta;
	}
	
	@GetMapping("/countArticulos")
	@CrossOrigin(origins="*")
	public ObjetoRespuestaGeneral conteoArticulos() {
		/* Se crea la varible que contendra toda la informacion de respuesta */
		ObjetoRespuestaGeneral objRespuesta = new ObjetoRespuestaGeneral();
		String conteo = "";
		
		/* Se realiza la llamada al metodo de conteo */
		conteo = articuloService.conteoArticulos();
		/* Se agrega el conteo al objeto de respuesta general */
		objRespuesta.setConteoClave(conteo);
		
		/* Se regresa el objeto respuesta */
		return objRespuesta;
	}
}
