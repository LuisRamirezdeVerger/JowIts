package interfacesGraficas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import connections.ConexionMySQL;

import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class nuevoProductoPrueba extends JFrame {

    private JPanel contentPane;
    private JTextField textField;

    // Declara una instancia de la clase ConexionMySQL
    private ConexionMySQL conexion;

    public nuevoProductoPrueba() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 1280, 720);
        contentPane = new JPanel();
        contentPane.setForeground(Color.BLACK);
        contentPane.setBackground(new Color(240, 230, 140));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Nombre Producto");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(210, 368, 287, 49);
        contentPane.add(lblNewLabel);

        JLabel lblCantidadDelProducto = new JLabel("Cantidad del Producto a añadir");
        lblCantidadDelProducto.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblCantidadDelProducto.setBounds(210, 508, 287, 49);
        contentPane.add(lblCantidadDelProducto);

        JSpinner spinner = new JSpinner();
        spinner.setModel(new SpinnerNumberModel(0, 0, null, 1));
        spinner.setToolTipText("");
        spinner.setBounds(728, 526, 202, 31);
        contentPane.add(spinner);

        textField = new JTextField();
        textField.setBounds(728, 381, 202, 31);
        contentPane.add(textField);
        textField.setColumns(10);
        textField.setText("Añadir el nombre del producto");
        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                textField.setText("");
            }
        });

        JButton btnNewButton = new JButton("Introducir el producto");
        btnNewButton.setBounds(913, 131, 247, 102);
        contentPane.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Establecer la conexión a la base de datos
                    conexion = new ConexionMySQL("freedb_wito.medac", "8DKQRDXu6Xumm@r", "freedb_medac420");
                    conexion.conectar();

                    // Preparar la consulta SQL para insertar un nuevo producto
                    String consulta = "INSERT INTO productos (nombre, cantidad) VALUES (?, ?)";
                    PreparedStatement statement = ((Statement) conexion).getConnection().prepareStatement(consulta);

                    // Obtener los valores del nombre del producto y la cantidad desde los componentes de la interfaz
                    String nombreProducto = textField.getText();
                    int cantidadProducto = (int) spinner.getValue();

                    // Establecer los valores de los parámetros en la consulta preparada
                    statement.setString(1, nombreProducto);
                    statement.setInt(2, cantidadProducto);

                    // Ejecutar la consulta
                    int filasAfectadas = statement.executeUpdate();

                    // Mostrar mensaje de éxito
                    JOptionPane.showMessageDialog(contentPane, "Producto añadido correctamente. Filas afectadas: " + filasAfectadas);

                    // Cerrar la conexión
                    conexion.desconectar();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(contentPane, "Error al añadir el producto: " + ex.getMessage());
                }
            }
        });
    }
}
