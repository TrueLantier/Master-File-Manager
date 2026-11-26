package nio.renombrar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatronesTest {
    static void main(String[] args) {
        String[] tiposPatrones = {
                "\\d+",
                "\\d+-\\d+",

        };
        final Pattern PATRON = Pattern.compile(
                "(\\d+(?:\\.\\d+)?)(?:\\s*-\\s*(\\d+(?:\\.\\d+)?))?"
        );

        String texto = "123Hola Mundo123-456 difuvbf 111-111";
        String textoDos = "123Hola Mundo123-123 EXTRA";
        Pattern patrón = Pattern.compile("\\d+-\\d+");
        Pattern patrónDos = Pattern.compile("exTRa", Pattern.CASE_INSENSITIVE);
        Matcher matcher = PATRON.matcher(texto);
        Matcher matcherDos = patrónDos.matcher(textoDos);
        String parte = "";

        if (matcher.find()) {
            parte = matcher.group();
            String dos = matcher.group();
            System.out.println(parte + " " + dos);
        } else {
            System.out.println("NO");
        }

        if (matcherDos.find()) {
            parte = matcherDos.group();
            System.out.println(parte);
        } else {
            System.out.println("NO");
        }
    }
}
