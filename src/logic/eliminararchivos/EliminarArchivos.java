package logic.eliminararchivos;

import logic.diseño.Diseño;
import java.io.*;

public class EliminarArchivos extends Diseño {
    File eliminarCarpeta;
    File[] eliminarElementos;

    public EliminarArchivos(String rutaEliminar) throws IOException {
        super(rutaEliminar);
        eliminarTodo(rutaEliminar);
    }

    public EliminarArchivos(String rutaEliminar, String eliminarArchivo) throws IOException{
        super(rutaEliminar);
        eliminarPorNombre(rutaEliminar, eliminarArchivo);
    }

    public EliminarArchivos(String rutaEliminar, String[] eliminarArchivo) throws IOException{
        super(rutaEliminar);
        eliminarPorNombre(rutaEliminar, eliminarArchivo);
    }

    public void eliminarTodo(String rutaEliminar) throws IOException{
        eliminarCarpeta = new File(rutaEliminar);
        eliminarElementos = eliminarCarpeta.listFiles();

        if (carpetaVacía(eliminarElementos)) {
            return;
        }

        for (File elemento: eliminarElementos) {
            if (elemento.isDirectory()) {
                eliminarTodo(elemento.getCanonicalPath());
            }
            elemento.delete();
        }
    }

    public void eliminarPorNombre(String rutaEliminar, String eliminarArchivo) throws IOException{
        eliminarCarpeta = new File(rutaEliminar);
        eliminarElementos = eliminarCarpeta.listFiles();

        if (carpetaVacía(eliminarElementos)) {
            return;
        }

        for (File elemento: eliminarElementos) {
            if (elemento.getName().contains(eliminarArchivo)) {
                if (elemento.isDirectory()) {
                    eliminarTodo(elemento.getCanonicalPath());
                }
                elemento.delete();
            }

            if (elemento.isDirectory()) {
                eliminarPorNombre(elemento.getCanonicalPath(), eliminarArchivo);
            }
        }
    }

    public void eliminarPorNombre(String rutaEliminar, String[] eliminarArchivo) throws IOException{
        for (String archivo: eliminarArchivo) {
            eliminarPorNombre(rutaEliminar, archivo);
        }

        // ¿Por qué no funciona?
        /*
        eliminarCarpeta = new File(rutaEliminar);
        eliminarElementos = eliminarCarpeta.listFiles();

        if (carpetaVacía(eliminarElementos)) {
            return;
        }

        for (String archivo : eliminarArchivo) {
            for (File elemento: eliminarElementos) {
                if (elemento.getName().contains(archivo)) {
                    if (elemento.isDirectory()) {
                        eliminarTodo(elemento.getCanonicalPath());
                    }
                    elemento.delete();
                }

                if (elemento.isDirectory()) {
                    eliminarPorNombre(elemento.getCanonicalPath(), eliminarArchivo);
                }
            }
        }
         */
    }

    public boolean elegir(String eliminarArchivo) {
        while (true) {
            System.out.println("Se eliminarán todos los archivos con '" + eliminarArchivo + "' en el nombre.");
            System.out.println("¿Está seguro que desea eliminar los archivos? 's/n'");
            String opción = scanner.nextLine().trim().toLowerCase();

            if (opción.equals("s")) { return true; }
            if (opción.equals("n")) { return false; }

            System.out.println("Entrada incorrecta. Reintente");
        }
    }

    public boolean carpetaVacía(File[] elementos) {
        return elementos == null || elementos.length == 0;
    }
}
