package Tests;

import Logic.CrearArchivos.CrearArchivos;

import java.io.FileNotFoundException;

public class TestCrearArchivos {
    public static void main(String[] args) throws FileNotFoundException {
        String ruta = "/home/angel/Documentos/ESCUELA/FASE 2/Master File Manager/src/Laboratorio/SalaDos";
        CrearArchivos ca = new CrearArchivos(ruta, 5);
        System.out.println(ca.getNombreCarpeta(ruta));
    }
}
