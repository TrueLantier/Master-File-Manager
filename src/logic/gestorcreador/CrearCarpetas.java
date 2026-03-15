package logic.gestorcreador;

import logic.diseño.Diseño;
import java.io.*;

public class CrearCarpetas extends Diseño implements GestorCreador{

    public CrearCarpetas(String rutaCrear, int cantidad) throws FileNotFoundException {
        super(rutaCrear);
        cantidadDeElementos = cantidad;
        crear();
    }

    public CrearCarpetas(String rutaCrear, int cantidad, String nombrePorDefecto) throws FileNotFoundException {
        super(rutaCrear);
        cantidadDeElementos = cantidad;
        crear(nombrePorDefecto);
    }

    public CrearCarpetas(String rutaCrear,String[] nombres, boolean anidar) throws FileNotFoundException {
        super(rutaCrear);
        cantidadDeElementos = nombres.length;
        crear(nombres, anidar);
    }

    @Override
    public void crear() {
        for (int i = 0; i < cantidadDeElementos; i++) {
            File nuevaCarpeta = new File(rutaArchivos + File.separator + "Nueva Carpeta " + i);
            if (sobreescritura(nuevaCarpeta)) {
                continue;
            }
            nuevaCarpeta.mkdir();
        }
    }

    @Override
    public void crear(String nombrePorDefecto) {
        for (int i = 0; i < cantidadDeElementos; i++) {
            File nuevaCarpeta = new File(rutaArchivos + File.separator + nombrePorDefecto + " " + i);
            if (sobreescritura(nuevaCarpeta)) {
                continue;
            }
            nuevaCarpeta.mkdir();
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
            if (sobreescritura(nuevaCarpeta)) return;
            nuevaCarpeta.mkdirs();
            return;
        }

        for (int i = 0; i < cantidadDeElementos; i++) {
            File nuevaCarpeta = new File(rutaArchivos + File.separator + nombres[i]);
            if (sobreescritura(nuevaCarpeta)) {
                continue;
            }
            nuevaCarpeta.mkdir();
        }
    }
}
