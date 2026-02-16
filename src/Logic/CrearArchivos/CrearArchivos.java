package Logic.CrearArchivos;
/*
-Crea archivos y carpetas.
 */
import Logic.Diseño.Diseño;

import java.io.*;

public class CrearArchivos extends Diseño {
    int cantidadDeArchivos;

    // Esta clase crea archivos donde se especifique, no en un lugar por defecto.
    public CrearArchivos(String rutaCrear, int cantidad) throws FileNotFoundException{
        super(rutaCrear);
        cantidadDeArchivos = cantidad;
        //crearArchivos();
        crearCarpetas();
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

    public void crearCarpetas() {
        File nuevaCarpeta = new File(rutaArchivos + "/Nueva Carpeta");
        nuevaCarpeta.mkdir();
    }
    public void crearCarpetas(int num) {
        for (int i = 1; i <= num; i++) {
            File nuevaCarpeta = new File(rutaArchivos + "/Nueva Carpeta" + i);
            nuevaCarpeta.mkdir();
        }
    }

    public void elementosACrear() {
        System.out.println("¿Qué desea crear?");
        System.out.println("");
    }
}
