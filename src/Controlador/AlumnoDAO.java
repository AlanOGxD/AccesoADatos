package Controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.RootPaneContainer;

import com.mysql.cj.protocol.Resultset;

import ConexionBD.ConexionBD;
import Modelo.Alumno;

public class AlumnoDAO {

	public boolean AlumnoDAO(Alumno a) {
		//INSERT INTO Alumnos VALUES('2', '2','2','2',2,2,'2');
		
		//se puede hacer de las dos siguientes maneras
		String sql = "INSERT INTO Alumnos VALUES(\"1\", \"1\",\"1\",\"1\",1,1,\"1\")";
		String sql2 = "INSERT INTO Alumnos VALUES('2', '2','2','2',2,2,'2')";
		
		String sql3="INSERT INTO Alumnos VALUES('"+a.getNumControl()+"','"+a.getNombre()+"','"+a.getPrimerAp()+"','"+a.getSegundoAp()+"',"+a.getEdad()+","
				+a.getSemetre()+",'"+a.getCarrera()+"')";
		ConexionBD conexion = new ConexionBD();
		
		return conexion.ejecutarInstruccion(sql3);
	} 
	
	public boolean eliminarAlumno(String nc) {
		String sql = "DELETE FROM Alumnos WHERE NumControl = '"+nc+"';";
		
		ConexionBD conexion = new ConexionBD();
		return conexion.ejecutarInstruccion(sql);
	}
	
	public boolean modificarAlumno(Alumno a) {
		String sql="UPDATE Alumnos SET NumControl='"+a.getNumControl()+"', edad='"+ a.getEdad()+"', semestre='"+a.getSemetre()+"', carrera='"+a.getCarrera()+"', nombre='"+a.getNombre()
		+"', PrimerAP='"+a.getPrimerAp()+"', SegundoAP='"+a.getSegundoAp()+"' WHERE NumControl='"+a.getNumControl()+"'";
		ConexionBD conexion = new ConexionBD();
		
		return conexion.ejecutarInstruccion(sql);
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ BUSCAR UN REGISTRO~~~~~~~~~~~~~~~~
	
	public Alumno buscarAlumno(String numControl) {
		Alumno alumno = new Alumno();
		//SELECT * FROM Alumnos WHERE NumControl =1;
		String sql = "SELECT * FROM alumnos WHERE NumControl = '"+numControl+"';";
		ConexionBD conexion = new ConexionBD();
		ResultSet rs = conexion.ejecutarConsultaRegistros(sql);
		
		try {
			rs.last();
			
			alumno.setNumControl(rs.getString(1));
			alumno.setNombre(rs.getString(2));
			alumno.setPrimerAp(rs.getString(3));
			alumno.setSegundoAp(rs.getString(4));
			alumno.setEdad(rs.getString(5));
			alumno.setSemetre(rs.getString(6));
			alumno.setCarrera(rs.getString(7));
		} catch (SQLException e) {
			
		}
		
		return alumno;
		
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~ BUSCAR MULTIPLES REGISTROS~~~~~~
	public ArrayList<Alumno> buscarAlumnos(String filtro){
		String sql = "SELECT * FROM alumnos WHERE Carrera='"+filtro+"';";
		ArrayList<Alumno> listaAlumnos = new ArrayList<>();
		ConexionBD conexion = new ConexionBD();
		ResultSet rs = conexion.ejecutarConsultaRegistros(sql);
		//RECORRER EL ResultSet miesntras haya registros
		//SELECT * FROM alumnos
		
		try {
			int cont=0;
			rs.first();
			while (!rs.isAfterLast()) {
			Alumno alumno = new Alumno();
			alumno.setNumControl(rs.getString(1));
			alumno.setNombre(rs.getString(2));
			alumno.setPrimerAp(rs.getString(3));
			alumno.setSegundoAp(rs.getString(4));
			alumno.setEdad(rs.getString(5));
			alumno.setSemetre(rs.getString(6));
			alumno.setCarrera(rs.getString(7));
			
			listaAlumnos.add(alumno);
			rs.next();
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("No se encontraron registros");
			return null;
		}
		
		
		return listaAlumnos;
	}
}
