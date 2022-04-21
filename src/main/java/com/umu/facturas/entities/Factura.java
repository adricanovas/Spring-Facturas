package com.umu.facturas.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Data
@Table(name = "FACTURA", schema = "FACTURAS")
@SequenceGenerator(schema = "FACTURAS", sequenceName = "factura_seq", name = "generador_factura_seq", initialValue = 0, allocationSize = 1)
public class Factura implements java.io.Serializable{

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(generator = "generador_factura_seq", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "NIF", unique = false, length = 9)
    private String nif;

    @Column(name = "CONSOLIDADA")
    private Boolean consolidada = false;

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
        return Math.round(getImporteTotal() + getImporteTotal() * 0.21);
    }

    public Factura(){

    }
}
