package Pruebas;
import Logic.GuardarNombres.GuardarNombres;
import java.io.*;
import java.util.*;

public class PruebasUno {
    public static void main(String[] args) throws IOException{
        String ruta = "/home/angel/Documentos/ESCUELA/FASE 2/Master File Manager/src/Laboratorio/SalaUno";
        GuardarNombres gn = new GuardarNombres(ruta);
        //gn.crearLista();
        System.out.println(gn.nombresArchivos);
        System.out.println(gn.getNombreCarpeta(ruta));

    }
}
