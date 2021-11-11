package com.umu.facturas.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
@Table(name = "FACTURA", schema = "FACTURAS")
@SequenceGenerator(schema = "FACTURAS", sequenceName = "factura_seq", name = "generador_factura_seq", initialValue = 0, allocationSize = 1)

public class Factura implements java.io.Serializable{
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(generator = "generador_factura_seq", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "NIF", unique = false, nullable = false, length = 9)
    private String nif;

    @ManyToMany
    @JoinTable(name = "factura_producto", joinColumns = @JoinColumn(name = "factura_id"),
    inverseJoinColumns = @JoinColumn(name = "producto_id"))
    private List<Producto> productos = new ArrayList<Producto>();

    @Transient
    public double getImporteTotal(){
        double importe = 0;
        for(Producto p: productos){
            importe += p.getPrecio();
        }
        return importe;
    }

    @Transient
    public double getImporteIVA(){
        return getImporteTotal() + getImporteTotal() * 0.21;
    }

    public Factura(){

    }
    public String getNif() {
        return this.nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Producto> getProductos() {
        return this.productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public int getnproductos(){
        return this.productos.size();
    }
}
