package com.umu.facturas.das.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.umu.facturas.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    
}
