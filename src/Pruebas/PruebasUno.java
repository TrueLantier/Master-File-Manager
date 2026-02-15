package Pruebas;
import Logic.GuardarNombres.GuardarNombres;
import java.io.*;
import java.util.*;

public class PruebasUno {
    public static void main(String[] args) throws IOException{
        String ruta = "/home/angel/Documentos/ESCUELA/FASE 2/Master File Manager/src/Laboratorio/SalaUno";
        String ruta2 = "/home/angel/Documentos/Universidad/Autoestudio/Java/Best Java";
        GuardarNombres gn = new GuardarNombres(ruta2);
        //gn.crearLista();
        System.out.println(gn.getNombreCarpeta(ruta));

    }
}
