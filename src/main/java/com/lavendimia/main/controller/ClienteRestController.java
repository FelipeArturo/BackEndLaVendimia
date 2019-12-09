package com.lavendimia.main.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lavendimia.main.Mapper.Mapper;
import com.lavendimia.main.collections.MCliente;
import com.lavendimia.main.collections.ObjetoHttpStatus;
import com.lavendimia.main.collections.ObjetoRespuestaGeneral;
import com.lavendimia.main.entity.Cliente;
import com.lavendimia.main.service.IClienteService;

@RestController
@RequestMapping("/api/Clientes")
public class ClienteRestController {
	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/getAllClientes")
	@CrossOrigin(origins="*")
	public ObjetoRespuestaGeneral getClientes(){
		/* Se crea la varible que contendra toda la informacion de respuesta */
		ObjetoRespuestaGeneral objRespuesta = new ObjetoRespuestaGeneral();
		List<Cliente> listClientes = new ArrayList<>();
		/* Se realiza la peticion al service para obtener el listado de clientes */
		listClientes = clienteService.findAll();
		/* Se asigna el listado al objeto general de respuesta */
		objRespuesta.setListadoClientes(listClientes);
		/* Se regresa el objeto general de respuesta */
		return objRespuesta;
	}
	
	@GetMapping("/getAllClientesMapper")
	@CrossOrigin(origins="*")
	public ObjetoRespuestaGeneral getClientesMapeados(){
		/* Se crea la varible que contendra toda la informacion de respuesta */
		ObjetoRespuestaGeneral objRespuesta = new ObjetoRespuestaGeneral();
		List<Cliente> listClientes = new ArrayList<>();
		List<MCliente> listClientesMap = new ArrayList<>();
		/* Se realiza la peticion al service para obtener el listado de clientes */
		listClientes = clienteService.findAll();
		/* Se mapea el listado */
		listClientesMap = Mapper.convertiListaclientes(listClientes);
		/* Se asigna el listado al objeto general de respuesta */
		objRespuesta.setListadoClientesMapeados(listClientesMap);
		/* Se regresa el objeto general de respuesta */
		return objRespuesta;
	}
	
	@PostMapping("/guardarCliente")
	@CrossOrigin(origins="*")
	public ObjetoRespuestaGeneral addCliente(@RequestBody Cliente cliente){
		/* Se crea la varible que contendra toda la informacion de respuesta */
		ObjetoRespuestaGeneral objRespuesta = new ObjetoRespuestaGeneral();
		ObjetoHttpStatus objetoStatus = new ObjetoHttpStatus();
		/* Se realiza la validacion para determinar si existe el cliente*/
		if(clienteService.findCliente(cliente)==null) {
			clienteService.saveCliente(cliente);
			//return new ResponseEntity<Object>(HttpStatus.CREATED);
			objetoStatus.setCodigoError(HttpStatus.CREATED.toString());
			objetoStatus.setMensajeError("Bien Hecho. El cliente ha sido registrado correctamente.");
		}else {
			objetoStatus.setCodigoError(HttpStatus.CONFLICT.toString());
			objetoStatus.setMensajeError("No se registro, ya existe un cliente con el mismo RFC.");
		}
		
		/* Se asigna el objeto status al objeto respuesta general */
		objRespuesta.setObjetoStatus(objetoStatus);
		/* Se regresa el objeto respuesta general */
		return objRespuesta;
	}
	
	@PostMapping("/actualizarCliente")
	@CrossOrigin(origins="*")
	public ObjetoRespuestaGeneral updateCliente(@RequestBody Cliente cliente) {
		/* Se crea la varible que contendra toda la informacion de respuesta */
		ObjetoRespuestaGeneral objRespuesta = new ObjetoRespuestaGeneral();
		ObjetoHttpStatus objetoStatus = new ObjetoHttpStatus();
		
		/** Se valida si el rfc que se esta ingresando ya existe o no*/
		if(clienteService.findClienteRfcAndId(cliente) == null) {
			clienteService.updateCliente(cliente);
			//return new ResponseEntity<Object>(HttpStatus.CREATED);
			objetoStatus.setCodigoError(HttpStatus.CREATED.toString());
			objetoStatus.setMensajeError("Bien Hecho. El cliente ha sido actualizado correctamente.");
		}else {
			objetoStatus.setCodigoError(HttpStatus.CONFLICT.toString());
			objetoStatus.setMensajeError("No se actualizo, porque existe un cliente con el mismo RFC.");
		}
		
		/* Se asigna el objeto status al objeto respuesta general */
		objRespuesta.setObjetoStatus(objetoStatus);
		/* Se regresa el objeto respuesta general */
		return objRespuesta;
	}
	
	@GetMapping("/countClientes")
	@CrossOrigin(origins="*")
	public ObjetoRespuestaGeneral conteoClientes() {
		/* Se crea la varible que contendra toda la informacion de respuesta */
		ObjetoRespuestaGeneral objRespuesta = new ObjetoRespuestaGeneral();
		String conteo = "";
		
		/* Se realiza la llamada al metodo de conteo */
		conteo = clienteService.conteoClientes();
		/* Se agrega el conteo al objeto de respuesta general */
		objRespuesta.setConteoClave(conteo);
		
		/* Se regresa el objeto respuesta */
		return objRespuesta;
	}
}
