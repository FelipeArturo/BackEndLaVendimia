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
@Table(name = "configuracion")
public class Configuracion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column (name="tasa_financiamiento")
	private double tasafinanciamiento;
	
	@Column (name="porciento_enganche")
	private double porcientoenganche;
	
	@Column (name="plazo_maximo")
	private double plazomaximo;
	
	@Column(name= "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getTasafinanciamiento() {
		return tasafinanciamiento;
	}

	public void setTasafinanciamiento(double tasafinanciamiento) {
		this.tasafinanciamiento = tasafinanciamiento;
	}

	public double getPorcientoenganche() {
		return porcientoenganche;
	}

	public void setPorcientoenganche(double porcientoenganche) {
		this.porcientoenganche = porcientoenganche;
	}

	public double getPlazomaximo() {
		return plazomaximo;
	}

	public void setPlazomaximo(double plazomaximo) {
		this.plazomaximo = plazomaximo;
	}
	
	
	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	@PrePersist
	public void prePersist() {
		createAt = new Date();
	}
}
