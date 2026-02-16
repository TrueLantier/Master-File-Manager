package Logic.EliminarArchivos;

import Logic.Diseño.Diseño;

import java.io.*;

public class EliminarArchivos extends Diseño {

    File archivoEliminar;
    File[] archivoSE;

    public EliminarArchivos(String rutaEliminar) throws FileNotFoundException {
        super(rutaEliminar);
        //System.out.println("Seleccione el archivo a eliminar: ");
        for (String archivo: carpeta.list()) {
            System.out.println(archivo);
        }
    }

    public void eliminar() {

    }


    public boolean archivoVálido(String archivoRuta) throws FileNotFoundException{
        archivoEliminar = new File(archivoRuta);

        if (!archivoEliminar.exists()) {
            System.out.println("ERROR: El archivo no existe.");
            throw new FileNotFoundException();
        }
        if (!archivoEliminar.isFile()) {
            System.out.println("ERROR: El archivo no debe ser una carpeta.");
            throw new FileNotFoundException();
        }
        if (!archivoEliminar.canWrite()) {
            System.out.println("ERROR: No tienes permiso para eliminar este archivo.");
            throw new FileNotFoundException();
        }
        return true;
    }
}
