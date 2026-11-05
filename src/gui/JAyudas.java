package gui;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class JAyudas {
    public static void probarJDialog(JFrame frame) {
        JDialog dialog = new JDialog(frame, "Renombrar", true);

        JPanel panel = new JPanel(new MigLayout());

        panel.add(new JLabel("Nuevo nombre:"));
        panel.add(new JTextField(20), "wrap");

        panel.add(new JButton("Aceptar"));
        panel.add(new JButton("Cancelar"));

        dialog.add(panel);
        dialog.pack();
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
    }

    public static void probarJOP1() {

    }
}
