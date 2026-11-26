package nio.renombrar;

import java.nio.file.Files;
import java.nio.file.Path;

public record Partes(String base, String extension) {
    static Partes de(Path p) {
        String n = p.getFileName().toString();
        if (Files.isDirectory(p)) return new Partes(n, "");
        int i = n.lastIndexOf('.');
        if (i > 0) {
            String ext = n.substring(i + 1);
            // ".cbz" y ".7z" sí; ".5" no (solo dígitos)
            if (ext.matches("[A-Za-z0-9]{1,5}") && !ext.matches("\\d+"))
                return new Partes(n.substring(0, i), "." + ext);
        }
        return new Partes(n, "");
    }
}
