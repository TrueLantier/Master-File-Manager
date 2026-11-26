package nio.renombrar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatronesTest {
    static void main(String[] args) {
        String[] tiposPatrones = {
                "\\d+",
                "\\d+-\\d+",

        };


        String texto = "123Hola Mundo123-123";
        String textoDos = "123Hola Mundo123-123 EXTRA";
        Pattern patrón = Pattern.compile("\\d+-\\d+");
        Pattern patrónDos = Pattern.compile("exTRa", Pattern.CASE_INSENSITIVE);
        Matcher matcher = patrón.matcher(texto);
        Matcher matcherDos = patrónDos.matcher(textoDos);
        String parte = "";

        if (matcher.find()) {
            parte = matcher.group();
            System.out.println(parte);
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
