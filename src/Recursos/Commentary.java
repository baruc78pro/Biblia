package Recursos;

import Comandos.CBiblia;
import Instancia.AbrirInstancia;
import java.awt.Color;
import java.io.BufferedReader;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.swing.ImageIcon;
import texto.BookList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
/**
 *
 * @Malware Inc
 */
public class Commentary extends javax.swing.JFrame {

    public HashMap<String, String> capitulos = new HashMap<>();
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private SwingWorker<Void, Void> loadingWorker;
    
    public Commentary() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("images/logo.png")).getImage());
        new CBiblia().KeyEvent(this);
        this.setTitle("Comentario");
        this.requestFocusInWindow();
        botones();
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
        panel.setBackground(Color.decode("#B77E63"));
    }
    public void botones(){
        List<JButton>  botones = List.of(gen,exo,lev,num,
        deu,jos,jue,rut,samuel1,samuel2,reyes1,reyes2,cronicas1,
        cronicas2,esdras,nehemias,ester,job,salmos,proverbios,eclesiastes,
        cantares,isaias,jeremias,lamentaciones,ezequiel,daniel,oseas,
        joel,amos, abdias,jonas,miqueas,nahum,habacuc,sofonias,hageo,zacarias,
        malaquias,mateo,marcos,lucas,juan,hechos,romanos,corintios1,
        corintios2,galatas,efesios,filipenses,colosenses,tesalonicenses1,
        tesalonicenses2,timoteo1,timoteo2,tito,filemon,hebreos,santiago,
        pedro1,pedro2,juan1,juan2,juan3,judas,apocalipsis);
        
        for (int i = 0; i < botones.size(); i++) {
            addButton(botones.get(i), "Recursos/Biblia_en_texto/" + 
                new BookList().carpetas.get(i) + "/", new BookList().libros.get(i),
                new BookList().capitulos[i]);
        }
    }
    
    public void addButton(JButton button, String rutaArchivo, String id, int cant) {
    button.addActionListener(e -> {
        Book li = new Book();
        // Primero configurar el libro
        li.cargarLibro(rutaArchivo, id, cant);
        
        // Luego mostrar la ventana
        new AbrirInstancia().instancia(li);
        
        // Finalmente cerrar esta ventana
        this.dispose();
    });
}
    
    public void abrirArchivo(JTextPane pane, String rutaL) throws InterruptedException {
        pane.setText(" "); // Mensaje inicial
        
        if (loadingWorker != null && !loadingWorker.isDone()) {
            loadingWorker.cancel(true);
        }
        
        loadingWorker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                try (InputStream input = getClass().getResourceAsStream("/" + rutaL)) {
                    if (input == null) {
                        pane.setText("No se encontró el archivo: " + rutaL);
                        return null;
                    }
                    
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8))) {
                        StringBuilder content = new StringBuilder();
                        String line;
                        int lineCount = 0;
                        
                        while ((line = reader.readLine()) != null && !isCancelled()) {
                            content.append(line).append("\n");
                            lineCount++;
                            
                            if (lineCount % 500 == 0) { // Actualizar cada 500 líneas
                                final String currentContent = content.toString();
                                SwingUtilities.invokeLater(() -> {
                                    pane.setText(currentContent);
                                    pane.setCaretPosition(0);
                                });
                                Thread.sleep(30); // Pequeña pausa
                            }
                        }
                        
                        if (!isCancelled()) {
                            final String finalContent = content.toString();
                            SwingUtilities.invokeLater(() -> {
                                pane.setText(finalContent);
                                pane.setCaretPosition(0);
                            });
                        }
                    }
                } catch (IOException | InterruptedException e) {
                    if (!isCancelled()) {
                        SwingUtilities.invokeLater(() -> {
                            pane.setText("Error al cargar el archivo: " + e.getMessage());
                        });
                    }
                }
                return null;
            }
        };
        
        executor.execute(loadingWorker);
    }
    
    @Override
    public void dispose() {
        if (loadingWorker != null && !loadingWorker.isDone()) {
            loadingWorker.cancel(true);
        }
        executor.shutdownNow();
        super.dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        gen = new javax.swing.JButton();
        exo = new javax.swing.JButton();
        lev = new javax.swing.JButton();
        num = new javax.swing.JButton();
        deu = new javax.swing.JButton();
        jos = new javax.swing.JButton();
        jue = new javax.swing.JButton();
        rut = new javax.swing.JButton();
        samuel1 = new javax.swing.JButton();
        samuel2 = new javax.swing.JButton();
        reyes1 = new javax.swing.JButton();
        reyes2 = new javax.swing.JButton();
        cronicas1 = new javax.swing.JButton();
        cronicas2 = new javax.swing.JButton();
        esdras = new javax.swing.JButton();
        nehemias = new javax.swing.JButton();
        ester = new javax.swing.JButton();
        job = new javax.swing.JButton();
        salmos = new javax.swing.JButton();
        proverbios = new javax.swing.JButton();
        eclesiastes = new javax.swing.JButton();
        cantares = new javax.swing.JButton();
        isaias = new javax.swing.JButton();
        jeremias = new javax.swing.JButton();
        lamentaciones = new javax.swing.JButton();
        ezequiel = new javax.swing.JButton();
        daniel = new javax.swing.JButton();
        oseas = new javax.swing.JButton();
        joel = new javax.swing.JButton();
        amos = new javax.swing.JButton();
        abdias = new javax.swing.JButton();
        jonas = new javax.swing.JButton();
        miqueas = new javax.swing.JButton();
        habacuc = new javax.swing.JButton();
        sofonias = new javax.swing.JButton();
        hageo = new javax.swing.JButton();
        zacarias = new javax.swing.JButton();
        malaquias = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        juan = new javax.swing.JButton();
        lucas = new javax.swing.JButton();
        marcos = new javax.swing.JButton();
        mateo = new javax.swing.JButton();
        hechos = new javax.swing.JButton();
        romanos = new javax.swing.JButton();
        corintios1 = new javax.swing.JButton();
        corintios2 = new javax.swing.JButton();
        colosenses = new javax.swing.JButton();
        filipenses = new javax.swing.JButton();
        efesios = new javax.swing.JButton();
        galatas = new javax.swing.JButton();
        tesalonicenses1 = new javax.swing.JButton();
        tito = new javax.swing.JButton();
        tesalonicenses2 = new javax.swing.JButton();
        filemon = new javax.swing.JButton();
        timoteo1 = new javax.swing.JButton();
        hebreos = new javax.swing.JButton();
        timoteo2 = new javax.swing.JButton();
        santiago = new javax.swing.JButton();
        pedro1 = new javax.swing.JButton();
        juan3 = new javax.swing.JButton();
        pedro2 = new javax.swing.JButton();
        judas = new javax.swing.JButton();
        juan1 = new javax.swing.JButton();
        apocalipsis = new javax.swing.JButton();
        juan2 = new javax.swing.JButton();
        nahum = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setBackground(new java.awt.Color(89, 50, 30));
        panel.setPreferredSize(new java.awt.Dimension(222, 3105));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nuevo Testamento");
        panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1820, -1, -1));

        gen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/genesis.png"))); // NOI18N
        gen.setBorderPainted(false);
        gen.setContentAreaFilled(false);
        gen.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/genesis_copia.png"))); // NOI18N
        panel.add(gen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        exo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/exodo.png"))); // NOI18N
        exo.setBorderPainted(false);
        exo.setContentAreaFilled(false);
        exo.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/exodo_copia.png"))); // NOI18N
        panel.add(exo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, -1, -1));

        lev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/levitico.png"))); // NOI18N
        lev.setBorderPainted(false);
        lev.setContentAreaFilled(false);
        lev.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/levitico_copia.png"))); // NOI18N
        panel.add(lev, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, -1, -1));

        num.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/numeros.png"))); // NOI18N
        num.setBorderPainted(false);
        num.setContentAreaFilled(false);
        num.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/numeros_copia.png"))); // NOI18N
        panel.add(num, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, -1, -1));

        deu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/deuteronomio.png"))); // NOI18N
        deu.setBorderPainted(false);
        deu.setContentAreaFilled(false);
        deu.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/deuteronomio_copia.png"))); // NOI18N
        panel.add(deu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        jos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/Josue.png"))); // NOI18N
        jos.setBorderPainted(false);
        jos.setContentAreaFilled(false);
        jos.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/Josue_copia.png"))); // NOI18N
        panel.add(jos, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, -1, -1));

        jue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/jueces.png"))); // NOI18N
        jue.setBorderPainted(false);
        jue.setContentAreaFilled(false);
        jue.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/jueces_copia.png"))); // NOI18N
        panel.add(jue, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, -1, -1));

        rut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/rut.png"))); // NOI18N
        rut.setBorderPainted(false);
        rut.setContentAreaFilled(false);
        rut.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/rut_copia.png"))); // NOI18N
        panel.add(rut, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, -1, -1));

        samuel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/samuel1.png"))); // NOI18N
        samuel1.setBorderPainted(false);
        samuel1.setContentAreaFilled(false);
        samuel1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/samuel1_copia.png"))); // NOI18N
        panel.add(samuel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

        samuel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/samuel2.png"))); // NOI18N
        samuel2.setBorderPainted(false);
        samuel2.setContentAreaFilled(false);
        samuel2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/samuel2_copia.png"))); // NOI18N
        panel.add(samuel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, -1, -1));

        reyes1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/reyes1.png"))); // NOI18N
        reyes1.setBorderPainted(false);
        reyes1.setContentAreaFilled(false);
        reyes1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/reyes1_copia.png"))); // NOI18N
        panel.add(reyes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 440, -1, -1));

        reyes2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/reyes2.png"))); // NOI18N
        reyes2.setBorderPainted(false);
        reyes2.setContentAreaFilled(false);
        reyes2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/reyes2_copia.png"))); // NOI18N
        panel.add(reyes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 440, -1, -1));

        cronicas1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/cronicas1.png"))); // NOI18N
        cronicas1.setBorderPainted(false);
        cronicas1.setContentAreaFilled(false);
        cronicas1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/cronicas1_copia.png"))); // NOI18N
        panel.add(cronicas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, -1, -1));

        cronicas2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/cronicas2.png"))); // NOI18N
        cronicas2.setBorderPainted(false);
        cronicas2.setContentAreaFilled(false);
        cronicas2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/cronicas2_copia.png"))); // NOI18N
        panel.add(cronicas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 610, -1, -1));

        esdras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/esdras.png"))); // NOI18N
        esdras.setBorderPainted(false);
        esdras.setContentAreaFilled(false);
        esdras.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/esdras_copia.png"))); // NOI18N
        panel.add(esdras, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 610, -1, -1));

        nehemias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/nehemias.png"))); // NOI18N
        nehemias.setBorderPainted(false);
        nehemias.setContentAreaFilled(false);
        nehemias.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/nehemias_copia.png"))); // NOI18N
        panel.add(nehemias, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 610, -1, -1));

        ester.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/ester.png"))); // NOI18N
        ester.setBorderPainted(false);
        ester.setContentAreaFilled(false);
        ester.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/ester_copia.png"))); // NOI18N
        panel.add(ester, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 780, -1, -1));

        job.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/job.png"))); // NOI18N
        job.setBorderPainted(false);
        job.setContentAreaFilled(false);
        job.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/job_copia.png"))); // NOI18N
        panel.add(job, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 780, -1, -1));

        salmos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/salmos.png"))); // NOI18N
        salmos.setBorderPainted(false);
        salmos.setContentAreaFilled(false);
        salmos.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/salmos_copia.png"))); // NOI18N
        panel.add(salmos, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 780, -1, -1));

        proverbios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/proverbios.png"))); // NOI18N
        proverbios.setBorderPainted(false);
        proverbios.setContentAreaFilled(false);
        proverbios.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/proverbios_copia.png"))); // NOI18N
        panel.add(proverbios, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 780, -1, -1));

        eclesiastes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/eclesiastes.png"))); // NOI18N
        eclesiastes.setBorderPainted(false);
        eclesiastes.setContentAreaFilled(false);
        eclesiastes.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/eclesiastes_copia.png"))); // NOI18N
        panel.add(eclesiastes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 950, -1, -1));

        cantares.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/cantares.png"))); // NOI18N
        cantares.setBorderPainted(false);
        cantares.setContentAreaFilled(false);
        cantares.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/cantares_copia.png"))); // NOI18N
        panel.add(cantares, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 950, -1, -1));

        isaias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/isias.png"))); // NOI18N
        isaias.setBorderPainted(false);
        isaias.setContentAreaFilled(false);
        isaias.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/isias_copia.png"))); // NOI18N
        panel.add(isaias, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 950, -1, -1));

        jeremias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/jeremias.png"))); // NOI18N
        jeremias.setBorderPainted(false);
        jeremias.setContentAreaFilled(false);
        jeremias.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/jeremias_copia.png"))); // NOI18N
        panel.add(jeremias, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 950, -1, -1));

        lamentaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/lamentaciones.png"))); // NOI18N
        lamentaciones.setBorderPainted(false);
        lamentaciones.setContentAreaFilled(false);
        lamentaciones.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/lamentaciones_copia.png"))); // NOI18N
        panel.add(lamentaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1120, -1, -1));

        ezequiel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/ezequiel.png"))); // NOI18N
        ezequiel.setBorderPainted(false);
        ezequiel.setContentAreaFilled(false);
        ezequiel.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/ezequiel_copia.png"))); // NOI18N
        panel.add(ezequiel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 1120, -1, -1));

        daniel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/daniel.png"))); // NOI18N
        daniel.setBorderPainted(false);
        daniel.setContentAreaFilled(false);
        daniel.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/daniel_copia.png"))); // NOI18N
        panel.add(daniel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 1120, -1, -1));

        oseas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/oseas.png"))); // NOI18N
        oseas.setBorderPainted(false);
        oseas.setContentAreaFilled(false);
        oseas.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/oseas_copia.png"))); // NOI18N
        panel.add(oseas, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 1120, -1, -1));

        joel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/joel.png"))); // NOI18N
        joel.setBorderPainted(false);
        joel.setContentAreaFilled(false);
        joel.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/joel_copia.png"))); // NOI18N
        panel.add(joel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1290, -1, -1));

        amos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/amos.png"))); // NOI18N
        amos.setBorderPainted(false);
        amos.setContentAreaFilled(false);
        amos.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/amos_copia.png"))); // NOI18N
        panel.add(amos, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 1290, -1, -1));

        abdias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/abdias.png"))); // NOI18N
        abdias.setBorderPainted(false);
        abdias.setContentAreaFilled(false);
        abdias.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/abdias_copia.png"))); // NOI18N
        panel.add(abdias, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 1290, -1, -1));

        jonas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/jonas.png"))); // NOI18N
        jonas.setBorderPainted(false);
        jonas.setContentAreaFilled(false);
        jonas.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/jonas_copia.png"))); // NOI18N
        panel.add(jonas, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 1290, -1, -1));

        miqueas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/miqueas.png"))); // NOI18N
        miqueas.setBorderPainted(false);
        miqueas.setContentAreaFilled(false);
        miqueas.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/miqueas_copia.png"))); // NOI18N
        panel.add(miqueas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1460, -1, 160));

        habacuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/habacuc.png"))); // NOI18N
        habacuc.setBorderPainted(false);
        habacuc.setContentAreaFilled(false);
        habacuc.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/habacuc_copia.png"))); // NOI18N
        panel.add(habacuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 1460, -1, -1));

        sofonias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/sofonias.png"))); // NOI18N
        sofonias.setBorderPainted(false);
        sofonias.setContentAreaFilled(false);
        sofonias.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/sofonias_copia.png"))); // NOI18N
        panel.add(sofonias, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 1460, -1, -1));

        hageo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/Hageo.png"))); // NOI18N
        hageo.setBorderPainted(false);
        hageo.setContentAreaFilled(false);
        hageo.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/Hageo_copia.png"))); // NOI18N
        panel.add(hageo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1630, -1, -1));

        zacarias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/zacarias.png"))); // NOI18N
        zacarias.setBorderPainted(false);
        zacarias.setContentAreaFilled(false);
        zacarias.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/zacarias_copia.png"))); // NOI18N
        panel.add(zacarias, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 1630, 130, -1));

        malaquias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/malaquias.png"))); // NOI18N
        malaquias.setBorderPainted(false);
        malaquias.setContentAreaFilled(false);
        malaquias.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/malaquias_copia.png"))); // NOI18N
        panel.add(malaquias, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 1630, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Antiguo Testamento");
        panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        juan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/juan.png"))); // NOI18N
        juan.setBorderPainted(false);
        juan.setContentAreaFilled(false);
        juan.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/juan_copia.png"))); // NOI18N
        panel.add(juan, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 1900, -1, -1));

        lucas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/lucas.png"))); // NOI18N
        lucas.setBorderPainted(false);
        lucas.setContentAreaFilled(false);
        lucas.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/lucas_copia.png"))); // NOI18N
        panel.add(lucas, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 1900, -1, -1));

        marcos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/marcos.png"))); // NOI18N
        marcos.setBorderPainted(false);
        marcos.setContentAreaFilled(false);
        marcos.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/marcos_copia.png"))); // NOI18N
        panel.add(marcos, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 1900, -1, -1));

        mateo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/mateo.png"))); // NOI18N
        mateo.setBorderPainted(false);
        mateo.setContentAreaFilled(false);
        mateo.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/mateo_copia.png"))); // NOI18N
        panel.add(mateo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1900, -1, -1));

        hechos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/hechos.png"))); // NOI18N
        hechos.setBorderPainted(false);
        hechos.setContentAreaFilled(false);
        hechos.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/hechos_copia.png"))); // NOI18N
        panel.add(hechos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2070, -1, -1));

        romanos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/romanos.png"))); // NOI18N
        romanos.setBorderPainted(false);
        romanos.setContentAreaFilled(false);
        romanos.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/romanos_copia.png"))); // NOI18N
        panel.add(romanos, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 2070, -1, -1));

        corintios1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/corintios1.png"))); // NOI18N
        corintios1.setBorderPainted(false);
        corintios1.setContentAreaFilled(false);
        corintios1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/corintios1_copia.png"))); // NOI18N
        panel.add(corintios1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 2070, -1, -1));

        corintios2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/corintios2.png"))); // NOI18N
        corintios2.setBorderPainted(false);
        corintios2.setContentAreaFilled(false);
        corintios2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/corintios2_copia.png"))); // NOI18N
        panel.add(corintios2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 2070, -1, -1));

        colosenses.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/colosenses.png"))); // NOI18N
        colosenses.setBorderPainted(false);
        colosenses.setContentAreaFilled(false);
        colosenses.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/colosenses_copia.png"))); // NOI18N
        panel.add(colosenses, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 2240, -1, -1));

        filipenses.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/filipenses.png"))); // NOI18N
        filipenses.setBorderPainted(false);
        filipenses.setContentAreaFilled(false);
        filipenses.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/filipenses_copia.png"))); // NOI18N
        panel.add(filipenses, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 2240, -1, -1));

        efesios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/efesios.png"))); // NOI18N
        efesios.setBorderPainted(false);
        efesios.setContentAreaFilled(false);
        efesios.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/efesios_copia.png"))); // NOI18N
        panel.add(efesios, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 2240, -1, -1));

        galatas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/galatas.png"))); // NOI18N
        galatas.setBorderPainted(false);
        galatas.setContentAreaFilled(false);
        galatas.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/galatas_copia.png"))); // NOI18N
        panel.add(galatas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2240, -1, -1));

        tesalonicenses1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/tesalonicenses1.png"))); // NOI18N
        tesalonicenses1.setBorderPainted(false);
        tesalonicenses1.setContentAreaFilled(false);
        tesalonicenses1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/tesalonicenses1_copia.png"))); // NOI18N
        panel.add(tesalonicenses1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2410, -1, -1));

        tito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/tito.png"))); // NOI18N
        tito.setBorderPainted(false);
        tito.setContentAreaFilled(false);
        tito.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/tito_copia.png"))); // NOI18N
        panel.add(tito, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2580, -1, -1));

        tesalonicenses2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/tesalonicenses2.png"))); // NOI18N
        tesalonicenses2.setBorderPainted(false);
        tesalonicenses2.setContentAreaFilled(false);
        tesalonicenses2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/tesalonicenses2_copia.png"))); // NOI18N
        panel.add(tesalonicenses2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 2410, -1, -1));

        filemon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/filemon.png"))); // NOI18N
        filemon.setBorderPainted(false);
        filemon.setContentAreaFilled(false);
        filemon.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/filemon_copia.png"))); // NOI18N
        panel.add(filemon, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 2580, -1, -1));

        timoteo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/timoteo1.png"))); // NOI18N
        timoteo1.setBorderPainted(false);
        timoteo1.setContentAreaFilled(false);
        timoteo1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/timoteo1_copia.png"))); // NOI18N
        panel.add(timoteo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 2410, -1, -1));

        hebreos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/hebreos.png"))); // NOI18N
        hebreos.setBorderPainted(false);
        hebreos.setContentAreaFilled(false);
        hebreos.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/hebreos_copia.png"))); // NOI18N
        panel.add(hebreos, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 2580, -1, -1));

        timoteo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/timoteo2.png"))); // NOI18N
        timoteo2.setBorderPainted(false);
        timoteo2.setContentAreaFilled(false);
        timoteo2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/timoteo2_copia.png"))); // NOI18N
        panel.add(timoteo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 2410, -1, -1));

        santiago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/santiago.png"))); // NOI18N
        santiago.setBorderPainted(false);
        santiago.setContentAreaFilled(false);
        santiago.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/santiago_copia.png"))); // NOI18N
        panel.add(santiago, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 2580, -1, -1));

        pedro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/pedro1.png"))); // NOI18N
        pedro1.setBorderPainted(false);
        pedro1.setContentAreaFilled(false);
        pedro1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/pedro1_copia.png"))); // NOI18N
        panel.add(pedro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2750, -1, -1));

        juan3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/juan3.png"))); // NOI18N
        juan3.setBorderPainted(false);
        juan3.setContentAreaFilled(false);
        juan3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/juan3_copia.png"))); // NOI18N
        panel.add(juan3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2920, -1, -1));

        pedro2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/pedro2.png"))); // NOI18N
        pedro2.setBorderPainted(false);
        pedro2.setContentAreaFilled(false);
        pedro2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/pedro2_copia.png"))); // NOI18N
        panel.add(pedro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 2750, -1, -1));

        judas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/judas.png"))); // NOI18N
        judas.setBorderPainted(false);
        judas.setContentAreaFilled(false);
        judas.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/judas_copia.png"))); // NOI18N
        panel.add(judas, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 2920, -1, -1));

        juan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/juan1.png"))); // NOI18N
        juan1.setBorderPainted(false);
        juan1.setContentAreaFilled(false);
        juan1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/juan1_copia.png"))); // NOI18N
        panel.add(juan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 2750, -1, -1));

        apocalipsis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/apocalipsis.png"))); // NOI18N
        apocalipsis.setBorderPainted(false);
        apocalipsis.setContentAreaFilled(false);
        apocalipsis.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/apocalipsis_copia.png"))); // NOI18N
        panel.add(apocalipsis, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 2920, -1, -1));

        juan2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/juan2.png"))); // NOI18N
        juan2.setBorderPainted(false);
        juan2.setContentAreaFilled(false);
        juan2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/juan2_copia.png"))); // NOI18N
        panel.add(juan2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 2750, -1, -1));

        nahum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/nahum.png"))); // NOI18N
        nahum.setBorderPainted(false);
        nahum.setContentAreaFilled(false);
        nahum.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/nahum_copia.png"))); // NOI18N
        panel.add(nahum, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 1460, 130, 160));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/bible_font.png"))); // NOI18N
        panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 0, 660, 1540));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/bible_font.png"))); // NOI18N
        panel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 1536, 660, 1540));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/bible_font.png"))); // NOI18N
        panel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3066, 660, 120));

        jScrollPane2.setViewportView(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(679, 547));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    /**/
    
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
            java.util.logging.Logger.getLogger(Commentary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Commentary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Commentary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Commentary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Commentary().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abdias;
    private javax.swing.JButton amos;
    private javax.swing.JButton apocalipsis;
    private javax.swing.JButton cantares;
    private javax.swing.JButton colosenses;
    private javax.swing.JButton corintios1;
    private javax.swing.JButton corintios2;
    private javax.swing.JButton cronicas1;
    private javax.swing.JButton cronicas2;
    private javax.swing.JButton daniel;
    private javax.swing.JButton deu;
    private javax.swing.JButton eclesiastes;
    private javax.swing.JButton efesios;
    private javax.swing.JButton esdras;
    private javax.swing.JButton ester;
    private javax.swing.JButton exo;
    private javax.swing.JButton ezequiel;
    private javax.swing.JButton filemon;
    private javax.swing.JButton filipenses;
    private javax.swing.JButton galatas;
    private javax.swing.JButton gen;
    private javax.swing.JButton habacuc;
    private javax.swing.JButton hageo;
    private javax.swing.JButton hebreos;
    private javax.swing.JButton hechos;
    private javax.swing.JButton isaias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jeremias;
    private javax.swing.JButton job;
    private javax.swing.JButton joel;
    private javax.swing.JButton jonas;
    private javax.swing.JButton jos;
    private javax.swing.JButton juan;
    private javax.swing.JButton juan1;
    private javax.swing.JButton juan2;
    private javax.swing.JButton juan3;
    private javax.swing.JButton judas;
    private javax.swing.JButton jue;
    private javax.swing.JButton lamentaciones;
    private javax.swing.JButton lev;
    private javax.swing.JButton lucas;
    private javax.swing.JButton malaquias;
    private javax.swing.JButton marcos;
    private javax.swing.JButton mateo;
    private javax.swing.JButton miqueas;
    private javax.swing.JButton nahum;
    private javax.swing.JButton nehemias;
    private javax.swing.JButton num;
    private javax.swing.JButton oseas;
    private javax.swing.JPanel panel;
    private javax.swing.JButton pedro1;
    private javax.swing.JButton pedro2;
    private javax.swing.JButton proverbios;
    private javax.swing.JButton reyes1;
    private javax.swing.JButton reyes2;
    private javax.swing.JButton romanos;
    private javax.swing.JButton rut;
    private javax.swing.JButton salmos;
    private javax.swing.JButton samuel1;
    private javax.swing.JButton samuel2;
    private javax.swing.JButton santiago;
    private javax.swing.JButton sofonias;
    private javax.swing.JButton tesalonicenses1;
    private javax.swing.JButton tesalonicenses2;
    private javax.swing.JButton timoteo1;
    private javax.swing.JButton timoteo2;
    private javax.swing.JButton tito;
    private javax.swing.JButton zacarias;
    // End of variables declaration//GEN-END:variables
}