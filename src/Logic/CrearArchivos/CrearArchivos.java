package Logic.CrearArchivos;

import Logic.Diseño.Diseño;

import java.io.*;

public class CrearArchivos extends Diseño {
    int cantidadDeArchivos;

    // Esta clase crea archivos donde se especifique, no en un lugar por defecto.
    public CrearArchivos(String rutaCrear, int cantidad) throws FileNotFoundException{
        super(rutaCrear);
        cantidadDeArchivos = cantidad;
        crearArchivos();
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
