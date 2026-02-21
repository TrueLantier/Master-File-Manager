package Tests;
// Para probar la clase CrearArchivos.
import Logic.CrearArchivos.CrearArchivos;

import java.io.*;

public class TestCrearArchivos {
    public static void main(String[] args) throws FileNotFoundException {
        String ruta = "/home/angel/Documentos/ESCUELA/FASE 2/Master File Manager/src/Laboratorio/SalaDos";
        String ruta2 = "";
        CrearArchivos ca = new CrearArchivos(ruta, "C", 2);
        //System.out.println(ca.getNombreCarpeta(ruta));

    }
}
