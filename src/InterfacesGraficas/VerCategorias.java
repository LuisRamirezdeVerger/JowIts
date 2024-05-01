package interfacesGraficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.TableModel;

import connections.ConexionMySQL;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTable;

public class VerCategorias extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea textAreaCategorias;
    private JList<String> listCategorias;


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
        lblImagen.setBounds(419, 48, 426, 290);
        ImageIcon ico2 = new ImageIcon(getClass().getResource("/imagenes/logo2.png"));
        ImageIcon img2 = new ImageIcon(ico2.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(),
                Image.SCALE_SMOOTH));
                
                        // Botón para cargar las categorías
                        JButton btnCargarCategorias = new JButton("Cargar Categorías");
                        btnCargarCategorias.setSize(289, 75);
                        btnCargarCategorias.setLocation(487, 566);
                        btnCargarCategorias.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                mostrarCategorias();
                            }
                        });
                               // listCategorias = new JList<>(listModel);
                                JScrollPane scrollPane1 = new JScrollPane(listCategorias);
                                contentPane.add(scrollPane1, BorderLayout.CENTER);
                        
                                // Crear el área de texto para mostrar las categorías
                                textAreaCategorias = new JTextArea();
                                textAreaCategorias.setRows(3);
                                textAreaCategorias.setEditable(false);
                                JScrollPane scrollPane = new JScrollPane(textAreaCategorias);
                                scrollPane.setSize(179, 140);
                                scrollPane.setLocation(546, 407);
                                contentPane.add(scrollPane, BorderLayout.CENTER);
                        contentPane.add(btnCargarCategorias, BorderLayout.SOUTH);
        lblImagen.setIcon(img2);
        contentPane.add(lblImagen, BorderLayout.NORTH);
        
        JLabel lblCategoriasCreadas = new JLabel("Categorías creadas: ");
        lblCategoriasCreadas.setHorizontalAlignment(SwingConstants.CENTER);
        lblCategoriasCreadas.setBounds(546, 370, 179, 14);
        contentPane.add(lblCategoriasCreadas);
        
        JButton btnAtras = new JButton("Volver");
        btnAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main main = new Main();
                main.setVisible(true);
                dispose();
            }
        });
        btnAtras.setSize(289, 75);
        btnAtras.setBounds(82, 604, 159, 37);
        contentPane.add(btnAtras);
        
        
     // Lista para mostrar las categorías
        DefaultListModel<String> listModel = new DefaultListModel<>();
    }

    // Método para mostras las categorías
    private void mostrarCategorias() {
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
