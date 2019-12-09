package com.lavendimia.main.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ventas")
public class Venta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column (name="folio_venta")
	private String folioventa;
	
	@Column (name="clave_cliente")
	private String clavecliente;
	
	@Column (name="nombre")
	private String nombre;
	
	@Column (name="total")
	private float total;
	
	@Column(name= "create_at")
	@Temporal(TemporalType.DATE)
	private Date createat;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFolioventa() {
		return folioventa;
	}

	public void setFolioventa(String folioventa) {
		this.folioventa = folioventa;
	}

	public String getClavecliente() {
		return clavecliente;
	}

	public void setClavecliente(String clavecliente) {
		this.clavecliente = clavecliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Date getCreateat() {
		return createat;
	}

	public void setCreateat(Date createat) {
		this.createat = createat;
	}
	
	@PrePersist
	public void prePersist() {
		createat = new Date();
	}
}
