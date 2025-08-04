package Cifrado;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.Base64;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class AesEjemplo extends javax.swing.JFrame {

    private SecretKeySpec key;
    private static final String CLAVE_SECRETA = "1234567890123456"; // 16 caracteres
    
    String llave;
    public AesEjemplo() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Recursos/images/logo.png")).getImage());
        selector.addActionListener(e-> {buscar();});
        encriptor.addActionListener(e->{encriptar();
        JOptionPane.showMessageDialog(null, "Apartado aun en desarrollo(solo encripta)", "Información", JOptionPane.INFORMATION_MESSAGE);});
    }

    public AesEjemplo(String llave) {
        this.key = new SecretKeySpec(llave.getBytes(), "AES");
    }
    
    public void buscar(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("TXT Files", "txt"));
        int seleccion = fileChooser.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            try {
                ver.setText("");
                File archivo = fileChooser.getSelectedFile();
                if (!archivo.getName().toLowerCase().endsWith(".txt")) {
                    archivo = new File(archivo.getAbsolutePath() + ".txt");
                }
                this.setTitle(archivo.getName());
                BufferedReader lector = new BufferedReader(new FileReader(archivo));
                StringBuilder contenido = new StringBuilder();
                String linea;
                while ((linea = lector.readLine()) != null) {
                    contenido.append(linea).append("\n");
                }
                lector.close();
                ver.setText(contenido.toString());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void encriptar() {
        if(ver.equals("")){
            JOptionPane.showMessageDialog(null, "Campo vacío, seleccione un archivo", "NULL", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
            String texto = ver.getText();
            AesEjemplo cifrador = new AesEjemplo(CLAVE_SECRETA);
        
            byte[] campoCifrado = cifrador.cifrar(texto);
            String textoEncriptado = Base64.getEncoder().encodeToString(campoCifrado);
            
            cifrado.setText(textoEncriptado);
            
            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showSaveDialog(this);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File archivo = fileChooser.getSelectedFile();
                FileWriter escritor = new FileWriter(archivo + "_encriptado.txt");
                escritor.write(textoEncriptado);
                escritor.close();
                JOptionPane.showMessageDialog(null, "Archivo encriptado", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    }
    
    public byte[] cifrar(String mensaje) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(mensaje.getBytes());
    }
    
    public String descifrar(byte[] campoCifrado) throws Exception {
        // Obtiene una instancia del cifrador AES y lo inicializa en modo de descifrado
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        // Descifra el mensaje cifrado y devuelve el resultado como una cadena de caracteres
        byte[] campoDecifrado = cipher.doFinal(campoCifrado);
        return new String(campoDecifrado);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cifrado = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        ver = new javax.swing.JTextPane();
        selector = new javax.swing.JButton();
        encriptor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cifrado.setEditable(false);
        cifrado.setBackground(new java.awt.Color(190, 190, 190));
        jScrollPane1.setViewportView(cifrado);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 350, 430));

        ver.setBackground(new java.awt.Color(190, 190, 190));
        jScrollPane2.setViewportView(ver);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 350, 430));

        selector.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        selector.setText("Seleccionar archivo .txt");
        jPanel1.add(selector, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 260, 40));

        encriptor.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        encriptor.setText("Encriptar");
        jPanel1.add(encriptor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(AesEjemplo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AesEjemplo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AesEjemplo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AesEjemplo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AesEjemplo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane cifrado;
    private javax.swing.JButton encriptor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton selector;
    private javax.swing.JTextPane ver;
    // End of variables declaration//GEN-END:variables
}