package main;

import nio.NioEliminar.NioEliminar;
import nio.copiarmover.NioCopiar;
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
        String ruta4 = "/home/angel/Documentos/ESCUELA/FASE 2/Master File Manager/src/laboratorio/salados/33";
        String[] nombres = { "1", "2", "3"};

        //NioCrearCarpeta.crearCarpeta(ruta1, "Java", 4);
        //NioCrearArchivo.crearArchivo(ruta1, "Java", 4);
        //NioEliminar.eliminarTodo(ruta1 + "/" + 33);
        NioCopiar.copiarTodo(ruta1 + "/" + 22, ruta1 + "/" + 33);

        MensajesError.mostrarErrores();
    }
}
