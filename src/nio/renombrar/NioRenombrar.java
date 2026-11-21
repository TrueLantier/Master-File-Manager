package nio.renombrar;

/*
  Renombrar varios archivos con condiciones
 */

import nio.Operaciones;
import nio.manejoerrores.MensajesError;
import nio.manejoerrores.Validador;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class NioRenombrar {

    public static void renombrarElemento(String rutaElemento, String nuevoNombre) {
        if (Validador.validar(rutaElemento, Operaciones.RENOMBRAR)) {
            return;
        }

        Path fuente = Path.of(rutaElemento);
        Path padre = fuente.getParent();
        Path destino = padre.resolve(nuevoNombre);
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
            MensajesError.agregarError(rutaElemento, Operaciones.RENOMBRAR, e.getMessage(), e);
        }
    }


}
