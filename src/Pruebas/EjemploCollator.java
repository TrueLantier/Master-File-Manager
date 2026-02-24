package Pruebas;
import java.util.Locale;
import java.util.*;
import java.text.Collator;

public class EjemploCollator {
    public static void main(String[] args) {
        Collator collator = Collator.getInstance(); // Collator para el locale por defecto.

        // Collator para un locale específico.
        Collator collatorSpain = Collator.getInstance(new Locale("es", "ES"));
        Collator collatorUS = Collator.getInstance(Locale.US);
        Collator collatorFrance = Collator.getInstance(Locale.FRANCE);

        collatorSpain.setStrength(Collator.PRIMARY); // Solo letras base diferentes.
        System.out.println("PRIMARY a vs ä " + (collatorSpain.compare("a", "ä") == 0 ? "iguales" : "diferentes"));

        collatorSpain.setStrength(Collator.SECONDARY); // Solo acentos y diacríticos. P
        System.out.println("SECONDARY a vs ä " + (collatorSpain.compare("a", "ä") == 0 ? "iguales" : "diferentes"));

        collatorSpain.setStrength(Collator.TERTIARY); // Solo mayúsculas y minúsculas. P S
        System.out.println("TERTIARY a vs ä " + (collatorSpain.compare("a", "ä") == 0 ? "iguales" : "diferentes"));

        List<String> palabras = Arrays.asList(
                "álbum", "casa", "Árbol", "pérez", "perez", "ñandú", "suela", "Oso"
        );
        palabras.sort(collatorSpain);

        System.out.println();
        System.out.println("Ordenando con Collator");
        for (String palabra: palabras) {
            System.out.print(palabra + " ");
        }
        System.out.println("\n");
        Collections.sort(palabras);
        System.out.println("Ordenando con compareTo (Unicode) ");
        for (String palabra: palabras) {
            System.out.print(palabra + " ");
        }
    }
}
