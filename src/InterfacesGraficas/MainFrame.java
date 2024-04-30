package interfacesGraficas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(131, 185, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnLogin = new JButton("Log in");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		btnLogin.setBounds(449, 464, 350, 116);
		contentPane.add(btnLogin);

		JButton btnRegistraEmpresa = new JButton("Registrar empresa nueva");
		btnRegistraEmpresa.setBounds(176, 270, 350, 116);
		btnRegistraEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroEmpresa registroEmpresa = new RegistroEmpresa();
				registroEmpresa.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnRegistraEmpresa);

		JButton btnRegistrate = new JButton("Registrar usuario nuevo");
		btnRegistrate.setBounds(732, 270, 350, 116);
		btnRegistrate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroUsuario registroUsuario = new RegistroUsuario();
				registroUsuario.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnRegistrate);

		// Crear botón de ir salir

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(136, 594, 195, 48);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane, "Gracias por usar 'JowIts'!");
				dispose();
			}
		});
		contentPane.add(btnSalir);

		JLabel lblImagen = new JLabel("Logo");
		lblImagen.setBounds(288, 38, 688, 604);
		ImageIcon ico2 = new ImageIcon(getClass().getResource("/imagenes/logo2.png"));
		ImageIcon img2 = new ImageIcon(
				ico2.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH));
		lblImagen.setIcon(img2);
		contentPane.add(lblImagen);
	}
}
