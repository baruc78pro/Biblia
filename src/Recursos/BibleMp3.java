package Recursos;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BibleMp3 extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    String dir;
    private Clip clip;
    public BibleMp3() {
        
        initComponents();
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("images/logo.png")).getImage());
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        transparencia();
        renderers();
        ver.setModel(model);
        ver.setEnabled(true);
        selector.addActionListener(e -> JOptionPane.showMessageDialog(null, "Desabilitado", "Información", JOptionPane.INFORMATION_MESSAGE));
        
        play.addActionListener(e -> {
    int filaSeleccionada = ver.getSelectedRow();
    if (filaSeleccionada != -1) {
        // Obtener el nombre del archivo de la tabla
        //String nombreArchivo = (String) model.getValueAt(filaSeleccionada, 0);
        //String rutaCompleta = dir + nombreArchivo;

        // Reproducir el archivo
        //reproducir(rutaCompleta);
    } else {
        JOptionPane.showMessageDialog(null, "Por favor, seleccione un capítulo para reproducir.", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
});
    }
    public void transparencia(){
        play.setBackground(new Color(0,0,0,0));
        panel.setBackground(new Color(0,0,0,0));
        selector.setBackground(new Color(0,0,0,0));
        ver.setBackground(new Color(0,0,0,0));
        jScrollPane2.setOpaque(false);
        jScrollPane2.getViewport().setOpaque(false);
    }
    public void renderers(){
        ver.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        c.setForeground(Color.WHITE); // Establece el color del texto
        c.setBackground(new Color(0, 0, 0, 150)); // Fondo transparente
        ((JComponent) c).setOpaque(true); // Asegura que sea transparente
        return c;
        }
    });
        
        selector.setRenderer(new javax.swing.DefaultListCellRenderer() {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        list.setSelectionBackground(new Color(0, 0, 0, 0));
        label.setForeground(Color.WHITE); // Color del texto
        label.setBackground(new Color(0, 0, 0, 150)); // Fondo transparente
        label.setOpaque(true); // Asegura transparencia
        return label;
            }
        });
    }
    private int extraerNumero(String nombre) {
    try {
        // Extraer los números del nombre del archivo
        String numero = nombre.replaceAll("\\D", ""); // Reemplaza todo excepto dígitos
        return Integer.parseInt(numero);
    } catch (NumberFormatException e) {
        return 0; // Si no hay números, devuelve 0
    }
    }
    private void actualizarTabla() {
    int selectedIndex = selector.getSelectedIndex();
    if (selectedIndex > 0) { // Ignorar la opción predeterminada
        String libro = selector.getSelectedItem().toString().split("\\.")[1]; // Obtener el nombre del libro
        dir = "C:\\Users\\Cooler Master\\Documents\\NetBeansProjects\\Biblia\\src\\AudioBiblia\\" + libro + "\\";
        
        model.setRowCount(0); // Limpia la tabla
        model.setColumnCount(0);
        model.addColumn("Capítulo");

        File carpeta = new File(dir);
        if (carpeta.exists() && carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles((dir, name) -> name.endsWith(".wav"));// Filtrar solo archivos MP3
            if (archivos != null) {
                Arrays.sort(archivos, (f1, f2) -> {
                    int num1 = extraerNumero(f1.getName());
                    int num2 = extraerNumero(f2.getName());
                    return Integer.compare(num1, num2); // Orden de menor a mayor
                });
                for (File archivo : archivos) {
                    model.addRow(new Object[]{archivo.getName()});
                }
            } else {
                model.setRowCount(0);
                JOptionPane.showMessageDialog(null, "No se encontraron archivos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            model.setRowCount(0);
            JOptionPane.showMessageDialog(null, "Directorio no encontrado\nNo modifique los archivos del programa base", "Error", JOptionPane.ERROR_MESSAGE);
        }
        }
    }
    public void reproducir(String rutaArchivo) {
        try {
            File archivo = new File(rutaArchivo);
            if (!archivo.exists()) {
                System.out.println("El archivo no existe: " + rutaArchivo);
                return;
            }

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivo);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            pause.addActionListener(e -> {
                detener();
            });
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    public void detener() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panel = new javax.swing.JPanel();
        selector = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        ver = new javax.swing.JTable();
        play = new javax.swing.JButton();
        pause = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel.setOpaque(false);

        selector.setBackground(new java.awt.Color(255, 255, 255));
        selector.setForeground(new java.awt.Color(255, 255, 255));
        selector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Clic para seleccionar", "1.Génesis", "2.Exodo", "3.Lévitico", "4.Números" }));
        selector.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        ver.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        ver.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Capitulo"
            }
        ));
        ver.setOpaque(false);
        jScrollPane2.setViewportView(ver);

        play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/reproductor_de_audio/play_mini.png"))); // NOI18N
        play.setBorderPainted(false);
        play.setContentAreaFilled(false);
        play.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/reproductor_de_audio/pause_mini.png"))); // NOI18N
        pause.setBorderPainted(false);
        pause.setContentAreaFilled(false);
        pause.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(selector, 0, 171, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(pause, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(play, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(selector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(play, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pause, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        jPanel1.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 410));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 403));

        setSize(new java.awt.Dimension(466, 413));
        setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(BibleMp3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BibleMp3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BibleMp3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BibleMp3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BibleMp3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panel;
    private javax.swing.JButton pause;
    private javax.swing.JButton play;
    private javax.swing.JComboBox<String> selector;
    private javax.swing.JTable ver;
    // End of variables declaration//GEN-END:variables
}