package Logic.CrearArchivos;
/*
  Esta clase recibe un directorio. Verifica que existe.
  Luego da la posibilidad de crear archivos o carpetas.
  Los crea según la cantidad especificada. El nombre viene por defecto.
  Esta clase también se puede hacer con más métodos y constructores.
 */

import Logic.Diseño.Diseño;

import java.io.*;

public class CrearArchivos extends Diseño {
    int cantidadDeArchivos;
    String nombrePorDefecto;
    String tipoDeArchivo; // Eliminar si no se usa.

    public CrearArchivos(String rutaCrear) throws FileNotFoundException{
        super(rutaCrear);
        elementosACrear();
    }

    public CrearArchivos(String rutaCrear, String[] carpetasAnidadas) throws FileNotFoundException {
        super(rutaCrear);
        crearCarpetas(carpetasAnidadas);
    }

    public CrearArchivos(String rutaCrear, String tipo, int cantidad) throws FileNotFoundException{
        super(rutaCrear);
        if (tipo.equals("A")) {
            cantidadDeArchivos = cantidad;
            crearArchivos();
            return;
        }
        if (tipo.equals("C")) {
            cantidadDeArchivos = cantidad;
            crearCarpetas();
        }
    }

    public CrearArchivos(String rutaCrear, String tipo, int cantidad, String nombreDefecto) throws FileNotFoundException{
        super(rutaCrear);
        if (tipo.equals("A")) {
            cantidadDeArchivos = cantidad;
            crearArchivos(nombreDefecto);
            return;
        }
        if (tipo.equals("C")) {
            cantidadDeArchivos = cantidad;
            crearCarpetas(nombreDefecto);
        }
    }

    public void crearArchivos() {
        for (int i = 0; i < cantidadDeArchivos; i++) {
            String nombreArchivo = rutaArchivos + "/" +getNombreCarpeta(rutaArchivos) +
                  " " + i  + ".txt";
            try (BufferedWriter lista = new BufferedWriter(new FileWriter(nombreArchivo))){

            }   catch (IOException e) {
                System.out.println("Error en la escritura de los archivos." + e.getMessage());
            }
        }
    }

    public void crearArchivos(String nombreDefecto) {
        for (int i = 0; i < cantidadDeArchivos; i++) {
            String nombreArchivo = rutaArchivos + "/" + nombreDefecto + " " +
                    i  + ".txt";
            try (BufferedWriter lista = new BufferedWriter(new FileWriter(nombreArchivo))){

            }   catch (IOException e) {
                System.out.println("Error en la escritura de los archivos." + e.getMessage());
            }
        }
    }

    public void crearCarpetas() {
        for (int i = 0; i < cantidadDeArchivos; i++) {
            File nuevaCarpeta = new File(rutaArchivos + "/Nueva Carpeta " + i);
            if (sobreescritura(nuevaCarpeta)) {
                continue;
            }
            nuevaCarpeta.mkdir();
        }
    }

    public void crearCarpetas(String nombreDefecto) {
        for (int i = 0; i < cantidadDeArchivos; i++) {
            File nuevaCarpeta = new File(rutaArchivos + "/" + nombreDefecto + " " + i);
            if (sobreescritura(nuevaCarpeta)) {
                continue;
            }
            nuevaCarpeta.mkdir();
        }
    }

    public void crearCarpetas(String[] carpetasAnidadas) {
        StringBuilder estructura = new StringBuilder(rutaArchivos);
        for (String carpetas : carpetasAnidadas) {
            estructura.append("/").append(carpetas);
        }
        File nuevaCarpeta = new File(String.valueOf(estructura));
        nuevaCarpeta.mkdirs();
    }

    public void elementosACrear() {
        // Aquí los elementos creados lo hacen con un nombre por defecto.
        System.out.println("¿Qué desea crear? Ingrese el número de la opción:");
        System.out.println("\t1- Archivos\n\t2- Carpetas\n\t3- Archivos y carpetas");
        int opción = scanner.nextInt();

        switch (opción) {
            case 1:
                System.out.println("\t¿Cuántos archivos desea crear?");
                cantidadDeArchivos = scanner.nextInt();
                scanner.nextLine(); // Se come el salto de línea.
                //Podría preguntar si quiere poner nombre por defecto, pero lo asumiré.
                System.out.println("\tNombre: ");
                nombrePorDefecto = scanner.nextLine();
                crearArchivos(nombrePorDefecto);
                break;
            case 2:
                System.out.println("\t¿Cuántas carpetas desea crear?");
                cantidadDeArchivos = scanner.nextInt();
                scanner.nextLine();
                System.out.println("\tNombre: ");
                nombrePorDefecto = scanner.nextLine();
                crearCarpetas(nombrePorDefecto);
                break;
            case 3:
                System.out.println("\t¿Cuántos archivos desea crear?");
                cantidadDeArchivos = scanner.nextInt();
                scanner.nextLine();
                System.out.println("\tNombre: ");
                nombrePorDefecto = scanner.nextLine();
                crearArchivos(nombrePorDefecto);

                System.out.println("\t¿Cuántas carpetas desea crear?");
                cantidadDeArchivos = scanner.nextInt();
                scanner.nextLine();
                System.out.println("\tNombre: ");
                nombrePorDefecto = scanner.nextLine();
                crearCarpetas(nombrePorDefecto);
                break;
        }
    }
}
