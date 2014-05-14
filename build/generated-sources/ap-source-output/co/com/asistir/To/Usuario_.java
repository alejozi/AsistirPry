package co.com.asistir.To;

import java.math.BigInteger;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Usuario.class)
public abstract class Usuario_ {

	public static volatile SingularAttribute<Usuario, String> usuarioNombre;
	public static volatile SingularAttribute<Usuario, Boolean> usuarioEstado;
	public static volatile SingularAttribute<Usuario, String> usuarioEmail;
	public static volatile SingularAttribute<Usuario, String> usuarioApellido;
	public static volatile SingularAttribute<Usuario, String> usuarioLogin;
	public static volatile SingularAttribute<Usuario, Integer> usuarioId;
	public static volatile SingularAttribute<Usuario, BigInteger> usuarioCedula;
	public static volatile SingularAttribute<Usuario, String> usuarioPass;

}

