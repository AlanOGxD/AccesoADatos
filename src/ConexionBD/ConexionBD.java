package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {
	private Connection conexion;
	private Statement stm;
	
	private PreparedStatement pst;//para proyecto final, evitar sql injection
	
	ResultSet rs;
	
	public ConexionBD() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/BD_Escuela?useTimezone=true&serverTimezone=UTC";
		
		conexion = DriverManager.getConnection(url, "root", "alanxD");
		
		System.out.println("Magia magia con BD, ya casi soy ISC =) ");
		
	} catch (ClassNotFoundException e2) {
		System.out.println("No se encontró el controlador");
		System.out.println("Mejor me dedico a las redes =(");
	}catch (SQLException e2) {
		System.out.println("No se puede conectar al servidor");
		System.out.println("Mejor me dedico a las redes =(");
		e2.printStackTrace();
	}finally {
		//codigo que siempre se ejecuta
		//cierre de conexion a BD, no se recomienda
	}
	
	
	}//constructor
	
	public void cerrarConexion() {
		try {
		stm.close();
		conexion.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("No se pudo cerrar la conexion");
		}
	}//cerrarConexion
	
	//Metodos que ejecuten las operaciones ABCC (DDL, DML Y SQL)
	//un metodo para DDL Y DML 
	//otro metodo para SQL
	
	public boolean ejecutarInstruccion(String sql) {
		try {
		stm=conexion.createStatement();
		int ejecucion;
		ejecucion=stm.executeUpdate(sql);
		return ejecucion == 1?true:false;
		}catch (SQLException e) {
			System.out.println("No se pudo ejecutar la instruccion SQL");
		return false;
		}
		
	}//ejecutarInstruccion
	
	
	//otro metodo para SQL (consultas)
	public ResultSet ejecutarConsultaRegistros(String sql) {
		
		try {
			stm=conexion.createStatement();
			rs=stm.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			System.out.println("No se pudo ejecutar la consulta SQL");
			
		}
		
		return rs;
	}
	
	public static void main(String[] args) {
		new ConexionBD();
	}
	
}
