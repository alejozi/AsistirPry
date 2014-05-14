package co.com.asistir.To;

import java.util.Date;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Cita.class)
public abstract class Cita_ {

	public static volatile SingularAttribute<Cita, Integer> id;
	public static volatile SingularAttribute<Cita, String> epicrisis;
	public static volatile SingularAttribute<Cita, ManejoSoportes> fkSoporte;
	public static volatile SingularAttribute<Cita, String> codServicio;
	public static volatile CollectionAttribute<Cita, ImpresionDiagnostica> impresionDiagnosticaCollection;
	public static volatile SingularAttribute<Cita, Date> fecha;
	public static volatile SingularAttribute<Cita, ExamenFisico> fkExamen;
	public static volatile SingularAttribute<Cita, String> convenio;
	public static volatile SingularAttribute<Cita, Persona> fkPersona;
	public static volatile CollectionAttribute<Cita, Medicamento> medicamentoCollection;
	public static volatile SingularAttribute<Cita, String> enfermeraAuxiliar;
	public static volatile SingularAttribute<Cita, String> nombreMedico;
	public static volatile SingularAttribute<Cita, String> movil;
	public static volatile SingularAttribute<Cita, String> ordenesMedicas;

}

