package Estilos;

import Recursos.Menu;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
/**
 *
 * @Malware Inc
 */
public class Animation {
    private static final String CONFIG_FILE_PATH = "config.txt";
    private final ExecutorService executor = Executors.newFixedThreadPool(2);
    
    public void aplicarIconos(Menu inicio, String tema) {
        executor.submit(() -> {
            try {
                Animations anim = cargarIconos(tema);
                SwingUtilities.invokeLater(() -> configurarInicio(inicio, anim));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    
    private Animations cargarIconos(String tema) throws IOException {
        String basePath = "/Recursos/images/" + tema + "/";
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
        </config>
        """.formatted(tema);

        // Escribimos el contenido al archivo, eliminando lo que había antes
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CONFIG_FILE_PATH))) {
            bw.write(contenidoFalsoXML);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Animations(
            new ImageIcon(getClass().getResource(basePath + "btn1.gif")),
            new ImageIcon(getClass().getResource(basePath + "btn2.gif")),
            new ImageIcon(getClass().getResource(basePath + "btn3.gif")),
            new ImageIcon(getClass().getResource(basePath + "btn4.gif")),
            new ImageIcon(getClass().getResource(basePath + "btn5.gif")),
            new ImageIcon(getClass().getResource(basePath + "btn6.gif"))
        );
    }

    private void configurarInicio(Menu inicio, Animations icons) {
        inicio.biblia.setRolloverIcon(icons.iconBiblia);
        inicio.comentario.setRolloverIcon(icons.iconComentario);
        inicio.bloc.setRolloverIcon(icons.iconBloc);
        inicio.mapas.setRolloverIcon(icons.iconMapas);
        inicio.extras.setRolloverIcon(icons.iconExtras);
        inicio.herramientas.setRolloverIcon(icons.iconHerramientas);
    }

    private static class Animations {
        final ImageIcon iconBiblia, iconComentario, iconBloc, iconMapas, iconExtras, iconHerramientas;

        Animations(ImageIcon biblia, ImageIcon comentario, ImageIcon bloc, ImageIcon mapas, ImageIcon extras, ImageIcon herramientas) {
            this.iconBiblia = biblia;
            this.iconComentario = comentario;
            this.iconBloc = bloc;
            this.iconMapas = mapas;
            this.iconExtras = extras;
            this.iconHerramientas = herramientas;
        }
    }
}