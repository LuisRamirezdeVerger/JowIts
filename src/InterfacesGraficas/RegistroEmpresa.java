package interfacesGraficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import componentes.RoundBorder;
import componentes.RoundedButton;
import connections.ConexionMySQL;

public class RegistroEmpresa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCif;
	private JTextField txtIntroduceEmpresa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroEmpresa frame = new RegistroEmpresa();
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
	public RegistroEmpresa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(131, 185, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		RoundedButton btnAnadirEmpresa = new RoundedButton("Añadir Empresa", Color.gray, 50);
		btnAnadirEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAnadirEmpresa.setBackground(Color.red);
		btnAnadirEmpresa.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				btnAnadirEmpresa.setText("Creando nueva empresa. ");

			}
		});

		btnAnadirEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAnadirEmpresa.setBackground(Color.red);
				String textoCif = txtCif.getText();
				String textoEmpresa = txtIntroduceEmpresa.getText();

				ConexionMySQL connectInv = new ConexionMySQL("freedb_wito.medac", "8DKQRDXu6Xumm@r", "freedb_medac420");
				try {
					connectInv.conectar();
					System.out.println("Conectado a la BBDD");
					String consulta = "INSERT INTO Empresa (CIF, nombreEmpresa) VALUES ('" + textoCif + "', '"
							+ textoEmpresa + "')";
					@SuppressWarnings("unused")
					int filasAfectadas = connectInv.ejecutarInsertDeleteUpdate(consulta);

					JOptionPane.showMessageDialog(btnAnadirEmpresa, "Empresa registrada con éxito. ");

					System.out.println("Fila insertada!");
					connectInv.desconectar();
					System.out.println("desConectado de la BBDD");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		});

		btnAnadirEmpresa.setBounds(514, 428, 241, 53);
		RoundBorder roundBorder = new RoundBorder(50);
		btnAnadirEmpresa.setBorder(roundBorder);
		contentPane.add(btnAnadirEmpresa);

		// Botón de atrás
		JButton btnFlecha = new JButton();
		btnFlecha.setToolTipText("Pulsa para volver al menú principal");
		btnFlecha.setText("Atrás");
		btnFlecha.setSize(116, 50);
		btnFlecha.setLocation(61, 526);
		btnFlecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame mainFrame = new MainFrame();
				mainFrame.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnFlecha);
		btnFlecha.setVisible(true);
		
		 //Botón teclado en pantalla
        JButton btnTeclado = new JButton("Teclado de Pantalla");
        btnTeclado.setBounds(1022, 607, 159, 50);
        contentPane.add(btnTeclado);
        btnTeclado.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	    try {
        	        // Ejecutar el comando para abrir el teclado de pantalla en Windows
        	        Runtime.getRuntime().exec("cmd /c start osk");
        	    } catch (IOException ex) {
        	        ex.printStackTrace();
        	        JOptionPane.showMessageDialog(contentPane, "No se pudo abrir el teclado de pantalla.");
        	    }
        	}
        });

		// Este botón solo está añadido por diseño, no tiene funcionalidad!!
		RoundedButton btnAnadirEmpresa2 = new RoundedButton("", Color.gray, 3);
		contentPane.add(btnAnadirEmpresa2);
		// Este botón solo está añadido por diseño, no tiene funcionalidad!!

		// Podemos utilizar HTML!!
		JLabel lblTituloEmpresa = new JLabel("Añade una nueva empresa");
		lblTituloEmpresa.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		lblTituloEmpresa.setForeground(Color.white);
		lblTituloEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloEmpresa.setBackground(SystemColor.textHighlightText);
		lblTituloEmpresa.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED)); // Agrega un borde en relieve
		lblTituloEmpresa.setBounds(10, 11, 1244, 94);
		contentPane.add(lblTituloEmpresa);

		// Botón registro usuario
		JButton btnRegistrate = new JButton("Registrar usuario nuevo");
		btnRegistrate.setBounds(1012, 517, 181, 69);
		btnRegistrate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroUsuario registroUsuario = new RegistroUsuario();
				registroUsuario.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnRegistrate);

		// Panel para dar fondo transparente al título
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(0, 0, 0, 90)); // Fondo semitransparente
		panelTitulo.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED)); // Borde en relieve
		panelTitulo.setLayout(new BorderLayout()); // Utilizamos BorderLayout para alinear el título en el centro
		panelTitulo.setBounds(10, 11, 1244, 94);
		contentPane.add(panelTitulo);

		txtCif = new JTextField("CIF");
		txtCif.setHorizontalAlignment(SwingConstants.CENTER);
		txtCif.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		txtCif.setBounds(525, 359, 221, 44);
		txtCif.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// Evento para eliminar texto
				txtCif.setText("");
			}
		});
		contentPane.add(txtCif);
		ImageIcon getIcono = new ImageIcon(getClass().getResource("/imagenes/logo2.png"));

		JLabel lblFondoLogo = new JLabel("FondoImg");
		lblFondoLogo.setBounds(224, 69, 815, 543);
		lblFondoLogo.setBackground(new Color(0, 0, 0, 80));
		ImageIcon icono = new ImageIcon(getIcono.getImage().getScaledInstance(lblFondoLogo.getWidth(),
				lblFondoLogo.getHeight(), Image.SCALE_SMOOTH));

		txtIntroduceEmpresa = new JTextField("Introduce Empresa");
		txtIntroduceEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		txtIntroduceEmpresa.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		txtIntroduceEmpresa.setBounds(525, 269, 221, 44);
		txtIntroduceEmpresa.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtIntroduceEmpresa.setText("");
			}
		});
		contentPane.add(txtIntroduceEmpresa);
		lblFondoLogo.setIcon(icono);
		contentPane.add(lblFondoLogo);

	}
}
