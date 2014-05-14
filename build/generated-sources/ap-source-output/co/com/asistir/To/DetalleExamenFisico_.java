package co.com.asistir.To;

import java.math.BigInteger;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(DetalleExamenFisico.class)
public abstract class DetalleExamenFisico_ {

	public static volatile SingularAttribute<DetalleExamenFisico, BigInteger> peso;
	public static volatile SingularAttribute<DetalleExamenFisico, Integer> hora;
	public static volatile SingularAttribute<DetalleExamenFisico, BigInteger> spo2;
	public static volatile SingularAttribute<DetalleExamenFisico, ExamenFisico> fkExamenFisico;
	public static volatile SingularAttribute<DetalleExamenFisico, BigInteger> t;
	public static volatile SingularAttribute<DetalleExamenFisico, Integer> idDetalle;
	public static volatile SingularAttribute<DetalleExamenFisico, BigInteger> glasgow;
	public static volatile SingularAttribute<DetalleExamenFisico, BigInteger> fr;
	public static volatile SingularAttribute<DetalleExamenFisico, BigInteger> fc;
	public static volatile SingularAttribute<DetalleExamenFisico, BigInteger> tensionArterial;

}

