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
            // Lanzar que la carpeta está vacía con la Clase Mensajes.
            return;
        }

        for (File elemento: eliminarElementos) {
            if (elemento.isDirectory()) {
                eliminarTodo(elemento.getCanonicalPath());
            }
            elemento.delete(); // Poco verificable si se borró bien. Poco control.
        }
    }

    public void eliminarPorNombre(String rutaEliminar, String eliminarArchivo) throws IOException{
        eliminarCarpeta = new File(rutaEliminar);
        eliminarElementos = eliminarCarpeta.listFiles();

        if (carpetaVacía(eliminarElementos)) {
            // Lanzar que la carpeta está vacía con la Clase Mensajes
            return;
        }

        for (File elemento: eliminarElementos) {
            if (elemento.getName().contains(eliminarArchivo)) {
                if (elemento.isDirectory()) {
                    eliminarTodo(elemento.getCanonicalPath());
                }
                elemento.delete();
            }

            // Busca el archivo en subcarpetas.
            if (elemento.isDirectory()) {
                eliminarPorNombre(elemento.getCanonicalPath(), eliminarArchivo);
            }
        }
    }

    public void eliminarPorNombre(String rutaEliminar, String[] eliminarArchivo) throws IOException{
        for (String archivo: eliminarArchivo) {
            eliminarPorNombre(rutaEliminar, archivo);
        }
    }

    // Conoce de cosas que no debería, interactúa con el usuario.
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
