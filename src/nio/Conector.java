package nio;

import javax.swing.*;
import java.nio.file.Path;

public class Conector {
    static JFileChooser chooser;

    public static void probar(JTextField textField) {
        chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = chooser.showOpenDialog(null); // Por defecto FILES ONLY.

        if (result == JFileChooser.APPROVE_OPTION) {
            Path directorio = chooser.getSelectedFile().toPath();
            textField.setText(directorio.toAbsolutePath().toString());
        }
    }
}
