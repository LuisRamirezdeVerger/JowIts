package interfacesGraficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import connections.ConexionMySQL;
import java.awt.Desktop;

import javax.swing.SwingConstants;

public class VerCategorias extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea textAreaCategorias;
    private JTextField textFieldCategoria;
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
        contentPane.setBackground(new Color(131, 185, 245));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        textFieldCategoria = new JTextField();
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

        // Área de texto para mostrar las categorías
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

        // Botón teclado en pantalla
        JButton btnTeclado = new JButton("Teclado de Pantalla");
        btnTeclado.setBounds(1065, 608, 159, 50);
        contentPane.add(btnTeclado);
        btnTeclado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Ejecutar el comando para abrir el teclado de pantalla en Windows
                    Desktop.getDesktop().open(new File("C:\\Windows\\System32\\osk.exe"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(contentPane, "No se pudo abrir el teclado de pantalla.");
                }
            }
        });

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

        // JTextField para ingresar el nombre de la categoría a eliminar
        textFieldCategoria = new JTextField();
        textFieldCategoria.setBounds(801, 405, 200, 30);
        contentPane.add(textFieldCategoria);

        contentPane.add(btnCargarCategorias, BorderLayout.SOUTH);
        lblImagen.setIcon(img2);
        contentPane.add(lblImagen, BorderLayout.NORTH);

        // Botón para eliminar categoría
        JButton btnEliminarCategoria = new JButton("Eliminar Categoría");
        btnEliminarCategoria.setBounds(1024, 405, 200, 30);
        btnEliminarCategoria.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarCategoria();
            }
        });
        contentPane.add(btnEliminarCategoria);
        
        JLabel lblEscribaUnaCategora = new JLabel("Escriba una categoría a eliminar");
        lblEscribaUnaCategora.setHorizontalAlignment(SwingConstants.CENTER);
        lblEscribaUnaCategora.setBounds(801, 370, 200, 14);
        contentPane.add(lblEscribaUnaCategora);

    }

    // Método para mostrar las categorías
    private void mostrarCategorias() {
        ConexionMySQL conexion = new ConexionMySQL("freedb_wito.medac", "8DKQRDXu6Xumm@r", "freedb_medac420");

        try {
            conexion.conectar();
            // Consulta
            String consulta = "SELECT nombreCategoria FROM Categoria";
            ResultSet rs = conexion.ejecutarSelect(consulta);
            // Limpia el área de texto antes de mostrar las nuevas categorías
            textAreaCategorias.setText("");
            // Agregamos las categorías al área de texto
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

    // Método para eliminar una categoría
    private void eliminarCategoria() {
        ConexionMySQL conectInv = new ConexionMySQL("freedb_wito.medac", "8DKQRDXu6Xumm@r", "freedb_medac420");
    
        try {
        	conectInv.conectar();
            String categoriaEscrita = textFieldCategoria.getText().trim();
            // Verificar si el campo está vacío
            if (!categoriaEscrita.isEmpty()) {
                // Consulta para eliminar la categoría
                String consulta = "DELETE FROM Categoria WHERE nombreCategoria = '" + categoriaEscrita + "'";
                int filasAfectadas = conectInv.ejecutarInsertDeleteUpdate(consulta);
                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(contentPane, "Categoría eliminada exitosamente.");
                    // Volver a cargar las categorías actualizadas
                    mostrarCategorias();
                } else {
                    JOptionPane.showMessageDialog(contentPane, "No se encontró la categoría especificada.");
                }
            } else {
                JOptionPane.showMessageDialog(contentPane, "Por favor, ingrese el nombre de la categoría a eliminar.");
            }
    
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
            	conectInv.desconectar();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
