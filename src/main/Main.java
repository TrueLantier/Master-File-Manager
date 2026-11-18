package main;

import nio.NioEliminar.NioEliminar;
import nio.crear.NioCrearArchivo;
import nio.crear.NioCrearCarpeta;
import nio.guardarnombres.NioGuardarNombres;
import nio.manejoerrores.MensajesError;
import nio.manejoerrores.RegistroErrores;
import java.io.IOException;

public class Main {
    static void main(String[] args) throws IOException {
        String ruta1 = "/home/angel/Documentos/ESCUELA/FASE 2/Master File Manager/src/laboratorio/salados";
        String ruta2 = "/home/angel/Documentos/ESCUELA/FASE 2/Master File Manager/src/laboratorio/salados/22";
        String ruta3 = "/home/angel/Documentos/ESCUELA/FASE 2/Master File Manager/src/laboratorio";
        String[] nombres = { "1", "2", "3"};


        NioEliminar.eliminarTodo(ruta2);
        MensajesError.mostrarErrores();
    }
}
