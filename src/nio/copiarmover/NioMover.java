package nio.copiarmover;

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

public class NioMover {

    public static void moverElemento(String rutaElemento, String rutaDestino) {
        if (Validador.validar(rutaElemento, Operaciones.MOVER)) {
            return;
        }
        if (Validador.validar(rutaDestino, Operaciones.MOVER)) {
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
                if (Validador.sobrescribir(destinoCompleto, Operaciones.MOVER)) {
                    Files.move(fuente, destinoCompleto,
                            StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
                    return;
                } else {
                    return;
                }
            }

            Files.move(fuente, destinoCompleto, StandardCopyOption.ATOMIC_MOVE);
        } catch (Exception e) {
            MensajesError.agregarError(rutaElemento, Operaciones.MOVER, e.getMessage(), e);
        }
    }

    public static void moverContenido(String rutaElementos, String rutaDestino, int cantidad) {
        if (Validador.validar(rutaElementos, Operaciones.MOVER)) {
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
                moverElemento(elemento, rutaDestino);
                ++contador;
            }
        } catch (Exception e) {
            MensajesError.agregarError(rutaElementos, Operaciones.MOVER, e.getMessage(), e);
        }
    }

    public static void moverNombres(String rutaElementos, String rutaDestino, String ... nombres) {
        if (Validador.validar(rutaElementos, Operaciones.MOVER)) {
            return;
        }
        if (rutaIncorrecta(rutaElementos, rutaDestino)) {
            return;
        }

        try (DirectoryStream<Path> elementos = Files.newDirectoryStream(Path.of(rutaElementos))) {
            uno: for (Path elemento: elementos) {
                for (String nombre: nombres) {
                    if (elemento.toString().contains(nombre)) {
                        moverElemento(elemento.toString(), rutaDestino);
                        continue uno;
                    }
                }
            }
        } catch (Exception e) {
            MensajesError.agregarError(rutaElementos, Operaciones.MOVER, e.getMessage(), e);
        }
    }

    /**
     * NO MOVER CARPETA DENTRO DE SÍ MISMA.
     */
    private static boolean rutaIncorrecta(String rutaOrigen, String rutaDestino) {
        try {
            boolean contenido = rutaDestino.contains(Path.of(rutaOrigen).toString());
            if (contenido) {
                throw new IllegalArgumentException("La ruta de origen contiene a la ruta de destino. " +
                        "Una carpeta no puede copiarse dentro de sí misma.");
            }
        } catch (Exception e) {
            MensajesError.agregarError(rutaOrigen, Operaciones.MOVER, e.getMessage(), e);
            return true;
        }
        return false;
    }
}
