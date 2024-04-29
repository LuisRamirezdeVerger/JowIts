package componentes;

public class Usuario {
 //idUsuario, nombreUsuario, dniUsuario, passUsuario
	private static int idUsuario;
	private static String nombreUsuario;
	private static String dniUsuario;
	private static String passUsuario;
	
	public static int getIdUsuario() {
		return idUsuario;
	}
	public static void setIdUsuario(int newIdUsuario) {
		Usuario.idUsuario = newIdUsuario;
	}
	public static String getNombreUsuario() {
		return nombreUsuario;
	}
	public static void setNombreUsuario(String newNombreUsuario) {
		Usuario.nombreUsuario = newNombreUsuario;
	}
	public static String getDniUsuario() {
		return dniUsuario;
	}
	public static void setDniUsuario(String newDniUsuario) {
		Usuario.dniUsuario = newDniUsuario;
	}
	public static String getPassUsuario() {
		return passUsuario;
	}
	public static void setPassUsuario(String newPassUsuario) {
		Usuario.passUsuario = newPassUsuario;
	}
	
}
