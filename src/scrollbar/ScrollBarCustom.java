package scrollbar;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBarCustom extends JScrollBar {

    public ScrollBarCustom() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(9, 12));
        setForeground(new Color(250, 0, 0));
        setBackground(new Color(60,60,60));
    }
}