package nio.NioEliminar;

import nio.Operaciones;
import nio.manejoerrores.*;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.Collator;

public class NioEliminar {
    private static final String OPERACIÓN = "Eliminar";

    public static void eliminar(String elementoEliminar) {
        if (Validador.validar(elementoEliminar, Operaciones.ELIMINAR)) {
            return;
        }

        Path path = Path.of(elementoEliminar);
        try {
            Files.delete(path);
        } catch (Exception e) {
            MensajesError.agregarError(elementoEliminar, Operaciones.ELIMINAR, e.getMessage(), e);
        }
    }

    public static void eliminarTodo(String rutaEliminar) {
        if (Validador.validar(rutaEliminar, Operaciones.ELIMINAR)) {
            return;
        }

        Path path = Path.of(rutaEliminar);

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)){
            for (Path elemento: stream) {
                if (Files.isDirectory(elemento)) {
                    eliminarTodo(elemento.getRoot().toString());
                }
                Files.delete(elemento);
            }

        } catch (Exception e) {
            MensajesError.agregarError(rutaEliminar, Operaciones.ELIMINAR, e.getMessage(), e);
        }
    }

    // NO es case-sensitive. Nombre exacto.
    public static void eliminarNombre(String rutaEliminar, String nombre) {
        if (Validador.validar(rutaEliminar, Operaciones.ELIMINAR)) {
            return;
        }

        Path path = Path.of(rutaEliminar);

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)){
            for (Path elemento: stream) {
                if (Files.isDirectory(elemento)) {
                    eliminarNombre(elemento.getRoot().toString(), nombre);
                }
                if (elemento.getFileName().toString().contains(nombre)) {
                    Files.delete(elemento);
                }
            }

        } catch (Exception e) {
            MensajesError.agregarError(rutaEliminar, Operaciones.ELIMINAR, e.getMessage(), e);
        }
    }

    public static void eliminarVariosNombres(String rutaEliminar, String[] nombres) {
        for (String nombre: nombres) {
            eliminarNombre(rutaEliminar, nombre);
        }
    }
}
