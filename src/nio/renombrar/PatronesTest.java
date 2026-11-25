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
        Pattern patrón = Pattern.compile("\\d+-\\d+");
        Matcher matcher = patrón.matcher(texto);
        String parte = "";

        if (matcher.find()) {
            parte = matcher.group();
            System.out.println(parte);
        } else {
            System.out.println("NO");
        }
    }
}
