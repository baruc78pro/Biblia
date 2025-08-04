package Recursos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Configuracion extends javax.swing.JFrame {

    private static final String CONFIG_FILE_PATH = "config.txt";
    
    public Configuracion() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("images/logo.png")).getImage());
        save.addActionListener(e->{
            if(biblia.equals("") && comentario.equals("") && bloc.equals("") &&  mapas.equals("") 
               && tareas.equals("") && extras.equals("") && herramientas.equals("")){
               JOptionPane.showMessageDialog(null, "Campos vacios", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                String contenidoFalsoXML = """
        <?xml version="1.0" encoding="UTF-8"?>
        <config>
            <general>
                <version>1.0.0</version>
                <app_name>Biblia App</app_name>
            </general>
            <configuracion>
                <theme>%s</theme>
                <language>es</language>
                <aceptado>true</aceptado>
            </configuracion>
            <bible.action> """ + """
              \n\tjava.command.bible = """ + biblia.getText()
              + """
              \n\tjava.command.comment = """ + comentario.getText()
              + """
              \n\tjava.command.notes = """ + bloc.getText()
              + """
              \n\tjava.command.maps = """ + mapas.getText()
              + """
              \n\tjava.command.task = """ + tareas.getText()
              + """
              \n\tjava.command.more = """ + extras.getText()
              + """
              \n\tjava.command.tools = """ + herramientas.getText()
             + """ 
            \n</bible.action>
        </config>
        """;
                escribir(contenidoFalsoXML);
            }
        });
        
    }
    
    public void escribir(String contenidoFalsoXML){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CONFIG_FILE_PATH))) {
            bw.write(contenidoFalsoXML);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        biblia = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        comentario = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        bloc = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        mapas = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        tareas = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        extras = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        herramientas = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(30, 30, 30));
        jPanel1.setPreferredSize(new java.awt.Dimension(134, 280));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Asignar ultima tecla");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 200, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Comentario");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 110, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Biblia");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 60, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mapas");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 90, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Bloc de notas");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 130, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tareas");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 90, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Extras");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 70, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Herramientas");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 130, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Sin cambios");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, 120, -1));

        cancel.setBackground(new java.awt.Color(30, 30, 30));
        cancel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setText("Cancelar cambios");
        cancel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        cancel.setContentAreaFilled(false);
        jPanel1.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 150, 40));

        biblia.setBackground(new java.awt.Color(30, 30, 30));
        biblia.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        biblia.setForeground(new java.awt.Color(255, 255, 255));
        biblia.setText("ctrl +  shift + b");
        biblia.setBorder(null);
        jPanel1.add(biblia, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 170, 30));

        jSeparator1.setBackground(new java.awt.Color(204, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 170, 10));

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Acción");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        save.setBackground(new java.awt.Color(30, 30, 30));
        save.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setText("Guardar Cambios");
        save.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        save.setContentAreaFilled(false);
        jPanel1.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 140, 40));

        comentario.setBackground(new java.awt.Color(30, 30, 30));
        comentario.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        comentario.setForeground(new java.awt.Color(255, 255, 255));
        comentario.setText("ctrl +  shift + c");
        comentario.setBorder(null);
        jPanel1.add(comentario, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 170, 30));

        jSeparator2.setBackground(new java.awt.Color(204, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 170, 10));

        jSeparator3.setBackground(new java.awt.Color(204, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 170, 50));

        bloc.setBackground(new java.awt.Color(30, 30, 30));
        bloc.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        bloc.setForeground(new java.awt.Color(255, 255, 255));
        bloc.setText("ctrl +  shift + t");
        bloc.setBorder(null);
        jPanel1.add(bloc, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 170, 30));

        jSeparator5.setBackground(new java.awt.Color(204, 0, 0));
        jSeparator5.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 170, 10));

        jSeparator6.setBackground(new java.awt.Color(204, 0, 0));
        jSeparator6.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 170, 10));

        mapas.setBackground(new java.awt.Color(30, 30, 30));
        mapas.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        mapas.setForeground(new java.awt.Color(255, 255, 255));
        mapas.setText("ctrl +  shift + m");
        mapas.setBorder(null);
        jPanel1.add(mapas, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 170, 30));

        jSeparator7.setBackground(new java.awt.Color(204, 0, 0));
        jSeparator7.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 170, 10));

        tareas.setBackground(new java.awt.Color(30, 30, 30));
        tareas.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tareas.setForeground(new java.awt.Color(255, 255, 255));
        tareas.setBorder(null);
        jPanel1.add(tareas, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 170, 30));

        jSeparator8.setBackground(new java.awt.Color(204, 0, 0));
        jSeparator8.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 170, 10));

        extras.setBackground(new java.awt.Color(30, 30, 30));
        extras.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        extras.setForeground(new java.awt.Color(255, 255, 255));
        extras.setText("ctrl +  shift + e");
        extras.setBorder(null);
        jPanel1.add(extras, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 170, 30));

        jSeparator9.setBackground(new java.awt.Color(204, 0, 0));
        jSeparator9.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 170, 10));

        herramientas.setBackground(new java.awt.Color(30, 30, 30));
        herramientas.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        herramientas.setForeground(new java.awt.Color(255, 255, 255));
        herramientas.setBorder(null);
        jPanel1.add(herramientas, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 170, 30));

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Configuracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField biblia;
    public javax.swing.JTextField bloc;
    private javax.swing.JButton cancel;
    public javax.swing.JTextField comentario;
    public javax.swing.JTextField extras;
    public javax.swing.JTextField herramientas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    public javax.swing.JTextField mapas;
    private javax.swing.JButton save;
    public javax.swing.JTextField tareas;
    // End of variables declaration//GEN-END:variables
}
