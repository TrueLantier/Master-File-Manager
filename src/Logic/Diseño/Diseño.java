package Logic.Diseño;
import java.io.*;

public abstract class Diseño {
    String rutaNombres;
    File carpeta ;
    File[] elementos;

    public Diseño() throws FileNotFoundException {
        if (rutaVálida(rutaNombres)) {
            this.rutaNombres = rutaNombres;
        }
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
