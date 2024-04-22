package interfacesGraficas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;

public class Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 300, 537, 316);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JEditorPane editorPane = new JEditorPane();
		contentPane.add(editorPane);
		
		JEditorPane dtrpnNombre = new JEditorPane();
		dtrpnNombre.setText("Nombre");
		dtrpnNombre.setBounds(10, 38, 107, 20);
		contentPane.add(dtrpnNombre);
		
		JEditorPane dtrpnDni = new JEditorPane();
		dtrpnDni.setText("DNI");
		dtrpnDni.setBounds(10, 80, 107, 20);
		contentPane.add(dtrpnDni);
		
		JEditorPane dtrpnContrasea = new JEditorPane();
		dtrpnContrasea.setText("Contraseña");
		dtrpnContrasea.setBounds(10, 125, 107, 20);
		contentPane.add(dtrpnContrasea);
		
		JEditorPane dtrpnConfirmarContrasea = new JEditorPane();
		dtrpnConfirmarContrasea.setText("Confirmar Contraseña");
		dtrpnConfirmarContrasea.setBounds(10, 169, 107, 20);
		contentPane.add(dtrpnConfirmarContrasea);
		
		
		
		
		
	}
}
