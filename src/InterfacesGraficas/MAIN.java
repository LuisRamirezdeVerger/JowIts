package interfacesGraficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.BorderFactory;
import javax.swing.border.EtchedBorder;

import componentes.Usuario;

import java.awt.Font;
import javax.swing.SwingConstants;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		/*
		 * Icono
		 */
		
		JLabel IconoUsuario = new JLabel("IconoUsuario");
		
		IconoUsuario.setBounds(262, 68, 739, 545);
		ImageIcon ico2 =new ImageIcon(getClass().getResource("/imagenes/logo2.png"));
		ImageIcon img2 =new ImageIcon(ico2.getImage().getScaledInstance(IconoUsuario.getWidth(), IconoUsuario.getHeight(), Image.SCALE_SMOOTH));
		
		JLabel lblWelcomeToJowits = new JLabel("Welcome to jowIts, " + Usuario.getNombreUsuario() + ". " );
		lblWelcomeToJowits.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToJowits.setForeground(Color.WHITE);
		lblWelcomeToJowits.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lblWelcomeToJowits.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		lblWelcomeToJowits.setBackground(SystemColor.textHighlightText);
		lblWelcomeToJowits.setBounds(10, 22, 1244, 94);
		contentPane.add(lblWelcomeToJowits);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		panelTitulo.setBackground(new Color(0, 0, 0, 90));
		panelTitulo.setBounds(10, 22, 1244, 94);
		contentPane.add(panelTitulo);
		panelTitulo.setLayout(new BorderLayout());
		IconoUsuario.setIcon(img2);
		contentPane.add(IconoUsuario);
		
		//BOTÓN DE ATRÁS
		JButton btnAtras = new JButton("Atrás");
		btnAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainFrame mainFrame = new MainFrame();
                mainFrame.setVisible(true);
                dispose();
            }
        });
		getContentPane().add(btnAtras, BorderLayout.CENTER);
		btnAtras.setBounds(52, 447, 174, 89);
		contentPane.add(btnAtras);
		
		JButton btnRegistrarProducto = new JButton("Registrar Nuevo Producto");
		btnRegistrarProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegistroNuevoProducto nuevoProducto = new RegistroNuevoProducto();
                nuevoProducto.setVisible(true);
                dispose();
            }
        });
		btnRegistrarProducto.setBounds(52, 260, 174, 89);
		contentPane.add(btnRegistrarProducto);
		
		JButton btnRegistrarEmpleado = new JButton("Registrar Nuevo Empleado");
		btnRegistrarEmpleado.setBounds(52, 127, 174, 89);
		contentPane.add(btnRegistrarEmpleado);
		
		JButton btnRegistrarCategoria = new JButton("Registrar Nueva Categoría");
		btnRegistrarCategoria.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CrearCategoria crearCategoria = new CrearCategoria();
                crearCategoria.setVisible(true);
                dispose();
            }
        });
		btnRegistrarCategoria.setBounds(984, 127, 174, 89);
		contentPane.add(btnRegistrarCategoria);
		

		
	}
}
