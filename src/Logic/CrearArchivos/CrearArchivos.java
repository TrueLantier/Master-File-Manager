package Logic.CrearArchivos;

import Logic.Diseño.Diseño;

import java.io.*;

public class CrearArchivos extends Diseño {
    private int cantidadDeArchivos;

    public CrearArchivos(String rutaCrear) throws FileNotFoundException{ // Constructor más completo.
        super(rutaCrear);
        elementosACrear();
    }

    public CrearArchivos(String rutaCrear, String[] archivos) throws FileNotFoundException {
        super(rutaCrear);
        crearArchivos(archivos);
    }

    public CrearArchivos(String rutaCrear, String[] carpetas, boolean anidar) throws FileNotFoundException {
        super(rutaCrear);
        crearCarpetas(carpetas, anidar);
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

            File nuevoArchivo = new File(nombreArchivo);
            if (sobreescritura(nuevoArchivo)) {
                continue;
            }

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

            File nuevoArchivo = new File(nombreArchivo);
            if (sobreescritura(nuevoArchivo)) {
                continue;
            }

            try (BufferedWriter lista = new BufferedWriter(new FileWriter(nombreArchivo))){

            }   catch (IOException e) {
                System.out.println("Error en la escritura de los archivos." + e.getMessage());
            }
        }
    }

    public void crearArchivos(String[] nombres) {
        for (String nombre : nombres) {
            String nombreArchivo = rutaArchivos + "/" + nombre + ".txt";

            File nuevoArchivo = new File(nombreArchivo);
            if (sobreescritura(nuevoArchivo)) {
                continue;
            }

            try (BufferedWriter lista = new BufferedWriter(new FileWriter(nombreArchivo))) {

            } catch (IOException e) {
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

    public void crearCarpetas(String[] nombres, boolean anidar) {
        if (anidar) {
            StringBuilder estructura = new StringBuilder(rutaArchivos);
            for (String nombre : nombres) {
                estructura.append("/").append(nombre);
            }
            File nuevaCarpeta = new File(String.valueOf(estructura));
            if (sobreescritura(nuevaCarpeta)) return;
            nuevaCarpeta.mkdirs();
            return;
        }

        for (int i = 0; i < nombres.length; i++) {
            File nuevaCarpeta = new File(rutaArchivos + "/" + nombres[i]);
            if (sobreescritura(nuevaCarpeta)) {
                continue;
            }
            nuevaCarpeta.mkdir();
        }
    }

    public void elementosACrear() {
        String nombrePorDefecto;
        System.out.println("\t¿Qué desea crear? Ingrese el número de la opción:");
        System.out.println("\t1- Archivos\n\t2- Carpetas\n\t3- Archivos y carpetas\n\t4- Carpetas anidadas");
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
            case 4:
                System.out.println("\t¿Cuántas carpetas anidadas desea crear?");
                int num = scanner.nextInt();
                scanner.nextLine(); // Se come el salto de línea.
                String[] nombres = new String[num];
                System.out.println("\tEscriba los nombres de las carpetas en orden de anidación:");
                for (int i = 0; i < num; i++) {
                    nombres[i] = scanner.nextLine();
                }

                StringBuilder estructura = new StringBuilder(rutaArchivos);
                for (String nombre : nombres) {
                    estructura.append("/").append(nombre);
                }
                File nuevaCarpeta = new File(String.valueOf(estructura));
                if (sobreescritura(nuevaCarpeta)) return;
                nuevaCarpeta.mkdirs();
                break;
        }
    }
}
