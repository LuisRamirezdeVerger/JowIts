package connections;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// -- Conexión a la tabla persona --
		//ConexionMySQL connect = new ConexionMySQL("root", "test", "Persona");
		// -- Conexión a la tabla Inventario --
		ConexionMySQL connectInv = new ConexionMySQL("root", "test", "Inventario");
		
		Scanner sc = new Scanner (System.in);
		try {
			connectInv.conectar();
			System.out.println("Conectado. ");
			
			
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
			
			String sentenciaDelete = "DELETE FROM Armas";
			int filasEliminadas = connectInv.ejecutarInsertDeleteUpdate(sentenciaDelete);
		    System.out.println("Se eliminaron " + filasEliminadas + " registros de la tabla Armas. ");
		    
		    String insertEspadaMadera = "INSERT INTO Inventario.Armas (id, dmg, durabilidad, nombre, encontrado) VALUES ('1', '1', '2', 'Espada de Madera', true)";
			String insertEspadaPiedra = "INSERT INTO Inventario.Armas (id, dmg, durabilidad, nombre, encontrado) VALUES ('2', '2', '3', 'Espada de Piedra', true)";
			
			//Como tenemos configurado el campo "id" como AutoIncremental, si obviamos el dato al insertarlo, el SGBD se encargará de enumerarlo
			String insertEspadaMetal = "INSERT INTO Inventario.Armas (dmg, durabilidad, nombre, encontrado) VALUES ('3', '4', 'Espada de Metal', true)";

			connectInv.ejecutarInsertDeleteUpdate(insertEspadaMadera);
			connectInv.ejecutarInsertDeleteUpdate(insertEspadaPiedra);
			connectInv.ejecutarInsertDeleteUpdate(insertEspadaMetal);
			
		    String sentenciaSelect = "SELECT * FROM Armas";
			ResultSet resultados;
			resultados = connectInv.ejecutarSelect(sentenciaSelect);
			
		    
			//Recorremos los datos rescatados y los imprimimos
			System.out.println("Los resultados de la BBDD son: ");
			while (resultados.next()) {
				int tempId = resultados.getInt("id");
				int tempDmg = resultados.getInt("dmg");
				int tempDurabilidad = resultados.getInt("durabilidad");
				String tempNombre = resultados.getNString("nombre");
				boolean tempEncontrado = false;
				
				System.out.println("ID: " + tempId + " \n " + "Nombre: " + tempNombre + " \n " + "Daño: " + tempDmg + " \n " + "Durabilidad:  " + tempDurabilidad + " \n " + "Estado encontrado: " + tempEncontrado);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connectInv.desconectar();
				System.out.println("Desconectado :D. ");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		sc.close();
	}

}
