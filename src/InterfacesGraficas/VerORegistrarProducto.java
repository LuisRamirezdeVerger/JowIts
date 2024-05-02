package interfacesGraficas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connections.ConexionMySQL;

import javax.swing.JButton;
import java.awt.Font;

public class VerORegistrarProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerORegistrarProducto frame = new VerORegistrarProducto();
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
	public VerORegistrarProducto() {
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
		 * LOGO
		 */
		
		JLabel lblImagen = new JLabel("Logo");
		lblImagen.setBounds(450, 11, 343, 263);
		ImageIcon ico2 = new ImageIcon(getClass().getResource("/imagenes/logo2.png"));
		ImageIcon img2 = new ImageIcon(ico2.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH));
		lblImagen.setIcon(img2);
		contentPane.add(lblImagen);
		contentPane.setLayout(null);
		
		
		
		/*
		 * IR a Ver Producto
		 */
		
		
		
		JButton irVerProducto = new JButton("Ver Producto");
		irVerProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		irVerProducto.setBounds(155, 350, 152, 176);
		contentPane.add(irVerProducto);
		irVerProducto.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
            	
            	ConexionMySQL conexion = new ConexionMySQL("freedb_wito.medac", "8DKQRDXu6Xumm@r", "freedb_medac420");
            	
                // Ocultar este frame
                dispose();
                
                // Mostrar el siguiente frame
                VerProductos frame2 = new VerProductos();
                frame2.setVisible(true);
                
                try {
                	
                	conexion.desconectar();
					System.out.println("Desconectado");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
		
		
		
		
		/*
		 * IR a Registrar Producto
		 */
		
		
		JButton irRegistrarProducto = new JButton("Registrar Producto");
		irRegistrarProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		irRegistrarProducto.setBounds(948, 350, 152, 176);
		contentPane.add(irRegistrarProducto);
		
		
		irRegistrarProducto.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
            	
            	ConexionMySQL conexion = new ConexionMySQL("freedb_wito.medac", "8DKQRDXu6Xumm@r", "freedb_medac420");
            	
                // Ocultar este frame
                dispose();
                
                // Mostrar el siguiente frame
                RegistroNuevoProducto frame2 = new RegistroNuevoProducto();
                frame2.setVisible(true);
                
                try {
                	
                	conexion.desconectar();
					System.out.println("Desconectado");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
		
		
		/*
		 * Volver al Main
		 */
		
		
		JButton volverMain = new JButton("Volver");
		volverMain.setBounds(557, 509, 89, 23);
		volverMain.setLocation(967, 42);
		volverMain.setSize(168, 58);
		contentPane.add(volverMain);
		volverMain.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
            	
            	ConexionMySQL conexion = new ConexionMySQL("freedb_wito.medac", "8DKQRDXu6Xumm@r", "freedb_medac420");
            	
                // Ocultar este frame
                dispose();
                
                // Mostrar el siguiente frame
                Main frame2 = new Main();
                frame2.setVisible(true);
                
                try {
                	
                	conexion.desconectar();
					System.out.println("Desconectado");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
