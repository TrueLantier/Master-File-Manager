package nio.manejoerrores;

import java.io.IOException;
import java.nio.file.*;
import java.util.NoSuchElementException;

public class Validador {

    /**
     * Validadores de ruta
     * Hacer ENUM de operaciones
     */

    private static void validarGeneral(String ruta) throws IOException{
        Path path = Path.of(ruta);

        if (!Files.exists(path)) {
            throw new NoSuchFileException("La ruta es incorrecta o no existe.");
        }
        if (!Files.isReadable(path)) {
            throw new AccessDeniedException("No hay permisos de lectura.");
        }
        if (!Files.isWritable(path)) {
            throw new AccessDeniedException("No hay permisos de escritura.");
        }
    }

    public static boolean validar(String ruta, String operación) {
        try {
            validarGeneral(ruta);
        } catch (Exception e) {
            MensajesError.errores.add(new RegistroErrores(
                    ruta, operación, e.getMessage(), e));
            return true;
        }
        return false;
    }

    public static boolean validarRuta(Path path) {
        return Files.exists(path);
    }

    public static boolean esLeíble(Path path) {
        return Files.isReadable(path);
    }

    public static boolean esEscribible(Path path) {
        return Files.isWritable(path);
    }

    /**
     * Validadores de operaciones
     * FileAlreadyExistsException
     * NoSuchElementException
     */

    public static boolean estáVacío(Path path, String operación) throws IOException { // Verdadero si ESTÁ VACÍO
        try (DirectoryStream<Path> elementos = Files.newDirectoryStream(path)){
            if (!elementos.iterator().hasNext()) {
                throw new NoSuchElementException("No hay elementos en esta carpeta.");
            }
        } catch (NoSuchElementException e) {
            MensajesError.errores.add(new RegistroErrores(
                    path.toString(), operación, e.getMessage(), e));
            return true;
        }
        return false;
    }

    public static boolean esDirectorio(String ruta) {
        Path path = Path.of(ruta);
        return Files.isDirectory(path);
    }

    public static boolean probar(String ruta) {
        return true;
    }
}
