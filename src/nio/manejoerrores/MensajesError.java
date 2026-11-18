package nio.manejoerrores;

import nio.Operaciones;

import java.util.ArrayList;
import java.util.List;

public class MensajesError {
    private static final List<RegistroErrores> ERRORES_LISTA = new ArrayList<>();

    public static void agregarError(String ruta, Operaciones operación, String mensaje, Exception e) {
        ERRORES_LISTA.add(new RegistroErrores(ruta, operación, mensaje, e));
    }

    public static void mostrarErrores() {
        int contadorErrores = 0;
        for (RegistroErrores error: ERRORES_LISTA) {
            System.out.println("Error " + ++contadorErrores);
            System.out.println(error.toString());
            System.out.println();
        }
    }
}
