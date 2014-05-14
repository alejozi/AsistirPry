package co.com.asistir.To;

import java.util.Date;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Persona.class)
public abstract class Persona_ {

	public static volatile SingularAttribute<Persona, String> direccion;
	public static volatile CollectionAttribute<Persona, Cita> citaCollection;
	public static volatile SingularAttribute<Persona, String> aseguradora;
	public static volatile SingularAttribute<Persona, String> ciudad;
	public static volatile SingularAttribute<Persona, String> apellidos;
	public static volatile SingularAttribute<Persona, String> estadoCivil;
	public static volatile SingularAttribute<Persona, Date> fechaNac;
	public static volatile SingularAttribute<Persona, String> telefono;
	public static volatile SingularAttribute<Persona, Ante> fkAnte;
	public static volatile SingularAttribute<Persona, String> sexo;
	public static volatile SingularAttribute<Persona, String> tipoAseguradora;
	public static volatile SingularAttribute<Persona, String> ocupacion;
	public static volatile SingularAttribute<Persona, String> nombres;
	public static volatile SingularAttribute<Persona, Integer> edad;
	public static volatile SingularAttribute<Persona, String> tipoDocumento;
	public static volatile SingularAttribute<Persona, Integer> idPersona;
	public static volatile SingularAttribute<Persona, String> celular;

}

