package Logic.EliminarArchivos;

import Logic.Diseño.Diseño;

import java.io.*;

public class EliminarArchivos extends Diseño {

    public EliminarArchivos(String rutaEliminar) throws FileNotFoundException {
        super(rutaEliminar);
        System.out.println("Seleccione el archivo a eliminar: ");
    }


}
