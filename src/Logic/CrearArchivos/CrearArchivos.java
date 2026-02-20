package Logic.CrearArchivos;
/*
  Esta clase recibe un directorio. Verifica que existe.
  Luego da la posibilidad de crear archivos o carpetas.
  Los crea según la cantidad especificada.
  Esta clase también se puede hacer con más métodos y constructores.
 */

import Logic.Diseño.Diseño;

import java.io.*;

public class CrearArchivos extends Diseño {
    int cantidadDeArchivos;
    String nombrePorDefecto;
    String tipoDeArchivo;

    public CrearArchivos(String rutaCrear) throws FileNotFoundException{
        super(rutaCrear);
        elementosACrear();
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
            return;
        }
    }

    public void crearArchivos() {
        for (int i = 0; i < cantidadDeArchivos; i++) {
            String nombreArchivo = rutaArchivos + "/" +getNombreCarpeta(rutaArchivos) +
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
            nuevaCarpeta.mkdir();
        }
    }

    public void elementosACrear() {
        System.out.println("¿Qué desea crear? Ingrese el número de la opción:");
        System.out.println("\t1- Archivos\n\t2- Carpetas\n\t3- Archivos y carpetas");
        int opción = scanner.nextInt();

        switch (opción) {
            case 1:
                System.out.println("\t¿Cuántos archivos desea crear?");
                cantidadDeArchivos = scanner.nextInt();
                System.out.println("\t¿Desea crearlos con un nombre por defecto?");
                nombrePorDefecto = scanner.nextLine();
                crearArchivos();
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }
}
