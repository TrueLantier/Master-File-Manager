package gui;

import javax.swing.*;
import java.io.File;
import java.nio.file.Path;

public class JFCPrueba {
    static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        chooserTres(chooser);
    }

    private static void chooserTres(JFileChooser chooser) {
        chooser.setDialogTitle("Esto funciona?");
        chooser.setToolTipText("Y esto?"); // Sí AMBOS
        chooser.setMultiSelectionEnabled(true);
        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File[] archivos = chooser.getSelectedFiles();
            for (File archivo: archivos) {
                Path ruta = archivo.toPath();
                System.out.println(ruta);
            }
        }
    }

    private static void chooserUno(JFileChooser chooser) {
        int result = chooser.showOpenDialog(null); // Por defecto FILES ONLY.

        if (result == JFileChooser.APPROVE_OPTION) {
            File archivo = chooser.getSelectedFile(); // Seleccionar archivo.
            Path ruta = archivo.toPath();
            System.out.println(ruta);
            System.out.println(ruta.getFileName());
            System.out.println(ruta.getParent());
        }
    }

    private static void chooserDos(JFileChooser chooser) {
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = chooser.showOpenDialog(null); // Por defecto FILES ONLY.

        if (result == JFileChooser.APPROVE_OPTION) {
            Path directorio = chooser.getSelectedFile().toPath();
            System.out.println(directorio);
            System.out.println(directorio.getParent());
            System.out.println(directorio.getFileName());
        }
    }
}
