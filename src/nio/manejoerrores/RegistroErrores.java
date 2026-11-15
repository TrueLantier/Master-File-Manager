package nio.manejoerrores;

import java.nio.file.Path;

public record RegistroErrores(
    String path,
    String operación,
    String mensaje,
    Exception causa
) {}
