package Estilos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import Recursos.Menu;
/**
 *
 * @Malware Inc
 */
public class Icono {
    private static final String CONFIG_FILE_PATH = "config.txt";
    private final ExecutorService executor = Executors.newFixedThreadPool(2);

    public void aplicarIconos(Menu inicio, String tema) {
        executor.submit(() -> {
            try {
                Iconos iconos = cargarIconos(tema);
                SwingUtilities.invokeLater(() -> configurarInicio(inicio, iconos));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private Iconos cargarIconos(String tema) throws IOException {
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
            return new Iconos(
            new ImageIcon(getClass().getResource(basePath + "boton1.png")),
            new ImageIcon(getClass().getResource(basePath + "boton2.png")),
            new ImageIcon(getClass().getResource(basePath + "boton3.png")),
            new ImageIcon(getClass().getResource(basePath + "boton4.png")),
            new ImageIcon(getClass().getResource(basePath + "boton5.png")),
            new ImageIcon(getClass().getResource(basePath + "boton6.png")),
            new ImageIcon(getClass().getResource(basePath + "fondo.png"))
        );
    }

    private void configurarInicio(Menu inicio, Iconos iconos) {
        inicio.biblia.setIcon(iconos.iconBiblia);
        inicio.comentario.setIcon(iconos.iconComentario);
        inicio.bloc.setIcon(iconos.iconBloc);
        inicio.mapas.setIcon(iconos.iconMapas);
        inicio.extras.setIcon(iconos.iconExtras);
        inicio.herramientas.setIcon(iconos.iconHerramientas);
        inicio.fondo.setIcon(iconos.fondo);
    }

    private static class Iconos {
        final ImageIcon iconBiblia, iconComentario, iconBloc, iconMapas, iconExtras, iconHerramientas, fondo;

        Iconos(ImageIcon biblia, ImageIcon comentario, ImageIcon bloc, ImageIcon mapas, ImageIcon extras, ImageIcon herramientas, ImageIcon fondo) {
            this.iconBiblia = biblia;
            this.iconComentario = comentario;
            this.iconBloc = bloc;
            this.iconMapas = mapas;
            this.iconExtras = extras;
            this.iconHerramientas = herramientas;
            this.fondo = fondo;
        }
    }
}