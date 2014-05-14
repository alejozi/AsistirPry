package co.com.asistir.To;

import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ExamenFisico.class)
public abstract class ExamenFisico_ {

	public static volatile CollectionAttribute<ExamenFisico, Cita> citaCollection;
	public static volatile CollectionAttribute<ExamenFisico, DetalleExamenFisico> detalleExamenFisicoCollection;
	public static volatile SingularAttribute<ExamenFisico, String> extremidades;
	public static volatile SingularAttribute<ExamenFisico, Character> alerta;
	public static volatile SingularAttribute<ExamenFisico, Integer> idEstadoFisico;
	public static volatile SingularAttribute<ExamenFisico, String> abdomen;
	public static volatile SingularAttribute<ExamenFisico, String> cabezaCuello;
	public static volatile SingularAttribute<ExamenFisico, String> urogenital;
	public static volatile SingularAttribute<ExamenFisico, Character> otro;
	public static volatile SingularAttribute<ExamenFisico, String> ginecobtetrico;
	public static volatile SingularAttribute<ExamenFisico, Character> estadoGeneral;
	public static volatile SingularAttribute<ExamenFisico, Character> conciente;
	public static volatile SingularAttribute<ExamenFisico, Character> orientado;
	public static volatile SingularAttribute<ExamenFisico, String> aparatoCardiovascular;
	public static volatile SingularAttribute<ExamenFisico, String> sistemaNervioso;
	public static volatile SingularAttribute<ExamenFisico, String> aparatoRespiratorio;

}

