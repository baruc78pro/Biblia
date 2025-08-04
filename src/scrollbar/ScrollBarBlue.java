package scrollbar;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBarBlue extends JScrollBar {

    public ScrollBarBlue() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(8, 8));
        setForeground(new Color(0, 100, 200));
        setBackground(new Color(250,250,250));
    }
}