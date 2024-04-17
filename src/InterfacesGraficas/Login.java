package InterfacesGraficas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 300, 537, 316);
		//Hacemos que la pantalla se centre
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JEditorPane editorPane = new JEditorPane();
		contentPane.add(editorPane);
		
		JEditorPane dtrpnNombreUsuario = new JEditorPane();
		dtrpnNombreUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//Creamos evento que al hacer click, elimine el texto que haya
				dtrpnNombreUsuario.setText("");
			}
		});
		dtrpnNombreUsuario.setText("Introduce usuario ");
		dtrpnNombreUsuario.setBounds(132, 178, 100, 20);
		contentPane.add(dtrpnNombreUsuario);
		
		JLabel lblImagen = new JLabel("Logo");
		lblImagen.setBounds(188, 11, 134, 125);
		ImageIcon ico2 =new ImageIcon(getClass().getResource("/imagenes/logo2.png"));
		ImageIcon img2 =new ImageIcon(ico2.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH));
		lblImagen.setIcon(img2);
		contentPane.add(lblImagen);
		
		passwordField = new JPasswordField("Contraseña");
		passwordField.setBounds(282, 178, 100, 20);
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//Creamos evento que al hacer click, elimine el texto que haya.
				passwordField.setText("");
			}
		});
		contentPane.add(passwordField);
		
		JTextArea textArea = new JTextArea("Usuario");
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textArea.setBackground(null);
		textArea.setBounds(132, 147, 100, 20);
		textArea.setMargin(new Insets(3, 30, 3, 0));
		textArea.setAlignmentX(textArea.CENTER_ALIGNMENT);
		textArea.setAlignmentY(textArea.CENTER_ALIGNMENT);
		
		textArea.setEditable(false);
		contentPane.add(textArea);
		
		JTextArea txtrContrasea = new JTextArea("Contrase\u00F1a");
		txtrContrasea.setMargin(new Insets(3, 20, 3, 0));
		txtrContrasea.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtrContrasea.setEditable(false);
		txtrContrasea.setBackground((Color) null);
		txtrContrasea.setAlignmentY(0.5f);
		txtrContrasea.setAlignmentX(0.5f);
		txtrContrasea.setBounds(282, 147, 100, 20);
		contentPane.add(txtrContrasea);
		
		JButton btnNewButton = new JButton("Conectar");
		//Con "MouseListener" podemos hacer diferentes cosas cuando el mouse entre/salga
		btnNewButton.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		        // Cambiar el color cuando el mouse entr
		        btnNewButton.setBackground(Color.lightGray);
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		        // Restaura el color original del botón cuando el mouse salga
		        btnNewButton.setBackground(Color.WHITE);
		    }
		});
            
		btnNewButton.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				btnNewButton.setBackground(Color.WHITE);
			}
		});
		btnNewButton.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				btnNewButton.setText("Conectando...");
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Introducir conexión a la DDBB aqu�
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
		btnNewButton.setBounds(132, 222, 250, 31);
		contentPane.add(btnNewButton);
		
	}
}