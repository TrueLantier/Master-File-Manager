package nio;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class NioDiseño {
    public static void validarRuta(String ruta) throws IOException {
        Path path = Path.of(ruta);
        if (!Files.isReadable(path)) {

        }
        if (!Files.isWritable(path)) {

        }
        if (!Files.exists(path)) { // Si no existe

        }
    }

    public static void esVacío(Path path) throws IOException {
        try (DirectoryStream<Path> elementos = Files.newDirectoryStream(path)){
            if (!elementos.iterator().hasNext()) {
                // Agregar cosas
                // throw new
            }
        }
    }

    public static void sobrescribir() {

    }
}
