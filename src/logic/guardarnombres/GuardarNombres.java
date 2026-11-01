package logic.guardarnombres;

import logic.diseño.Diseño;
import java.io.*;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GuardarNombres extends Diseño {
    String rutaDeGuardado = "src/logic/guardarnombres/listas/";
    File fileRutaGuardado;
    File[] elementosAGuardar;
    List<String> nombresArchivos;
    Locale locale = Locale.getDefault();
    Collator collator = Collator.getInstance(locale);

    public GuardarNombres(String rutaNombres) throws FileNotFoundException{
        super(rutaNombres);
        copiarNombreArchivos();
    }

    public GuardarNombres(String rutaNombres, String rutaDeGuardado) throws FileNotFoundException{
        super(rutaNombres);
        if (rutaVálida(rutaDeGuardado)) {
            carpeta = new File(rutaNombres);
            this.rutaDeGuardado = rutaDeGuardado;
            copiarNombreArchivos();
        }
    }

    public GuardarNombres(String rutaNombres, String rutaDeGuardado, String nombre) throws FileNotFoundException {
        super(rutaNombres);
        if (rutaVálida(rutaDeGuardado)) {
            carpeta = new File(rutaNombres);
            this.rutaDeGuardado = rutaDeGuardado;
            copiarNombreArchivos(nombre);
        }
    }

    public void copiarNombreArchivos() {
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
        crearLista();
    }

    public void copiarNombreArchivos(String nombre) {
        if (carpetaVacía()) {
            System.out.println("Carpeta vacía. No hay elementos para guardar.");
            return;
        }

        nombresArchivos = new ArrayList<>();
        for (File elemento: elementos) {
            if (elemento.isFile()) {
                if (elemento.getName().contains(nombre)) {
                    nombresArchivos.add(elemento.getName());
                }
            }
        }

        collator.setStrength(Collator.TERTIARY);
        nombresArchivos.sort(collator);
        crearLista();
    }

    public void crearLista() {
        String nombreLista = rutaDeGuardado + getNombreDirectorio() + ".txt";
        try (BufferedWriter lista = new BufferedWriter(new FileWriter(nombreLista))){
            // new FileWriter(nombreLista,true); // Para agregar al final del archivo sin sobreescribir.
            for (String elemento: nombresArchivos) {
                lista.write(elemento);
                lista.newLine();
                //lista.write("\n");
            }

        }   catch (IOException e) {
            System.out.println("Error escribiendo la lista. -> " + e.getMessage());
        }
    }
}
