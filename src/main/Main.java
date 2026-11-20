package main;

import nio.*;
import nio.copiarmover.NioMover;
import nio.manejoerrores.MensajesError;
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
        //NioCopiar.copiarTodo(ruta1 + "/" + 22, ruta1 + "/" + 33);
        //NioCopiar.copiarContenido(ruta1 + "/" + 22, ruta1 + "/" + 1, 3);
        //NioEliminar.eliminarNombre(ruta1 + "/" + 1, "a");
        //NioCopiar.copiarNombres(ruta1 + "/" + 22, ruta1 + "/" + 1, "carpeta");

        //NioMover.moverElemento(ruta1 + "/" + "archivo.txt", ruta1 + "/" + 1);
        //NioMover.moverElemento(ruta1 + "/33/22", ruta1 + "");
        //NioMover.moverContenido(ruta1 + "/33", ruta1 + "/22", 7);
        NioMover.moverNombres(ruta1 + "/22", ruta1 + "/33", "Java");

        MensajesError.mostrarErrores();
    }
}
