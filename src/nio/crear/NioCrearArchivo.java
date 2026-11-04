package nio.crear;

import nio.NioDiseño;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NioCrearArchivo extends NioDiseño {
    public static String tipoArchivo = ".txt"; // Por defecto.
    public static String[] tiposArchivos = { ".txt", ".md", ".java", ".sh", ".py"};

    public static void crearArchivo(String ruta) throws IOException {
        validarRuta(ruta);
        Path archivo = Path.of(ruta, "archivo" + tipoArchivo); // Por defecto
        Files.createFile(archivo);
    }

    public static void crearArchivo(String ruta, String nombre) throws IOException {
        validarRuta(ruta);
        Path archivo = Path.of(ruta, nombre + tipoArchivo);
        Files.createFile(archivo);
    }

    public static void crearArchivo(String ruta, int cantidad) throws IOException {
        validarRuta(ruta);

        for (int i = 0; i < cantidad; i++) {
            Path archivo = Path.of(ruta, "archivo " + i + tipoArchivo);
            Files.createFile(archivo);
        }
    }

    public static void crearArchivo(String ruta, String nombre, int cantidad) throws IOException {
        validarRuta(ruta);

        for (int i = 0; i < cantidad; i++) {
            Path archivo = Path.of(ruta, nombre + " " + i + tipoArchivo);
            Files.createFile(archivo);
        }
    }

    public static void crearArchivo(String ruta, String[] nombres, boolean anidar) throws IOException {
        validarRuta(ruta);

        if (anidar) {
            StringBuilder anidados = new StringBuilder();
            for (String nombre: nombres) {
                anidados.append(File.separator).append(nombre);
            }
            Path carpetas = Path.of(ruta, String.valueOf(anidados));
            Files.createDirectories(carpetas);
            return;
        }

        for (String nombre: nombres) {
            Path archivo = Path.of(ruta, nombre);
            Files.createFile(archivo);
        }
    }
}
