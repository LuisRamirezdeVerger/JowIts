package connections;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// -- Conexión a la tabla persona --
		//ConexionMySQL connect = new ConexionMySQL("root", "test", "Persona");
		// -- Conexión a la tabla Inventario --
		ConexionMySQL connectInv = new ConexionMySQL("freedb_wito.medac", "8DKQRDXu6Xumm@r", "freedb_medac420");
		
		Scanner sc = new Scanner (System.in);
		try {
			connectInv.conectar();
			System.out.println("Conexión establecida. ");
			
			
			// Ejemplo de sentencia pre-definida
			/*String sentencia = "INSERT INTO Persona (Nombre, Edad) VALUES ('Wito', '32')";
			connect.ejecutarInsertDeleteUpdate(sentencia);*/
			// Ejemplo de sentencia definida por el usuario
			/* System.out.println("Introduzca nombre: ");
			String nombre = sc.next();
			System.out.println("Introduzca edad: ");
			int edad = sc.nextInt();
			String sentenciaTeclado = "INSERT INTO Persona (Nombre, Edad) VALUES ('"+ nombre +"', '"+ edad +"')";
			connect.ejecutarInsertDeleteUpdate(sentenciaTeclado);*/
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connectInv.desconectar();
				System.out.println("Desconectando :D ");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		sc.close();
	}

}
