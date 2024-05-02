package interfacesGraficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connections.ConexionMySQL;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RegistroNuevoEmpleado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombreEmpleado;
	private JTextField textAñadirDNI;
	private JTextField textTurno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroNuevoEmpleado frame = new RegistroNuevoEmpleado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistroNuevoEmpleado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JEditorPane editorPane = new JEditorPane();
		contentPane.add(editorPane);
		
		/*
		 * LOGO
		 */
		
		JLabel lblImagen = new JLabel("Logo");
		lblImagen.setBounds(450, 11, 343, 263);
		ImageIcon ico2 = new ImageIcon(getClass().getResource("/imagenes/logo2.png"));
		ImageIcon img2 = new ImageIcon(ico2.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH));
		lblImagen.setIcon(img2);
		contentPane.add(lblImagen);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre empleado:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(194, 376, 237, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDni.setBounds(194, 430, 237, 43);
		contentPane.add(lblDni);
		
		JLabel lblTurnoQueTrabajara = new JLabel("Turno que trabajara:");
		lblTurnoQueTrabajara.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTurnoQueTrabajara.setBounds(194, 484, 237, 43);
		contentPane.add(lblTurnoQueTrabajara);
		
		textNombreEmpleado = new JTextField();
		textNombreEmpleado.setHorizontalAlignment(SwingConstants.TRAILING);
		textNombreEmpleado.setBounds(798, 380, 237, 43);
		contentPane.add(textNombreEmpleado);
		textNombreEmpleado.setColumns(10);
		textNombreEmpleado.setText("Añadir el nombre del nuevo empleado");
		textNombreEmpleado.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//Creamos evento que al hacer click, elimine el texto que haya.
				textNombreEmpleado.setText("");
			}
		});
		
		textAñadirDNI = new JTextField();
		textAñadirDNI.setHorizontalAlignment(SwingConstants.TRAILING);
		textAñadirDNI.setColumns(10);
		textAñadirDNI.setBounds(798, 434, 237, 43);
		contentPane.add(textAñadirDNI);textAñadirDNI.setText("Añadir el DNI");
		textAñadirDNI.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//Creamos evento que al hacer click, elimine el texto que haya.
				textAñadirDNI.setText("");
			}
		});
		
		textTurno = new JTextField();
		textTurno.setHorizontalAlignment(SwingConstants.TRAILING);
		textTurno.setColumns(10);
		textTurno.setBounds(798, 488, 237, 43);
		contentPane.add(textTurno);textTurno.setText("En que turno trabajará");
		textTurno.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//Creamos evento que al hacer click, elimine el texto que haya.
				textTurno.setText("");
			}
		});
		
		
		
		
		/*
		 * Boton que regista al empleado nuevo
		 */
		
		 JButton btnRegistrar = new JButton("Registrar Empleado");
	        btnRegistrar.setBounds(913, 131, 247, 102);
	        contentPane.add(btnRegistrar);
	        btnRegistrar.addActionListener(new ActionListener() {
	           
	        	@Override
	        	public void actionPerformed(ActionEvent e) {
	                // Obtener el texto de cada campo de texto
	                String nombre = textNombreEmpleado.getText();
	                String dni = textAñadirDNI.getText();
	                String turno = textTurno.getText();

	                String consulta= "INSERT INTO empleados (nombre, dni, turno) VALUES ('nombre_del_empleado', 'dni_del_empleado', 'turno_del_empleado');";

	                ConexionMySQL conexion = new ConexionMySQL("freedb_wito.medac", "8DKQRDXu6Xumm@r", "freedb_medac420");
	                try {
	                	
						conexion.conectar();
						System.out.println("Conectado");
						
						//conexion.ejecutarInsertDeleteUpdate(consulta);
						
						int filasAfectadas = conexion.ejecutarInsertDeleteUpdate(consulta);
						
						System.out.println("Fila insertada");
						
						conexion.desconectar();
						System.out.println("Desconectado");
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
	                
	                // Mostrar los datos en un cuadro de diálogo
	                JOptionPane.showMessageDialog(contentPane,
	                        "Nombre: " + nombre + "\nDNI: " + dni + "\nTurno: " + turno,
	                        "Datos del Nuevo Empleado",
	                        JOptionPane.INFORMATION_MESSAGE);
	            }

				
	        });
	    
		
	        JButton volverMain = new JButton("Volver");
			volverMain.setLocation(967, 42);
			volverMain.setSize(168, 58);
			volverMain.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Mostrar el siguiente frame
	                Main frame2 = new Main();
	                frame2.setVisible(true);
	                dispose();
	            }
	        });	        
	        getContentPane().add(volverMain, BorderLayout.CENTER);	        
	        setVisible(true);
	}

}
