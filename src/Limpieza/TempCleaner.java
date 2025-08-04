/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Limpieza;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class TempCleaner {

    public static void main(String[] args) {
        cleanTempFiles();
    }

    public static void cleanTempFiles() {
        try {
            // Obtener rutas temporales
            String systemTemp = System.getenv("SystemRoot") + "\\Temp";
            String userTemp = System.getenv("TEMP");
            String localAppData = System.getenv("LOCALAPPDATA");

            // Limpiar directorios temporales
            cleanDirectory(systemTemp);
            cleanDirectory(userTemp);

            // Limpiar otras carpetas temporales comunes
            if (localAppData != null) {
                cleanDirectory(localAppData + "\\Microsoft\\Windows\\INetCache");
                cleanDirectory(localAppData + "\\Microsoft\\Windows\\INetCookies");
                cleanDirectory(localAppData + "\\Microsoft\\Windows\\History");
            }

            System.out.println("Limpieza de archivos temporales completada.");
        } catch (Exception ex) {
            System.err.println("Error durante la limpieza: " + ex.getMessage());
        }
    }

    private static void cleanDirectory(String directoryPath) {
        File dir = new File(directoryPath);
        
        if (!dir.exists()) {
            System.out.println("Directorio no encontrado: " + directoryPath);
            return;
        }

        System.out.println("Limpiando directorio: " + directoryPath);

        File[] files = dir.listFiles();
        if (files == null) {
            System.out.println("No se puede listar el contenido del directorio: " + directoryPath);
            return;
        }

        Arrays.stream(files).forEach(file -> {
            try {
                if (file.isDirectory()) {
                    deleteDirectory(file.toPath());
                    System.out.println("Eliminado directorio: " + file.getAbsolutePath());
                } else {
                    Files.delete(file.toPath());
                    System.out.println("Eliminado: " + file.getAbsolutePath());
                }
            } catch (IOException ex) {
                System.err.println("No se pudo eliminar " + file.getAbsolutePath() + ": " + ex.getMessage());
            }
        });
    }

    private static void deleteDirectory(Path path) throws IOException {
        Files.walk(path)
             .sorted((a, b) -> b.compareTo(a))
             .forEach(p -> {
                 try {
                     Files.delete(p);
                 } catch (IOException ex) {
                     System.err.println("No se pudo eliminar " + p + ": " + ex.getMessage());
                 }
             });
    }
}