package Logic.GuardarNombres;
/*
  Esta clase recibe una ruta de un directorio.
  Luego lista todos los archivos(no carpetas).
  Los guarda en un List<String> y los copia en un .txt en la ruta designada.
 */

import Logic.Diseño.Diseño;

import java.io.*;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GuardarNombres extends Diseño {
    String rutaDeGuardado = "src/Logic/GuardarNombres/Listas/"; // Posible modificación.
    List<String> nombresArchivos;
    Locale locale = Locale.getDefault();
    Collator collator = Collator.getInstance(locale);

    // Implementar que se pueda restringir la cantidad de archivos a copiar en la lista. *
    // No lista las carpetas. *
    public GuardarNombres(String rutaNombres) throws FileNotFoundException{
        super(rutaNombres);
        copiarArchivos();
        crearLista();
    }

    public GuardarNombres(String rutaNombres, String rutaGuardado) throws FileNotFoundException{
        super(rutaNombres);
        rutaDeGuardado = rutaGuardado;
        copiarArchivos();
        crearLista();
    }

    public void copiarArchivos() {
        elementos = carpeta.listFiles();
        if (elementos == null) {
            // Más adelante se pueden separar estas condiciones.
            System.out.println("Carpeta vacía o no se puede leer por los permisos.");
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
