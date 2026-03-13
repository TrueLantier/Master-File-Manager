package pruebas;
import java.io.*;

public class Rutas {
    public static void main(String[] args) throws IOException {
        String ruta = "src/Laboratorio/SalaUno/java.pdf";
        String ruta2 = "/home/angel/Documentos/Meditación Guiada 1 FR.mp3";
        File archivo = new File(ruta2);
        System.out.println("Absoluta: " + archivo.getAbsolutePath());
        System.out.println("Canonical: " + archivo.getCanonicalPath()); // Lanza IOException.
    }
}
