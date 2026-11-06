package gui;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class MiJDialog {
    public JFrame frame;
    public JDialog dialog;
    public JPanel panel;
    public JLabel[] labels = new JLabel[10];
    public JRadioButton[] radioButtons = new JRadioButton[10];
    public JButton[] buttons = new JButton[10];
    public JButton buttonAceptar, buttonCancelar;
    public ButtonGroup buttonGroup = new ButtonGroup();

    public MiJDialog(JFrame frame, String nombre, boolean modal) {
        this.frame = frame;
        dialog = new JDialog(frame, nombre, true);
        panel = new JPanel(new MigLayout(" insets 20, gap 10"));

    }

    public void setJRB() {
        for (JRadioButton rb: radioButtons) {
            buttonGroup.add(rb);
        }
    }

    public void setMiJDialog() {
        dialog.add(panel);
        dialog.pack();
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
    }
}
