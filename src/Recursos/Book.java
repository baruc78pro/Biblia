package Recursos;

import Comandos.CLibro;
import Comandos.ClipBoard;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.DefaultStyledDocument;
import scrollbar.ScrollBarGolden;
import texto.Escala;
import texto.Marker;
import Dialogo.TooltipHelper;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.SwingWorker;
import javax.swing.text.DefaultCaret;
import texto.BraileTraductor;

public class Book extends javax.swing.JFrame {
    
    ArrayList<JTextPane> list = new ArrayList<>();
    private String ruta;
    private String identificador;
    private int totalCapitulos;
    private int capituloActual = 1;
    private static final int CHUNK_SIZE = 1000; // Número de líneas a cargar por parte
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private SwingWorker<Void, String> loadingWorker;
    
    public Book() {
        initComponents();
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("images/logo.png")).getImage());
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        new CLibro().KeyEvent(this);
        new ClipBoard().configurarAtajos(textArea);
        
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        textArea.setBorder(null);
        textArea.setBackground(Color.decode("#1C1C1E"));
        textArea.setForeground(Color.decode("#E8E6E3"));
        panel.setBackground(Color.decode("#1C1C1E"));
        scrollPane.setVerticalScrollBar(new ScrollBarGolden());
        ScrollBarGolden sp = new ScrollBarGolden();
        sp.setOrientation(JScrollBar.HORIZONTAL);
        scrollPane.setHorizontalScrollBar(sp);
        next.setBackground(new Color(0,0,0,0));
        prev.setBackground(new Color(0,0,0,0));
        list.add(textArea);
        slider.setMajorTickSpacing(12);
        slider.setMinorTickSpacing(4);
        slider.setPaintTicks(true);
        slider.setMinimum(8);
        slider.setMaximum(48);
        slider.setValue(12);
        libro.setBackground(new Color(0,0,0,0));
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e){
                new Escala().tamText(slider.getValue(), list);
            }
        });
        DefaultStyledDocument doc = new DefaultStyledDocument();
        textArea.setStyledDocument(doc);
        new Marker().colors(textArea);
        abrirBiblia(libro, new Bible());
        next.addActionListener(e -> avanzarCapitulo());
        prev.addActionListener(e -> retrocederCapitulo());
        new TooltipHelper().applyTooltips(textArea);
        textArea.getCaret().setBlinkRate(0);
        textArea.setCaret(new DefaultCaret() {
            @Override
            public void paint(Graphics g) {
        // No pintar nada (caret invisible)
            }
        });
        textArea.addKeyListener(new KeyAdapter() {
        @Override
            public void keyPressed(KeyEvent e) { 
                if((e.getModifiersEx() & (KeyEvent.CTRL_DOWN_MASK)) != 0 
                    && e.getKeyCode() == KeyEvent.VK_T){
                        new BraileTraductor().traducir(textArea);
                }
            }
        });
    }
    
    public void abrirBiblia(JButton button, JFrame frame) {
        button.addActionListener(e -> {
            frame.setVisible(true);
            frame.requestFocusInWindow();
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.dispose();
        });
    }
    public void cargarLibro(String ruta, String identificador, int totalCapitulos) {
        this.ruta = ruta;
        this.identificador = identificador;
        this.totalCapitulos = totalCapitulos;
        this.capituloActual = 1;
        next.setEnabled(totalCapitulos > 1);
        prev.setEnabled(false);
        cargarCapitulo();
    }
    
    private void cargarCapitulo() {
    if (loadingWorker != null && !loadingWorker.isDone()) {
        loadingWorker.cancel(true);
    }
    
    textArea.setText("Cargando capítulo " + capituloActual + "...");

    loadingWorker = new SwingWorker<Void, String>() {
        @Override
        protected Void doInBackground() throws Exception {
            String rutaArchivo = ruta + identificador + capituloActual + ".txt";
            try (InputStream input = getClass().getResourceAsStream("/" + rutaArchivo);
                 BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8))) {
                
                if (input == null) {
                    publish("Error: Archivo no encontrado\n" + rutaArchivo);
                    return null;
                }
                
                StringBuilder content = new StringBuilder();
                String line;
                int lineCount = 0;
                
                while ((line = reader.readLine()) != null && !isCancelled()) {
                    content.append(line).append("\n");
                    lineCount++;
                    
                    // Publicar cada 100 líneas para mantener la UI responsive
                    if (lineCount % 100 == 0) {
                        publish(content.toString());
                        content.setLength(0); // Limpiar el buffer
                    }
                }
                
                if (!isCancelled() && content.length() > 0) {
                    publish(content.toString());
                }
                
            } catch (Exception e) {
                if (!isCancelled()) {
                    publish("Error al cargar el capítulo: " + e.getMessage());
                }
            }
            return null;
        }

        @Override
        protected void process(List<String> chunks) {
            if (textArea.getText().startsWith("Cargando")) {
                textArea.setText("");
            }
            
            // Agregar los nuevos chunks al contenido existente
            for (String chunk : chunks) {
                textArea.setText(textArea.getText() + chunk);
            }
            textArea.setCaretPosition(0);
        }

            @Override
            protected void done() {
                if (isCancelled()) {
                    textArea.setText("Carga cancelada");
                }
            }
        };
    
        executor.execute(loadingWorker);
    }

    public void avanzarCapitulo() {
        if (capituloActual < totalCapitulos) {
            capituloActual++;
            cargarCapitulo();
        } else {
            JOptionPane.showMessageDialog(this, "Has alcanzado el último capítulo.",
                                      "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
        next.setEnabled(capituloActual < totalCapitulos);
        prev.setEnabled(capituloActual > 1);
    }

    public void retrocederCapitulo() {
        if (capituloActual > 1) {
            capituloActual--;
            cargarCapitulo();
        } else {
            JOptionPane.showMessageDialog(this, "Estás en el primer capítulo.",
                                      "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
        next.setEnabled(capituloActual < totalCapitulos);
        prev.setEnabled(capituloActual > 1);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextPane();
        slider = new slider.JsliderCustom();
        libro = new javax.swing.JButton();
        next = new javax.swing.JButton();
        prev = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setBackground(new java.awt.Color(40, 40, 40));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textArea.setEditable(false);
        textArea.setBackground(new java.awt.Color(40, 40, 40));
        textArea.setBorder(null);
        textArea.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textArea.setForeground(new java.awt.Color(220, 220, 220));
        textArea.setText("texto prueba");
        textArea.setOpaque(false);
        scrollPane.setViewportView(textArea);

        panel.add(scrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 600, 480));

        slider.setForeground(new Color(250,0,0));
        panel.add(slider, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 540, -1));

        libro.setBackground(new java.awt.Color(10, 10, 10));
        libro.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        libro.setForeground(new java.awt.Color(250, 250, 250));
        libro.setText("ir a Biblia");
        libro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        libro.setBorderPainted(false);
        libro.setContentAreaFilled(false);
        libro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel.add(libro, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 530, 230, 50));

        next.setBackground(new java.awt.Color(245, 245, 220));
        next.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        next.setForeground(new java.awt.Color(250, 250, 250));
        next.setText(">");
        next.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        next.setBorderPainted(false);
        next.setContentAreaFilled(false);
        next.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel.add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 40, 490));

        prev.setBackground(new java.awt.Color(245, 245, 220));
        prev.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        prev.setForeground(new java.awt.Color(250, 250, 250));
        prev.setText("<");
        prev.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        prev.setBorderPainted(false);
        prev.setContentAreaFilled(false);
        prev.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel.add(prev, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 490));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/book_font.png"))); // NOI18N
        panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 590));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Book().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton libro;
    private javax.swing.JButton next;
    private javax.swing.JPanel panel;
    private javax.swing.JButton prev;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JSlider slider;
    public javax.swing.JTextPane textArea;
    // End of variables declaration//GEN-END:variables
}