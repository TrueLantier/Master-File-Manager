package Logic.GuardarNombres;

import java.io.*;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GuardarNombres {
    String rutaArchivos;
    String rutaDeGuardado = "src/Logic/GuardarNombres/Listas/";
    File carpeta ;
    File[] elementos;
    List<String> nombresArchivos;
    Locale locale = Locale.getDefault();
    Collator collator = Collator.getInstance(locale);

    /*
     Formas de pasar la ruta:
     1- Pedir la ruta por teclado y analizar con Scanner u otro método.
     2- Pasar la ruta como argumento de línea de comandos.
     */

    public GuardarNombres(String rutaNombres) throws FileNotFoundException{
        if (rutaVálida(rutaNombres)) {
            rutaArchivos = rutaNombres;
        }
        copiarArchivos();
        crearLista();
    }

    public boolean rutaVálida(String rutaNombres) throws FileNotFoundException{
        carpeta = new File(rutaNombres);

        if (!carpeta.exists()) {
            System.out.println("La ruta no existe.");
            throw new FileNotFoundException();
        }
        if (!carpeta.isDirectory()) {
            System.out.println("La ruta no es una carpeta.");
            throw new FileNotFoundException();
        }
        return true;
    }

    public String getNombreCarpeta(String rutaNombres) {
        StringBuilder nombreCarpeta = new StringBuilder();

        for (int i = rutaNombres.length()-1; ; i--) {
            char charActual = rutaNombres.charAt(i);
            if (charActual == '/') break;
            nombreCarpeta.append(charActual);
        }
        return nombreCarpeta.reverse().toString();
    }

    public void copiarArchivos() {
        elementos = carpeta.listFiles();
        if (elementos == null) {
            // Más adelante se pueden separar estas condiciones.
            System.out.println("Carpeta vacía o no se pueden leer los permisos.");
            return;
        }

        nombresArchivos = new ArrayList<>();
        for (File elemento: elementos) {
            if (elemento.isFile()) {
                nombresArchivos.add(elemento.getName());
            }
        }

        collator.setStrength(Collator.TERTIARY);
        nombresArchivos.sort(collator);
    }

    public void crearLista() {
        String nombreLista = rutaDeGuardado + getNombreCarpeta(rutaArchivos) + ".txt";
        try (BufferedWriter lista = new BufferedWriter(new FileWriter(nombreLista))){
            // new FileWriter(nombreLista,true); // Para agregar al final del archivo sin sobreescribir.
            for (String elemento: nombresArchivos) {
                lista.write(elemento);
                lista.newLine();
                //lista.write("\n");
            }

        }   catch (IOException e) {
            System.out.println("Error escribiendo la lista." + e.getMessage());
        }
    }
}
