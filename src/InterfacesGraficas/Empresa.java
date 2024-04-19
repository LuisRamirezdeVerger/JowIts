package InterfacesGraficas;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

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
import javax.swing.JButton;

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
        		
        		JButton btnAnadirEmpresa = new JButton("Añadir Empresa");
        		btnAnadirEmpresa.setBounds(90, 182, 241, 53);
        		contentPane.add(btnAnadirEmpresa);
        
        		
        		//Podemos utilizar HTML!!
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
		
		JTextArea userTextArea = new JTextArea("Nombre de Empresa");
		userTextArea.setForeground(SystemColor.window);
		userTextArea.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		userTextArea.setEditable(false);
		//Añadimos transparencia para mejorar el diseño
		userTextArea.setBackground(new Color(0, 0, 0, 50));
		userTextArea.setAlignmentY(0.5f);
		userTextArea.setAlignmentX(0.5f);
		userTextArea.setBounds(60, 74, 120, 39);
		contentPane.add(userTextArea);
		
		
		JTextArea txtrCif = new JTextArea("CIF");
		txtrCif.setForeground(SystemColor.window);
		txtrCif.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtrCif.setEditable(false);
		txtrCif.setBackground(new Color(0, 0, 0, 50));
		txtrCif.setAlignmentY(0.5f);
		txtrCif.setAlignmentX(0.5f);
		txtrCif.setBounds(230, 74, 120, 39);
		contentPane.add(txtrCif);
		
		
		
		JEditorPane dtrpnNombreUsuario = new JEditorPane();
		dtrpnNombreUsuario.setText("Introduce empresa");
		dtrpnNombreUsuario.setBounds(60, 134, 120, 30);
		dtrpnNombreUsuario.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		dtrpnNombreUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//Creamos evento que al hacer click, elimine el texto que haya
				dtrpnNombreUsuario.setText("");
			}
		});
		contentPane.add(dtrpnNombreUsuario);
		
		txtCif = new JTextField("CIF");
		txtCif.setBounds(230, 134, 120, 30);
		txtCif.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//Evento para eliminar texto
				txtCif.setText("");
			}
		});
		contentPane.add(txtCif);
		ImageIcon getIcono = new ImageIcon(getClass().getResource("/imagenes/logo2.png"));
		
		JLabel lblFondoLogo = new JLabel("FondoImg");
		lblFondoLogo.setBounds(20, 11, 404, 239);
		lblFondoLogo.setBackground(new Color(0, 0, 0, 80));
		ImageIcon icono = new ImageIcon(getIcono.getImage().getScaledInstance(lblFondoLogo.getWidth(), lblFondoLogo.getHeight(), Image.SCALE_SMOOTH));
		lblFondoLogo.setIcon(icono);
		contentPane.add(lblFondoLogo);
		
	}
}
