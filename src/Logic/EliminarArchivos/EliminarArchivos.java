package Logic.EliminarArchivos;
/*
Esta clase es para eliminar archivos. Va hacia una carpeta, permite una selección de archivos y
elimina los elegidos. Sin importar si son carpetas o archivos. El usuario verifica su elección.
También debe dar la opción de eliminar directamente el archivo elegido.
 */

import Logic.Diseño.Diseño;

import java.io.*;

public class EliminarArchivos extends Diseño {

    public EliminarArchivos(String eliminarArchivo) throws FileNotFoundException {
        super(eliminarArchivo);
        eliminar();
    }
    public EliminarArchivos(String rutaEliminar, String eliminarArchivo) throws FileNotFoundException{
        super(rutaEliminar);
        eliminar(eliminarArchivo);
    }
    public EliminarArchivos(String rutaEliminar, String[] eliminarArchivo) throws FileNotFoundException{
        super(rutaEliminar);
        eliminar(eliminarArchivo);
    }

    public void eliminar() {
        System.out.println("¿Está seguro que desea eliminar el archivo seleccionado? 's/n'");
        String eliminar = scanner.nextLine().trim().toLowerCase();

        if (eliminar.equals("s")) {
            carpeta.delete();
            return;
        }
        if (!eliminar.equals("n")) {
            System.out.println("Entrada incorrecta. Reintente");
            eliminar();
        }
    }

    public void eliminar(String eliminarArchivo) {
        elementos = carpeta.listFiles();
        if (elementos == null) {
            System.out.println("Carpeta vacía. No hay elementos para borrar.");
            return;
        }

        System.out.println("Se eliminarán todos los archivos con '" + eliminarArchivo + "' en el nombre.");
        System.out.println("¿Está seguro que desea eliminar los archivos? 's/n'");
        String eliminar = scanner.nextLine().trim().toLowerCase();

        if (eliminar.equals("s")) {
            for (File elemento: elementos) {
                if (elemento.getName().contains(eliminarArchivo)) {
                    elemento.delete();
                }
            }
            return;
        }
        if (!eliminar.equals("n")) {
            System.out.println("Entrada incorrecta. Reintente");
            eliminar(eliminarArchivo);
        }
    }

    public void eliminar(String[] eliminarArchivo) {
        elementos = carpeta.listFiles();
        if (elementos == null) {
            System.out.println("Carpeta vacía. No hay elementos para borrar.");
            return;
        }

        System.out.println("Se eliminarán todos los archivos con los siguientes nombres:");
        for (int i = 0; i < eliminarArchivo.length; i++) {
            System.out.print(eliminarArchivo[i] + " ");
        }
        System.out.println("¿Está seguro que desea eliminar los archivos? 's/n'");
        String eliminar = scanner.nextLine().trim().toLowerCase();

        if (eliminar.equals("s")) {
            for (int i = 0; i < eliminarArchivo.length; i++) {
                for (File elemento: elementos) {
                    if (elemento.getName().contains(eliminarArchivo[i])) {
                        elemento.delete();
                    }
                }
            }
            return;
        }
        if (!eliminar.equals("n")) {
            System.out.println("Entrada incorrecta. Reintente");
            eliminar(eliminarArchivo);
        }
    }
}
