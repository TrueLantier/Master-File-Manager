package gui;

import net.miginfocom.swing.MigLayout;
import javax.swing.*;

public class Paneles {
    public static void crearElección(JFrame frame) {
        MiJDialog m1 = new MiJDialog(frame, "Tipo de objeto", true);

        m1.radioButtons[0] = new JRadioButton("Archivos");
        m1.radioButtons[1] = new JRadioButton("Carpetas");
        m1.radioButtons[2] = new JRadioButton("Crear 1 carpeta predeterminada");
        m1.radioButtons[3] = new JRadioButton("Crear varias carpetas predeterminadas");
        m1.radioButtons[4] = new JRadioButton("Crear 1 carpeta personalizada");
        m1.radioButtons[5] = new JRadioButton("Crear varias carpetas personalizadas");
        m1.radioButtons[6] = new JRadioButton("Crear varias carpetas personalizadas anidadas");

        ButtonGroup grupoUno = new ButtonGroup();
        grupoUno.add(m1.radioButtons[0]);
        grupoUno.add(m1.radioButtons[1]);

        ButtonGroup grupoDos = new ButtonGroup();
        grupoDos.add(m1.radioButtons[2]);
        grupoDos.add(m1.radioButtons[3]);
        grupoDos.add(m1.radioButtons[4]);
        grupoDos.add(m1.radioButtons[5]);
        grupoDos.add(m1.radioButtons[6]);

        m1.buttonAceptar = new JButton("Aceptar");
        m1.buttonCancelar = new JButton("Cancelar");

        m1.panel.add(new JLabel("Elige el tipo de objeto a crear:"), "wrap, growx");
        m1.panel.add(m1.radioButtons[0], "");
        m1.panel.add(m1.radioButtons[1], "align center, wrap");
        m1.panel.add(new JSeparator(), "wrap");

        m1.panel.add(m1.radioButtons[2], "wrap");
        m1.panel.add(m1.radioButtons[3], "wrap");
        m1.panel.add(m1.radioButtons[4], "wrap");
        m1.panel.add(m1.radioButtons[5], "wrap");
        m1.panel.add(m1.radioButtons[6], "wrap");

        m1.panel.add(m1.buttonAceptar);
        m1.panel.add(m1.buttonCancelar, "wrap");
        m1.panel.add(new JSeparator(), "wrap");

        m1.buttonCancelar.addActionListener(e -> m1.dialog.dispose());

        m1.setMiJDialog();
    }
}
