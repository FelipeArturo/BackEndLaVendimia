package com.lavendimia.main.collections;

public class VentaGeneral {
	private String folioventa;
    private String clavecliente;
    private String nombre;
    private Float total;
    private int cantidad;
    private Long idarticulo;
    
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
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Long getIdarticulo() {
		return idarticulo;
	}
	public void setIdarticulo(Long idarticulo) {
		this.idarticulo = idarticulo;
	}
}
