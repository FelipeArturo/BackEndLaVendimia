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
import com.lavendimia.main.collections.VentaGeneral;
import com.lavendimia.main.entity.Articulo;
import com.lavendimia.main.entity.Venta;
import com.lavendimia.main.service.IArticuloService;
import com.lavendimia.main.service.IVentaService;

@RestController
@RequestMapping("/api/Ventas")
public class VentaRestController {
	@Autowired
	private IVentaService ventaService;
	
	@Autowired
	private IArticuloService articuloService;
	
	@GetMapping("/getAllVentas")
	@CrossOrigin(origins="*")
	public ObjetoRespuestaGeneral getVentas(){
		/* Se crea la varible que contendra toda la informacion de respuesta */
		ObjetoRespuestaGeneral objRespuesta = new ObjetoRespuestaGeneral();
		List<Venta> listVentas = new ArrayList<>();
		/* Se realiza la peticion al service para obtener el listado de clientes */
		listVentas = ventaService.findAll();
		/* Se asigna el listado al objeto general de respuesta */
		objRespuesta.setListadoVentas(listVentas);
		/* Se regresa el objeto general de respuesta */
		return objRespuesta;
	}
	
	@PostMapping("/guardarVenta")
	@CrossOrigin(origins="*")
	public ObjetoRespuestaGeneral addVenta(@RequestBody VentaGeneral ventaG){
		/* Se crea la varible que contendra toda la informacion de respuesta */
		ObjetoRespuestaGeneral objRespuesta = new ObjetoRespuestaGeneral();
		ObjetoHttpStatus objetoStatus = new ObjetoHttpStatus();
		Venta objVenta = new Venta();
		Articulo objArticulo = new Articulo();
		/* Se asigna toda la informacion necesaria */
		objVenta.setClavecliente(ventaG.getClavecliente());
		objVenta.setFolioventa(ventaG.getFolioventa());
		objVenta.setNombre(ventaG.getNombre());
		objVenta.setTotal(ventaG.getTotal());
		/* Se realiza el registro de guardado*/
		ventaService.saveVenta(objVenta);
		/* Se busca el articulo por medio de su id */
		objArticulo = articuloService.findByIdSQL(ventaG.getIdarticulo());
		/* Se asigna la informacion a actualizar y se manda actualizar */
		objArticulo.setExistencia(objArticulo.getExistencia() - ventaG.getCantidad());
		articuloService.updateArticulo(objArticulo);
		//return new ResponseEntity<Object>(HttpStatus.CREATED);
		objetoStatus.setCodigoError(HttpStatus.CREATED.toString());
		objetoStatus.setMensajeError("Bien Hecho. Tu venta ha sido registrada correctamente.");

		/* Se asigna el objeto status al objeto respuesta general */
		objRespuesta.setObjetoStatus(objetoStatus);
		/* Se regresa el objeto respuesta general */
		return objRespuesta;
	}
	
	@GetMapping("/countVentas")
	@CrossOrigin(origins="*")
	public ObjetoRespuestaGeneral conteoVentas() {
		/* Se crea la varible que contendra toda la informacion de respuesta */
		ObjetoRespuestaGeneral objRespuesta = new ObjetoRespuestaGeneral();
		String conteo = "";
		
		/* Se realiza la llamada al metodo de conteo */
		conteo = ventaService.conteoVentas();
		/* Se agrega el conteo al objeto de respuesta general */
		objRespuesta.setConteoClave(conteo);
		
		/* Se regresa el objeto respuesta */
		return objRespuesta;
	}
}
