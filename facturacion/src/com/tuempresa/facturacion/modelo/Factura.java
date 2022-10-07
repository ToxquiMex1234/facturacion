package com.tuempresa.facturacion.modelo;

import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;
import org.openxava.calculators.*;

import com.tuempresa.facturacion.calculadores.*;

import lombok.*;

public class Factura {
	@Id
	 @GeneratedValue(generator="system-uuid")
	 @Hidden
	 @GenericGenerator(name="system-uuid", strategy="uuid")
	 @Column(length=32)
	 String oid;
	 @Column(length=4)
	 @DefaultValueCalculator(CurrentYearCalculator.class) // Año actual
	 int anyo;
	 @Column(length=6)
	 int numero1;
	 @Required
	@DefaultValueCalculator(CurrentLocalDateCalculator.class) // Fecha actual
	 @TextArea
	 String observaciones;
	  @Column (length=6)
      @DefaultValueCalculator(value=ClculadorSiguienteNumeroParaAnyo.class,
      properties=@PropertyValue(name="anyo")
      )
	  int numero;
	  @ManyToOne(fetch=FetchType.LAZY, optional=false)
	  Cliente cliente;
	  @ElementCollection
	  Collection<Detalle>detalles;
	  
	  @Embeddable @Getter @Setter
	  public class Detalle{
		  @ManyToOne(fetch=FetchType.LAZY, optional =true)
		  Producto producto;
		  @ElementCollection
		  @ListProperties("producto.numero, producto.descripcion, cantidad")
		  Collection<Detalle>detalles;
		  //LECCION 3
	  }
	  
	  
	  
	  


}
