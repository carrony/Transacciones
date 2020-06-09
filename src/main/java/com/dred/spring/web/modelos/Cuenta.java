package com.dred.spring.web.modelos;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component	
public class Cuenta implements Serializable{

	private static final long serialVersionUID = 2287283424251453334L;
	private String movil;
	private String nombre;
	private String apellidos;
	private double saldo;
	
	public Cuenta() {
	}
	
	public Cuenta(String movil, String nombre, String apellidos, double saldo) {
		super();
		this.movil = movil;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.saldo = saldo;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Cuenta [movil=" + movil + ", nombre=" + nombre + ", apellidos=" + apellidos + ", saldo=" + saldo
				+ "]";
	}
	
	
}
