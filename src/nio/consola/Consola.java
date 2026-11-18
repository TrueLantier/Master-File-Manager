package nio.consola;

import nio.Operaciones;
import java.util.Locale;
import java.util.Scanner;

public class Consola {
    private static final Scanner ENTRADA = new Scanner(System.in);

    public static String consolaSobrescribir(Operaciones operaciones) {
        String elección = "";

        while (true) {
            System.out.println();
            switch (operaciones) {
                case CREAR_CARPETA -> {
                    System.out.println("La carpeta que desea crear ya existe. ¿Desea sobrescribir? (s/n):");
                }
                case CREAR_ARCHIVO -> {
                    System.out.println("El archivo que desea crear ya existe. ¿Desea sobrescribir? (s/n):");
                }
                case GUARDAR_NOMBRES -> {
                    System.out.println("Ya existe un archivo de guardado de nombres. ¿Desea sobrescribir? (s/n):");
                }
                case COPIAR -> {
                    System.out.println("El archivo/carpeta que desea copiar ya existe. ¿Desea sobrescribir? (s/n):");
                }
                case MOVER -> {
                    System.out.println("El archivo/carpeta que desea mover ya existe. ¿Desea sobrescribir? (s/n):");
                }
                case RENOMBRAR -> {
                    System.out.println("El archivo/carpeta que desea renombrar ya existe. ¿Desea sobrescribir? (s/n):");
                }
                case BUSCAR_DUPLICADOS -> {
                }
            }

            System.out.println("Agregue 'p' a la respuesta si desea establecer esta opción por defecto" +
                    " al resto de elementos. Ejemplo: 'sp'");
            elección = ENTRADA.nextLine();
            elección = elección.trim().toLowerCase(Locale.ROOT);

            if (elección.equals("s") || elección.equals("n") || elección.equals("sp") || elección.equals("np")) {
                break;
            }

            System.out.println("Entrada incorrecta. Reintente."); // \n
        }

        return elección;
    }


}
