package com.dred.spring.web.exceptions;

public class SaldoInsuficienteException extends Exception {

	public SaldoInsuficienteException() {
		super("No hay saldo suficiente");
	}
}
