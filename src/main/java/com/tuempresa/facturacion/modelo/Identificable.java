package com.tuempresa.facturacion.modelo;

import javax.persistence.*;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import lombok.*;

@MappedSuperclass
@Getter @Setter
public class Identificable {
	
 @Id
 @Hidden
 @GeneratedValue(generator="System-uuid")
 @GenericGenerator(name="System-uuid",strategy="uuid")
 @Column(length=32)
 String oid;
}
