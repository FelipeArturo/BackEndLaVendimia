package com.lavendimia.main.collections;

import java.util.List;

import com.lavendimia.main.entity.Articulo;
import com.lavendimia.main.entity.Cliente;
import com.lavendimia.main.entity.Configuracion;
import com.lavendimia.main.entity.Venta;

public class ObjetoRespuestaGeneral {
	private List<Cliente> listadoClientes;
	private List<Articulo> listadoArticulos;
	private List<MCliente> listadoClientesMapeados;
	private List<Venta> listadoVentas;
	
	private ObjetoHttpStatus objetoStatus;
	private Configuracion objConfiguracion;
	
	private String conteoClave;
	
	public List<Venta> getListadoVentas() {
		return listadoVentas;
	}
	public void setListadoVentas(List<Venta> listadoVentas) {
		this.listadoVentas = listadoVentas;
	}
	public List<Cliente> getListadoClientes() {
		return listadoClientes;
	}
	public void setListadoClientes(List<Cliente> listadoClientes) {
		this.listadoClientes = listadoClientes;
	}
	public List<Articulo> getListadoArticulos() {
		return listadoArticulos;
	}
	public void setListadoArticulos(List<Articulo> listadoArticulos) {
		this.listadoArticulos = listadoArticulos;
	}
	public List<MCliente> getListadoClientesMapeados() {
		return listadoClientesMapeados;
	}
	public void setListadoClientesMapeados(List<MCliente> listadoClientesMapeados) {
		this.listadoClientesMapeados = listadoClientesMapeados;
	}
	public ObjetoHttpStatus getObjetoStatus() {
		return objetoStatus;
	}
	public void setObjetoStatus(ObjetoHttpStatus objetoStatus) {
		this.objetoStatus = objetoStatus;
	}
	public Configuracion getObjConfiguracion() {
		return objConfiguracion;
	}
	public void setObjConfiguracion(Configuracion objConfiguracion) {
		this.objConfiguracion = objConfiguracion;
	}
	
	
	public String getConteoClave() {
		return conteoClave;
	}
	public void setConteoClave(String conteoClave) {
		this.conteoClave = conteoClave;
	}
}
