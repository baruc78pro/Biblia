package Estilos;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.border.AbstractBorder;

public class RoundedBorder extends AbstractBorder {
    
    private final Color color;
    private final int thickness;
    private final int radius;
    private final boolean rounded;

    public RoundedBorder(Color color, int thickness, int radius, boolean rounded) {
        this.color = color;
        this.thickness = thickness;
        this.radius = radius;
        this.rounded = rounded;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(color);
        
        for (int i = 0; i < thickness; i++) {
            if (rounded) {
                g2.drawRoundRect(x + i, y + i, width - 1 - i * 2, height - 1 - i * 2, radius, radius);
            } else {
                g2.drawRect(x + i, y + i, width - 1 - i * 2, height - 1 - i * 2);
            }
        }
        g2.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(thickness, thickness, thickness, thickness);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.left = insets.top = insets.right = insets.bottom = thickness;
        return insets;
    }
}