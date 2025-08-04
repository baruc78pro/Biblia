package Recursos;

import Chimpy.Panel;
import Cifrado.AesEjemplo;
import CodigoEditor.CodePanel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JMenuItem;
import Instancia.AbrirFrame;
import Estilos.Icono;
import Instancia.AbrirInstancia;
import Comandos.CMenu;
import Rastreo.Logger;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Estilos.Animation;
import Performance.Consume;
import javax.swing.ImageIcon;
import Instancia.Window;
/**
 *
 * @Malware Inc.
 */
public class Menu extends javax.swing.JFrame {
    
    private final Icono icono = new Icono();
    private final Animation animation = new Animation();
    private final Window win = new Window();
    
    public Menu() {
        initComponents();
        configurarVentana();
        inicializarInstancias();
        cargarTemaDesdeConfig();
        Logger.logEvent("Inicio", "Aplicación iniciada");
    }
    
    private void cerrarAplicacion() {
        for (java.awt.Frame frame : java.awt.Frame.getFrames()) {
            frame.dispose();
        }
        System.exit(0);
        Logger.logEvent("Inicio", "Aplicación finalizada");
    }
    
    private void configurarVentana() {
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Menú");
        setIconImage(new ImageIcon(getClass().getResource("images/logo.png")).getImage());
        new CMenu().KeyEvent(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                cerrarAplicacion();
            }
        });
    }
    
    private void inicializarInstancias() {
        List<JButton> botones = List.of(biblia, comentario, bloc, mapas, extras, herramientas);
        List<JFrame> ventanas = List.of(win.select, win.commentary, win.notes, win.maps, win.plus, win.tools);

        for (int i = 0; i < botones.size(); i++) {
            new AbrirFrame().instanciaFoco(botones.get(i), ventanas.get(i), this);
            Logger.logEvent("Inicio", "Abierta ventana: " + ventanas.get(i).getTitle());

        }

        configurarMenuEnlaces();
        configurarEstilos();
        configurarMenuAcciones();
    }

    private void configurarMenuEnlaces() {
        addMenuUrl(sub1, "https://malwareinc.mitiendanube.com/");
        addMenuUrl(sub2, "https://www.facebook.com/profile.php?id=100092255387900");
        //addMenuUrl(menu6, "https://malwareinc.mitiendanube.com/contacto/");
    }

    private void configurarEstilos() {
        JMenuItem[] estilos = {estilo1,especial};
        String[] nombresEstilos = {"normales", "creativos"};

        for (int i = 0; i < estilos.length; i++) {
            int finalI = i;
            estilos[i].addActionListener(e -> {
                icono.aplicarIconos(this, nombresEstilos[finalI]);
                animation.aplicarIconos(this, nombresEstilos[finalI]);
            });
            Logger.logEvent("Inicio", "Tema cambiado a: " + nombresEstilos[finalI]);
        }
    }

    private void configurarMenuAcciones() {
        menu2.addActionListener(e-> abrirInstancia(new About()));
        //menu3.addActionListener(e -> abrirInstancia(new Manual()));
        menu4.addActionListener(e -> abrirInstancia(new Referencias()));
        noticias.addActionListener(e -> abrirInstancia(new News()));
        crypto.addActionListener(e->  abrirInstancia(new AesEjemplo()));
        registro.addActionListener(e-> {abrirInstancia(new Logger()); 
                JOptionPane.showMessageDialog(null,
                "El registro es y solo para el usuario, Malware Inc no tiene acceso", 
                "Advertencia", JOptionPane.WARNING_MESSAGE);});
        terminos.addActionListener(e-> abrirInstancia(new Politicy()));
        chimpy.addActionListener(e->abrirInstancia(new Panel()));
        convert.addActionListener(e->abrirInstancia(new Converter()));
        code.addActionListener(e->abrirInstancia(new CodePanel()));
        performance.addActionListener(e->abrirInstancia(new Consume()));
    }

    private void abrirInstancia(JFrame ventana) {
        new AbrirInstancia().instancia(ventana);
        mipanel.setFocusable(true);
    }

    private void addMenuUrl(JMenuItem item, String url) {
        item.addActionListener(e -> {
            Logger.logEvent("Inicio", "Enlace abierto: " + url);
            requestFocusInWindow();
        });
    }

    private void cargarTemaDesdeConfig() {
        String tema = leerTemaDesdeConfig();
        if (tema != null) {
            icono.aplicarIconos(this, tema);
            animation.aplicarIconos(this, tema);
        }
    }

    private String leerTemaDesdeConfig() {
        File configFile = new File("config.txt");
        if (!configFile.exists()) return null;

        try (BufferedReader reader = new BufferedReader(new FileReader(configFile))) {
            return reader.lines()
                         .filter(line -> line.contains("<theme>"))
                         .map(line -> line.replace("<theme>", "").replace("</theme>", "").trim())
                         .findFirst()
                         .orElse(null);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mipanel = new javax.swing.JPanel();
        logo2 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        biblia = new javax.swing.JButton();
        comentario = new javax.swing.JButton();
        bloc = new javax.swing.JButton();
        mapas = new javax.swing.JButton();
        extras = new javax.swing.JButton();
        nombre1 = new javax.swing.JLabel();
        nombre2 = new javax.swing.JLabel();
        fondo2 = new javax.swing.JLabel();
        nombre3 = new javax.swing.JLabel();
        nombre4 = new javax.swing.JLabel();
        fondo3 = new javax.swing.JLabel();
        nombre5 = new javax.swing.JLabel();
        fondo4 = new javax.swing.JLabel();
        herramientas = new javax.swing.JButton();
        nombre6 = new javax.swing.JLabel();
        fondo6 = new javax.swing.JLabel();
        fondo5 = new javax.swing.JLabel();
        report = new javax.swing.JButton();
        reportar = new javax.swing.JLabel();
        fondo7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        nombre7 = new javax.swing.JLabel();
        fondo8 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();
        menu_opciones = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menu1 = new javax.swing.JMenu();
        sub1 = new javax.swing.JMenuItem();
        sub2 = new javax.swing.JMenuItem();
        menu2 = new javax.swing.JMenuItem();
        noticias = new javax.swing.JMenuItem();
        menu4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        estilo1 = new javax.swing.JMenuItem();
        especial = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        registro = new javax.swing.JMenuItem();
        crypto = new javax.swing.JMenuItem();
        chimpy = new javax.swing.JMenuItem();
        convert = new javax.swing.JMenuItem();
        performance = new javax.swing.JMenuItem();
        code = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        terminos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mipanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logo2.setForeground(new java.awt.Color(0, 102, 102));
        logo2.setText(" beta 2.1.3.1");
        mipanel.add(logo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 90, 30));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/etiqueta2.png"))); // NOI18N
        mipanel.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 210, 100));

        biblia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/creativos/boton1.png"))); // NOI18N
        biblia.setBorderPainted(false);
        biblia.setContentAreaFilled(false);
        biblia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mipanel.add(biblia, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, 140));

        comentario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/creativos/boton2.png"))); // NOI18N
        comentario.setBorderPainted(false);
        comentario.setContentAreaFilled(false);
        comentario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mipanel.add(comentario, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 130, 130));

        bloc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/creativos/boton3.png"))); // NOI18N
        bloc.setBorderPainted(false);
        bloc.setContentAreaFilled(false);
        bloc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mipanel.add(bloc, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, 130, 130));

        mapas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/creativos/boton4.png"))); // NOI18N
        mapas.setBorderPainted(false);
        mapas.setContentAreaFilled(false);
        mapas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mipanel.add(mapas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 140, 130));

        extras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/creativos/boton5.png"))); // NOI18N
        extras.setBorderPainted(false);
        extras.setContentAreaFilled(false);
        extras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mipanel.add(extras, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, 140, 130));

        nombre1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nombre1.setForeground(new java.awt.Color(0, 0, 0));
        nombre1.setText(" Lumen");
        mipanel.add(nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 70, 40));

        nombre2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nombre2.setForeground(new java.awt.Color(0, 0, 0));
        nombre2.setText("    Comentario");
        mipanel.add(nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 130, 50));

        fondo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/creativos/etiqueta_larga.png"))); // NOI18N
        mipanel.add(fondo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 140, 50));

        nombre3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nombre3.setForeground(new java.awt.Color(0, 0, 0));
        nombre3.setText("Bloc de notas");
        mipanel.add(nombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, -1, 30));

        nombre4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nombre4.setForeground(new java.awt.Color(0, 0, 0));
        nombre4.setText(" Mapas");
        mipanel.add(nombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 500, 70, 30));

        fondo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/creativos/etiqueta_larga.png"))); // NOI18N
        mipanel.add(fondo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 280, -1, 50));

        nombre5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nombre5.setForeground(new java.awt.Color(0, 0, 0));
        nombre5.setText("     Extras");
        mipanel.add(nombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 500, 100, 30));

        fondo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/creativos/etiqueta.png"))); // NOI18N
        mipanel.add(fondo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 490, 120, 50));

        herramientas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/creativos/boton6.png"))); // NOI18N
        herramientas.setBorderPainted(false);
        herramientas.setContentAreaFilled(false);
        herramientas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mipanel.add(herramientas, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 350, 140, 130));

        nombre6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nombre6.setForeground(new java.awt.Color(0, 0, 0));
        nombre6.setText("  Herramientas");
        mipanel.add(nombre6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 500, 140, 30));

        fondo6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/creativos/etiqueta_larga.png"))); // NOI18N
        mipanel.add(fondo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 490, 150, 50));

        fondo5.setForeground(new java.awt.Color(0, 0, 0));
        fondo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/creativos/etiqueta.png"))); // NOI18N
        mipanel.add(fondo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 490, 120, 50));

        report.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/reportar_off.png"))); // NOI18N
        report.setBorderPainted(false);
        report.setContentAreaFilled(false);
        report.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/reportado_on.png"))); // NOI18N
        report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportActionPerformed(evt);
            }
        });
        mipanel.add(report, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 70, -1));

        reportar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        reportar.setForeground(new java.awt.Color(0, 0, 0));
        reportar.setText("   Reportar");
        mipanel.add(reportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, 110, 40));

        fondo7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/creativos/etiqueta.png"))); // NOI18N
        mipanel.add(fondo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 110, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/creativos/etiqueta.png"))); // NOI18N
        mipanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/lumen.gif"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        mipanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 100, 90));

        nombre7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nombre7.setForeground(new java.awt.Color(0, 0, 0));
        nombre7.setText("Biblia");
        mipanel.add(nombre7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 50, 40));

        fondo8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/creativos/etiqueta.png"))); // NOI18N
        mipanel.add(fondo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 110, 40));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/creativos/fondo.png"))); // NOI18N
        mipanel.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 590));

        menu_opciones.setBackground(new java.awt.Color(255, 255, 255));
        menu_opciones.setForeground(new java.awt.Color(0, 0, 0));

        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("Opciones");

        menu1.setText("Contacto oficial");

        sub1.setText("Página web");
        menu1.add(sub1);

        sub2.setText("Facebook");
        menu1.add(sub2);

        jMenu1.add(menu1);

        menu2.setText("Créditos");
        jMenu1.add(menu2);

        noticias.setText("Mejoras y noticias");
        jMenu1.add(noticias);

        menu4.setText("Referencias");
        jMenu1.add(menu4);

        menu_opciones.add(jMenu1);

        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setText("Estilos");

        estilo1.setText("Java clasicos");
        jMenu2.add(estilo1);

        especial.setText("creativos");
        jMenu2.add(especial);

        menu_opciones.add(jMenu2);

        jMenu3.setForeground(new java.awt.Color(255, 255, 255));
        jMenu3.setText("Opciones avanzadas");

        registro.setText("Registro de actividades");
        jMenu3.add(registro);

        crypto.setText("Encriptador de texto");
        jMenu3.add(crypto);

        chimpy.setText("Chimpy editor");
        jMenu3.add(chimpy);

        convert.setText("Convertidor");
        jMenu3.add(convert);

        performance.setText("Rendimiento");
        jMenu3.add(performance);

        code.setText("ver código fuente");
        jMenu3.add(code);

        menu_opciones.add(jMenu3);

        jMenu4.setForeground(new java.awt.Color(255, 255, 255));
        jMenu4.setText("Terminos y condiciones");

        terminos.setText("ver terminos");
        jMenu4.add(terminos);

        menu_opciones.add(jMenu4);

        setJMenuBar(menu_opciones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mipanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mipanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(737, 614));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportActionPerformed
        String url1 = "https://malwareinc.mitiendanube.com/contacto/";
        this.requestFocusInWindow();
    }//GEN-LAST:event_reportActionPerformed
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton biblia;
    public javax.swing.JButton bloc;
    private javax.swing.JMenuItem chimpy;
    private javax.swing.JMenuItem code;
    public javax.swing.JButton comentario;
    private javax.swing.JMenuItem convert;
    private javax.swing.JMenuItem crypto;
    private javax.swing.JMenuItem especial;
    private javax.swing.JMenuItem estilo1;
    public javax.swing.JButton extras;
    public javax.swing.JLabel fondo;
    public javax.swing.JLabel fondo2;
    public javax.swing.JLabel fondo3;
    public javax.swing.JLabel fondo4;
    public javax.swing.JLabel fondo5;
    public javax.swing.JLabel fondo6;
    public javax.swing.JLabel fondo7;
    public javax.swing.JLabel fondo8;
    public javax.swing.JButton herramientas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    public javax.swing.JLabel logo;
    public javax.swing.JLabel logo2;
    public javax.swing.JButton mapas;
    private javax.swing.JMenu menu1;
    private javax.swing.JMenuItem menu2;
    private javax.swing.JMenuItem menu4;
    private javax.swing.JMenuBar menu_opciones;
    public javax.swing.JPanel mipanel;
    public javax.swing.JLabel nombre1;
    public javax.swing.JLabel nombre2;
    public javax.swing.JLabel nombre3;
    public javax.swing.JLabel nombre4;
    public javax.swing.JLabel nombre5;
    public javax.swing.JLabel nombre6;
    public javax.swing.JLabel nombre7;
    private javax.swing.JMenuItem noticias;
    private javax.swing.JMenuItem performance;
    private javax.swing.JMenuItem registro;
    public javax.swing.JButton report;
    public javax.swing.JLabel reportar;
    private javax.swing.JMenuItem sub1;
    private javax.swing.JMenuItem sub2;
    private javax.swing.JMenuItem terminos;
    // End of variables declaration//GEN-END:variables
}