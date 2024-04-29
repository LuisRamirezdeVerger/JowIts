package interfacesGraficas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JFormattedTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.border.LineBorder;

public class verProductos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					verProductos frame = new verProductos();
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
	public verProductos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(240, 230, 140));
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JEditorPane editorPane = new JEditorPane();
		contentPane.add(editorPane);
		
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
		
		JTree tree = new JTree();
		tree.setBackground(new Color(240, 230, 140));
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Comidas") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("Carnes");
						node_1.add(new DefaultMutableTreeNode("Secreto Iberico"));
						node_1.add(new DefaultMutableTreeNode("Chuleton Rubia Gallega"));
						node_1.add(new DefaultMutableTreeNode("Cordero al Horno"));
						node_1.add(new DefaultMutableTreeNode("Solomillo al Roque"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Pescado");
						node_1.add(new DefaultMutableTreeNode("Lubina al Horno"));
						node_1.add(new DefaultMutableTreeNode("Dorada al Horno"));
						node_1.add(new DefaultMutableTreeNode("Choco Frito"));
						node_1.add(new DefaultMutableTreeNode("Frito Variado"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Mariscos");
						node_1.add(new DefaultMutableTreeNode("Gambas"));
						node_1.add(new DefaultMutableTreeNode("Mejillones"));
						node_1.add(new DefaultMutableTreeNode("Langostinos"));
						node_1.add(new DefaultMutableTreeNode("Centollos"));
					add(node_1);
				}
			}
		));
		tree.setBounds(163, 240, 163, 177);
		contentPane.add(tree);
		
		
	}
}
