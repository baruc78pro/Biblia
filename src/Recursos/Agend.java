package Recursos;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.UIManager;
import scrollbar.ScrollBarCustom;

public class Agend extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    public Agend() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("images/logo_pequeño(2).jpg")).getImage());
        model.addColumn("ID");
        model.addColumn("Tareas");
        ver.setModel(model);
        ver.setEnabled(true);
        getContentPane().setBackground(Color.BLACK);
        scrollPane.setVerticalScrollBar(new ScrollBarCustom());
        ScrollBarCustom sp = new ScrollBarCustom();
        sp.setOrientation(JScrollBar.HORIZONTAL);
        scrollPane.setHorizontalScrollBar(sp);
        scrollPane2.setVerticalScrollBar(new ScrollBarCustom());
        ScrollBarCustom sp1 = new ScrollBarCustom();
        sp1.setOrientation(JScrollBar.HORIZONTAL);
        scrollPane2.setHorizontalScrollBar(sp1);
        cargarDatos();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        update = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        search = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        idSh = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        scrollPane2 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        ver = new javax.swing.JTable();
        textAreaScroll1 = new textarea.TextAreaScroll();
        desc = new textarea.TextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(10, 10, 10));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/new.png"))); // NOI18N
        add.setText("       Nueva tarea");
        add.setBorderPainted(false);
        add.setContentAreaFilled(false);
        add.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel2.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 250, -1));

        update.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/update.png"))); // NOI18N
        update.setText("     Actualizar tarea");
        update.setBorderPainted(false);
        update.setContentAreaFilled(false);
        update.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel2.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 270, -1));

        refresh.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        refresh.setForeground(new java.awt.Color(255, 255, 255));
        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/refresh.png"))); // NOI18N
        refresh.setText("      Refrescar tabla");
        refresh.setBorderPainted(false);
        refresh.setContentAreaFilled(false);
        refresh.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        jPanel2.add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 270, -1));

        delete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/delete.png"))); // NOI18N
        delete.setText("      Eliminar tarea");
        delete.setBorderPainted(false);
        delete.setContentAreaFilled(false);
        delete.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel2.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 260, -1));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        search.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/search.png"))); // NOI18N
        search.setText("   Buscar");
        search.setBorderPainted(false);
        search.setContentAreaFilled(false);
        search.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel3.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 170, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Buscar por id");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, -1));
        jPanel3.add(idSh, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 70, -1));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Descripción de la tarea");

        scrollPane2.setPreferredSize(new java.awt.Dimension(40, 900));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        ver.setBackground(new java.awt.Color(0, 0, 0));
        ver.setForeground(new java.awt.Color(255, 255, 255));
        ver.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        ver.setSelectionBackground(new java.awt.Color(0, 51, 102));
        ver.setSelectionForeground(new java.awt.Color(255, 255, 255));
        scrollPane.setViewportView(ver);
        if (ver.getColumnModel().getColumnCount() > 0) {
            ver.getColumnModel().getColumn(0).setPreferredWidth(20);
            ver.getColumnModel().getColumn(1).setPreferredWidth(300);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                .addContainerGap())
        );

        scrollPane2.setViewportView(jPanel4);

        textAreaScroll1.setBackground(new java.awt.Color(0, 0, 0));
        textAreaScroll1.setForeground(new java.awt.Color(204, 204, 204));

        desc.setBackground(new java.awt.Color(0, 0, 0));
        desc.setColumns(20);
        desc.setForeground(new java.awt.Color(255, 255, 255));
        desc.setRows(5);
        textAreaScroll1.setViewportView(desc);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(298, 298, 298))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(scrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(226, 226, 226))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
       try {
        Connection cn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Cooler Master\\Documents\\NetBeansProjects\\Biblia\\src\\Recursos\\Base_de_datos\\Biblia.db");
        String nuevaTarea = desc.getText().trim();
        if (nuevaTarea.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La descripción de la tarea no puede estar vacía.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        PreparedStatement psCheck = cn.prepareStatement("SELECT tarea FROM tareas WHERE tarea = ?");
        psCheck.setString(1, nuevaTarea);
        ResultSet rs = psCheck.executeQuery();

        if (rs.next()) {
            JOptionPane.showMessageDialog(null, "Ya existe una tarea con esta descripción. No se puede duplicar.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            PreparedStatement psInsert = cn.prepareStatement("INSERT INTO tareas (tarea) VALUES(?)");
            psInsert.setString(1, nuevaTarea);
            psInsert.executeUpdate();

            // Limpiar el campo de descripción
            desc.setText("");
            cargarDatos(); // Actualizar la vista de datos
            JOptionPane.showMessageDialog(null, "Tarea agregada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            psInsert.close();
        }
        rs.close();
        psCheck.close();
        cn.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos.\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
    }//GEN-LAST:event_addActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        try{
        int filaSeleccionada = ver.getSelectedRow();
        if (filaSeleccionada != -1) {
            String ID = ver.getValueAt(filaSeleccionada, 0).toString();
            int confirmacion = JOptionPane.showConfirmDialog(null, 
            "¿Estás seguro de que deseas eliminar esta tarea?", 
            "Confirmar eliminación", 
            JOptionPane.YES_NO_OPTION);
            Connection cn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Cooler Master\\Documents\\NetBeansProjects\\Biblia\\src\\Recursos\\Base_de_datos\\Biblia.db");
            PreparedStatement ps = cn.prepareStatement("DELETE FROM tareas WHERE ID = ?");
            ps.setString(1, ID);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Tarea eliminada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            cargarDatos();
        } else {
        JOptionPane.showMessageDialog(null, "Selecciona una tarea para eliminar", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar o conectar a la base de datos.\nFavor de reportar problema en inicio en caso de error", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        JOptionPane.showMessageDialog(null, "Función aún no disponible", "No disponible", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_updateActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        cargarDatos();
        JOptionPane.showMessageDialog(null, "Carga exitosa", "Exito", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_refreshActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        try{
            Connection cn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Cooler Master\\Documents\\NetBeansProjects\\Biblia\\src\\Recursos\\Base_de_datos\\Biblia.db");
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM tareas WHERE id = ?");
            String sh = idSh.getText().trim();
            ps.setString(1, sh);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                desc.setText(rs.getString("tarea"));
            } else {
                JOptionPane.showMessageDialog(null, "Error de busqueda, información no existente", "Error", JOptionPane.ERROR_MESSAGE);
            }
            idSh.setText("");
            // Cerrar recursos
            rs.close();
            ps.close();
            cn.close();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al buscar o conectar a la base de datos.\nFavor de reportar problema en inicio en caso de error", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_searchActionPerformed

    private void limpiarTabla(){
    int filas = model.getRowCount();
    for (int i = filas - 1; i >= 0; i--) {
        model.removeRow(i);
    }
    }
    private void cargarDatos() {
    limpiarTabla(); // Limpia la tabla antes de cargar los datos.
    ver.getColumnModel().getColumn(0).setPreferredWidth(10);
    ver.getColumnModel().getColumn(1).setPreferredWidth(850);
    try {
        Connection cn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Cooler Master\\Documents\\NetBeansProjects\\Biblia\\src\\Recursos\\Base_de_datos\\Biblia.db");
        PreparedStatement ps = cn.prepareStatement("SELECT id, tarea FROM tareas");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Object[] fila = new Object[2];
            fila[0] = rs.getInt("id");
            fila[1] = rs.getString("tarea");
            model.addRow(fila);
        }
        cn.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al cargar los datos.", "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
}
    

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
            java.util.logging.Logger.getLogger(Agend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agend().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton delete;
    private textarea.TextArea desc;
    private javax.swing.JTextField idSh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton refresh;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JScrollPane scrollPane2;
    private javax.swing.JButton search;
    private textarea.TextAreaScroll textAreaScroll1;
    private javax.swing.JButton update;
    private javax.swing.JTable ver;
    // End of variables declaration//GEN-END:variables
}