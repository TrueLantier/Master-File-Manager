package logic.eliminararchivos;

import logic.diseño.Diseño;
import java.io.*;

public class EliminarArchivos extends Diseño {

    public EliminarArchivos(String rutaEliminar, String eliminarArchivo) throws IOException{
        super(rutaEliminar);
        eliminarPorNombre(rutaEliminar, eliminarArchivo);
    }

    public EliminarArchivos(String rutaEliminar, String[] eliminarArchivo) throws FileNotFoundException{
        super(rutaEliminar);
        eliminar(eliminarArchivo);
    }

    public EliminarArchivos(String eliminarArchivo) throws FileNotFoundException {
        super(eliminarArchivo);
        eliminar();
    }

    public void eliminarPorNombre(String rutaEliminar, String eliminarArchivo) throws IOException{
//        if (carpetaVacía()) {
//            System.out.println("Carpeta vacía. No hay elementos para eliminar.");
//            return;
//        }
        File eliminarCarpeta = new File(rutaEliminar);
        File[] eliminarElementos = eliminarCarpeta.listFiles();

        while (true) {
            System.out.println("Se eliminarán todos los archivos con '" + eliminarArchivo + "' en el nombre.");
            System.out.println("¿Está seguro que desea eliminar los archivos? 's/n'");
            String opción = scanner.nextLine().trim().toLowerCase();

            if (opción.equals("s")) {
                for (File elemento: eliminarElementos) {
                    if (elemento.isDirectory()) {
                        eliminarPorNombre(elemento.getCanonicalPath(), eliminarArchivo);
                    }

                    if (elemento.getName().contains(eliminarArchivo)) {
                        elemento.delete();
                    }
                }
                return;
            }
            if (opción.equals("n")) { return; }

            System.out.println("Entrada incorrecta. Reintente");
        }
    }

    public void eliminar(String[] eliminarArchivo) {
        if (carpetaVacía()) {
            System.out.println("Carpeta vacía. No hay elementos para eliminar.");
            return;
        }

        while (true) {
            System.out.println("Se eliminarán todos los archivos con los siguientes nombres:");
            for (String archivo : eliminarArchivo) {
                System.out.print(archivo + " ");
            }

            System.out.println("\n¿Está seguro que desea eliminar los archivos? 's/n'");
            String eliminar = scanner.nextLine().trim().toLowerCase();

            if (eliminar.equals("s")) {
                for (String archivo : eliminarArchivo) {
                    for (File elemento : elementos) {
                        if (elemento.getName().contains(archivo)) {
                            elemento.delete();
                        }
                    }
                }
                return;
            }
            if (eliminar.equals("n")) { return; }

            System.out.println("Entrada incorrecta. Reintente");
        }
    }

    public void eliminar(File carpeta) {
        for (File elementos: carpeta.listFiles()) {

        }
    }

    /*
    if (elemento.isDirectory()) {
                            EliminarArchivos ea = new EliminarArchivos(elemento.getCanonicalPath(), eliminarArchivo);
                            // Lo ideal sería después eliminar el objeto ea para no dejar tantos colgando.
                        }
     */

    public void eliminar() {
        if (carpetaVacía()) {
            System.out.println("Carpeta vacía. No hay elementos para eliminar.");
            return;
        }

        // Enlazar de alguna manera los archivos con un número


        System.out.println("Escriba los números correspondientes a los archivos que va a eliminar. " +
                "Sepárelos por espacios.");
        System.out.println("Seleccione: ");



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
}
