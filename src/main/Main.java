package main;

import nio.*;
import nio.copiarmover.NioMover;
import nio.crear.NioCrearArchivo;
import nio.manejoerrores.MensajesError;
import nio.renombrar.NioRenombrar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    static void main(String[] args) throws IOException {
        String ruta1 = "/home/angel/Documentos/ESCUELA/FASE 2/Master File Manager/src/laboratorio/salados";
        String ruta2 = "/home/angel/Documentos/ESCUELA/FASE 2/Master File Manager/src/laboratorio/salados/22";
        String ruta3 = "/home/angel/Documentos/ESCUELA/FASE 2/Master File Manager/src/laboratorio";
        String ruta4 = "/home/angel/Documentos/ESCUELA/FASE 2/Master File Manager/src/laboratorio/salados/33";
        String ruta5 = "/home/angel/Documentos/Mangas/Solo Leveling";
        String[] nombres = { "1", "2", "3"};


        NioRenombrar.renombrarMangas(ruta5);

        MensajesError.mostrarErrores();
    }
}
