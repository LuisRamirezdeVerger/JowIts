package interfacesGraficas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RegistroNuevoEmpleado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.TRAILING);
		textField.setBounds(798, 380, 237, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText("Añadir el nombre del nuevo empleado");
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//Creamos evento que al hacer click, elimine el texto que haya.
				textField.setText("");
			}
		});
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.TRAILING);
		textField_1.setColumns(10);
		textField_1.setBounds(798, 434, 237, 43);
		contentPane.add(textField_1);textField_1.setText("Añadir el DNI");
		textField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//Creamos evento que al hacer click, elimine el texto que haya.
				textField_1.setText("");
			}
		});
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.TRAILING);
		textField_2.setColumns(10);
		textField_2.setBounds(798, 488, 237, 43);
		contentPane.add(textField_2);textField_2.setText("En que turno trabajará");
		textField_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//Creamos evento que al hacer click, elimine el texto que haya.
				textField_2.setText("");
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
	                String nombre = textField.getText();
	                String dni = textField_1.getText();
	                String turno = textField_2.getText();

	                // Mostrar los datos en un cuadro de diálogo
	                JOptionPane.showMessageDialog(contentPane,
	                        "Nombre: " + nombre + "\nDNI: " + dni + "\nTurno: " + turno,
	                        "Datos del Nuevo Empleado",
	                        JOptionPane.INFORMATION_MESSAGE);
	            }

				
	        });
	    
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
