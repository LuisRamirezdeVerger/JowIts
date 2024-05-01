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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import connections.ConexionMySQL;
import java.awt.Component;

public class VerCategorias extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea textAreaCategorias;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VerCategorias frame = new VerCategorias();
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
    public VerCategorias() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

        /*
         * LOGO
         */

        JLabel lblImagen = new JLabel("Logo");
        lblImagen.setBounds(419, 81, 426, 346);
        ImageIcon ico2 = new ImageIcon(getClass().getResource("/imagenes/logo2.png"));
        ImageIcon img2 = new ImageIcon(ico2.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(),
                Image.SCALE_SMOOTH));
                
                        // Botón para cargar las categorías
                        JButton btnCargarCategorias = new JButton("Cargar Categorías");
                        btnCargarCategorias.setSize(120, 120);
                        btnCargarCategorias.setLocation(580, 521);
                        btnCargarCategorias.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                cargarCategorias();
                            }
                        });
                        
                                // Crear el área de texto para mostrar las categorías
                                textAreaCategorias = new JTextArea();
                                textAreaCategorias.setEditable(true);
                                JScrollPane scrollPane = new JScrollPane(textAreaCategorias);
                                scrollPane.setSize(100, 200);
                                scrollPane.setLocation(300, 300);
                                contentPane.add(scrollPane, BorderLayout.CENTER);
                        contentPane.add(btnCargarCategorias, BorderLayout.SOUTH);
        lblImagen.setIcon(img2);
        contentPane.add(lblImagen, BorderLayout.NORTH);
    }

    // Método para cargar las categorías desde la base de datos y mostrarlas en el JTextArea
    private void cargarCategorias() {
        ConexionMySQL conexion = new ConexionMySQL("freedb_wito.medac", "8DKQRDXu6Xumm@r", "freedb_medac420");

        try {
            conexion.conectar();
            // Consulta para obtener las categorías desde la base de datos
            String consulta = "SELECT nombreCategoria FROM Categoria";
            ResultSet rs = conexion.ejecutarSelect(consulta);

            // Limpiar el área de texto antes de mostrar las nuevas categorías
            textAreaCategorias.setText("");

            // Agregar las categorías al área de texto
            while (rs.next()) {
                textAreaCategorias.append(rs.getString("nombreCategoria") + "\n");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexion.desconectar();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
