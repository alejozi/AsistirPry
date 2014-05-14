package co.com.asistir.To;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Medicamento.class)
public abstract class Medicamento_ {

	public static volatile SingularAttribute<Medicamento, Integer> id;
	public static volatile SingularAttribute<Medicamento, String> via;
	public static volatile SingularAttribute<Medicamento, String> nombreMedicamento;
	public static volatile SingularAttribute<Medicamento, Integer> cantidad;
	public static volatile SingularAttribute<Medicamento, Cita> fkCita;

}

