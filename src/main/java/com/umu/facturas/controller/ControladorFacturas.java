package com.umu.facturas.controller;

import com.umu.facturas.entities.Factura;
import com.umu.facturas.entities.Producto;
import com.umu.facturas.das.interfaces.FacturaRepository;
import com.umu.facturas.das.interfaces.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControladorFacturas {

	@Autowired
	private FacturaRepository facturaRep;
	@Autowired
	private ProductoRepository productoRep;

	//Lista de facturas
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("facturas", facturaRep.findAll());
		return "index";
	}
	//Nueva Factura
	@RequestMapping("/nueva")
	public String nuevaFactura(Model model) {
        model.addAttribute("factura", new Factura());
		model.addAttribute("productos", productoRep.findAll());
		return "nueva";
	}

	//Editar factura
	@RequestMapping("/editar/{id}")
	public String editarFactura(Model model, @PathVariable Integer id) {
		Factura f = facturaRep.findById(id).get();
		model.addAttribute("factura", f);
		model.addAttribute("", f.getConsolidada());
		model.addAttribute("productos", productoRep.findAll());
		return "edit";
	}

	//Guardar Factura
	@RequestMapping(value = "/save", method = RequestMethod.POST, params={"save"})
	public String saveFactura(@ModelAttribute("factura") Factura factura){
		//DEBUG:
		System.out.println(factura.getId());
		facturaRep.save(factura);
		return "redirect:/";
	}

	//Eliminar Factura
	@RequestMapping(value = "/delete/{id}")
	public String deleteFactura(@PathVariable Integer id, Model model){
		facturaRep.deleteById(id);
		return "redirect:/";
	}

	//Consolidar Factura
	@RequestMapping(value = "/consolidar/{id}", method = RequestMethod.POST)
	public String consolidarFactura(@PathVariable Integer id, Model model){
		Factura f = facturaRep.findById(id).get();
		f.setConsolidada(true);
		facturaRep.save(f);
		return "redirect:/";
	}
}