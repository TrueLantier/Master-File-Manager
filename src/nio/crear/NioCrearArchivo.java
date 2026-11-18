package nio.crear;

import nio.NioEliminar.NioEliminar;
import nio.Operaciones;
import nio.manejoerrores.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NioCrearArchivo {

    private static String tipoArchivo = ".txt"; // Por defecto.
    public static String[] tiposArchivos = { ".txt", ".md", ".java", ".sh", ".py"};

    public static void crearArchivo(String ruta) throws IOException {
        if (Validador.validar(ruta, Operaciones.CREAR_ARCHIVO)) {
            return;
        }
        Path archivo = Path.of(ruta, "archivo" + tipoArchivo); // Por defecto

        if (Files.exists(archivo)) {
            if (Validador.sobrescribir(archivo, Operaciones.CREAR_ARCHIVO)) {
                NioEliminar.eliminarElemento(archivo.toString());
            } else {
                return;
            }
        }

        Files.createFile(archivo);
    }

    public static void crearArchivo(String ruta, String nombre) throws IOException {
        if (Validador.validar(ruta, Operaciones.CREAR_ARCHIVO)) {
            return;
        }
        Path archivo = Path.of(ruta, nombre + tipoArchivo);

        if (Files.exists(archivo)) {
            if (Validador.sobrescribir(archivo, Operaciones.CREAR_ARCHIVO)) {
                NioEliminar.eliminarElemento(archivo.toString());
            } else {
                return;
            }
        }

        Files.createFile(archivo);
    }

    public static void crearArchivo(String ruta, int cantidad) throws IOException {
        if (Validador.validar(ruta, Operaciones.CREAR_ARCHIVO)) {
            return;
        }

        for (int i = 0; i < cantidad; i++) {
            Path archivo = Path.of(ruta, "archivo " + i + tipoArchivo);

            if (Files.exists(archivo)) {
                if (Validador.sobrescribir(archivo, Operaciones.CREAR_ARCHIVO)) {
                    NioEliminar.eliminarElemento(archivo.toString());
                } else {
                    return;
                }
            }

            Files.createFile(archivo);
        }
    }

    public static void crearArchivo(String ruta, String nombre, int cantidad) throws IOException {
        if (Validador.validar(ruta, Operaciones.CREAR_ARCHIVO)) {
            return;
        }

        for (int i = 0; i < cantidad; i++) {
            Path archivo = Path.of(ruta, nombre + " " + i + tipoArchivo);

            if (Files.exists(archivo)) {
                if (Validador.sobrescribir(archivo, Operaciones.CREAR_ARCHIVO)) {
                    NioEliminar.eliminarElemento(archivo.toString());
                } else {
                    return;
                }
            }

            Files.createFile(archivo);
        }
    }

    public static void setTipoArchivo(String tipoArchivo) {
        NioCrearArchivo.tipoArchivo = tipoArchivo;
    }


}
