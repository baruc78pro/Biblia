package scrollbar;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBarGolden extends JScrollBar {

    public ScrollBarGolden() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(8, 8));
        setForeground(new Color(255,211,105));
        setBackground(new Color(40,40,40));
    }
}