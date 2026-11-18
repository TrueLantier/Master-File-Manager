package nio.guardarnombres;

import nio.Operaciones;
import nio.manejoerrores.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class NioGuardarNombres {
    private static String rutaDeGuardado = "src/nio/guardarnombres/listas";
    private static String nombrePadre;
    private static final String OPERACIÓN = "Guardar nombres";
    private static final Locale locale = Locale.getDefault();
    private static final Collator collator = Collator.getInstance(locale);
    private static List<String> nombresArchivos;

    public static void guardarNombres(String rutaNombres) throws IOException {
        if (Validador.validar(rutaNombres, Operaciones.GUARDAR_NOMBRES)) {
            return;
        }

        Path path = Path.of(rutaNombres);
        nombrePadre = path.getFileName().toString();
        copiarNombresArchivos(path);
    }

    public static void guardarNombres(String rutaNombres, boolean objetivo, String nombre) throws IOException {
        if (Validador.validar(rutaNombres, Operaciones.GUARDAR_NOMBRES)) {
            return;
        }
        Path path = Path.of(rutaNombres);
        nombrePadre = path.getFileName().toString();
        copiarNombresArchivos(path, nombre);
    }

    public static void guardarNombres(String rutaNombres, String rutaGuardado) throws IOException{
        if (Validador.validar(rutaNombres, Operaciones.GUARDAR_NOMBRES)) {
            return;
        }
        if (Validador.validar(rutaGuardado, Operaciones.GUARDAR_NOMBRES)) {
            return;
        }
        rutaDeGuardado = rutaGuardado;
        Path path = Path.of(rutaNombres);
        nombrePadre = path.getFileName().toString();
        copiarNombresArchivos(path);
    }

    public static void guardarNombres(String rutaNombres, String rutaGuardado, boolean objetivo, String nombre) throws IOException{
        if (Validador.validar(rutaNombres, Operaciones.GUARDAR_NOMBRES)) {
            return;
        }
        if (Validador.validar(rutaGuardado, Operaciones.GUARDAR_NOMBRES)) {
            return;
        }
        rutaDeGuardado = rutaGuardado;
        Path path = Path.of(rutaNombres);
        nombrePadre = path.getFileName().toString();
        copiarNombresArchivos(path, nombre);
    }

    private static void copiarNombresArchivos(Path path) throws IOException{ // Copiar todo.
        if (Validador.estáVacío(path, Operaciones.GUARDAR_NOMBRES)) {
            System.out.println("hola");
            return;
        }

        nombresArchivos = new ArrayList<>();

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)){
            for (Path nombres: stream) {
                nombresArchivos.add(nombres.getFileName().toString());
            }
            collator.setStrength(Collator.TERTIARY);
            nombresArchivos.sort(collator);
            crearLista();
        } catch (IOException e) {
            // Por ver.
        }
    }

    private static void copiarNombresArchivos(Path path, String nombreObjetivo) throws IOException{
        if (Validador.estáVacío(path, Operaciones.GUARDAR_NOMBRES)) {
            return;
        }

        nombresArchivos = new ArrayList<>();

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)){
            for (Path nombres: stream) {
                if (nombres.getFileName().toString().contains(nombreObjetivo)) {
                    nombresArchivos.add(nombres.getFileName().toString());
                }

            }
            collator.setStrength(Collator.TERTIARY);
            nombresArchivos.sort(collator);
            crearLista();
        } catch (IOException e) {
            // Por ver.
        }
    }

    private static void crearLista() {
        String nombreLista = rutaDeGuardado + File.separator + nombrePadre + ".txt";
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
