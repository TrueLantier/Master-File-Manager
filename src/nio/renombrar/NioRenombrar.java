package nio.renombrar;

/*
  Renombrar varios archivos con condiciones.
  Esta clase no soporta doble extensión: "algo.tar.xz".
 */

import nio.Operaciones;
import nio.manejoerrores.*;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NioRenombrar {

    private static void renombrar(Path fuente, Path destino) {
//        if (fuente.equals(destino)) {
//            return;
//        }
        try {
            if (Files.exists(destino)) {
                if (Validador.sobrescribir(destino, Operaciones.RENOMBRAR)) {
                    Files.move(fuente, destino,
                            StandardCopyOption.REPLACE_EXISTING);
                    return;
                } else {
                    return;
                }
            }

            Files.move(fuente, destino);
        } catch (Exception e) {
            MensajesError.agregarError(fuente.toString(), Operaciones.RENOMBRAR, e.getMessage(), e);
        }
    }

    public static void renombrarElemento(String rutaElemento, String nuevoNombre) {
        if (Validador.validar(rutaElemento, Operaciones.RENOMBRAR)) {
            return;
        }
        Path fuente = Path.of(rutaElemento);
        String nombre = ProcesarCadenas.nombreNuevoConExtensión(fuente, nuevoNombre);
        renombrar(fuente, fuente.resolveSibling(nombre));
    }

    /**
     * Se asume que todos los mangas estarán en una carpeta con su nombre.
     * @param rutaElementos
     */
    public static void renombrarMangas(String rutaElementos, String ... palabrasClave) {
        if (Validador.validar(rutaElementos, Operaciones.RENOMBRAR)) {
            return;
        }
        if (palabrasClave.length > 0) {
            ProcesarCadenas.agregarPalabrasClave(palabrasClave);
        }

        try {
            for (Path elemento : listar(rutaElementos)) {
                String nombre = ProcesarCadenas.construirNombreManga(elemento);
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

        try {
            for (Path elemento : listar(rutaElementos)) {
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

        try {
            for (Path elemento : listar(rutaElementos)) {
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

        try {
            for (Path elemento : listar(rutaElementos)) {
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
        String nombre = ProcesarCadenas.nombreNuevoConPrefijo(fuente, prefijo);
        Path destino = padre.resolve(nombre);
        renombrar(fuente, destino);
    }

    public static void agregarSufijo(String rutaElemento, String sufijo) {
        if (Validador.validar(rutaElemento, Operaciones.RENOMBRAR)) {
            return;
        }

        Path fuente = Path.of(rutaElemento);
        Path padre = fuente.getParent();
        String nombre = ProcesarCadenas.nombreNuevoConSufijo(fuente, sufijo);
        Path destino = padre.resolve(nombre);
        renombrar(fuente, destino);
    }

    public static void quitarCadena(String rutaElemento, String cadena) {
        if (Validador.validar(rutaElemento, Operaciones.RENOMBRAR)) {
            return;
        }
        Path fuente = Path.of(rutaElemento);
        String nombreOriginal = fuente.getFileName().toString();
        if (!nombreOriginal.contains(cadena)) {
            MensajesError.agregarError(rutaElemento, Operaciones.RENOMBRAR,
                    "La ruta no contiene la cadena que desea eliminar.", new IllegalArgumentException());
            return;
        }

        Path padre = fuente.getParent();
        String nombre = ProcesarCadenas.nombreNuevoSinCadena(fuente, cadena);
        Path destino = padre.resolve(nombre);
        renombrar(fuente, destino);
    }

    private static List<Path> listar(String rutaElementos) throws IOException {
        List<Path> elementos = new ArrayList<>();
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(Path.of(rutaElementos))) {
            for (Path p : ds) {
                elementos.add(p);
            }
        }
        Collections.sort(elementos);   // Orden determinista.
        return elementos;
    }
}
