package com.dred.spring.web.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dred.spring.web.exceptions.CuentaBloqueadaException;
import com.dred.spring.web.exceptions.SaldoInsuficienteException;
import com.dred.spring.web.modelo.dao.CuentaDAO;
import com.dred.spring.web.modelos.Cuenta;
import com.dred.spring.web.modelos.Transferencia;

@Controller
public class TransferenciaController {

	@Autowired
	@Qualifier("cuentaDAOJDBC")
	private CuentaDAO cuentaDAO;
	
	@GetMapping("/transferir")
	public String tranferir(Model model) {
		Transferencia t = new Transferencia();
		model.addAttribute("transferencia",t);
		model.addAttribute("listaCuentas", cuentaDAO.getListaCuentas());
		return "registroTransferencia";
	}
	
	@PostMapping("/transferir")
	public String procesar(@Valid Transferencia transfer, BindingResult resultado, Model model) {
		if (resultado.hasErrors()) {
			model.addAttribute("tranferenca", transfer);
			return "registroTransferencia";
		}
		try {
			cuentaDAO.transfiere(transfer);
		} catch (SaldoInsuficienteException | CuentaBloqueadaException e) {
			model.addAttribute("error", e.getMessage());
			return "registroTransferencia";
		} finally {
			model.addAttribute("listaCuentas", cuentaDAO.getListaCuentas());
		}
		return "redirect:mostrar_cuentas";
	}
}
