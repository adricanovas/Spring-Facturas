package com.umu.facturas.controller;

import com.umu.facturas.model.Factura;
import com.umu.facturas.model.Producto;
import com.umu.facturas.repository.FacturaRepository;
import com.umu.facturas.repository.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@RequestMapping("/nueva")
	public String nuevaFactura(Model model) {
		boolean block_edit = false;
		model.addAttribute("editable", block_edit);
        model.addAttribute("factura", new Factura());
		model.addAttribute("productos", productoRep.findAll());
		return "form";
	}

	@RequestMapping("/editar/{id}")
	public String editarFactura(Model model, @PathVariable Integer id) {
		boolean block_edit = true;
		model.addAttribute("editable", block_edit);
		model.addAttribute("factura", facturaRep.findById(id).get());
		model.addAttribute("productos", productoRep.findAll());
		return "form";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST, params={"save"})
	public String saveFactura(@ModelAttribute("factura") Factura factura){
		//DEBUG:
		System.out.println(factura.getId());
		facturaRep.save(factura);
		return "redirect:/";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST, params={"addProduct"})
	public String addProduct(@ModelAttribute("producto") Producto producto, Model model){
		
		return "redirect:/";
	}

	@RequestMapping(value = "/delete/{id}")
	public String deleteFactura(@PathVariable Integer id, Model model){
		facturaRep.deleteById(id);
		return "redirect:/";
	}
}