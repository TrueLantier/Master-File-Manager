package tests;
// Para probar la clase CrearArchivos.

import logic.gestorcreador.*;
import java.io.*;

public class TestGestorCreador {
    static void main(String[] args) throws FileNotFoundException {
        String[] carpetas = { "Programación", "Herencia", "Polimorfismo" };
        String ruta = "/home/angel/Documentos/ESCUELA/FASE 2/Master File Manager/src/laboratorio/salados";
        String ruta2 = "/home/angel/Documentos/ESCUELA/FASE 2/Master File Manager/src/laboratorio/salados/java 1";
        String ruta3 = "/home/angel/Documentos/ESCUELA/FASE 2/Master File Manager/src/" +
                "laboratorio/salados/java 0/java 0";

        CrearArchivos ca1 = new CrearArchivos(ruta2, 2);
        CrearArchivos ca2 = new CrearArchivos(ruta2, 2, "java");
        CrearArchivos ca3 = new CrearArchivos(ruta2, carpetas);

        CrearCarpetas cp1 = new CrearCarpetas(ruta2, 2);
        CrearCarpetas cp2 = new CrearCarpetas(ruta2, 2, "java");
        CrearCarpetas cp3 = new CrearCarpetas(ruta2, carpetas, false);
    }
}
