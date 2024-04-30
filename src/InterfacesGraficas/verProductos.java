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
		
		JButton btnNewButton = new JButton("Pescado");
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		ImageIcon icono = new ImageIcon("C:\\Users\\josem\\Desktop\\jowIts\\JowIts\\src\\Imagenes\\pescado.jpg");
	    Image imagenEscalada = icono.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH);
	    btnNewButton.setIcon(new ImageIcon(imagenEscalada));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ConexionMySQL conexion = new ConexionMySQL("freedb_wito.medac", "8DKQRDXu6Xumm@r", "freedb_medac420");
				
                JOptionPane.showMessageDialog(contentPane, "Estos son los pescados que tenemos: ");
                
                String Pescado;
                Pescado ="SELECT * FROM productos WHERE nombre_producto LIKE 'P%';";
                
                try {
					conexion.ejecutarSelect(getName());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					try {
						conexion.desconectar();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
                
			}
<<<<<<< HEAD
		));
		tree.setBounds(163, 240, 163, 177);
		contentPane.add(tree);
=======
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\josem\\Desktop\\jowIts\\JowIts\\src\\Imagenes\\pescado.jpg"));
		btnNewButton.setSelectedIcon(new ImageIcon("C:\\Users\\josem\\Desktop\\jowIts\\JowIts\\src\\Imagenes\\pescado.jpg"));
		btnNewButton.setBounds(78, 339, 236, 124);
		contentPane.add(btnNewButton);
		
		/*
		 * CARNES
		 */
		
		JButton Button2 = new JButton("Carnes");
		ImageIcon icono2 = new ImageIcon("C:\\Users\\josem\\Desktop\\jowIts\\JowIts\\src\\Imagenes\\carnes2.jpg");
	    Image imagenEscalada2 = icono.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH);
	    Button2.setIcon(new ImageIcon(imagenEscalada));
	    Button2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
				
	    		ConexionMySQL conexion = new ConexionMySQL("freedb_wito.medac", "8DKQRDXu6Xumm@r", "freedb_medac420");
	    		
                JOptionPane.showMessageDialog(contentPane, "Estos son las carnes que tenemos: ");
                
                String Carne;
                Carne ="SELECT * FROM productos WHERE nombre_producto LIKE 'C%';";
                
                try {
					conexion.ejecutarSelect(getName());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					try {
						conexion.desconectar();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
                
			}
		});
		Button2.setIcon(new ImageIcon("C:\\Users\\josem\\Desktop\\jowIts\\JowIts\\src\\Imagenes\\carnes2.jpg"));
		Button2.setSelectedIcon(new ImageIcon("C:\\Users\\josem\\Desktop\\jowIts\\JowIts\\src\\Imagenes\\carnes2.jpg"));
		Button2.setBounds(519, 339, 236, 124);
		contentPane.add(Button2);
        
        
		/*
		 * VERDURAS
		 */
        
		
		JButton Button3 = new JButton("Verduras");
		Button3.setVerticalAlignment(SwingConstants.BOTTOM);
		ImageIcon icono3 = new ImageIcon("C:\\Users\\josem\\Desktop\\jowIts\\JowIts\\src\\Imagenes\\verduras.jpeg");
	    Image imagenEscalada3 = icono.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH);
	    Button3.setIcon(new ImageIcon(imagenEscalada));
	    Button3.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		ConexionMySQL conexion = new ConexionMySQL("freedb_wito.medac", "8DKQRDXu6Xumm@r", "freedb_medac420");
				
                
                JOptionPane.showMessageDialog(contentPane, "Estos son las verduras que tenemos: ");
                
                String Verdura;
                Verdura ="SELECT * FROM productos WHERE nombre_producto LIKE 'V%';";
                
                try {
					conexion.ejecutarSelect(getName());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					try {
						conexion.desconectar();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
               
                
                
			}
		});
	    Button3.setIcon(new ImageIcon("C:\\Users\\josem\\Desktop\\jowIts\\JowIts\\src\\Imagenes\\verduras.jpeg"));
	    Button3.setSelectedIcon(new ImageIcon("C:\\Users\\josem\\Desktop\\jowIts\\JowIts\\src\\Imagenes\\verduras.jpeg"));
	    Button3.setBounds(959, 339, 236, 124);
		contentPane.add(Button3);
		
		
		
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
                MAIN frame2 = new MAIN();
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
>>>>>>> 40f7621e9f7c8c33a1c32c298483358bdb242c6b
	}

