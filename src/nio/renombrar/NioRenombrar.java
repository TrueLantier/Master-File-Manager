package nio.renombrar;

/*
  Renombrar varios archivos con condiciones.
  Esta clase no soporta archivos ocultos Linux ".archivo" ni doble extensión: "algo.txt.xz".
 */

import nio.Operaciones;
import nio.manejoerrores.*;

import java.lang.ref.PhantomReference;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class NioRenombrar {

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

        Path fuente = Path.of(rutaElemento);
        Path padre = fuente.getParent();
        Path destino = padre.resolve(nuevoNombre);
        renombrar(fuente, destino);
    }

    // Sufijo es la extensión: ".algo".
    public static void renombrarConSufijo(String rutaElemento, String nuevoNombre) {
        if (Validador.validar(rutaElemento, Operaciones.RENOMBRAR)) {
            return;
        }

        if (!rutaElemento.contains(".")) {
            renombrarElemento(rutaElemento, nuevoNombre);
            return;
        }

        Path fuente = Path.of(rutaElemento);
        Path padre = fuente.getParent();
        String nombre = nombreNuevoConExtensión(fuente, nuevoNombre);
        Path destino = padre.resolve(nombre);
        renombrar(fuente, destino);
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

    private static boolean tienePunto(Path path) {
        String nombreElemento = path.getFileName().toString();


        return false;
    }
}
