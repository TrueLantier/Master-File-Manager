package nio.crear;

import nio.NioDiseño;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NioCrearCarpeta extends NioDiseño {

    public static void crearCarpeta(String ruta) throws IOException {
        validarRuta(ruta);
        Path carpeta = Path.of(ruta, "Nueva carpeta");
        Files.createDirectory(carpeta);
    }

    public static void crearCarpeta(String ruta, String nombre) throws IOException {
        validarRuta(ruta);
        Path carpeta = Path.of(ruta, nombre);
        Files.createDirectory(carpeta);
    }

    public static void crearCarpeta(String ruta, int cantidad) throws IOException {
        validarRuta(ruta);

        for (int i = 0; i < cantidad; i++) {
            Path carpeta = Path.of(ruta, "Nueva carpeta " + i);
            Files.createDirectory(carpeta);
        }
    }

    public static void crearCarpeta(String ruta, String nombre, int cantidad) throws IOException {
        validarRuta(ruta);

        for (int i = 0; i < cantidad; i++) {
            Path carpeta = Path.of(ruta, nombre + " " + i);
            Files.createDirectory(carpeta);
        }
    }

    public static void crearCarpeta(String ruta, String[] nombres, boolean anidar) throws IOException {
        validarRuta(ruta);

        if (anidar) {
            Path carpetas = Path.of(ruta);
            for (String nombre: nombres) {
                carpetas = carpetas.resolve(nombre);
            }
            Files.createDirectories(carpetas);
            return;

            /**
             * OTRA FORMA
             * String subRuta = String.join(File.separator, nombres);
             * Path path = Path.of(ruta, subRuta);
             * Files.createDirectories(path);
             */
        }

        for (String nombre: nombres) {
            Path carpetas = Path.of(ruta, nombre);
            Files.createDirectory(carpetas);
        }
    }
}
