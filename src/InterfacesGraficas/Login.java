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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.SwingUtilities;
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

	// Podríamos bloquear el tamaño de la ventana o hacerla fullscreen
	// Hacer que los cuadros de user/contraseña estén en vertical
	public Login() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 300, 1280, 720);
		// Hacemos que la pantalla se centre
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
		txtNombreUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// Creamos evento que al hacer click, elimine el texto que haya.
				txtNombreUsuario.setText("");
			}
		});
		txtNombreUsuario.setBounds(403, 419, 202, 40);
		contentPane.add(txtNombreUsuario);

		JLabel lblImagen = new JLabel("Logo");
		lblImagen.setBounds(450, 11, 343, 263);
		ImageIcon ico2 = new ImageIcon(getClass().getResource("/imagenes/logo2.png"));
		ImageIcon img2 = new ImageIcon(
				ico2.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH));
		lblImagen.setIcon(img2);
		contentPane.add(lblImagen);

		passwordField = new JPasswordField("Contraseña");
		passwordField.setBackground(new Color(94, 253, 102));
		passwordField.setBounds(655, 419, 208, 40);
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// Creamos evento que al hacer click, elimine el texto que haya.
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
		// Con "MouseListener" podemos hacer diferentes cosas cuando el mouse
		// entre/salga
		//El pulsar "Enter" hacemos click en el botón de Conectar
		passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnConectar.doClick();
                }
            }
        });
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
				// DDBB aquí
				ConexionMySQL connectInv = new ConexionMySQL("freedb_wito.medac", "8DKQRDXu6Xumm@r", "freedb_medac420");
				try {
					connectInv.conectar();
					System.out.println("Conexión establecida. ");

					String consulta = "SELECT * FROM Usuario WHERE nombreUsuario = '" + txtNombreUsuario.getText()
							+ "' AND passUsuario = '" + new String(passwordField.getPassword()) + "'";
					ResultSet resultSet = connectInv.ejecutarSelect(consulta);

					if (resultSet.next()) {
						Usuario.setNombreUsuario(resultSet.getString("nombreUsuario"));
						Usuario.setPassUsuario(resultSet.getString("passUsuario"));
						Main main = new Main();
						main.setVisible(true);
						dispose();
					} else {
						// Si el usuario o contraseña no se encuentra
						JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrecto. ");
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos: " + e1.getMessage());

				} finally {
					try {
						connectInv.desconectar();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					System.out.println("Desconectado :D ");
				}
			}
		});
		btnConectar.setForeground(Color.BLACK);
		// btnConectar.setBackground(Color.ORANGE);
		btnConectar.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
		
		btnConectar.setBounds(444, 513, 376, 60);
		contentPane.add(btnConectar);

		// Botón de atrás
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


	}
}