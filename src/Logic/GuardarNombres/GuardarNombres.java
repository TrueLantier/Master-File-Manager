package Logic.GuardarNombres;
import java.io.*;
import java.nio.*;

public class GuardarNombres {
    String rutaNombres;
    String rutaDeGuardado = "src/Logic/GuardarNombres";
    File carpeta ;
    //boolean rutaVálida = rutaVálida(rutaNombres);
    /*
     Formas de pasar la ruta:
     1- Pedir la ruta por teclado y analizar con Scanner u otro método.
     2- Pasar la ruta como argumento de línea de comandos.
     */

    GuardarNombres(String rutaNombres) throws FileNotFoundException{
        if (rutaVálida(rutaNombres)) {
            this.rutaNombres = rutaNombres;
        }
    }

    boolean rutaVálida(String rutaNombres) throws FileNotFoundException{
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

    public StringBuilder getNombreCarpeta(String rutaNombres) {
        StringBuilder nombreCarpeta = new StringBuilder();

        for (int i = rutaNombres.length()-1; ; i--) {
            char charActual = rutaNombres.charAt(i);
            if (charActual == '/') break;
            nombreCarpeta.append(charActual);
        }
        return nombreCarpeta.reverse();
    }
}
