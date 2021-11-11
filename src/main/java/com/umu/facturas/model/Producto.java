package com.umu.facturas.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
@Entity
@Data
@Table(name = "PRODUCTO", schema = "FACTURAS")
@NamedQueries({ @NamedQuery(name = "Producto.obtenerProductoTodos", query = "SELECT producto FROM Producto producto")})
@SequenceGenerator(schema = "FACTURAS", sequenceName = "producto_seq", name = "generador_producto_seq", initialValue = 0, allocationSize = 1)
public class Producto implements java.io.Serializable{
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(generator = "generador_producto_seq", strategy = GenerationType.SEQUENCE)
    private Integer id;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name = "DESCRIPCION", nullable = false, length = 256)
    private String descripcion;

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "PRECIO", nullable = false, precision = 17, scale = 0)
    private double precio;

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @ManyToMany(mappedBy = "productos")
    private List<Factura> factura = new LinkedList<Factura>();

    public Producto(){

    }
}
