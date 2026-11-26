package nio.renombrar;

import nio.Operaciones;
import nio.manejoerrores.MensajesError;
import nio.manejoerrores.RegistroErrores;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcesarCadenas {
    private static int num = 1;
    private static final Pattern PATRON = Pattern.compile(
            "(\\d+(?:\\.\\d+)?)(?:\\s*-\\s*(\\d+(?:\\.\\d+)?))?"
    );

    private static List<String> palabrasClave = new ArrayList<>(
            Arrays.asList("Final", "Extra", "Especial", "Epílogo"));

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
        Partes p = Partes.de(fuente);
        return p.base() + sufijo + p.extension();
    }

    public static String nombreNuevoConExtensión(Path fuente, String nuevoNombre) {
        return nuevoNombre + Partes.de(fuente).extension();
    }

    /**
     * Mangas
     */
    public static String construirNombreManga(Path elemento) {
        String nombreManga = elemento.getParent().getFileName().toString();
        String nombreElemento = Partes.de(elemento).base();
        Matcher matcher = PATRON.matcher(nombreElemento);
        String númeroUno = "";
        String númeroDos = "";
        String númeroTres = "";
        String clave = encontrarPalabraClave(nombreElemento);

        while (matcher.find()) {
            númeroUno = matcher.group(1);
            númeroDos = matcher.group(2);
            númeroTres = matcher.group(3);

            if (númeroTres != "") {
                MensajesError.agregarError(elemento.toString(), Operaciones.RENOMBRAR,
                        "Archivo con más de tres números", new IllegalArgumentException());
                return elemento.getFileName().toString();
            }

            if (númeroDos != null) {
                return clave + númeroUno + "-" + númeroDos + " " + nombreManga;
            } else {
                return clave + númeroUno + " " + nombreManga;
            }
        }

        return clave + nombreManga + " (sin número) " + ++num;
    }

    private static String encontrarPalabraClave(String nombre) {
        StringBuilder palabra = new StringBuilder();
        for (String clave: palabrasClave) {
            Pattern patrón = Pattern.compile("(?<!\\p{L})" + Pattern.quote(clave) + "(?!\\p{L})",
                    Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
            Matcher matcher = patrón.matcher(nombre);
            if (matcher.find()) {
                palabra.append(clave).append(" ");
            }
        }
        return palabra.toString();
    }
}
