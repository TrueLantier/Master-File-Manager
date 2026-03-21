package tests;
// Para Probar la clase EliminarArchivos.

import logic.eliminararchivos.EliminarArchivos;
import java.io.*;

public class TestEliminarArchivos {
    public static void main(String[] args) throws IOException {
        String ruta = "/home/angel/Documentos/ESCUELA/FASE 2/Master File Manager/src/laboratorio/salados";
        String ruta2 = "/home/angel/Documentos/ESCUELA/FASE 2/Master File Manager/src/laboratorio/salados/angel 0.txt";
        String[] archivos = { "0", "1", "2"};

        EliminarArchivos ea = new EliminarArchivos(ruta, archivos);

    }
}
