package Tests;
// Para Probar la clase EliminarArchivos.
import Logic.EliminarArchivos.EliminarArchivos;

import java.io.*;

public class TestEliminarArchivos {
    public static void main(String[] args) throws FileNotFoundException {
        String ruta = "/home/angel/Documentos/ESCUELA/FASE 2/Master File Manager/src/Laboratorio/SalaDos";
        String ruta2 = "/home/angel/Documentos/ESCUELA/FASE 2/Master File Manager/src/Laboratorio/SalaDos/angel 0.txt";

        EliminarArchivos ea = new EliminarArchivos(ruta, ".txt");
    }
}
