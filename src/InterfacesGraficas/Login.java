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
import java.sql.ResultSet;
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

import componentes.Usuario;
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
		
		JTextField txtNombreUsuario = new JTextField();
		txtNombreUsuario.setBackground(new Color(94, 253, 102));
		txtNombreUsuario.setText("Usuario");
		txtNombreUsuario.setBounds(403, 419, 202, 40);
		contentPane.add(txtNombreUsuario);
		
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
				//DDBB aquí
				ConexionMySQL connectInv = new ConexionMySQL("freedb_wito.medac", "8DKQRDXu6Xumm@r", "freedb_medac420");
				try {
					connectInv.conectar();
					System.out.println("Conexión establecida. ");
					
					String consulta = "SELECT * FROM Usuario WHERE nombreUsuario = '" + txtNombreUsuario.getText() + "' AND passUsuario = '" + new String(passwordField.getPassword()) + "'";
					ResultSet resultSet = connectInv.ejecutarSelect(consulta);
					
					if(resultSet.next()) {
						Usuario.setNombreUsuario(resultSet.getString("nombreUsuario"));
						Usuario.setPassUsuario(resultSet.getString("passUsuario"));
						 MAIN main = new MAIN();
	                        main.setVisible(true);
	                        dispose();
					}
					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				} finally {
					
				} }
				
			//Conexión bbdd finalizada
		});
		btnConectar.setForeground(Color.BLACK);
		//btnConectar.setBackground(Color.ORANGE);
		btnConectar.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
		btnConectar.setBounds(444, 513, 376, 60);
		contentPane.add(btnConectar);
		
		//Botón de atrás
		JButton btnFlecha = new JButton();
		btnFlecha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainFrame mainFrame = new MainFrame();
                mainFrame.setVisible(true);
            	dispose();
            }
        });
		getContentPane().add(btnFlecha, BorderLayout.CENTER);
		btnFlecha.setBounds(52, 447, 174, 89);
		contentPane.add(btnFlecha);
		
		JButton btnConectar_1 = new JButton("desConectar");
		
		
		btnConectar_1.setToolTipText("Pulsa para desconectarte de tu cuenta");
		btnConectar_1.setForeground(Color.BLACK);
		btnConectar_1.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
		btnConectar_1.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		ConexionMySQL connectInv = new ConexionMySQL("freedb_wito.medac", "8DKQRDXu6Xumm@r", "freedb_medac420");
		btnConectar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (connectInv != null) {
					try {
                        connectInv.desconectar();
                        System.out.println("Desconectando :D ");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error al intentar desconectar de la base de datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } 
            }
			
				
			//Conexión bbdd finalizada
		});
		btnConectar_1.setBounds(746, 588, 376, 60);
		contentPane.add(btnConectar_1);
		
	}
}