package com.dred.spring.web.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dred.spring.web.exceptions.CuentaBloqueadaException;
import com.dred.spring.web.exceptions.SaldoInsuficienteException;
import com.dred.spring.web.modelos.Cuenta;
import com.dred.spring.web.modelos.Transferencia;


@Repository("cuentaDAOJDBC")
public class CuentaDAOJDBC implements CuentaDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;	

	@Override
	public List<Cuenta> getListaCuentas() {
		List<Cuenta> listaCuentas = jdbcTemplate.query(
				"select * from cuentas", new CuentaMapper());
		return listaCuentas;
	}

	@Override
	public Cuenta getCuenta(String movil) {
		Cuenta c = null;
		c=jdbcTemplate.queryForObject(
				"select * from cuentas where movil= ?", 
				new Object [] {movil},
				new CuentaMapper());
		return c;
	}

	@Override
	public void insertarCuenta(Cuenta c) {
		jdbcTemplate.update(
			 "insert into cuentas(movil,nombre,apellidos,saldo) values(?,?,?,?)",
			 c.getMovil(),c.getNombre(), c.getApellidos(),c.getSaldo());
	}

	@Override
	public void eliminarCuenta(String movil) {
		jdbcTemplate.update("delete from cuentas where movil=?",movil);
	}

	@Override
	public void editarCuenta(Cuenta c) {
		jdbcTemplate.update(
			"update cuentas set nombre=?, apellidos=?, saldo=? where movil=?",
			c.getNombre(),c.getApellidos(),c.getSaldo(),c.getMovil());
	}

	@Override
	@Transactional( rollbackFor = {SaldoInsuficienteException.class, CuentaBloqueadaException.class})
	public void transfiere(Transferencia transfer) throws SaldoInsuficienteException, CuentaBloqueadaException {
		// Recogemos las dos cuentas
		Cuenta origen = this.getCuenta(transfer.getEmisor());
		if (origen.getSaldo()<transfer.getCantidad()) {
			throw new SaldoInsuficienteException();
		}
		origen.setSaldo(origen.getSaldo()-transfer.getCantidad());
		this.editarCuenta(origen);
		Cuenta destino = this.getCuenta(transfer.getReceptor());
		if ( destino.getMovil().equals("600000000") ) {
			throw new CuentaBloqueadaException();
		}
		destino.setSaldo(destino.getSaldo()+transfer.getCantidad());
		this.editarCuenta(destino);
	}
	
	

}
