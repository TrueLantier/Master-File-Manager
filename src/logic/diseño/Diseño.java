package logic.diseño;

import java.io.*;
import java.util.Scanner;

public abstract class Diseño {
    protected String rutaArchivos;
    protected boolean stop = false;
    protected int cantidadDeElementos;
    protected File carpeta ;
    protected File[] elementos;
    protected Scanner scanner = new Scanner(System.in);

    public Diseño(String ruta) throws FileNotFoundException {
        if (rutaVálida(ruta)) {
            rutaArchivos = ruta;
        }
    }

    public boolean rutaVálida(String ruta) throws FileNotFoundException{
        carpeta = new File(ruta);

        if (!carpeta.exists()) {
            throw new FileNotFoundException("ERROR: La ruta no existe.");
        }
        if (!carpeta.canWrite() || !carpeta.canRead()) {
            throw new FileNotFoundException("ERROR: No hay permisos de escritura o lectura en el directorio actual.");
        }
        return true;
    }

    public String getNombreArchivo() {
        return carpeta.getName();
    }

    @Deprecated // En Windows causaría problemas el '/'. Mejor usar getName()
    public String getNombreCarpeta(String ruta) {
        StringBuilder nombreCarpeta = new StringBuilder();

        for (int i = ruta.length()-1; ; i--) {
            char charActual = ruta.charAt(i);
            if (charActual == '/') break;
            nombreCarpeta.append(charActual);
        }
        return nombreCarpeta.reverse().toString();
    }

    public boolean sobreescritura(File archivo) {
        if (archivo.exists()) {
            while (true) {
                String tipoArchivo = archivo.toString().contains("txt") ? "archivo" : "carpeta";
                System.out.println(tipoArchivo + " ya existe. ¿Deseas sobreescribir igualmente? 's/n'");
                String sobreescribir = scanner.nextLine().trim().toLowerCase();

                if (sobreescribir.equals("s")) { return false; }
                if (sobreescribir.equals("n")) { return true; }

                System.out.println("Entrada incorrecta. Reintente");
            }
        }
        return false;
    }

    public boolean carpetaVacía(){
        elementos = carpeta.listFiles();
        return elementos == null || elementos.length == 0;
        // Una carpeta existente pero vacía devolverá un File[0], que es diferente de null.
    }

//    public boolean carpetaVacía(File[] ){
//        return elementos == null || elementos.length == 0;
//    }
}