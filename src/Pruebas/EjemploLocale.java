package Pruebas;
import java.util.Locale;

public class EjemploLocale {
    public static void main(String[] args) {
        Locale loc = Locale.getDefault(); // El locale configurado del sistema operativo.
        System.out.println("Locale por defecto: " + loc); // es-ES

        // Usar constantes predefinidas.
        Locale spain = Locale.forLanguageTag("es-ES");
        Locale mexico = new Locale("es", "MX"); // Ignorar depreciado.
        Locale us = Locale.US;
        Locale france = Locale.FRANCE;

        System.out.println("España " + spain.getDisplayName()); // Nombre del locale en el idioma del locale actual.
        System.out.println("España en inglés: " + spain.getDisplayName(Locale.US));
    }
}
