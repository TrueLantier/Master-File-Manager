package tests;
import logic.renombrar.Renombrar;
import java.io.*;

public class TestRenombrar {
    static void main() throws IOException {
        String ruta1 = "src/laboratorio/salados/java 1/prueba";
        String ruta = "src/laboratorio/salados/java 1";
        Renombrar renombrar = new Renombrar(ruta);
    }
}
