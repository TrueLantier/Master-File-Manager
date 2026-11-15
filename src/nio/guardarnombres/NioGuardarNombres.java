package nio.guardarnombres;

import nio.NioDiseño;

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

public class NioGuardarNombres extends NioDiseño {
    private static String rutaDeGuardado = "src/nio/guardarnombres/listas";
    private static String nombrePadre;
    private static final Locale locale = Locale.getDefault();
    private static final Collator collator = Collator.getInstance(locale);
    Path pathNombres;
    private static List<String> nombresArchivos;

    public static void guardarNombres(String rutaNombres) throws IOException {
        validarRuta(rutaNombres);
        Path path = Path.of(rutaNombres);
        nombrePadre = path.getFileName().toString();
        copiarNombresArchivos(path);
    }

    public static void guardarNombres(String rutaNombres, String rutaGuardado) throws IOException{
        validarRuta(rutaNombres);
        validarRuta(rutaDeGuardado);
        rutaDeGuardado = rutaGuardado;
        Path path = Path.of(rutaNombres);

    }

    private static void copiarNombresArchivos(Path path) throws IOException{ // Copiar todo.
        esVacío(path);

        nombresArchivos = new ArrayList<>();

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)){
            for (Path nombres: stream) {
                System.out.println(nombres.getFileName());
                nombresArchivos.add(path.getFileName().toString());

            }
            collator.setStrength(Collator.TERTIARY);
            nombresArchivos.sort(collator);
            crearLista();
        } catch (IOException e) {
            // Por ver.
        }
    }

    public static void crearLista() {
        String nombreLista = rutaDeGuardado + nombrePadre + ".txt";
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
