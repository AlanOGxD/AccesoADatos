package Vista;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.awt.*;
import javax.swing.*;

import Controlador.AlumnoDAO;
import Modelo.Alumno;

class VentanaInicio extends JFrame implements ActionListener{
	
	JMenu menuPrincipalAlumnos;
	JMenuItem itemAltaAlumnos, itemBAjaAlumnos,itemCambioAlumnos, itemConsultaAlumnos;
	
	JInternalFrame internalFrameAltaAlumos = new JInternalFrame();
	
	JButton btnAgregar, btnBorrar, btnCancelar;
	
	JTextField cajaNumControl, cajaNombres, cajaApPaterno, cajaApMaterno;
	
	JComboBox<String> comboSemestre, comboCarrera;
	
	JTable tablaAlumnos;
	public VentanaInicio() {
		getContentPane().setLayout(new BorderLayout());
		setSize(800, 800);
		setLocationRelativeTo(null);
		setTitle("Ventana Alumnos");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		JMenuBar menuBar = new JMenuBar();
		menuPrincipalAlumnos = new JMenu("Alumnos");
			
			itemAltaAlumnos = new JMenuItem("Agregar");
				itemAltaAlumnos.addActionListener(this);
				itemAltaAlumnos.setMnemonic(KeyEvent.VK_G);
				itemAltaAlumnos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.ALT_MASK));
		menuPrincipalAlumnos.add(itemAltaAlumnos);
		
		menuBar.add(menuPrincipalAlumnos);
		
		setJMenuBar(menuBar);
		
		//INTERNAL FRAMES
		JDesktopPane desktopPane = new JDesktopPane();
		
			internalFrameAltaAlumos = new JInternalFrame("Agregar Alumno");
			internalFrameAltaAlumos.getContentPane().setLayout(null);
			internalFrameAltaAlumos.setDefaultCloseOperation(HIDE_ON_CLOSE);
			
			internalFrameAltaAlumos.setClosable(true);
			internalFrameAltaAlumos.setMaximizable(true);
			internalFrameAltaAlumos.setIconifiable(true);
			internalFrameAltaAlumos.setResizable(true);
			
			internalFrameAltaAlumos.setSize(700, 700);
			
			//Componentes
			JPanel panelAltaAlumnos = new JPanel();
				JPanel panel1 = new JPanel();
				panel1.setBackground(Color.GREEN);
				panel1.setBounds(0, 10, 700, 50);
				panel1.setLayout(null); 
				JLabel lblAltas = new JLabel("ALTAS ALUMNOS");
				
				lblAltas.setForeground(Color.WHITE);
				lblAltas.setFont(new Font("OCR A Extended", 2, 20));
				lblAltas.setBounds(10, 10, 170, 30);
				panel1.add(lblAltas);
				
				panelAltaAlumnos.setBackground(Color.WHITE);
				panelAltaAlumnos.setSize(700, 700);
				panelAltaAlumnos.setLayout(null);
				JLabel lblNumControl = new JLabel("NUMERO DE CONTROL: ");
				lblNumControl.setBounds(60, 80, 150, 20);
				panelAltaAlumnos.add(lblNumControl);
			panelAltaAlumnos.add(panel1);
			
				cajaNumControl = new JTextField();
				cajaNumControl.setBounds(200, 80, 150, 20);
				panelAltaAlumnos.add(cajaNumControl);
				
				JLabel lblNombre = new JLabel("NOMBRES:");
				lblNombre.setBounds(60, 110, 150, 20);
				panelAltaAlumnos.add(lblNombre);
				
				cajaNombres = new JTextField();
				cajaNombres.setBounds(130, 110, 220, 20);
				panelAltaAlumnos.add(cajaNombres);
				
				JLabel lblApellidoPaterno = new JLabel("APELLIDO PATERNO: ");
				lblApellidoPaterno.setBounds(60, 150, 150, 20);
				panelAltaAlumnos.add(lblApellidoPaterno);
				
				cajaApPaterno = new JTextField();
				cajaApPaterno.setBounds(190, 150, 160, 20);
				panelAltaAlumnos.add(cajaApPaterno);
				
				JLabel lblApellidoMaterno = new JLabel("APELLIDO MATERNO: ");
				lblApellidoMaterno.setBounds(60, 180, 150, 20);
				panelAltaAlumnos.add(lblApellidoMaterno);
				
				cajaApMaterno = new JTextField();
				cajaApMaterno.setBounds(190, 180, 160, 20);
				panelAltaAlumnos.add(cajaApMaterno);
				
				JLabel lblSemestre =  new JLabel("SEMESTRE: ");
				lblSemestre.setBounds(60, 210, 150, 20);
				panelAltaAlumnos.add(lblSemestre);
				
				comboSemestre = new JComboBox<String>();
				comboSemestre.addItem("Elige un semestre... ");
				comboSemestre.addItem("1°");
				comboSemestre.addItem("2°");
				comboSemestre.addItem("3°");
				comboSemestre.addItem("4°");
				comboSemestre.addItem("5°");
				comboSemestre.addItem("6°");
				comboSemestre.addItem("7°");
				comboSemestre.addItem("8°");
				comboSemestre.addItem("9°");
				comboSemestre.addItem("10°");
				comboSemestre.setBounds(190, 210, 160, 20);
				panelAltaAlumnos.add(comboSemestre);
				
				JLabel lblCarrera =  new JLabel("CARRERA: ");
				lblCarrera.setBounds(60, 240, 150, 20);
				panelAltaAlumnos.add(lblCarrera);
				
				comboCarrera = new JComboBox<String>();
				comboCarrera.addItem("Elige Carrera: ");
				comboCarrera.addItem("I.S.C.");
				comboCarrera.addItem("I.M.");
				comboCarrera.addItem("I.I.A.");
				comboCarrera.setBounds(190, 240, 160, 20);
				panelAltaAlumnos.add(comboCarrera);
				
				btnAgregar = new JButton("AGREGAR");
				btnAgregar.setBounds(420, 100, 100, 20);
				panelAltaAlumnos.add(btnAgregar);
				
				btnBorrar = new JButton("BORRAR");
				btnBorrar.setBounds(420, 160, 100, 20);
				panelAltaAlumnos.add(btnBorrar);
				
				btnCancelar =  new JButton("CANCELAR");
				btnCancelar.setBounds(420, 220, 100, 20);
				panelAltaAlumnos.add(btnCancelar);
		
				tablaAlumnos =  new JTable(6,6);
				tablaAlumnos.setBounds(20, 300, 650, 220);
				tablaAlumnos.setValueAt("NO. DE CONTROL", 0, 0);
				tablaAlumnos.setValueAt("  NOMBRE", 0, 1);
				tablaAlumnos.setValueAt("AP. PATERNO", 0, 2);
				tablaAlumnos.setValueAt("AP. MATERNO", 0, 3);
				tablaAlumnos.setValueAt("  SEMESTRE", 0, 4);
				tablaAlumnos.setValueAt("  CARRERA", 0, 5);
				panelAltaAlumnos.add(tablaAlumnos);
				
		internalFrameAltaAlumos.add(panelAltaAlumnos);
		desktopPane.add(internalFrameAltaAlumos);
		
	
	add(desktopPane, BorderLayout.CENTER);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		actualizarTabla(tablaAlumnos);
		if (e.getSource() == itemAltaAlumnos) {
			
			internalFrameAltaAlumos.setVisible(true);
			
			if (e.getSource()== btnAgregar) {
				//Alumno a1 = new Alumno(cajaNumControl.getText(), cajaNombres.getText(), cajaApPaterno.getText(), cajaApMaterno.getText(), (byte)18, (byte)comboSemestre.getSelectedItem(), (byte)comboCarrera.getSelectedItem());
				
				AlumnoDAO adao = new AlumnoDAO();
				//adao.AlumnoDAO(a1);
				//adao.AlumnoDAO(a1);
			}
		}
		
	}
	
	
	public void actualizarTabla(JTable tabla) {
		String controlador="com.mysql.cj.jdbc.Driver";
		String url ="jdbc:mysql://localhost:3306/BD_Escuela?useTimezone=true&serverTimezone=UTC";
		String consulta ="SELECT * FROM Alumnos";
		ResultSetTableModel modeloDatos=null; 
		try {
			modeloDatos= new ResultSetTableModel(controlador, url, consulta);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	tabla.setModel(modeloDatos);
	 
	}
}

public class Prueba {
public static void main(String[] args) throws InvocationTargetException, InterruptedException {
	/*Alumno a1 = new Alumno("2", "2", "2", "2", (byte)3, (byte)2, (byte)3);
	AlumnoDAO adao = new AlumnoDAO();
	adao.AlumnoDAO(a1);
	
	adao.buscarAlumno("2");
	System.out.println(adao.buscarAlumno("3"));*/
	SwingUtilities.invokeAndWait(new Runnable() {
		
		@Override
		public void run() {
			
			// TODO Auto-generated method stub
			new VentanaInicio();
		}
	});
}
}
