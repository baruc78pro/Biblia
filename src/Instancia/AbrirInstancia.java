package Instancia;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AbrirInstancia {
    private static final ExecutorService executor = Executors.newCachedThreadPool();
    
    public void instancia(JFrame frame) {
        executor.execute(() -> {
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            SwingUtilities.invokeLater(() -> {
                frame.setVisible(true);
                frame.revalidate();
                frame.repaint();
            });
        });
    }
    
    public static void shutdown() {
        executor.shutdown();
    }
}