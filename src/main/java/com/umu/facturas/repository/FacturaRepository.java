package com.umu.facturas.repository;

import com.umu.facturas.model.Factura;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Integer> {
    
}
