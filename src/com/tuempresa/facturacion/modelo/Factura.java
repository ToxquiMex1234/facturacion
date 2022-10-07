package com.tuempresa.facturacion.modelo;

import java.time.*;
import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;
import org.openxava.calculators.*;

import com.tuempresa.facturacion.calculadores.*;
@View(members =
         "anyo, numero, fecha;"+
          "cliente;"+
          "detalles"+
          "observaciones"
          )
public class Factura {
	 @Id
	 @GeneratedValue(generator="system-uuid")
	 @Hidden
	 @GenericGenerator(name="system-uuid", strategy="uuid")
	 @Column(length=32)
	 String oid;
	
	
	 @DefaultValueCalculator(CurrentYearCalculator.class) // Año actual
	 @Column(length=4)
	 int anyo;
	 
	 @Column(length=6)
      @DefaultValueCalculator(value=ClculadorSiguienteNumeroParaAnyo.class,
      properties=@PropertyValue(name="anyo"))
      int numero;
      
	  @Required
	  @DefaultValueCalculator(CurrentLocalDateCalculator.class)
	  LocalDate fecha;
	  
	 
	  @ManyToOne(fetch=FetchType.LAZY, optional=false)
	  @ReferenceView("Simple")
	  Cliente cliente;
	  
	   @ElementCollection
	   @ListProperties("producto.numero, producto.descripcion, cantidad")
	   Collection<Detalle>detalles;
	   
	   @Stereotype("MEMO")
	   String observaciones;
		  
		  //LECCION 5
	  }
	  
	    
	  
	  
