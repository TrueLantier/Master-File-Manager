package tests;
// Para probar la clase CrearArchivos.

import logic.creararchivos.CrearArchivos;

import java.io.*;

public class TestCrearArchivos {
    public static void main(String[] args) throws FileNotFoundException {
        String[] carpetas = { "Programación", "Herencia", "Polimorfismo" };
        String ruta = "/home/angel/Documentos/ESCUELA/FASE 2/Master File Manager/src/Laboratorio/SalaDos";
        String ruta2 = "";
        //CrearArchivos ca1 = new CrearArchivos(ruta);
        //CrearArchivos ca2 = new CrearArchivos(ruta, carpetas, false);
        CrearArchivos ca3 = new CrearArchivos(ruta, "C", 3); // Nombre por defecto.
        //CrearArchivos ca4 = new CrearArchivos(ruta, "C", 3, "angel"); // Nombre personalizado.
    }
}
