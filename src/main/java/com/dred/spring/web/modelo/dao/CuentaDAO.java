package com.dred.spring.web.modelo.dao;

import java.util.List;

import javax.validation.Valid;

import com.dred.spring.web.exceptions.CuentaBloqueadaException;
import com.dred.spring.web.exceptions.SaldoInsuficienteException;
import com.dred.spring.web.modelos.Cuenta;
import com.dred.spring.web.modelos.Transferencia;

public interface CuentaDAO {
	public List<Cuenta> getListaCuentas();
	public Cuenta getCuenta(String movil);
	public void insertarCuenta(Cuenta p);
	public void eliminarCuenta(String movil);
	public void editarCuenta(Cuenta p);
	public void transfiere(@Valid Transferencia transfer) throws SaldoInsuficienteException, CuentaBloqueadaException;
}
