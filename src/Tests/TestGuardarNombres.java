package Tests;
// Para probar la clase GuardarNombres.
import Logic.GuardarNombres.GuardarNombres;
import java.io.*;

public class TestGuardarNombres {
    public static void main(String[] args) throws IOException{
        String ruta = "/home/angel/Documentos/ESCUELA/FASE 2/Master File Manager/src/Laboratorio/SalaDos/";
        String ruta2 = "/home/angel/Documentos/Universidad/Autoestudio/Java/Best Java";
        GuardarNombres gn = new GuardarNombres(ruta2, ruta);
        //gn.crearLista();
        System.out.println(gn.getNombreCarpeta(ruta));

    }
}
