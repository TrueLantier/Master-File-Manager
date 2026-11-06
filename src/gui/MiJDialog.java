package gui;

import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MiJDialog implements ActionListener, ItemListener {
    public static final String FORMA = "insets 20, gap 10";
    public static MigLayout MIG_LAYOUT = new MigLayout("insets 20, gap 10");
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
        panel.add(buttonAceptar);
        panel.add(buttonCancelar);

        dialog.add(panel);
        dialog.pack();
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("3")) {
            JOptionPane.showMessageDialog(null, "Holaaa");
        }
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        if (ie.equals("3")) {
            JOptionPane.showMessageDialog(null, "Holaaa");
        }
    }
}
