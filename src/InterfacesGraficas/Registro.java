package interfacesGraficas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.PreparedStatement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connections.ConexionMySQL;

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
		dtrpnDni.setText("DNI");
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
		
		
		
		JLabel lblNewLabel = new JLabel("Contraseña");
		lblNewLabel.setBounds(784, 339, 116, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Confirmar Contraseña");
		lblNewLabel_1.setBounds(784, 391, 116, 36);
		contentPane.add(lblNewLabel_1);
		
		
		
		
		/*
		 * BOTON REGISTRO
		 */
		
		
		JButton btnNewButton = new JButton("Registrarme");
		btnNewButton.setBounds(545, 497, 148, 65);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String textoNombre = dtrpnNombre.getText();
				String textoDNI = dtrpnDni.getText();
				String textoPassword1 = passwordField.getText();
				String textoPassword2 = passwordField_1.getText();
				
				
				if (!textoPassword1.equals(textoPassword2)) {
					JOptionPane.showMessageDialog(passwordField, "Las contraseñas no son iguales");
				} else {
				System.out.println(textoNombre+" "+textoDNI+" "+textoPassword1+" "+textoPassword2);
				}
				
				try {
					ConexionMySQL connectInv = new ConexionMySQL("freedb_wito.medac", "8DKQRDXu6Xumm@r", "freedb_medac420");
		            
		            // Sentencia SQL de inserción
		            String sql = "INSERT INTO tu_tabla (columna1, columna2, columna3) VALUES (?, ?, ?)";
		            
		            // Preparar la sentencia
		            PreparedStatement statement = connectInv.prepareStatement(sql);
		            statement.setString(1, textoNombre);
		            statement.setString(2, textoDNI);
		            statement.setString(3, textoPassword2);
		           
		            
		            // Ejecutar la sentencia
		            int filasInsertadas = statement.executeUpdate();
		            
		            if (filasInsertadas > 0) {
		                System.out.println("Los datos han sido insertados exitosamente en la base de datos.");
		            } else {
		                System.out.println("No se han insertado datos en la base de datos.");
		            }

		            // Cerrar conexión y recursos
		            statement.close();
		            connectInv.close();
		        } catch (Exception x) {
		            x.printStackTrace();
		            System.out.println("Error al intentar insertar datos en la base de datos.");
		        }
			}
        });
		

	}
}