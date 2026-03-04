package Logic.GuardarNombres;

import Logic.Diseño.Diseño;

import java.io.*;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GuardarNombres extends Diseño {
    String rutaDeGuardado = "src/Logic/GuardarNombres/Listas/";
    List<String> nombresArchivos;
    Locale locale = Locale.getDefault();
    Collator collator = Collator.getInstance(locale);

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
        if (carpetaVacía()) {
            System.out.println("Carpeta vacía. No hay elementos para guardar.");
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
            System.out.println("Error escribiendo la lista. " + e.getMessage());
        }
    }
}
