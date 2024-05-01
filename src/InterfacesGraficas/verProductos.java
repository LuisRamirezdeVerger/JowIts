package interfacesGraficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

import connections.ConexionMySQL;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class VerProductos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerProductos frame = new VerProductos();
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
	public VerProductos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(240, 230, 140));
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
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
		 * PESCADO
		 */
		
		JButton btnImagenPescado = new JButton("Pescado");
		btnImagenPescado.setVerticalAlignment(SwingConstants.BOTTOM);
		ImageIcon icono = new ImageIcon("C:\\Users\\josem\\Desktop\\jowIts\\JowIts\\src\\Imagenes\\pescado.jpg");
	    Image imagenEscalada = icono.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH);
	    btnImagenPescado.setIcon(new ImageIcon(imagenEscalada));
		btnImagenPescado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ConexionMySQL conexion = new ConexionMySQL("freedb_wito.medac", "8DKQRDXu6Xumm@r", "freedb_medac420");
				
                JOptionPane.showMessageDialog(contentPane, "Estos son los pescados que tenemos: ");
                
                String Pescado;
                Pescado ="SELECT * FROM productos WHERE nombre_producto LIKE 'P%';";
                
                try {
					conexion.conectar();
					System.out.println("Conectado");
					
					int filasAfectadas = conexion.ejecutarInsertDeleteUpdate(Pescado);
					
					System.out.println("Fila insertada");
					
					conexion.desconectar();
					System.out.println("Desconectado");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
                
			}
		);
		btnImagenPescado.setIcon(new ImageIcon("C:\\Users\\josem\\Desktop\\jowIts\\JowIts\\src\\Imagenes\\pescado.jpg"));
		btnImagenPescado.setSelectedIcon(new ImageIcon("C:\\Users\\josem\\Desktop\\jowIts\\JowIts\\src\\Imagenes\\pescado.jpg"));
		btnImagenPescado.setBounds(78, 339, 236, 124);
		contentPane.add(btnImagenPescado);
		
		/*
		 * CARNES
		 */
		
		JButton btnImagenCarne = new JButton("Carnes");
		ImageIcon icono2 = new ImageIcon("C:\\Users\\josem\\Desktop\\jowIts\\JowIts\\src\\Imagenes\\carnes2.jpg");
	    Image imagenEscalada2 = icono.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH);
	    btnImagenCarne.setIcon(new ImageIcon(imagenEscalada));
	    btnImagenCarne.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
				
	    		ConexionMySQL conexion = new ConexionMySQL("freedb_wito.medac", "8DKQRDXu6Xumm@r", "freedb_medac420");
	    		
                JOptionPane.showMessageDialog(contentPane, "Estos son las carnes que tenemos: ");
                
                String Carne;
                Carne ="SELECT * FROM productos WHERE nombre_producto LIKE 'C%';";
                
                try {
					conexion.conectar();
					System.out.println("Conectado");
					
					int filasAfectadas = conexion.ejecutarInsertDeleteUpdate(Carne);
					
					System.out.println("Fila insertada");
					
					conexion.desconectar();
					System.out.println("Desconectado");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
                
			}
		});
		btnImagenCarne.setIcon(new ImageIcon("C:\\Users\\josem\\Desktop\\jowIts\\JowIts\\src\\Imagenes\\carnes2.jpg"));
		btnImagenCarne.setSelectedIcon(new ImageIcon("C:\\Users\\josem\\Desktop\\jowIts\\JowIts\\src\\Imagenes\\carnes2.jpg"));
		btnImagenCarne.setBounds(519, 339, 236, 124);
		contentPane.add(btnImagenCarne);
        
        
		/*
		 * VERDURAS
		 */
        
		
		JButton btnImagenVerdura = new JButton("Verduras");
		btnImagenVerdura.setVerticalAlignment(SwingConstants.BOTTOM);
		ImageIcon icono3 = new ImageIcon("C:\\Users\\josem\\Desktop\\jowIts\\JowIts\\src\\Imagenes\\verduras.jpeg");
	    Image imagenEscalada3 = icono.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH);
	    btnImagenVerdura.setIcon(new ImageIcon(imagenEscalada));
	    btnImagenVerdura.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		ConexionMySQL conexion = new ConexionMySQL("freedb_wito.medac", "8DKQRDXu6Xumm@r", "freedb_medac420");
				
                
                JOptionPane.showMessageDialog(contentPane, "Estos son las verduras que tenemos: ");
                
                String Verdura;
                Verdura ="SELECT * FROM productos WHERE nombre_producto LIKE 'V%';";
                
                try {
					conexion.conectar();
					System.out.println("Conectado");
						
					int filasAfectadas = conexion.ejecutarInsertDeleteUpdate(Verdura);
					
					System.out.println("Fila insertada");
					
					conexion.desconectar();
					System.out.println("Desconectado");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
               
                
                
			}
		});
	    btnImagenVerdura.setIcon(new ImageIcon("C:\\Users\\josem\\Desktop\\jowIts\\JowIts\\src\\Imagenes\\verduras.jpeg"));
	    btnImagenVerdura.setSelectedIcon(new ImageIcon("C:\\Users\\josem\\Desktop\\jowIts\\JowIts\\src\\Imagenes\\verduras.jpeg"));
	    btnImagenVerdura.setBounds(959, 339, 236, 124);
		contentPane.add(btnImagenVerdura);
		
		
		
		/*
		 * Boton para volver
		 */
		
		
		JButton volverMain = new JButton("Volver");
		volverMain.setLocation(967, 42);
		volverMain.setSize(168, 58);
		volverMain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	ConexionMySQL conexion = new ConexionMySQL("freedb_wito.medac", "8DKQRDXu6Xumm@r", "freedb_medac420");
            	
                // Ocultar este frame
                setVisible(false);
                
                // Mostrar el siguiente frame
                Main frame2 = new Main();
                frame2.setVisible(true);
                
                try {
					conexion.desconectar();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        
        getContentPane().add(volverMain, BorderLayout.CENTER);
        
        setVisible(true);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    	}
	}

