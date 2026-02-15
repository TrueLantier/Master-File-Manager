package Logic.CrearArchivos;

import java.io.*;

public class CrearArchivos {
    String rutaArchivos;
    File carpeta ;
    int cantidadDeArchivos;

    public CrearArchivos(String ruta, int cantidad) throws FileNotFoundException{
        if (rutaVálida(ruta)) {
            rutaArchivos = ruta;
            cantidadDeArchivos = cantidad;
        }
        crearArchivos();
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

    public String getNombreCarpeta(String rutaArchivos) {
        StringBuilder nombreCarpeta = new StringBuilder();

        for (int i = rutaArchivos.length()-1; ; i--) {
            char charActual = rutaArchivos.charAt(i);
            if (charActual == '/') break;
            nombreCarpeta.append(charActual);
        }
        return nombreCarpeta.reverse().toString();
    }

    public void crearArchivos() {
        for (int i = 1; i <= cantidadDeArchivos; i++) {
            String nombreLista = rutaArchivos + "/" +getNombreCarpeta(rutaArchivos) +
                  i  + ".txt";
            try (BufferedWriter lista = new BufferedWriter(new FileWriter(nombreLista))){

            }   catch (IOException e) {
                System.out.println("Error en la escritura de los archivos." + e.getMessage());
            }
        }
    }
}
