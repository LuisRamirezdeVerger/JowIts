package interfacesGraficas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class POPUP extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					POPUP frame = new POPUP();
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
	public POPUP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 246, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		
		
		

		/*
		 * 
		 * BOTON REGISTRIOS
		 * 
		 */
		
		
		JButton btnRegistros = new JButton("REGISTROS");
		btnRegistros.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRegistros.setBounds(88, 268, 164, 94);
		contentPane.add(btnRegistros);
		btnRegistros.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
        	  /*
               * POPUP
               */
              
              
              JPanel panel = new JPanel();
              JButton button1 = new JButton("Opción 1");
              JButton button2 = new JButton("Opción 2");
              JButton button3 = new JButton("Opción 3");
              JButton button4 = new JButton("Opción 4");
              panel.add(button1);
              panel.add(button2);
              panel.add(button3);
              panel.add(button4);
              
              // Mostrar el panel dentro de un JOptionPane
              int option = JOptionPane.showOptionDialog(contentPane, panel, "Selecciona una opción",
                      JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                      new Object[]{"Cancelar"}, null);
              
              // Realizar acciones basadas en la opción seleccionada
              switch (option) {
                  case 0: // El usuario seleccionó el primer botón
                      System.out.println("El usuario seleccionó Opción 1");
                      break;
                  case 1: // El usuario seleccionó el segundo botón
                      System.out.println("El usuario seleccionó Opción 2");
                      break;
                  case 2: // El usuario seleccionó el tercer botón
                      System.out.println("El usuario seleccionó Opción 3");
                      break;
                  case 3: // El usuario seleccionó el cuarto botón
                      System.out.println("El usuario seleccionó Opción 4");
                      break;
                  default: // El usuario cerró el diálogo o seleccionó Cancelar
                      System.out.println("El usuario canceló");
                      break;
              }
          }
      });
		
		
		
		
		
		
	}

}
