package co.com.asistir.To;

import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Ante.class)
public abstract class Ante_ {

	public static volatile CollectionAttribute<Ante, Persona> personaCollection;
	public static volatile SingularAttribute<Ante, String> alergicos;
	public static volatile SingularAttribute<Ante, Integer> idAntecedentes;
	public static volatile SingularAttribute<Ante, String> familiares;
	public static volatile SingularAttribute<Ante, String> fur;
	public static volatile SingularAttribute<Ante, String> menarquia;
	public static volatile SingularAttribute<Ante, String> quirurgicos;
	public static volatile SingularAttribute<Ante, String> tipoFur;
	public static volatile SingularAttribute<Ante, String> farmacologicos;
	public static volatile SingularAttribute<Ante, String> patologicos;

}

