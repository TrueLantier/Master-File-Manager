package main;

import nio.crear.NioCrearCarpeta;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String ruta1 = "/home/angel/Documentos/ESCUELA/FASE 2/Master File Manager/src/laboratorio/salados/Java 1";
        String ruta2 = "/home/angel/Documentos/ESCUELA/FASE 2/Master File Manager/src/laboratorio/salados/Java 2";
        String[] nombres = { "1", "2", "3"};
        String[] nombres2 = { "11", "22", "33"};


        NioCrearCarpeta.crearCarpeta(ruta1, nombres, true);
        NioCrearCarpeta.crearCarpeta(ruta1, nombres2, false);
    }
}
