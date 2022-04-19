package com.umu.facturas.das;

import com.umu.facturas.entities.Factura;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Integer> {
    
}
