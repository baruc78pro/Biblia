package Recursos;

import Comandos.CText;
import Comandos.ClipBoard;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JPopupMenu;
import javax.swing.Timer;
import texto.Analisis;
import texto.Escala;
import texto.Writer;
import texto.Reader;
import texto.DocxReader;
import texto.BraileTraductor;
import texto.Functions;

/**
 *
 * @author Malware Inc.
 */

public class Notes extends javax.swing.JFrame {
    
    private final ArrayList<JTextPane> list = new ArrayList<>();
    private JPopupMenu menu = new JPopupMenu();
    private final Analisis analizador = new Analisis();
    private final Functions func = new Functions();
    private final DocxReader docxs = new DocxReader();
    private final Writer writer = new Writer();
    private final Reader reader = new Reader();
    
    
    public Notes() {
        initComponents();
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("images/logo.png")).getImage());
        new CText().KeyEvent(this);
        new CText().buscador(textArea);
        new ClipBoard().configurarAtajos(textArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        textArea.setBorder(BorderFactory.createEmptyBorder());
        list.add(textArea);
        fondo.setBackground(Color.decode("#1C1C1E"));
        slider.setMajorTickSpacing(12);
        slider.setMinorTickSpacing(4);
        slider.setPaintTicks(true);
        slider.setForeground(Color.WHITE);
        slider.setMinimum(8);
        slider.setMaximum(48);
        slider.setValue(12);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e){
                new Escala().tamText(slider.getValue(), list);
            }
        });
        menu = new JPopupMenu();
        textArea.addKeyListener(new KeyAdapter() {
        @Override
            public void keyPressed(KeyEvent e) {
                // Verificar Ctrl+Shift+P (o la combinación que prefieras)
                if ((e.getModifiersEx() & (KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK)) != 0 
                    && e.getKeyCode() == KeyEvent.VK_P) {
            
                    // Crear y mostrar presentación con el texto actual
                    new Presentation().obtenerTexto(textArea);
                } 
                if((e.getModifiersEx() & (KeyEvent.CTRL_DOWN_MASK)) != 0 
                    && e.getKeyCode() == KeyEvent.VK_T){
                        new BraileTraductor().traducir(textArea);
                }
            }
        });
        Timer timer = new Timer(320, (ActionEvent e) -> {
        analizador.imprimir(textArea, label1, label2, label3, label4);
        });
        timer.start();
        paste.addActionListener(e->func.pasteText(textArea));
        copy.addActionListener(e->func.copyText(textArea));
        cut.addActionListener(e->func.cutText(textArea));
        docx.addActionListener(e->docxs.loadWordDocument(textArea, this));
        save.addActionListener(e->writer.guardarArchivo(textArea, this));
        open.addActionListener(e->reader.abrirArchivo(textArea, this));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu4 = new javax.swing.JMenu();
        fondo = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextPane();
        slider = new slider.JsliderCustom();
        label4 = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        panelTools = new javax.swing.JPanel();
        paste = new javax.swing.JButton();
        copy = new javax.swing.JButton();
        cut = new javax.swing.JButton();
        docx = new javax.swing.JButton();
        save = new javax.swing.JButton();
        open = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jMenu4.setText("jMenu4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fondo.setBackground(new java.awt.Color(40, 40, 40));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textArea.setBackground(new java.awt.Color(35, 35, 35));
        textArea.setForeground(new java.awt.Color(255, 255, 255));
        scrollPane.setViewportView(textArea);

        fondo.add(scrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 520, 410));
        fondo.add(slider, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 530, 40));

        label4.setForeground(new java.awt.Color(0, 0, 0));
        label4.setText("jLabel1");
        fondo.add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 200, -1, -1));

        label1.setForeground(new java.awt.Color(0, 0, 0));
        label1.setText("jLabel1");
        fondo.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, -1, -1));

        label2.setForeground(new java.awt.Color(0, 0, 0));
        label2.setText("jLabel1");
        fondo.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, -1, -1));

        label3.setForeground(new java.awt.Color(0, 0, 0));
        label3.setText("jLabel1");
        fondo.add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, -1, -1));

        panelTools.setBackground(new java.awt.Color(25, 25, 25));
        panelTools.setOpaque(false);

        paste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/icono_notas/icono_pegar.png"))); // NOI18N
        paste.setBorderPainted(false);
        paste.setContentAreaFilled(false);

        copy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/icono_notas/icono_copiar.png"))); // NOI18N
        copy.setBorderPainted(false);
        copy.setContentAreaFilled(false);

        cut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/icono_notas/icono_cortar.png"))); // NOI18N
        cut.setBorderPainted(false);
        cut.setContentAreaFilled(false);

        docx.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/icono_notas/icono_docx.png"))); // NOI18N
        docx.setBorderPainted(false);
        docx.setContentAreaFilled(false);

        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/icono_notas/icono_guardar.png"))); // NOI18N
        save.setBorderPainted(false);
        save.setContentAreaFilled(false);

        open.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/icono_notas/icono_abrir.png"))); // NOI18N
        open.setBorderPainted(false);
        open.setContentAreaFilled(false);

        javax.swing.GroupLayout panelToolsLayout = new javax.swing.GroupLayout(panelTools);
        panelTools.setLayout(panelToolsLayout);
        panelToolsLayout.setHorizontalGroup(
            panelToolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelToolsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paste)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelToolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(copy)
                    .addComponent(cut))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(docx)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelToolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(open, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(390, Short.MAX_VALUE))
        );
        panelToolsLayout.setVerticalGroup(
            panelToolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelToolsLayout.createSequentialGroup()
                .addGroup(panelToolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelToolsLayout.createSequentialGroup()
                        .addComponent(copy, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cut, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(paste, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelToolsLayout.createSequentialGroup()
                .addGroup(panelToolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(docx, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(panelToolsLayout.createSequentialGroup()
                        .addComponent(open, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        fondo.add(panelTools, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 80));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/bloc_font.png"))); // NOI18N
        fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 670, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Notes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Notes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Notes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Notes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Notes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton copy;
    private javax.swing.JButton cut;
    private javax.swing.JButton docx;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JButton open;
    private javax.swing.JPanel panelTools;
    private javax.swing.JButton paste;
    private javax.swing.JButton save;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JSlider slider;
    private javax.swing.JTextPane textArea;
    // End of variables declaration//GEN-END:variables
}