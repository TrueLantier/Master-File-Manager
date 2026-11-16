package nio.crear;

import nio.manejoerrores.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NioCrearArchivo {

    private static String tipoArchivo = ".txt"; // Por defecto.
    private static String[] tiposArchivos = { ".txt", ".md", ".java", ".sh", ".py"};
    private static final String OPERACIÓN = "Crear archivo"; // Provisional hasta el enum.

    public static void crearArchivo(String ruta) throws IOException {
        if (Validador.validar(ruta, "Crear archivo")) {
            return;
        }
        Path archivo = Path.of(ruta, "archivo" + tipoArchivo); // Por defecto
        Files.createFile(archivo);
    }

    public static void crearArchivo(String ruta, String nombre) throws IOException {
        if (Validador.validar(ruta, "Crear archivo")) {
            return;
        }
        Path archivo = Path.of(ruta, nombre + tipoArchivo);
        Files.createFile(archivo);
    }

    public static void crearArchivo(String ruta, int cantidad) throws IOException {
        if (Validador.validar(ruta, "Crear archivo")) {
            return;
        }

        for (int i = 0; i < cantidad; i++) {
            Path archivo = Path.of(ruta, "archivo " + i + tipoArchivo);
            Files.createFile(archivo);
        }
    }

    public static void crearArchivo(String ruta, String nombre, int cantidad) throws IOException {
        if (Validador.validar(ruta, "Crear archivo")) {
            return;
        }

        for (int i = 0; i < cantidad; i++) {
            Path archivo = Path.of(ruta, nombre + " " + i + tipoArchivo);
            Files.createFile(archivo);
        }
    }

    public static void setTipoArchivo(String tipoArchivo) {
        NioCrearArchivo.tipoArchivo = tipoArchivo;
    }

    public static String[] getTiposArchivos() {
        return tiposArchivos;
    }
}
