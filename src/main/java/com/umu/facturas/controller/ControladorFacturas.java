package com.umu.facturas.controller;

import com.umu.facturas.entities.Factura;
import com.umu.facturas.entities.Producto;
import com.umu.facturas.das.interfaces.FacturaRepository;
import com.umu.facturas.das.interfaces.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
		model.addAttribute("articulos", f.getProductos());
		model.addAttribute("productos", productoRep.findAll());
		return "edit";
	}

	//Guardar Factura
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String saveFactura(@ModelAttribute Factura factura){
		System.out.println(factura);
		facturaRep.save(factura);
		return "redirect:/";
	}

	//Eliminar Factura
	@RequestMapping(value = "/deletef/{id}")
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

	//Add Producto
	@RequestMapping(value = "/incluir/{id}")
	public String addProducto(@PathVariable Integer id, @RequestParam(value = "idProducto") Integer idp, Model model){
		Producto producto = productoRep.findById(idp).get();
		Factura factura = facturaRep.findById(id).get();
		List<Producto> ps = factura.getProductos();
		ps.add(producto);
		factura.setProductos(ps);
		facturaRep.save(factura);
		return "redirect:/editar/" + factura.getId();
	}

	//Eliminar Producto
	@RequestMapping(value = "/eliminar/{idp}/{idf}")
	public String eliminarProducto(@PathVariable Integer idp, @PathVariable Integer idf, Model model){
		Producto producto = productoRep.findById(idp).get();
		Factura factura = facturaRep.findById(idf).get();
		List<Producto> ps = factura.getProductos();
		ps.remove(producto);
		factura.setProductos(ps);
		facturaRep.save(factura);
		return "redirect:/editar/" + factura.getId();
	}

}