package tests;
// Para Probar la clase EliminarArchivos.

import logic.eliminararchivos.EliminarArchivos;
import java.io.*;

public class TestEliminarArchivos {
    public static void main(String[] args) throws IOException {
        String ruta = "/home/angel/Documentos/ESCUELA/FASE 2/Master File Manager/src/laboratorio/salados";
        String ruta2 = "/home/angel/Documentos/ESCUELA/FASE 2/Master File Manager/src/laboratorio/salados/Java 1";
        String[] archivos = { "1", "3"};

        EliminarArchivos ea = new EliminarArchivos(ruta2);

    }
}
