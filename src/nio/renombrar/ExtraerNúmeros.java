package nio.renombrar;

import java.util.regex.*;

public class ExtraerNúmeros {

    private static final Pattern PATRON = Pattern.compile(
        "(\\d+(?:\\.\\d+)?)(?:\\s*-\\s*(\\d+(?:\\.\\d+)?))?"
    );

    static void main(String[] args) {
        String texto = "Ver capítulo2.4-50 y luego el 145, "
                     + "página 22-30, valor 2.8 -   90.90, "
                     + "y también 2, 15, 2.1, 999.50 fin.";

        Matcher m = PATRON.matcher(texto);
        while (m.find()) {
            String ini = m.group(1);
            String fin = m.group(2);

            if (fin != null) {
                System.out.println("Rango: " + ini + " a " + fin);
            } else {
                System.out.println("Número: " + ini);
            }
        }
    }
}