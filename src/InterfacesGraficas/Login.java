package interfacesGraficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import connections.ConexionMySQL;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	
	//Podríamos bloquear el tamaño de la ventana o hacerla fullscreen
	// Hacer que los cuadros de user/contraseña estén en vertical
	public Login() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 300, 1280, 720);
		//Hacemos que la pantalla se centre
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(new Color(131, 185, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane); 
		contentPane.setLayout(null);
		
		JEditorPane editorPane = new JEditorPane();
		contentPane.add(editorPane);
		
		JTextField dtrpnNombreUsuario = new JTextField();
		dtrpnNombreUsuario.setBackground(new Color(94, 253, 102));
		dtrpnNombreUsuario.setText("Usuario");
		dtrpnNombreUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//Creamos evento que al hacer click, elimine el texto que haya.
				dtrpnNombreUsuario.setText("");
			}
		});
		dtrpnNombreUsuario.setBounds(403, 419, 202, 40);
		contentPane.add(dtrpnNombreUsuario);
		
		JLabel lblImagen = new JLabel("Logo");
		lblImagen.setBounds(450, 11, 343, 263);
		ImageIcon ico2 = new ImageIcon(getClass().getResource("/imagenes/logo2.png"));
		ImageIcon img2 = new ImageIcon(ico2.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH));
		lblImagen.setIcon(img2);
		contentPane.add(lblImagen);
		
		passwordField = new JPasswordField("Contraseña");
		passwordField.setBackground(new Color(94, 253, 102));
		passwordField.setBounds(655, 419, 208, 40);
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//Creamos evento que al hacer click, elimine el texto que haya.
				passwordField.setText("");
			}
		});
		contentPane.add(passwordField);
		
		JTextField txtrCredenciales = new JTextField("Introduce tus credenciales");
		txtrCredenciales.setBorder(BorderFactory.createLoweredBevelBorder());


		txtrCredenciales.setHorizontalAlignment(SwingConstants.CENTER);
		txtrCredenciales.setMargin(new Insets(3, 20, 3, 0));
		txtrCredenciales.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		txtrCredenciales.setEditable(false);
		txtrCredenciales.setBackground(new Color(255, 128, 0));
		txtrCredenciales.setAlignmentY(0.5f);
		txtrCredenciales.setAlignmentX(0.5f);
		txtrCredenciales.setBounds(403, 285, 460, 89);
		contentPane.add(txtrCredenciales);
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		btnConectar.setToolTipText("Pulsa para conectarte a tu cuenta");
		//Con "MouseListener" podemos hacer diferentes cosas cuando el mouse entre/salga
		btnConectar.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		        // Cambiar el color cuando el mouse entr
		    	btnConectar.setBackground(Color.lightGray);
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		        // Restaura el color original del botón cuando el mouse salga
		    	btnConectar.setBackground(Color.WHITE);
		    }
		});
            
		btnConectar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				btnConectar.setBackground(Color.WHITE);
			}
		});
		btnConectar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				btnConectar.setText("Conectando...");
			}
		});
		
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Introducir conexión a la DDBB aqu�
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
					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				} finally {
					
				}
				sc.close();
				try {
					connectInv.desconectar();
					System.out.println("Desconectando :D ");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
				
			//Conexión bbdd finalizada
		});
		btnConectar.setForeground(Color.BLACK);
		//btnConectar.setBackground(Color.ORANGE);
		btnConectar.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
		btnConectar.setBounds(444, 513, 376, 60);
		contentPane.add(btnConectar);
		
		//Imagen que vamos a usar
		ImageIcon iconoFlecha = new ImageIcon ("flechaFruta.png");
		JButton btnFlecha = new JButton(new ImageIcon("\\Imagenes\flechaFruta.png"));
//		btnFlecha.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                // Agrega aquí la funcionalidad que deseas cuando se presione el botón
//                JOptionPane.showMessageDialog(btnFlecha, "¡Botón presionado!");
//            }
//        });
		btnFlecha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainFrame mainFrame = new MainFrame();
                mainFrame.setVisible(true);
            	
            }
        });
		getContentPane().add(btnFlecha, BorderLayout.CENTER);
		btnFlecha.setBounds(52, 447, 174, 89);
		contentPane.add(btnFlecha);
		
	}
}