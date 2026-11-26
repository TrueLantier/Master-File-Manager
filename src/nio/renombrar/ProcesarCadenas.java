package nio.renombrar;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcesarCadenas {
    private static final Pattern PATRON = Pattern.compile(
            "(\\d+(?:\\.\\d+)?)(?:\\s*-\\s*(\\d+(?:\\.\\d+)?))?"
    );

    private static List<String> palabrasClave = new ArrayList<>(
            Arrays.asList("Final", "Extra", "Epílogo", "Especial"));

    public static void agregarPalabrasClave(String[] matrizClave) {
        Collections.addAll(palabrasClave, matrizClave); // Más limpia y eficiente.
        // palabrasClave.addAll(Arrays.asList(matrizClave));
        // palabrasClave.addAll(List.of(matrizClave));
    }

    public static String nombreNuevoSinCadena(Path fuente, String cadena) {
        String nombreOriginal = fuente.getFileName().toString();
        return nombreOriginal.replace(cadena, "");
    }

    public static String nombreNuevoConPrefijo(Path fuente, String prefijo) {
        String nombreOriginal = fuente.getFileName().toString();
        return prefijo + nombreOriginal;
    }

    public static String nombreNuevoConSufijo(Path fuente, String sufijo) {
        String nombreOriginal = fuente.getFileName().toString();
        if (!nombreOriginal.contains(".")) {
            return nombreOriginal + sufijo;
        }

        int posiciónPunto = nombreOriginal.lastIndexOf(".");
        String nombreSolo = nombreOriginal.substring(0, posiciónPunto);
        String extensión = nombreOriginal.substring(posiciónPunto);

        return nombreSolo + sufijo + extensión;
    }

    public static String nombreNuevoConExtensión(Path fuente, String nuevoNombre) {
        String nombreOriginal = fuente.getFileName().toString();
        int posiciónPunto = nombreOriginal.lastIndexOf(".");
        String extensión = nombreOriginal.substring(posiciónPunto);

        return nuevoNombre + extensión;
    }

    /**
     * Mangas
     */
    public static String construirNombreManga(Path elemento) {
        String nombreManga = elemento.getParent().getFileName().toString();
        String nombreElemento = elemento.getFileName().toString();
        Matcher matcher = PATRON.matcher(nombreElemento);
        String númeroUno = "";
        String númeroDos = "";
        String clave = encontrarPalabraClave(nombreElemento);

        while (matcher.find()) {
            númeroUno = matcher.group(1);
            númeroDos = matcher.group(2);

            if (númeroDos != null) {
                return clave + númeroUno + "-" + númeroDos + " " + nombreManga;
            } else {
                return clave + númeroUno + " " + nombreManga;
            }
        }

        return númeroUno + "-" + númeroDos + " " + nombreManga; // Innecesario
    }

    private static String encontrarPalabraClave(String nombre) {
        for (String clave: palabrasClave) {
            Pattern patrón = Pattern.compile(clave, Pattern.CASE_INSENSITIVE);
            Matcher matcher = patrón.matcher(nombre);
            if (matcher.find()) {
                return matcher.group() + " ";
            } else {
                return "";
            }
        }
        return "";
    }
}
