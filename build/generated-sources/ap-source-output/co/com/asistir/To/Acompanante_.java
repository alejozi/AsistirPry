package co.com.asistir.To;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Acompanante.class)
public abstract class Acompanante_ {

	public static volatile SingularAttribute<Acompanante, byte[]> nombre;
	public static volatile SingularAttribute<Acompanante, Integer> id;
	public static volatile SingularAttribute<Acompanante, Persona> fkPaciente;
	public static volatile SingularAttribute<Acompanante, byte[]> parentesco;
	public static volatile SingularAttribute<Acompanante, Integer> nroDoc;

}

