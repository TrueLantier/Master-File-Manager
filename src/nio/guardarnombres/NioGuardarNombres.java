package nio.guardarnombres;

import nio.NioDiseño;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.Collator;
import java.util.Locale;

public class NioGuardarNombres extends NioDiseño {
    String rutaDeGuardado = "src/nio/guardarnombres/listas";
    Locale locale = Locale.getDefault();
    Collator collator = Collator.getInstance(locale);
    Path pathNombres;

    public void guardarNombres(String rutaNombres) throws IOException {
        validarRuta(rutaNombres);
        Path path = Path.of(rutaNombres);
        copiarNombres(path);
    }

    public void guardarNombres(String rutaNombres, String rutaDeGuardado) throws IOException{
        validarRuta(rutaNombres);
        validarRuta(rutaDeGuardado);
        Path path = Path.of(rutaNombres);
        this.rutaDeGuardado = rutaDeGuardado;

    }

    private void copiarNombres(Path path) {

    }
}
