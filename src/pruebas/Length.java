package pruebas;
import java.io.*;

public class Length {
    public static void main(String[] args) {
        String rutaLibro1 = "src/Laboratorio/SalaUno/Effective_Java_Best_Practices_for_the_Java_Platform_Joshua_Bloch.pdf";
        String rutaLibro2 = "src/Laboratorio/SalaUno/java.pdf";
        String rutaLibro3 = "src/Laboratorio/SalaUno/leetcode_solutions_java.pdf";

        File[] archivos = { new File(rutaLibro1), new File(rutaLibro2), new File(rutaLibro3) };
        long[] bytes = { archivos[0].length(), archivos[1].length(), archivos[2].length() };

        for (int i = 0; i < 3; i++) {
            // No es perfecto pero se entiende.
            System.out.println("Tamaña libro " + i + " " + bytes[i] + " bytes");
        }
    }
}
