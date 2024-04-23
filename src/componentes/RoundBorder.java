package componentes;

import java.awt.*;
import javax.swing.border.*;

public class RoundBorder implements Border {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private int radius;

    public RoundBorder(int radius) {
        this.radius = radius;
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
    }

    public boolean isBorderOpaque() {
        return true;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(c.getForeground());
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
    }
}
