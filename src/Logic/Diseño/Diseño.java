package Logic.Diseño;
import java.io.*;

public abstract class Diseño {
    String rutaArchivos;
    File carpeta ;
    File[] elementos;

    public Diseño(String ruta) throws FileNotFoundException {
        if (rutaVálida(rutaArchivos)) {
            this.rutaArchivos = ruta;
        }
    }

    public boolean rutaVálida(String ruta) throws FileNotFoundException{
        carpeta = new File(ruta);

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
