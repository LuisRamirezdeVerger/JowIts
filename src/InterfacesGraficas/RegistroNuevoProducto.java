package interfacesGraficas;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;

public class RegistroNuevoProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombreProducto;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroNuevoProducto frame = new RegistroNuevoProducto();
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
	public RegistroNuevoProducto() {
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
		ImageIcon ico2 = new ImageIcon(getClass().getResource("/imagenes/logo2.png"));
		contentPane.setLayout(null);
		
		JButton btnAtras = new JButton("Atrás");
		btnAtras.setBounds(43, 585, 206, 68);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main main = new Main();
				main.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnAtras);
		
		JLabel lblNewLabel = new JLabel("Nombre Producto");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(210, 368, 287, 49);
		contentPane.add(lblNewLabel);
		contentPane.setLayout(null);
		
		JLabel lblCantidadDelProducto = new JLabel("Cantidad del Producto a añadir");
		lblCantidadDelProducto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCantidadDelProducto.setBounds(210, 464, 287, 49);
		contentPane.add(lblCantidadDelProducto);
		contentPane.setLayout(null);

		JSpinner ContadorCantidad = new JSpinner();
		ContadorCantidad.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		ContadorCantidad.setToolTipText("");
		ContadorCantidad.setBounds(728, 477, 202, 31);
		contentPane.add(ContadorCantidad);

		contentPane.setLayout(null);
		
		textNombreProducto = new JTextField();
		textNombreProducto.setBounds(728, 381, 202, 31);
		contentPane.add(textNombreProducto);
		textNombreProducto.setColumns(10);
		textNombreProducto.setText("Añadir el nombre del producto");
		textNombreProducto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//Creamos evento que al hacer click, elimine el texto que haya.
				textNombreProducto.setText("");
			}
		});
		
		
		
		
		
		
		/*
		 * Volver al MAIN
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
					System.out.println("Desconectado");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        
        getContentPane().add(volverMain, BorderLayout.CENTER);
        
        JRadioButton rdbtnCarne = new JRadioButton("Carne");
        rdbtnCarne.setBounds(1077, 405, 109, 23);
        contentPane.add(rdbtnCarne);
        buttonGroup.add(rdbtnCarne);
        
        JRadioButton rdbtnPescado = new JRadioButton("Pescado");
        rdbtnPescado.setBounds(1077, 431, 109, 23);
        contentPane.add(rdbtnPescado);
        buttonGroup.add(rdbtnPescado);
        
        JRadioButton rdbtnVardura = new JRadioButton("Verdura");
        rdbtnVardura.setBounds(1077, 457, 109, 23);
        contentPane.add(rdbtnVardura);
        buttonGroup.add(rdbtnVardura);
        
        setVisible(true);
		
        /*
		 * Boton que enviara todo
		 */
		
		JButton btnIntroducirProducto = new JButton("Introducir el producto");
		btnIntroducirProducto.setBounds(915, 533, 247, 102);
		contentPane.add(btnIntroducirProducto);
		
		JLabel lblImagen = new JLabel("Logo");
		lblImagen.setBounds(344, 33, 573, 420);
		ImageIcon img2 = new ImageIcon(ico2.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH));
		lblImagen.setIcon(img2);
		contentPane.add(lblImagen);
		btnIntroducirProducto.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String textAnadirProducto = textField.getText();
				int value = (int) spinner.getValue(); // Convertir a Integer si es necesario
                JOptionPane.showMessageDialog(contentPane, "Vas a añadir el producto= "+ textAnadirProducto+"\nLa cantidad es= " + value);   
			}
            
        });


				
				String textAnadirProducto = textNombreProducto.getText();
				int value = (int) ContadorCantidad.getValue(); // Convertir a Integer si es necesario
				
				ConexionMySQL conexion = new ConexionMySQL("freedb_wito.medac", "8DKQRDXu6Xumm@r", "freedb_medac420");
				
				
				
	            String opcion = "";
				
	            
	            
	            if (rdbtnCarne.isSelected()) {
	            	textAnadirProducto = "C." + textAnadirProducto;
                    opcion = "Carne";
                } else if (rdbtnPescado.isSelected()) {
                	textAnadirProducto = "P." + textAnadirProducto;
                    opcion = "Pescado";
                } else if (rdbtnVardura.isSelected()) {
                	textAnadirProducto = "V." + textAnadirProducto;
                    opcion = "Verdura";
                }
				
                JOptionPane.showMessageDialog(contentPane, "Vas a añadir el producto= "+ textAnadirProducto+"\nLa cantidad es= " + value);
                
                String consulta = "INSERT INTO Producto (nombreProducto, cantidadProducto) VALUES ('" + textAnadirProducto+ "', '" + value + "')";
                
                try {
					conexion.conectar();
					System.out.println("Conectado");
					
					//conexion.ejecutarInsertDeleteUpdate(consulta);
					
					int filasAfectadas = conexion.ejecutarInsertDeleteUpdate(consulta);
					
					System.out.println("Fila insertada");
					
					conexion.desconectar();
					System.out.println("Desconectado");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
                
             
			
            
        });
		
		

		
		
		
		
		
		
		
		

		/*
		 * Volver al MAIN
		 */
		
		
		JButton volverMain = new JButton("Volver");
		volverMain.setLocation(967, 42);
		volverMain.setSize(168, 58);
		volverMain.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
            	
            	ConexionMySQL conexion = new ConexionMySQL("freedb_wito.medac", "8DKQRDXu6Xumm@r", "freedb_medac420");
            	
                // Ocultar este frame
                setVisible(false);
                
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
        
        getContentPane().add(volverMain, BorderLayout.CENTER);
        
        setVisible(true);


	}
}
