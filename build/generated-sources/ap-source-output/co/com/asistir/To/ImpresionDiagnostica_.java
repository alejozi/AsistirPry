package co.com.asistir.To;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ImpresionDiagnostica.class)
public abstract class ImpresionDiagnostica_ {

	public static volatile SingularAttribute<ImpresionDiagnostica, String> codigo;
	public static volatile SingularAttribute<ImpresionDiagnostica, Integer> id;
	public static volatile SingularAttribute<ImpresionDiagnostica, String> descripcion;
	public static volatile SingularAttribute<ImpresionDiagnostica, Cita> fkCita;

}

