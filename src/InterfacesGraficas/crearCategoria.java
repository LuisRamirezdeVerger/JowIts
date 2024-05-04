package interfacesGraficas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connections.ConexionMySQL;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

public class CrearCategoria extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCategoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearCategoria frame = new CrearCategoria();
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
	public CrearCategoria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(new Color(131, 185, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JEditorPane editorPane = new JEditorPane();
		contentPane.add(editorPane);

		/*
		 * LOGO
		 */

		JLabel lblImagen = new JLabel("Logo");
		lblImagen.setBounds(452, 51, 343, 263);
		ImageIcon ico2 = new ImageIcon(getClass().getResource("/imagenes/logo2.png"));
		ImageIcon img2 = new ImageIcon(
				ico2.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH));
		lblImagen.setIcon(img2);
		contentPane.add(lblImagen);
		contentPane.setLayout(null);

		// Crear botón de ir atrás

		JButton btnAtras = new JButton("Atrás");
		btnAtras.setBounds(63, 525, 206, 68);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main main = new Main();
				main.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnAtras);

		textCategoria = new JTextField();
		textCategoria.setBounds(529, 400, 206, 55);
		contentPane.add(textCategoria);
		textCategoria.setColumns(10);

		JButton btnCreaCategoria = new JButton("Crear Categoría para empleado ");
		btnCreaCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String textoCategoria = textCategoria.getText().trim();
				if (textoCategoria.isEmpty()) {
		            JOptionPane.showMessageDialog(btnCreaCategoria, "Nombre la categoría de empleado a añadir: Jefe, Encargado, Gerente... ", "La categoría debe tener un nombre. ", JOptionPane.ERROR_MESSAGE);
		            setLocationRelativeTo(null);
				} else {
				ConexionMySQL connectInv = new ConexionMySQL("freedb_wito.medac", "8DKQRDXu6Xumm@r", "freedb_medac420");
				
				try {
					connectInv.conectar();
					System.out.println("Conectado a la BBDD! ");
					String consulta = "INSERT INTO Categoria (nombreCategoria) VALUES ('" + textoCategoria + "')";
					@SuppressWarnings("unused")
					int filasAfectadas = connectInv.ejecutarInsertDeleteUpdate(consulta);

					JOptionPane.showMessageDialog(btnCreaCategoria, "Categoría registrada con éxito. ");

					System.out.println("Fila insertada! ");
					connectInv.desconectar();
					System.out.println("desConectado de la BBDD ");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			}
		});
		

		btnCreaCategoria.setBounds(529, 493, 206, 68);
		contentPane.add(btnCreaCategoria);

		JLabel lblCreaCategoria = new JLabel("Escriba la categoría de empleado");
		lblCreaCategoria.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCreaCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreaCategoria.setBounds(446, 341, 372, 48);
		contentPane.add(lblCreaCategoria);
	}
}
