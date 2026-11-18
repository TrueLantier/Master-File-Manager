package nio.manejoerrores;

import nio.Operaciones;

public record RegistroErrores(
    String path,
    Operaciones operación,
    String mensaje,
    Exception causa
) {
    @Override
    public String toString() {
        return "path=" + path + '\n' +
                "operación=" + operación + '\n' +
                "mensaje=" + mensaje + '\n' +
                "causa=" + causa +
                '\n';
    }
}
