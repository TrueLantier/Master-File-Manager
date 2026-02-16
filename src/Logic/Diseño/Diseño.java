package Logic.Diseño;
import java.io.*;

public abstract class Diseño {
    protected String rutaArchivos;
    protected File carpeta ;
    protected File[] elementos;

    public Diseño(String ruta) throws FileNotFoundException {
        if (rutaVálida(ruta)) {
            rutaArchivos = ruta;
        }
    }

    // Métodos públicos porque en los Test a veces son necesarios para probar si todo funciona bien.
    public boolean rutaVálida(String ruta) throws FileNotFoundException{
        carpeta = new File(ruta);

        if (!carpeta.exists()) {
            System.out.println("ERROR: La ruta no existe.");
            throw new FileNotFoundException();
        }
        if (!carpeta.isDirectory()) {
            System.out.println("ERROR: La ruta no es una carpeta.");
            throw new FileNotFoundException();
        }
        return true;
    }

    public String getNombreCarpeta(String ruta) {
        StringBuilder nombreCarpeta = new StringBuilder();

        for (int i = ruta.length()-1; ; i--) {
            char charActual = ruta.charAt(i);
            if (charActual == '/') break;
            nombreCarpeta.append(charActual);
        }
        return nombreCarpeta.reverse().toString();
    }
}
