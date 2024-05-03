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
import javax.swing.JOptionPane;
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
		contentPane.setBackground(new Color(131, 185, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		/*
		 * Icono
		 */
		
		JLabel fondoLogo = new JLabel("IconoUsuario");
		fondoLogo.setToolTipText("Logo JowIts");
		
		fondoLogo.setBounds(262, 68, 739, 545);
		ImageIcon ico2 =new ImageIcon(getClass().getResource("/imagenes/logo2.png"));
		ImageIcon img2 =new ImageIcon(ico2.getImage().getScaledInstance(fondoLogo.getWidth(), fondoLogo.getHeight(), Image.SCALE_SMOOTH));
		
//		JButton btnRegistrarProducto = new JButton("Registrar Nuevo Producto");
//		btnRegistrarProducto.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                RegistroNuevoProducto nuevoProducto = new RegistroNuevoProducto();
//                nuevoProducto.setVisible(true);
//                dispose();
//            } 
//        });
//		btnRegistrarProducto.setBounds(52, 260, 228, 89);
//		contentPane.add(btnRegistrarProducto);
		
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
		fondoLogo.setIcon(img2);
		contentPane.add(fondoLogo);
		
		//BOTÓN DE ATRÁS
		JButton btnCerrarSesion = new JButton("Cerrar sesión");
		btnCerrarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainFrame mainFrame = new MainFrame();
                mainFrame.setVisible(true);
                dispose();
            }
        });
		getContentPane().add(btnCerrarSesion, BorderLayout.CENTER);
		btnCerrarSesion.setBounds(88, 533, 228, 89);
		contentPane.add(btnCerrarSesion);
//		
//		JButton btnRegistrarEmpleado = new JButton("Registrar Nuevo Empleado");
//		btnRegistrarEmpleado.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                RegistroNuevoEmpleado registroEmpleado = new RegistroNuevoEmpleado();
//                registroEmpleado.setVisible(true);
//                dispose();
//            }
//        });
//		btnRegistrarEmpleado.setBounds(52, 127, 228, 89);
//		contentPane.add(btnRegistrarEmpleado);
//		
//		JButton btnRegistrarCategoria = new JButton("Registrar Nueva Categoría");
//		btnRegistrarCategoria.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                CrearCategoria crearCategoria = new CrearCategoria();
//                crearCategoria.setVisible(true);
//                dispose();
//            }
//        });
//		btnRegistrarCategoria.setBounds(984, 127, 174, 89);
//		contentPane.add(btnRegistrarCategoria);
		
		JButton btnSalir = new JButton("Salir de la aplicación");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane, "Gracias por usar JowIts!", "Saliendo de la aplicación. ", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
		});
		btnSalir.setBounds(966, 584, 192, 52);
		contentPane.add(btnSalir);
		
		
		
		
		/*
		 * 
		 * BOTON REGISTRIOS
		 * 
		 */
		
		
		JButton btnRegistros = new JButton("REGISTROS");
		btnRegistros.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRegistros.setBounds(88, 268, 164, 94);
		contentPane.add(btnRegistros);
		btnRegistros.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
        	  JPanel panel = new JPanel();
            JButton button1 = new JButton("Producto");
            JButton button2 = new JButton("Empleado");
            JButton button3 = new JButton("Usuario");
            JButton button4 = new JButton("Categoria");
            
            panel.add(button1);
            panel.add(button2);
            panel.add(button3);
            panel.add(button4);
          
            button1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Crear y mostrar el nuevo frame
                	RegistroNuevoProducto PRODUCTOS = new RegistroNuevoProducto();
                	PRODUCTOS.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo este frame, no toda la aplicación
                	PRODUCTOS.setVisible(true);
                	dispose();
                }
            });
            
            button2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Crear y mostrar el nuevo frame
                	RegistroNuevoEmpleado EMPLEADO = new RegistroNuevoEmpleado();
                	EMPLEADO.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo este frame, no toda la aplicación
                	EMPLEADO.setVisible(true);
                	dispose();
                }
            });
            
            button3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Crear y mostrar el nuevo frame
                	RegistroUsuario USUARIO = new RegistroUsuario();
                	USUARIO.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo este frame, no toda la aplicación
                	USUARIO.setVisible(true);
                	dispose();
                }
            });
            
            button4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Crear y mostrar el nuevo frame
                	CrearCategoria CATEGORIA = new CrearCategoria();
                	CATEGORIA.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo este frame, no toda la aplicación
                	CATEGORIA.setVisible(true);
                	dispose();
                }
            });
            
            
            
            // Mostrar el panel dentro de un JOptionPane
            int option = JOptionPane.showOptionDialog(contentPane, panel, "Selecciona una opción",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                    new Object[]{"Cancelar"}, null);
            
            // Realizar acciones basadas en la opción seleccionada
            switch (option) {
                case 0: // El usuario seleccionó el primer botón
                    System.out.println("El usuario seleccionó Opción 1");
                    
                                        
                    break;
                case 1: // El usuario seleccionó el segundo botón
                    System.out.println("El usuario seleccionó Opción 2");
                    
                    
                    break;
                case 2: // El usuario seleccionó el tercer botón
                    System.out.println("El usuario seleccionó Opción 3");
                    
                    
                    break;
                case 3: // El usuario seleccionó el tercer botón
                    System.out.println("El usuario seleccionó Opción 4");
                    
                    
                    break;
                default: // El usuario cerró el diálogo o seleccionó Cancelar
                    System.out.println("El usuario canceló");
                    break;
            }
          }
      });
		
		
		/*
		 * 
		 * VISUALIZACION
		 * 
		 */
		
		
		
		
		
		JButton btnVisualizacion = new JButton("VISUALIZACION");
		btnVisualizacion.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVisualizacion.setBounds(1011, 268, 164, 94);
		contentPane.add(btnVisualizacion);
		
		btnVisualizacion.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	        	JPanel panel = new JPanel();
	            JButton button1 = new JButton("Producto");
	            JButton button2 = new JButton("Categorias");
	            
	            panel.add(button1);
	            panel.add(button2);
	          
	            button1.addActionListener(new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                    // Crear y mostrar el nuevo frame
	                	VerProductos PRODUCTOS = new VerProductos();
	                	PRODUCTOS.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo este frame, no toda la aplicación
	                	PRODUCTOS.setVisible(true);
	                	dispose();
	                }
	            });
	            
	            button2.addActionListener(new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                    // Crear y mostrar el nuevo frame
	                	VerCategorias CATEGORIAS = new VerCategorias();
	                	CATEGORIAS.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo este frame, no toda la aplicación
	                	CATEGORIAS.setVisible(true);
	                	dispose();
	                }
	            });
	            
	            
	            
	            // Mostrar el panel dentro de un JOptionPane
	            int option = JOptionPane.showOptionDialog(contentPane, panel, "Selecciona una opción",
	                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
	                    new Object[]{"Cancelar"}, null);
	            
	            // Realizar acciones basadas en la opción seleccionada
	            switch (option) {
	                case 0: // El usuario seleccionó el primer botón
	                    System.out.println("El usuario seleccionó Opción 1");
	                    
	                    
	                    
	                    break;
	                case 1: // El usuario seleccionó el segundo botón
	                    System.out.println("El usuario seleccionó Opción 2");
	                    
	                    
	                    
	                    break;
	                default: // El usuario cerró el diálogo o seleccionó Cancelar
	                    System.out.println("El usuario canceló");
	                    break;
	            }
	          }
	      });
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
