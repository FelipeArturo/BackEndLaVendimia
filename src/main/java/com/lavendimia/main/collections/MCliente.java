package com.lavendimia.main.collections;

import com.lavendimia.main.entity.Cliente;

public class MCliente {
	private Long id;
	private String nombre;
	private String clavecliente;
	private String rfc;
	
	public MCliente() {
		
	}
	
	public MCliente(Long id,String nombre,String appaterno,String apmaterno,String clavecliente,String rfc) {
		this.id = id;
		this.nombre = nombre + " " + appaterno + " " + apmaterno;
		this.clavecliente = clavecliente;
		this.rfc = rfc;
	}
	
	public MCliente(Cliente cliente) {
		this.id = cliente.getId();
		this.nombre = cliente.getNombre() + " " + cliente.getAppaterno() + " " + cliente.getApmaterno();
		this.clavecliente = cliente.getClavecliente();
		this.rfc = cliente.getRfc();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClavecliente() {
		return clavecliente;
	}

	public void setClavecliente(String clavecliente) {
		this.clavecliente = clavecliente;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
}
