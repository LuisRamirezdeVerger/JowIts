package interfacesGraficas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	// Variables para detectar combinaciones de teclas
    private boolean teclaWPresionada = false;
    private boolean teclaSPresionada = false;
    private boolean teclaAPresionada = false;

    // Método para verificar la combinación de teclas
    private void checkKeyCombination() {
        if (teclaWPresionada && teclaSPresionada && teclaAPresionada) {
            JOptionPane.showMessageDialog(contentPane, "¡Has seleccionado el panel de Administración!");
            int opcion = JOptionPane.showConfirmDialog(this, "¿Deseas abrir el menú?", "Confirmar apertura de menú", JOptionPane.YES_NO_OPTION);
            
            if (opcion == JOptionPane.YES_OPTION) {
            	JPasswordField passwordField = new JPasswordField();
                Object[] message = {"Introduce la contraseña:", passwordField};
                int result = JOptionPane.showConfirmDialog(this, message, "Confirmar contraseña", JOptionPane.OK_CANCEL_OPTION);
                
                if (result == JOptionPane.OK_OPTION) {
                    // Obtiene la contraseña ingresada por el usuario
                    char[] passwordChars = passwordField.getPassword();
                    @SuppressWarnings("unused")
					String password = new String(passwordChars);
                    //Aquí añadiremos el panel de administración
                    Main nuevoFrame = new Main();
                    nuevoFrame.setVisible(true);
                    dispose(); 
                }
            }
        }
        contentPane.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
               if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                   int opcion = JOptionPane.showConfirmDialog(contentPane, "¿Deseas cerrar la aplicación?", "Confirmar salida de la aplicación", JOptionPane.YES_NO_OPTION);
		        // Verificamos la opción seleccionada por el usuario
		        if (opcion == JOptionPane.YES_OPTION) {
		            JOptionPane.showMessageDialog(contentPane, "Gracias por usar 'JowIts'!"); 
		            dispose();
		        }
                }
               
            }
        });
    }

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
		contentPane.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
               if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                   int opcion = JOptionPane.showConfirmDialog(contentPane, "¿Deseas cerrar la aplicación?", "Confirmar salida de la aplicación", JOptionPane.YES_NO_OPTION);
		        // Verificamos la opción seleccionada por el usuario
		        if (opcion == JOptionPane.YES_OPTION) {
		            JOptionPane.showMessageDialog(contentPane, "Gracias por usar 'JowIts'!"); 
		            dispose();
		        }
                }
               
            }
        });
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 
		//////////// Key Listener //////////////
        contentPane.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Verificamos las teclas pulsadaso y actualizamos las variables
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    teclaWPresionada = true;
                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    teclaSPresionada = true;
                } else if (e.getKeyCode() == KeyEvent.VK_A) {
                    teclaAPresionada = true;
                }

                // Verificamos si se ha pulsado la combinación de teclas
                checkKeyCombination();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Verificamos qué tecla se ha soltado y actualizamos las variables correspondientes
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    teclaWPresionada = false;
                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    teclaSPresionada = false;
                } else if (e.getKeyCode() == KeyEvent.VK_A) {
                    teclaAPresionada = false;
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // No es necesario implementar este método, pero es parte de la interfaz KeyListener
            }
        });

        // Hacemos que el panel contentPane sea el foco para que pueda recibir eventos de teclado
        contentPane.setFocusable(true);
        contentPane.requestFocus();
    

		JButton btnLogin = new JButton("Log in");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		btnLogin.setBounds(465, 464, 350, 116);
		contentPane.add(btnLogin);

		JButton btnRegistraEmpresa = new JButton("Registrar empresa nueva");
		btnRegistraEmpresa.setBounds(465, 270, 350, 116);
		btnRegistraEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroEmpresa registroEmpresa = new RegistroEmpresa();
				registroEmpresa.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnRegistraEmpresa);

		

		// Crear botón de ir salir

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(136, 594, 195, 48);
		btnSalir.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Mostramos un mensaje de confirmación antes de salir
		        int opcion = JOptionPane.showConfirmDialog(contentPane, "¿Deseas cerrar la aplicación?", "Confirmar salida de la aplicación", JOptionPane.YES_NO_OPTION);
		        
		        // Verificamos la opción seleccionada por el usuario
		        if (opcion == JOptionPane.YES_OPTION) {
		            JOptionPane.showMessageDialog(contentPane, "Gracias por usar 'JowIts'!"); 
		            dispose(); // Cerramos la ventana actual
		        }
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
