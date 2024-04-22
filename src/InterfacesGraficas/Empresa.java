package InterfacesGraficas;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import componentes.RoundBorder;
import componentes.RoundedButton;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextArea;
import java.awt.Insets;
import javax.swing.JEditorPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Empresa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCif;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Empresa frame = new Empresa();
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
	public Empresa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		RoundedButton btnAnadirEmpresa = new RoundedButton("Añadir Empresa", Color.gray, 50);
		//No sé porqué, pero añadiendo un background, no se ve el cuadrado del boton NO redondeado 
		btnAnadirEmpresa.setBackground(Color.black);
		btnAnadirEmpresa.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {
		        // Cambiar el color de fondo cuando se presiona el botón
		        btnAnadirEmpresa.setBackground(Color.RED.darker());
		    }

		    @Override
		    public void mouseReleased(MouseEvent e) {
		        // Restaurar el color de fondo original cuando se libera el botón
		        btnAnadirEmpresa.setBackground(Color.RED);
		    }
		});
		btnAnadirEmpresa.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				btnAnadirEmpresa.setText("Creando nueva empresa. "); 

			}
		});
		btnAnadirEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAnadirEmpresa.setBackground(Color.red);
				System.out.println("Nueva empresa añadida");
			}
		});

		btnAnadirEmpresa.setBounds(90, 182, 241, 53);
		RoundBorder roundBorder = new RoundBorder(50);
		btnAnadirEmpresa.setBorder(roundBorder);
		contentPane.add(btnAnadirEmpresa);

		// Este botón solo está añadido por diseño, no tiene funcionalidad!!
		RoundedButton btnAnadirEmpresa2 = new RoundedButton("", Color.gray, 3);
		contentPane.add(btnAnadirEmpresa2);
		// Este botón solo está añadido por diseño, no tiene funcionalidad!!

		// Podemos utilizar HTML!!
		JLabel lblTituloEmpresa = new JLabel("Añade una nueva empresa");
		lblTituloEmpresa.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTituloEmpresa.setForeground(Color.white);
		lblTituloEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloEmpresa.setBackground(SystemColor.textHighlightText);
		lblTituloEmpresa.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED)); // Agrega un borde en relieve
		lblTituloEmpresa.setBounds(10, 11, 414, 39);
		contentPane.add(lblTituloEmpresa);

		// Panel para dar fondo transparente al título
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(0, 0, 0, 90)); // Fondo semitransparente
		panelTitulo.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED)); // Borde en relieve
		panelTitulo.setLayout(new BorderLayout()); // Utilizamos BorderLayout para alinear el título en el centro
		panelTitulo.setBounds(10, 11, 414, 39);
		contentPane.add(panelTitulo);

		JTextField dtrpnNombreUsuario = new JTextField();
		dtrpnNombreUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// Creamos evento que al hacer click, elimine el texto que haya
				dtrpnNombreUsuario.setText("");
			}
		});
		dtrpnNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		dtrpnNombreUsuario.setText("Introduce empresa");
		dtrpnNombreUsuario.setBounds(154, 75, 120, 30);
		dtrpnNombreUsuario.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		contentPane.add(dtrpnNombreUsuario);

		txtCif = new JTextField("CIF");
		txtCif.setHorizontalAlignment(SwingConstants.CENTER);
		txtCif.setBounds(154, 129, 120, 30);
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
		lblFondoLogo.setBounds(20, 11, 404, 239);
		lblFondoLogo.setBackground(new Color(0, 0, 0, 80));
		ImageIcon icono = new ImageIcon(getIcono.getImage().getScaledInstance(lblFondoLogo.getWidth(),
				lblFondoLogo.getHeight(), Image.SCALE_SMOOTH));
		lblFondoLogo.setIcon(icono);
		contentPane.add(lblFondoLogo);

	}
}
