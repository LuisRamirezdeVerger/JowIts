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

public class MAIN extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MAIN frame = new MAIN();
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
	public MAIN() {
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		/*
		 * Icono
		 */
		
		JLabel IconoUsuario = new JLabel("IconoUsuario");
		
		IconoUsuario.setBounds(262, 68, 739, 545);
		ImageIcon ico2 =new ImageIcon(getClass().getResource("/imagenes/logo2.png"));
		ImageIcon img2 =new ImageIcon(ico2.getImage().getScaledInstance(IconoUsuario.getWidth(), IconoUsuario.getHeight(), Image.SCALE_SMOOTH));
		IconoUsuario.setIcon(img2);
		contentPane.add(IconoUsuario);
		
		//BOTÓN DE ATRÁS
		JButton btnFlecha = new JButton("Atrás");
		btnFlecha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainFrame mainFrame = new MainFrame();
                mainFrame.setVisible(true);
                dispose();
            }
        });
		getContentPane().add(btnFlecha, BorderLayout.CENTER);
		btnFlecha.setBounds(52, 447, 174, 89);
		contentPane.add(btnFlecha);
		
		
		
		
		
		
		
		
		
		
		
	}
}
