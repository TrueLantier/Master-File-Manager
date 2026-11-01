package logic.gestorcreador;

import logic.diseño.Diseño;
import java.io.*;

public class CrearCarpetas extends Diseño implements GestorCreador{

    public CrearCarpetas(String rutaCrear, int cantidad) throws Exception {
        super(rutaCrear);
        cantidadDeElementos = cantidad;
        crear();
    }

    public CrearCarpetas(String rutaCrear, int cantidad, String nombrePorDefecto) throws Exception {
        super(rutaCrear);
        cantidadDeElementos = cantidad;
        crear(nombrePorDefecto);
    }

    public CrearCarpetas(String rutaCrear,String[] nombres, boolean anidar) throws Exception {
        super(rutaCrear);
        cantidadDeElementos = nombres.length;
        crear(nombres, anidar);
    }

    @Override
    public void crear() throws Exception {
        for (int i = 0; i < cantidadDeElementos; i++) {
            File nuevaCarpeta = new File(rutaArchivos + File.separator + "Nueva Carpeta " + i);
//            if (sobreescritura(nuevaCarpeta)) {
//                continue;
//            }
            if (nuevaCarpeta.exists()) { continue;}
            if (!nuevaCarpeta.mkdir()) {
                throw new RuntimeException("Error creando la carpeta.");
            }
        }
    }

    @Override
    public void crear(String nombrePorDefecto) throws Exception{
        for (int i = 0; i < cantidadDeElementos; i++) {
            File nuevaCarpeta = new File(rutaArchivos + File.separator + nombrePorDefecto + " " + i);
//            if (sobreescritura(nuevaCarpeta)) {
//                continue;
//            }
            if (nuevaCarpeta.exists()) { continue;}
            if (!nuevaCarpeta.mkdir()) {
                throw new RuntimeException("Error creando la carpeta.");
            }
        }
    }

    // Sobrecarga.
    public void crear(String[] nombres, boolean anidar) {
        if (anidar) {
            StringBuilder estructura = new StringBuilder(rutaArchivos);
            for (String nombre : nombres) {
                estructura.append(File.separator).append(nombre);

            }
            File nuevaCarpeta = new File(String.valueOf(estructura));
            // if (sobreescritura(nuevaCarpeta)) return;
            nuevaCarpeta.mkdirs(); // No hay forma de verificar si se creó correctamente sino mirando.
            return;
        }

        for (int i = 0; i < cantidadDeElementos; i++) {
            File nuevaCarpeta = new File(rutaArchivos + File.separator + nombres[i]);
//            if (sobreescritura(nuevaCarpeta)) {
//                continue;
//            }
            if (nuevaCarpeta.exists()) { continue;}
            if (!nuevaCarpeta.mkdir()) {
                throw new RuntimeException("Error creando la carpeta.");
            }
        }
    }
}
