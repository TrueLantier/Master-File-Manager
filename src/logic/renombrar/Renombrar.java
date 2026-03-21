package logic.renombrar;

import logic.diseño.Diseño;
import java.io.*;

import static java.io.File.separator;

public class Renombrar extends Diseño {
    File nuevoNombre = new File("src/laboratorio/salados/java 1/prueba2");
    String cadena;

    public Renombrar(String ruta) throws FileNotFoundException {
        super(ruta);
        renombrar();
    }

    public Renombrar(String ruta, String nombre) throws FileNotFoundException {
        super(ruta);
        cadena = ruta;
        renombrar();
    }

    public void renombrar() {
        carpeta.renameTo(nuevoNombre);
    }

    public void renombrar(String cad) {
        if (carpetaVacía()) {
            return;
        }

        for (File elemento: elementos) {
            if (elemento.getName().contains("java")) {
                cadena = cadena + separator + elemento.getName();
                elemento.renameTo(new File(cadena));
            }
        }
    }


}
