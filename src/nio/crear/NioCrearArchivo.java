package nio.crear;

import nio.NioDiseño;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NioCrearArchivo extends NioDiseño {

    private static String tipoArchivo = ".txt"; // Por defecto.
    private static String[] tiposArchivos = { ".txt", ".md", ".java", ".sh", ".py"};

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

    public static void setTipoArchivo(String tipoArchivo) {
        NioCrearArchivo.tipoArchivo = tipoArchivo;
    }
}
