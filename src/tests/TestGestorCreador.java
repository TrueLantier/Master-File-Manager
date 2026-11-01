package tests;
// Para probar la clase CrearArchivos.

import logic.gestorcreador.*;
import java.io.*;

public class TestGestorCreador {
    static void main(String[] args) throws Exception {
        String[] carpetas = { "Programación", "Herencia", "Polimorfismo" };
        String[] carpetas2 = { "A", "B", "C" };
        String ruta = "/home/angel/Documentos/ESCUELA/FASE 2/Master File Manager/src/laboratorio/salados";
        String ruta2 = "/home/angel/Documentos/ESCUELA/FASE 2/Master File Manager/src/laboratorio/salados/Java 1";
        String ruta3 = "/home/angel/Documentos/ESCUELA/FASE 2/Master File Manager/src/" +
                "laboratorio/salados/java 0/java 0";

        CrearArchivos ca1 = new CrearArchivos(ruta2, "Java", 2, 4);
        CrearArchivos ca2 = new CrearArchivos(ruta2, 2, 2);
        CrearArchivos ca3 = new CrearArchivos(ruta2, carpetas, 1);

        CrearCarpetas cp1 = new CrearCarpetas(ruta2, 4);
        CrearCarpetas cp2 = new CrearCarpetas(ruta2, 4, "Java");
        CrearCarpetas cp3 = new CrearCarpetas(ruta2, carpetas2, false);
    }
}
