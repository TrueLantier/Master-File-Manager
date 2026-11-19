package nio.NioEliminar;

import nio.Operaciones;
import nio.manejoerrores.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class NioEliminar {

    public static void eliminarElemento(String elementoEliminar) {
        if (Validador.validar(elementoEliminar, Operaciones.ELIMINAR)) {
            return;
        }

        Path path = Path.of(elementoEliminar);
        try {
            if (Files.isDirectory(path)) {
                eliminarTodo(path.toString());
            }
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
                    eliminarTodo(elemento.toAbsolutePath().toString());
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
                    eliminarNombre(elemento.toAbsolutePath().toString(), nombre);
                }

                if (elemento.getFileName().toString().contains(nombre)) {
                    if (Files.isDirectory(elemento)) {
                        eliminarTodo(elemento.toAbsolutePath().toString());
                    }
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
