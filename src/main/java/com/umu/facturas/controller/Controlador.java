package com.umu.facturas.controller;

import com.umu.facturas.model.Factura;
import com.umu.facturas.repository.FacturaRepository;
import com.umu.facturas.repository.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controlador {

	@Autowired
	private FacturaRepository facturaRep;
	@Autowired
	private ProductoRepository productoRep;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("facturas", facturaRep.findAll());
		return "index";
	}

	@RequestMapping("/form")
	public String form(Model model, Boolean edit) {
		model.addAttribute("editable", edit);
        model.addAttribute("factura", new Factura());
		model.addAttribute("productos", productoRep.findAll());
		return "form";
	}
}