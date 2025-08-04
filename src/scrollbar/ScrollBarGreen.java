package scrollbar;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBarGreen extends JScrollBar {

    public ScrollBarGreen() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(8, 8));
        setForeground(new Color(0, 200, 70));
        setBackground(new Color(250,250,250));
    }
}