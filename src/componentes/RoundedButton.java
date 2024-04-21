package componentes;

import javax.swing.*;
import java.awt.*;

public class RoundedButton extends JButton {

    private Color backgroundColor;
    private int cornerRadius;

    public RoundedButton(String text, Color backgroundColor, int cornerRadius) {
        super(text);
        this.backgroundColor = backgroundColor;
        this.cornerRadius = cornerRadius;
        setOpaque(false); // Hace que el fondo del botón sea transparente
        // setContentAreaFilled(false); // Elimina el relleno del contenido del botón
        // setBorderPainted(false); // Elimina el borde del botón
        setForeground(Color.WHITE); // Establece el color del texto del botón
        setFocusPainted(false); // Elimina el efecto de enfoque al hacer clic
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibujar fondo redondeado
        g2d.setColor(backgroundColor);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);

        // Llamar al método paintComponent de la superclase para dibujar el texto y
        // otros elementos
        super.paintComponent(g2d);

        g2d.dispose();
    }

    // Sobreescribe el método getPreferredSize para asegurar que el botón tenga un
    // tamaño adecuado
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(120, 40); // Ajusta el tamaño según lo necesites
    }
}
