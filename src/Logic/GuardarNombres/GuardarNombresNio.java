package Logic.GuardarNombres;
import java.nio.file.*; // Files, Path, Paths
import java.io.*;
import java.text.Collator;
import java.util.List;
import java.util.Locale;

public class GuardarNombresNio {
    String rutaNombres;
    String rutaDeGuardado = "src/Logic/GuardarNombres";
    File carpeta ;
    File[] elementos;
    public List<String> nombresArchivos;
    Locale locale = Locale.getDefault();
    Collator collator = Collator.getInstance(locale);

    public GuardarNombresNio(String ruta) {
        rutaNombres = ruta;
    }




}
