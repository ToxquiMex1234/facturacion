package com.tuempresa.facturacion.modelo;

import java.util.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
public class Autor {
	
	@Id @GeneratedValue(generator="system-uuid")
	@Hidden
	@GenericGenerator(name="system-uuid", strategy="uuid")
	String oid;
	
     @Column(length=50)
     String nombre;

    @OneToMany(mappedBy="autor",cascade=CascadeType.REMOVE)
    @ListProperties("numero,descripcion,precio")
    Collection<Producto>productos;
}
