package com.dred.spring.web.modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dred.spring.web.modelos.Cuenta;

public class CuentaMapper implements RowMapper<Cuenta> {

	@Override
	public Cuenta mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cuenta c = new Cuenta();
		c.setMovil(rs.getString("movil"));
		c.setNombre(rs.getString("nombre"));
		c.setApellidos(rs.getString("apellidos"));
		c.setSaldo(rs.getDouble("saldo"));
		
		return c;
	}

}
