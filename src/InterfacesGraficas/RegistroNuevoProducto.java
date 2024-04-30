package interfacesGraficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connections.ConexionMySQL;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;

public class RegistroNuevoProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

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
		
		ConexionMySQL conexion = new ConexionMySQL("freedb_wito.medac", "8DKQRDXu6Xumm@r", "freedb_medac420");

		
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
		
		JLabel lblNewLabel = new JLabel("Nombre Producto");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(210, 368, 287, 49);
		contentPane.add(lblNewLabel);
		contentPane.setLayout(null);
		
		JLabel lblCantidadDelProducto = new JLabel("Cantidad del Producto a añadir");
		lblCantidadDelProducto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCantidadDelProducto.setBounds(210, 508, 287, 49);
		contentPane.add(lblCantidadDelProducto);
		contentPane.setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinner.setToolTipText("");
		spinner.setBounds(728, 526, 202, 31);
		contentPane.add(spinner);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(728, 381, 202, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText("Añadir el nombre del producto");
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//Creamos evento que al hacer click, elimine el texto que haya.
				textField.setText("");
			}
		});
		
		
		
		/*
		 * Boton que enviara todo
		 */
		
		JButton btnNewButton = new JButton("Introducir el producto");
		btnNewButton.setBounds(913, 131, 247, 102);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String textAnadirProducto = textField.getText();
				int value = (int) spinner.getValue(); // Convertir a Integer si es necesario
                JOptionPane.showMessageDialog(contentPane, "Vas a añadir el producto= "+ textAnadirProducto+"\nLa cantidad es= " + value);
                try {
					conexion.conectar();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
                String consulta = "INSERT INTO Producto (nombreProducto, cantidadProducto) VALUES ('" + textAnadirProducto+ "', '" + value + "')";
                
                try {
					conexion.ejecutarInsertDeleteUpdate(consulta);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
                
                
                
                
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
                // Ocultar este frame
                setVisible(false);
                
                // Mostrar el siguiente frame
                MAIN frame2 = new MAIN();
                frame2.setVisible(true);
            }
        });
        
        getContentPane().add(volverMain, BorderLayout.CENTER);
        
        setVisible(true);
		
		
		
		
		
		
		
		
		
		
		
	}
}
