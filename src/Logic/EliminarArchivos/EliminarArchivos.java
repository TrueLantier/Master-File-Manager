package Logic.EliminarArchivos;

import java.io.*;

public class EliminarArchivos {
    String rutaArchivos;
    File carpeta ;
    File[] elementos;

    public EliminarArchivos(String ruta) throws FileNotFoundException {
        if (rutaVálida(ruta)) {
            rutaArchivos = ruta;
        }
        System.out.println("Seleccione el archivo a eliminar: ");

    }

    public boolean rutaVálida(String rutaNombres) throws FileNotFoundException{
        carpeta = new File(rutaNombres);

        if (!carpeta.exists()) {
            System.out.println("La ruta no existe.");
            throw new FileNotFoundException();
        }
        if (!carpeta.isDirectory()) {
            System.out.println("La ruta no es una carpeta.");
            throw new FileNotFoundException();
        }
        return true;
    }
}
