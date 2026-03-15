package logic.gestorcreador;

import logic.diseño.Diseño;
import java.io.*;

public class CrearArchivos extends Diseño implements GestorCreador{

    public CrearArchivos(String rutaCrear, int cantidad) throws FileNotFoundException{
        super(rutaCrear);
        cantidadDeElementos = cantidad;
        crear();
    }

    public CrearArchivos(String rutaCrear, int cantidad, String nombrePorDefecto) throws FileNotFoundException{
        super(rutaCrear);
        cantidadDeElementos = cantidad;
        crear(nombrePorDefecto);
    }

    public CrearArchivos(String rutaCrear, String[] nombres) throws FileNotFoundException {
        super(rutaCrear);
        cantidadDeElementos = nombres.length;
        crear(nombres);
    }

    @Override
    public void crear() {
        for (int i = 0; i < cantidadDeElementos; i++) {
            String nombreArchivo = rutaArchivos + File.separator +getNombreArchivo() +
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

    @Override
    public void crear(String nombrePorDefecto) {
        for (int i = 0; i < cantidadDeElementos; i++) {
            String nombreArchivo = rutaArchivos + File.separator + nombrePorDefecto + " " +
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

    public void crear(String[] nombres) {
        for (String nombre : nombres) {
            String nombreArchivo = rutaArchivos + File.separator + nombre + ".txt";

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

    // Ver qué hacer con esto después.
    public void elementosACrear() {
        String nombrePorDefecto;
        System.out.println("\t¿Qué desea crear? Ingrese el número de la opción:");
        System.out.println("\t1- Archivos\n\t2- Carpetas\n\t3- Archivos y carpetas\n\t4- Carpetas anidadas");
        int opción = scanner.nextInt();

        switch (opción) {
            case 1:
                System.out.println("\t¿Cuántos archivos desea crear?");
                cantidadDeElementos = scanner.nextInt();
                scanner.nextLine(); // Se come el salto de línea.
                //Podría preguntar si quiere poner nombre por defecto, pero lo asumiré.
                System.out.println("\tNombre: ");
                nombrePorDefecto = scanner.nextLine();
                crear(nombrePorDefecto);
                break;
            case 2:
                System.out.println("\t¿Cuántas carpetas desea crear?");
                cantidadDeElementos = scanner.nextInt();
                scanner.nextLine();
                System.out.println("\tNombre: ");
                nombrePorDefecto = scanner.nextLine();
                //crearCarpetas(nombrePorDefecto);
                break;
            case 3:
                System.out.println("\t¿Cuántos archivos desea crear?");
                cantidadDeElementos = scanner.nextInt();
                scanner.nextLine();
                System.out.println("\tNombre: ");
                nombrePorDefecto = scanner.nextLine();
                //crearArchivos(nombrePorDefecto);

                System.out.println("\t¿Cuántas carpetas desea crear?");
                cantidadDeElementos = scanner.nextInt();
                scanner.nextLine();
                System.out.println("\tNombre: ");
                nombrePorDefecto = scanner.nextLine();
                //crearCarpetas(nombrePorDefecto);
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
