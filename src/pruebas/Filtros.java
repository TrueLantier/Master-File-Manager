package pruebas;
import java.io.*;

public class Filtros {
    public static void main(String[] args) {
        String ruta = "src/Laboratorio/SalaDos";
        ruta.startsWith("a");

        // FileFilter: solo archivos .txt
        File directorio = new File(ruta);
        File[] archivos_txt = directorio.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isFile() && file.getName().endsWith(".txt");
            }
        });

        // FilenameFilter: solo archivos .txt (usando nombre)
        String[] nombres_txt = directorio.list(new FilenameFilter() {
            @Override
            public boolean accept(File file, String s) {
                return s.endsWith(".txt");
            }
        });

        // Clase separada que implementa FileFilter
        File[] archivosTxt = directorio.listFiles(new Filtro_txt());

        for (String file: nombres_txt) {
            System.out.println(file);
        }
        System.out.println();
        for (File file: archivosTxt) {
            System.out.println(file.getName());
        }
    }
}

class Filtro_txt implements FileFilter{
    @Override
    public boolean accept(File archivo) {
        return archivo.isFile() && archivo.getName().toLowerCase().endsWith(".txt");
    }
}
