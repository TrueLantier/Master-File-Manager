package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

abstract public class NioDiseño {
    public static void validarRuta(String ruta) throws IOException {
        Path path = Path.of(ruta);
        if (!Files.exists(path)) { // Si no existe

        }
        if (!Files.isReadable(path) || !Files.isWritable(path)) {

        }
    }


}
