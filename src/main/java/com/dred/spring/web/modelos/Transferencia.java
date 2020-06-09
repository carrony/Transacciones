package com.dred.spring.web.modelos;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class Transferencia implements Serializable{

	private static final long serialVersionUID = 1497298064230969828L;
	private String emisor;
	private double cantidad;
	private String concepto;
	private String receptor;
	
	public Transferencia() {
	}

	public Transferencia(String emisor, double cantidad, String concepto, String receptor) {
		super();
		this.emisor = emisor;
		this.cantidad = cantidad;
		this.concepto = concepto;
		this.receptor = receptor;
	}
	
	public String getEmisor() {
		return emisor;
	}
	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public String getReceptor() {
		return receptor;
	}
	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}


	
	
}
