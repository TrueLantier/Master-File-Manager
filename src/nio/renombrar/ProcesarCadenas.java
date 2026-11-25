package nio.renombrar;

import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcesarCadenas {
    private static final Pattern PATRON = Pattern.compile(
            "(\\d+(?:\\.\\d+)?)(?:\\s*-\\s*(\\d+(?:\\.\\d+)?))?"
    );

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

        while (matcher.find()) {
            númeroUno = matcher.group(1);
            númeroDos = matcher.group(2);

            if (númeroDos != null) {
                return númeroUno + "-" + númeroDos + " " + nombreManga;
            } else {
                return númeroUno + " " + nombreManga;
            }
        }


//        if (matcher.find()) {
//            parte = matcher.group();
//            System.out.println(parte);
//        }

        return númeroUno+ "-" +númeroDos + " " + nombreManga;
    }


}
