package nio.crear;

import nio.NioEliminar.NioEliminar;
import nio.Operaciones;
import nio.manejoerrores.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NioCrearCarpeta {

    public static void crearCarpeta(String ruta) throws IOException {
        if (Validador.validar(ruta, Operaciones.CREAR_CARPETA)) {
            return;
        }

        Path carpeta = Path.of(ruta, "Nueva carpeta");

        if (Files.exists(carpeta)) {
            if (Validador.sobrescribir(carpeta, Operaciones.CREAR_CARPETA)) {
                NioEliminar.eliminarElemento(carpeta.toString());
            } else {
                return;
            }
        }

        Files.createDirectory(carpeta);
    }

    public static void crearCarpeta(String ruta, String nombre) throws IOException {
        if (Validador.validar(ruta, Operaciones.CREAR_CARPETA)) {
            return;
        }

        Path carpeta = Path.of(ruta, nombre);

        if (Files.exists(carpeta)) {
            if (Validador.sobrescribir(carpeta, Operaciones.CREAR_CARPETA)) {
                NioEliminar.eliminarElemento(carpeta.toString());
            } else {
                return;
            }
        }

        Files.createDirectory(carpeta);
    }

    public static void crearCarpeta(String ruta, int cantidad) throws IOException {
        if (Validador.validar(ruta, Operaciones.CREAR_CARPETA)) {
            return;
        }

        for (int i = 0; i < cantidad; i++) {
            Path carpeta = Path.of(ruta, "Nueva carpeta " + i);

            if (Files.exists(carpeta)) {
                if (Validador.sobrescribir(carpeta, Operaciones.CREAR_CARPETA)) {
                    NioEliminar.eliminarElemento(carpeta.toString());
                } else {
                    continue;
                }
            }

            Files.createDirectory(carpeta);
        }
    }

    public static void crearCarpeta(String ruta, String nombre, int cantidad) throws IOException {
        if (Validador.validar(ruta, Operaciones.CREAR_CARPETA)) {
            return;
        }

        for (int i = 0; i < cantidad; i++) {
            Path carpeta = Path.of(ruta, nombre + " " + i);

            if (Files.exists(carpeta)) {
                if (Validador.sobrescribir(carpeta, Operaciones.CREAR_CARPETA)) {
                    NioEliminar.eliminarElemento(carpeta.toString());
                } else {
                    continue;
                }
            }

            Files.createDirectory(carpeta);
        }
    }

    public static void crearCarpeta(String ruta, String[] nombres, boolean anidar) throws IOException {
        if (Validador.validar(ruta, Operaciones.CREAR_CARPETA)) {
            return;
        }

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

            if (Files.exists(carpetas)) {
                if (Validador.sobrescribir(carpetas, Operaciones.CREAR_CARPETA)) {
                    NioEliminar.eliminarElemento(carpetas.toString());
                } else {
                    return;
                }
            }

            Files.createDirectory(carpetas);
        }
    }
}
