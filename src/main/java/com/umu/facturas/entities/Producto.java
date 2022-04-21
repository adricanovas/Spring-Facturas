package com.umu.facturas.entities;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;

import lombok.Data;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@Entity
@Data
@Table(name = "PRODUCTO", schema = "FACTURAS")
@NamedQueries({@NamedQuery(name = "Producto.obtenerProductoTodos", query = "SELECT producto FROM Producto producto")})
@SequenceGenerator(schema = "FACTURAS", sequenceName = "producto_seq", name = "generador_producto_seq", initialValue = 0, allocationSize = 1)
public class Producto implements java.io.Serializable {
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(generator = "generador_producto_seq", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "DESCRIPCION", nullable = false, length = 256)
    private String descripcion;

    @Column(name = "PRECIO", nullable = false, precision = 17, scale = 0)
    private double precio;

    public Producto() {

    }
}
