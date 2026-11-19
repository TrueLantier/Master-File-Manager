package nio.manejoerrores;

import nio.Operaciones;
import nio.consola.Consola;
import java.io.IOException;
import java.nio.file.*;
import java.util.NoSuchElementException;

public class Validador {
    private static int indicador = 0;

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

    public static boolean validar(String ruta, Operaciones operación) {
        try {
            validarGeneral(ruta);
        } catch (Exception e) {
            MensajesError.agregarError(ruta, operación, e.getMessage(), e);
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

    // Uso para NioGuardarNombres
    public static boolean estáVacío(Path path, Operaciones operación) throws IOException {
        try (DirectoryStream<Path> elementos = Files.newDirectoryStream(path)){
            if (!elementos.iterator().hasNext()) {
                throw new NoSuchElementException("No hay elementos en esta carpeta.");
            }
        } catch (NoSuchElementException e) {
            MensajesError.agregarError(path.toString(), operación, e.getMessage(), e);
            return true;
        }
        return false;
    }

    public static boolean estáVacío(String ruta) { // Se supone que ya se hizo comprobaciones.
        Path path = Path.of(ruta);
        try (DirectoryStream<Path> elementos = Files.newDirectoryStream(path)){
            if (!elementos.iterator().hasNext()) {
                return true;
            }
        } catch (Exception e) {
            MensajesError.agregarError(path.toString(), Operaciones.CARPETA_VACÍA, e.getMessage(), e);
        }
        return false;
    }

    public static boolean sobrescribir(Path path, Operaciones operación) {
        if (indicador == 1) {
            return true;
        } else if (indicador == 2){
            return false;
        }

        String elección = Consola.consolaSobrescribir(operación);

        return switch (elección) {
            case "s" -> true;
            case "n" -> false;
            case "sp" -> {
                indicador = 1;
                yield true;
            }
            case "np" -> {
                indicador = 2;
                yield false;
            }
            default -> false;
        };

    }

    public static boolean probar(String ruta) {
        return true;
    }
}
