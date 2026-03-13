package tests;
// Para probar la clase GuardarNombres.

import logic.guardarnombres.GuardarNombres;

import java.io.*;

public class TestGuardarNombres {
    public static void main(String[] args) throws IOException{
        String ruta = "/home/angel/Documentos/ESCUELA/FASE 2/Master File Manager/src/Laboratorio/SalaDos/";
        String ruta2 = "/home/angel/Documentos/Universidad/Autoestudio/Java/Best Java";
        String ruta3 = "/home/angel/Documentos/Universidad/Autoestudio/Java";
        String ruta4 = "/home/angel/Documentos/ESCUELA/FASE 2/Master File Manager/src/Laboratorio/SalaDos";
        String rutaVacía = "/home/angel/Vídeos/proxy";
        //GuardarNombres gn1 = new GuardarNombres(ruta2, ruta, "Java");
        GuardarNombres gn2 = new GuardarNombres(rutaVacía);
        //gn.crearLista();

    }
}
