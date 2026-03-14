package tests;
// Para probar la clase CrearArchivos.

import logic.gestorcreador.*;

import java.io.*;

public class TestGestorCreador {
    public static void main(String[] args) throws FileNotFoundException {
        String[] carpetas = { "Programación", "Herencia", "Polimorfismo" };
        String ruta = "/home/angel/Documentos/ESCUELA/FASE 2/Master File Manager/src/laboratorio/salados";
        String ruta2 = "";

        CrearArchivos ca1 = new CrearArchivos(ruta, 2);
        CrearArchivos ca2 = new CrearArchivos(ruta, 2, "angel");
        CrearArchivos ca3 = new CrearArchivos(ruta, carpetas);

        CrearCarpetas cp1 = new CrearCarpetas(ruta, 2);
        CrearCarpetas cp2 = new CrearCarpetas(ruta, 2, "java");
        CrearCarpetas cp3 = new CrearCarpetas(ruta, carpetas, true);

    }
}
