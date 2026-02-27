package Tests;
// Para probar la clase CrearArchivos.
import Logic.CrearArchivos.CrearArchivos;

import java.io.*;

public class TestCrearArchivos {
    public static void main(String[] args) throws FileNotFoundException {
        String[] carpetas = { "Uno", "Dos", "Tres" };
        String ruta = "/home/angel/Documentos/ESCUELA/FASE 2/Master File Manager/src/Laboratorio/SalaDos";
        String ruta2 = "";
        //CrearArchivos ca1 = new CrearArchivos(ruta);
        //CrearArchivos ca2 = new CrearArchivos(ruta, carpetas);
        CrearArchivos ca3 = new CrearArchivos(ruta, "A", 3);
        CrearArchivos ca4 = new CrearArchivos(ruta, "A", 3, "angel");
        //System.out.println(ca.getNombreCarpeta(ruta));

    }
}
