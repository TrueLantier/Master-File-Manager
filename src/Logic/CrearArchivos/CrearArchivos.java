package Logic.CrearArchivos;

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
        File NuevaCarpeta = new File(rutaArchivos + "/Carpeta");

        boolean carpetaR = NuevaCarpeta.canRead();
        boolean carpetaW = NuevaCarpeta.canWrite();
        boolean carpeta1 = NuevaCarpeta.mkdirs();


        if (carpeta1) {
            System.out.println("Algo pasa.");
        }   else {
            System.out.println("Algo no pasa.");
        }

        if (carpetaR) {
            System.out.println("Se puede leer.");
        }   else {
            System.out.println("No se puede leer");
        }

        if (carpetaW) {
            System.out.println("Se puede escribir.");
        }   else {
            System.out.println("No se puede escribir.");
        }
    }
}
