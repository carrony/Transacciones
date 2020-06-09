package com.dred.spring.web.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.dred.spring.web.modelo.dao.CuentaDAO;
import com.dred.spring.web.modelos.Cuenta;

@Controller
//@RequestMapping("/banco")
public class CuentaController {
	
	@Autowired
	@Qualifier("cuentaDAOJDBC")
	private CuentaDAO cuentaDAO;
	
	@PostMapping("/resumenCuenta")
	public String procesar(@Valid Cuenta cuenta, BindingResult resultado, Model model) {
		if (resultado.hasErrors()) {
			model.addAttribute("producto", cuenta);
			return "registroCuenta";
		}
		cuentaDAO.insertarCuenta(cuenta);
		return "redirect:mostrar_cuentas";
	}

	@GetMapping("/registrarCuenta")
	public String formulario(Model model) {
		Cuenta cuenta = new Cuenta();
		model.addAttribute("cuenta", cuenta);
		return "registroCuenta";
	}
	
	
	@GetMapping("/mostrar_cuentas")
	public String mostrar_productos(Model model) {
		model.addAttribute("listaCuentas", cuentaDAO.getListaCuentas());
		return "listarCuentas";
	}
	
	@GetMapping("/editarCuenta")
	public String editarform(@RequestParam String movil, Model model) {
		Cuenta cuenta = new Cuenta();
		model.addAttribute("mensaje", "Editar un producto");
		if (movil!=null && movil.length()>0) {
			cuenta=cuentaDAO.getCuenta(movil);
			model.addAttribute("cuenta", cuenta);
		} else {
			model.addAttribute("cuenta", cuenta);
			return "redirect:mostar_cuentas";
		}
		return "editarCuenta";
	}
	
	@PostMapping("/modificarCuenta")
	public String editar(@Valid Cuenta cuenta, BindingResult resultado, Model model) {
		if (resultado.hasErrors()) {
			model.addAttribute("cuenta", cuenta);
			return "editarCuenta";
		}
		cuentaDAO.editarCuenta(cuenta);
		return "redirect:mostrar_cuentas";
	}
	
	@GetMapping("/eliminarCuenta")
	public String eliminar(@RequestParam String movil, Model model) {
		if (movil!=null &&  movil.length()>0) {
			cuentaDAO.eliminarCuenta(movil);
		} 
		return "redirect:mostrar_cuentas";
	} 
}
