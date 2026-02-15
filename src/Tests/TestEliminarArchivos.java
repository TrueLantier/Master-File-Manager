package Tests;
// Para Probar la clase EliminarArchivos.
import Logic.EliminarArchivos.EliminarArchivos;

import java.io.FileNotFoundException;

public class TestEliminarArchivos {
    public static void main(String[] args) throws FileNotFoundException {
        String ruta = "/home/angel/Documentos/ESCUELA/FASE 2/Master File Manager/src/Laboratorio/SalaDos";

        EliminarArchivos ea = new EliminarArchivos(ruta);
    }
}
