package Instancia;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.SwingUtilities;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AbrirFrame {
    private static final ExecutorService executor = Executors.newCachedThreadPool();
    
    public void instancia(JButton button, JFrame frame) {
        button.addActionListener(e -> {
            executor.execute(() -> {
                SwingUtilities.invokeLater(() -> {
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                });
            });
        });
    }
    
    public void instancia(JMenu menu, JFrame frame) {
        menu.addActionListener(e -> {
            executor.execute(() -> {
                SwingUtilities.invokeLater(() -> {
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                });
            });
        });
    }
    
    public void instancia(JButton button, JFrame frame, JFrame frame2) {
        button.addActionListener(e -> {
            executor.execute(() -> {
                SwingUtilities.invokeLater(() -> {
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame2.dispose();
                });
            });
        });
    }
    
    public void instancia(JFrame frame, JFrame frame2) {
        executor.execute(() -> {
            SwingUtilities.invokeLater(() -> {
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame2.dispose();
            });
        });
    }
    
    public void instanciaFoco(JButton button, JFrame frame, JFrame principal) {
        button.addActionListener(e -> {
            executor.execute(() -> {
                SwingUtilities.invokeLater(() -> {
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    principal.requestFocusInWindow();
                });
            });
        });
    }
}