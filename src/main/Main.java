package main;

import logic.gestorcreador.CrearArchivos;
import nio.crear.NioCrearArchivo;
import nio.crear.NioCrearCarpeta;
import nio.guardarnombres.NioGuardarNombres;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String ruta1 = "/home/angel/Documentos/ESCUELA/FASE 2/Master File Manager/src/laboratorio/salados";
        String ruta2 = "/home/angel/Documentos/ESCUELA/FASE 2/Master File Manager/src/laboratorio/salados";
        String ruta3 = "/home/angel/Documentos/ESCUELA/FASE 2/Master File Manager/src/laboratorio";
        String[] nombres = { "1", "2", "3"};
        String[] nombres2 = { "11", "22", "33"};

        NioGuardarNombres.guardarNombres(ruta1, ruta3);

    }
}
