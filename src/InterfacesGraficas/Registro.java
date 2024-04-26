package interfacesGraficas;

import java.sql.Connection;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connections.*;

import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 ConexionMySQL conexion = new ConexionMySQL("freedb_wito.medac", "8DKQRDXu6Xumm@r", "freedb_medac420");

	
	// Método para obtener la conexión
    public ConexionMySQL obtenerConexion() {
        return obtenerConexion();
        
    }
    
    

	/**
	 * Create the frame.
	 */
	public Registro() {
		setTitle("REGISTRO");
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
		 * CUADRADO NOMBRE
		 */
		
		JEditorPane dtrpnNombre = new JEditorPane();
		dtrpnNombre.setText("Nombre");
		dtrpnNombre.setBounds(283, 358, 200, 30);
		contentPane.add(dtrpnNombre);
		
		
		dtrpnNombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//Creamos evento que al hacer click, elimine el texto que haya.
				dtrpnNombre.setText("");
			}
		});
		
		
		/*
		 * CUADRADO DNI
		 */
		
		JEditorPane dtrpnDni = new JEditorPane();
		dtrpnDni.setText("10101010X");
		dtrpnDni.setBounds(283, 418, 200, 30);
		contentPane.add(dtrpnDni);
		
		
		dtrpnDni.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//Creamos evento que al hacer click, elimine el texto que haya.
				dtrpnDni.setText("");
			}
		});
		
		
		/*
		 * LOGO
		 */
		
		JLabel lblImagen = new JLabel("Logo");
		lblImagen.setBounds(450, 11, 343, 263);
		ImageIcon ico2 = new ImageIcon(getClass().getResource("/imagenes/logo2.png"));
		ImageIcon img2 = new ImageIcon(ico2.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH));
		lblImagen.setIcon(img2);
		contentPane.add(lblImagen);
		
		
		/*
		 * CONTRASEÑA
		 */
		
		
		passwordField = new JPasswordField("Contraseña");
		passwordField.setBackground(new Color(255, 255, 255));
		passwordField.setBounds(784, 358, 200, 30);
		
		
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//Creamos evento que al hacer click, elimine el texto que haya.
				passwordField.setText("");
			}
		});
		contentPane.add(passwordField);
		
		
		/*
		 * CONFIRMAR CONTRASEÑA
		 */
		
		passwordField_1 = new JPasswordField("Contraseña");
		passwordField_1.setBackground(new Color(255, 255, 255));
		passwordField_1.setBounds(784, 418, 200, 30);
		
		
		passwordField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//Creamos evento que al hacer click, elimine el texto que haya.
				passwordField_1.setText("");
			}
		});
		contentPane.add(passwordField_1);
		
		
		
		JLabel lblPass = new JLabel("Contraseña");
		lblPass.setBounds(784, 339, 116, 14);
		contentPane.add(lblPass);
		
		JLabel lblConfCon = new JLabel("Confirmar Contraseña");
		lblConfCon.setBounds(784, 391, 116, 36);
		contentPane.add(lblConfCon);
		
		//BOTÓN DE ATRÁS
		//Imagen que vamos a usar
				ImageIcon iconoFlecha = new ImageIcon ("flechaFruta.png");
				JButton btnFlecha = new JButton(iconoFlecha);
//				btnFlecha.addActionListener(new ActionListener() {
//		            public void actionPerformed(ActionEvent e) {
//		                // Agrega aquí la funcionalidad que deseas cuando se presione el botón
//		                JOptionPane.showMessageDialog(btnFlecha, "¡Botón presionado!");
//		            }
//		        });
				btnFlecha.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                MainFrame mainFrame = new MainFrame();
		                mainFrame.setVisible(true);
		            	
		            }
		        });
				getContentPane().add(btnFlecha, BorderLayout.CENTER);
				btnFlecha.setBounds(52, 447, 174, 89);
				contentPane.add(btnFlecha);
		
		
		/*
		 * BOTON REGISTRO
		 */
		
		
		JButton btnRegistro = new JButton("Registrarme");
		btnRegistro.setBounds(545, 497, 148, 65);
		contentPane.add(btnRegistro);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(283, 339, 116, 14);
		contentPane.add(lblNombre);
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setBounds(283, 391, 116, 36);
		contentPane.add(lblDNI);
		
		JLabel lblCIF = new JLabel("CIF Empresa registrada");
		lblCIF.setBounds(528, 370, 116, 36);
		contentPane.add(lblCIF);
		
		JEditorPane dtrpnCIF = new JEditorPane();
		dtrpnCIF.setText("X-01010101");
		dtrpnCIF.setBounds(528, 397, 200, 30);
		contentPane.add(dtrpnCIF);
		 
		
		
		btnRegistro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String textoNombre = dtrpnNombre.getText();
				String textoDNI = dtrpnDni.getText();
				String textoCIF = dtrpnCIF.getText();
				String textoCIF2 = dtrpnCIF.getText();
				
				//Al trabajar con contraseñas, es más seguro manejarlas como arrays de caracteres en lugar de como cadenas de texto
				char[] passwordChars1 = passwordField.getPassword();
				String textoPassword1 = new String(passwordChars1);
				char[] passwordChars2 = passwordField_1.getPassword();
				String textoPassword2 = new String(passwordChars2);
		
				
				ConexionMySQL connectInv = new ConexionMySQL("freedb_wito.medac", "8DKQRDXu6Xumm@r", "freedb_medac420");
				try { 
					connectInv.conectar();
					System.out.println("Conectado a la BBDD");
					// Tenemos errores a la hora de insertar, ya que antes de poder crear un Usuario, habría que crear la empresa y modificar los valores de 'consulta'
					//String consulta = "INSERT INTO Usuario (nombreUsuario, dniUsuario, passUsuario, Empresa_CIF, Empresa_CIF1) VALUES ('" + textoNombre + "', '" + textoDNI + "', '" + textoPassword2 + "', '', '')";
					String consulta = "INSERT INTO Usuario (nombreUsuario, dniUsuario, passUsuario, Empresa_CIF, Empresa_CIF1) VALUES ('" + textoNombre + "', '" + textoDNI + "', '" + textoPassword2 + "', '" + textoCIF + " ', '" + textoCIF2 + "')";

			        int filasAfectadas = connectInv.ejecutarInsertDeleteUpdate(consulta);
			        System.out.println("Fila insertada!");
			        connectInv.desconectar();
			        System.out.println("desConectado de la BBDD");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if (!textoPassword1.equals(textoPassword2)) {
					JOptionPane.showMessageDialog(passwordField, "Las contraseñas no son iguales");
				} else {
				System.out.println(textoNombre+" "+textoDNI+" "+textoPassword1+" "+textoPassword2);
				}
			}
        });
	}
}