package nio.copiarmover;

import nio.NioEliminar.NioEliminar;
import nio.Operaciones;
import nio.manejoerrores.MensajesError;
import nio.manejoerrores.Validador;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class NioCopiar {

    public static void copiarElemento(String rutaElemento, String rutaDestino) {
        if (Validador.validar(rutaElemento, Operaciones.COPIAR)) {
            return;
        }
        if (Validador.validar(rutaDestino, Operaciones.COPIAR)) {
            return;
        }
        if (rutaIncorrecta(rutaElemento, rutaDestino)) {
            return;
        }

        Path fuente = Path.of(rutaElemento);
        Path destino = Path.of(rutaDestino);
        Path destinoCompleto = destino.resolve(fuente.getFileName());
        try {
            if (Files.exists(destinoCompleto)) {
                if (Validador.sobrescribir(destinoCompleto, Operaciones.COPIAR)) {
                    NioEliminar.eliminarElemento(destinoCompleto.toString());
                    Files.copy(fuente, destinoCompleto, StandardCopyOption.COPY_ATTRIBUTES);
                    return;
                } else {
                    return;
                }
            }

            /**
             * Por defecto NO copia contenido si es una carpeta.
              */
            Files.copy(fuente, destinoCompleto, StandardCopyOption.COPY_ATTRIBUTES);
        } catch (Exception e) {
            MensajesError.agregarError(rutaElemento, Operaciones.COPIAR, e.getMessage(), e);
        }
    }

    public static void copiarTodo(String rutaElementos, String rutaDestino) { // FUNCIONA
        if (Validador.validar(rutaElementos, Operaciones.COPIAR)) {
            return;
        }
        if (Validador.validar(rutaDestino, Operaciones.COPIAR)) {
            return;
        }
        if (rutaIncorrecta(rutaElementos, rutaDestino)) {
            return;
        }

        Path fuente = Path.of(rutaElementos);
        Path destino = Path.of(rutaDestino);
        Path destinoCompleto = destino.resolve(fuente.getFileName());
        copiarElemento(rutaElementos, rutaDestino);
        if (Files.isRegularFile(fuente) || Validador.estáVacío(rutaElementos)) {
            return;
        }

        try (DirectoryStream<Path> elementos = Files.newDirectoryStream(fuente)) {
            for (Path elemento: elementos) {
                String rutaIndividual = elemento.toString();
                String rutaIndividualFinal = destinoCompleto.toString();
                copiarTodo(rutaIndividual, rutaIndividualFinal);
            }
        } catch (Exception e) {
            MensajesError.agregarError(rutaElementos, Operaciones.COPIAR, e.getMessage(), e);
        }
    }

    // Copia por orden alfabético. Ejemplo: los 10 primeros.
    public static void copiarContenido(String rutaElementos, String rutaDestino, int cantidad) {
        if (Validador.validar(rutaElementos, Operaciones.COPIAR)) {
            return;
        }
        if (rutaIncorrecta(rutaElementos, rutaDestino)) {
            return;
        }

        int contador = 0;
        List<String> listaElementos = new ArrayList<>();
        Locale locale = Locale.getDefault();
        Collator collator = Collator.getInstance(locale);

        try (DirectoryStream<Path> elementos = Files.newDirectoryStream(Path.of(rutaElementos))) {
            for (Path elemento: elementos) {
                listaElementos.add(elemento.toString());
            }
            collator.setStrength(Collator.TERTIARY);
            listaElementos.sort(collator);

            for (String elemento: listaElementos) {
                if (contador==cantidad) { break;}
                copiarTodo(elemento, rutaDestino);
                ++contador;
            }
        } catch (Exception e) {
            MensajesError.agregarError(rutaElementos, Operaciones.COPIAR, e.getMessage(), e);
        }
    }

    public static void copiarNombres(String rutaElementos, String rutaDestino, String ... nombres) {
        if (Validador.validar(rutaElementos, Operaciones.COPIAR)) {
            return;
        }
        if (rutaIncorrecta(rutaElementos, rutaDestino)) {
            return;
        }

        try (DirectoryStream<Path> elementos = Files.newDirectoryStream(Path.of(rutaElementos))) {
            uno: for (Path elemento: elementos) {
                for (String nombre: nombres) {
                    if (elemento.toString().contains(nombre)) {
                        copiarTodo(elemento.toString(), rutaDestino);
                        continue uno;
                    }
                }
            }
        } catch (Exception e) {
            MensajesError.agregarError(rutaElementos, Operaciones.COPIAR, e.getMessage(), e);
        }
    }

    /**
     * NO COPIAR CARPETA DENTRO DE SÍ MISMA.
     */
    private static boolean rutaIncorrecta(String rutaOrigen, String rutaDestino) {
        try {
            boolean contenido = rutaDestino.contains(Path.of(rutaOrigen).toString());
            if (contenido) {
                throw new IllegalArgumentException("La ruta de origen contiene a la ruta de destino. " +
                        "Una carpeta no puede copiarse dentro de sí misma.");
            }
        } catch (Exception e) {
            MensajesError.agregarError(rutaOrigen, Operaciones.COPIAR, e.getMessage(), e);
            return true;
        }
        return false;
    }
}
