package nio.renombrar;

/*
  Renombrar varios archivos con condiciones.
  Esta clase no soporta doble extensión: "algo.txt.xz".
 */

import nio.Operaciones;
import nio.manejoerrores.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NioRenombrar {
    private static final int NÚMERO_PUNTOS = 2;

    private static void renombrar(Path fuente, Path destino) {
        try {
            if (Files.exists(destino)) {
                if (Validador.sobrescribir(destino, Operaciones.RENOMBRAR)) {
                    Files.move(fuente, destino,
                            StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
                    return;
                } else {
                    return;
                }
            }

            Files.move(fuente, destino, StandardCopyOption.ATOMIC_MOVE);
        } catch (Exception e) {
            MensajesError.agregarError(fuente.toString(), Operaciones.RENOMBRAR, e.getMessage(), e);
        }
    }

    public static void renombrarElemento(String rutaElemento, String nuevoNombre) {
        if (Validador.validar(rutaElemento, Operaciones.RENOMBRAR)) {
            return;
        }
        if (rutaElemento.contains(".")) {
            renombrarConSufijo(rutaElemento, nuevoNombre);
            return;
        }

        Path fuente = Path.of(rutaElemento);
        Path padre = fuente.getParent();
        Path destino = padre.resolve(nuevoNombre);
        renombrar(fuente, destino);
    }

    // Sufijo es la extensión: ".algo".
    private static void renombrarConSufijo(String rutaElemento, String nuevoNombre) {
        Path fuente = Path.of(rutaElemento);
        if (tienePuntos(fuente)) {
            return;
        }

        Path padre = fuente.getParent();
        String nombre = nombreNuevoConExtensión(fuente, nuevoNombre);
        Path destino = padre.resolve(nombre);
        renombrar(fuente, destino);
    }

    // Se asume que todos los mangas estarán en una carpeta con su nombre.
    public static void renombrarMangas(String rutaElementos) {
        if (Validador.validar(rutaElementos, Operaciones.RENOMBRAR)) {
            return;
        }

        try (DirectoryStream<Path> elementos = Files.newDirectoryStream(Path.of(rutaElementos))){
            for (Path elemento: elementos) {
                String nombre = construirNombreManga(elemento);
                renombrarElemento(elemento.toString(), nombre);
            }
        } catch (Exception e) {
            MensajesError.agregarError(rutaElementos, Operaciones.RENOMBRAR, e.getMessage(), e);
        }
    }

    public static void agregarTodoPrefijo(String rutaElementos, String prefijo) {
        if (Validador.validar(rutaElementos, Operaciones.RENOMBRAR)) {
            return;
        }

        try (DirectoryStream<Path> elementos = Files.newDirectoryStream(Path.of(rutaElementos))){
            for (Path elemento: elementos) {
                agregarPrefijo(elemento.toString(), prefijo);
            }
        } catch (Exception e) {
            MensajesError.agregarError(rutaElementos, Operaciones.RENOMBRAR, e.getMessage(), e);
        }
    }

    public static void agregarTodoSufijo(String rutaElementos, String sufijo) {
        if (Validador.validar(rutaElementos, Operaciones.RENOMBRAR)) {
            return;
        }

        try (DirectoryStream<Path> elementos = Files.newDirectoryStream(Path.of(rutaElementos))){
            for (Path elemento: elementos) {
                agregarSufijo(elemento.toString(), sufijo);
            }
        } catch (Exception e) {
            MensajesError.agregarError(rutaElementos, Operaciones.RENOMBRAR, e.getMessage(), e);
        }
    }

    public static void quitarTodoCadena(String rutaElementos, String cadena) {
        if (Validador.validar(rutaElementos, Operaciones.RENOMBRAR)) {
            return;
        }

        try (DirectoryStream<Path> elementos = Files.newDirectoryStream(Path.of(rutaElementos))){
            for (Path elemento: elementos) {
                quitarCadena(elemento.toString(), cadena);
            }
        } catch (Exception e) {
            MensajesError.agregarError(rutaElementos, Operaciones.RENOMBRAR, e.getMessage(), e);
        }
    }

    public static void agregarPrefijo(String rutaElemento, String prefijo) {
        if (Validador.validar(rutaElemento, Operaciones.RENOMBRAR)) {
            return;
        }

        Path fuente = Path.of(rutaElemento);
        Path padre = fuente.getParent();
        String nombre = nombreNuevoConPrefijo(fuente, prefijo);
        Path destino = padre.resolve(nombre);
        renombrar(fuente, destino);
    }

    public static void agregarSufijo(String rutaElemento, String sufijo) {
        if (Validador.validar(rutaElemento, Operaciones.RENOMBRAR)) {
            return;
        }

        Path fuente = Path.of(rutaElemento);
        Path padre = fuente.getParent();
        String nombre = nombreNuevoConSufijo(fuente, sufijo);
        Path destino = padre.resolve(nombre);
        renombrar(fuente, destino);
    }

    public static void quitarCadena(String rutaElemento, String cadena) {
        if (Validador.validar(rutaElemento, Operaciones.RENOMBRAR)) {
            return;
        }
        if (!rutaElemento.contains(cadena)) {
            MensajesError.agregarError(rutaElemento, Operaciones.RENOMBRAR,
                    "La ruta no contiene la cadena que desea eliminar.", new IllegalArgumentException());
            return;
        }

        Path fuente = Path.of(rutaElemento);
        Path padre = fuente.getParent();
        String nombre = nombreNuevoSinCadena(fuente, cadena);
        Path destino = padre.resolve(nombre);
        renombrar(fuente, destino);
    }

    private static String nombreNuevoSinCadena(Path fuente, String cadena) {
        String nombreOriginal = fuente.getFileName().toString();
        return nombreOriginal.replace(cadena, "");
    }

    private static String nombreNuevoConPrefijo(Path fuente, String prefijo) {
        String nombreOriginal = fuente.getFileName().toString();
        return prefijo + nombreOriginal;
    }

    private static String nombreNuevoConSufijo(Path fuente, String sufijo) {
        String nombreOriginal = fuente.getFileName().toString();
        if (!nombreOriginal.contains(".")) {
            return nombreOriginal + sufijo;
        }

        int posiciónPunto = nombreOriginal.lastIndexOf(".");
        String nombreSolo = nombreOriginal.substring(0, posiciónPunto);
        String extensión = nombreOriginal.substring(posiciónPunto);

        return nombreSolo + sufijo + extensión;
    }

    private static String nombreNuevoConExtensión(Path fuente, String nuevoNombre) {
        String nombreOriginal = fuente.getFileName().toString();
        int posiciónPunto = nombreOriginal.lastIndexOf(".");
        String extensión = nombreOriginal.substring(posiciónPunto);

        return nuevoNombre + extensión;
    }

    private static String construirNombreManga(Path elemento) {
        String nombreManga = elemento.getParent().getFileName().toString();
        String nombreElemento = elemento.getFileName().toString();
        Pattern patrón = Pattern.compile("\\d+-\\d+");
        Matcher matcher = patrón.matcher(nombreElemento);
        String parte = "";

        if (matcher.find()) {
            parte = matcher.group();
            System.out.println(parte);
        }

        return nombreManga + " " + parte;
    }

    private static boolean tienePuntos(Path path) {
        String nombreElemento = path.getFileName().toString();
        int contador = 0;
        for (int i = 0; i < nombreElemento.length(); i++) {
            if (nombreElemento.charAt(i) == '.') {
                ++contador;
            }
        }
        if (contador >= NÚMERO_PUNTOS) {
            MensajesError.agregarError(path.toString(), Operaciones.RENOMBRAR,
                    "El archivo tiene más de una extensión.", new IllegalArgumentException());
            return true;
        }

        return false;
    }
}
