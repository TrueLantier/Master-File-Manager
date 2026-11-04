package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NioDiseño {
    public static void validarRuta(String ruta) throws IOException {
        Path path = Path.of(ruta);
        if (!Files.isReadable(path)) {

        }
        if (!Files.isReadable(path)) {

        }
        if (!Files.exists(path)) { // Si no existe

        }
    }


}
