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

    public static void probarJOP1(JFrame frame) {
        JOptionPane.showMessageDialog(
                frame,
                "Archivo creado correctamente",
                "Operación completada",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void probarJOP2(JFrame frame) {
        JOptionPane.showMessageDialog(
                frame,
                "No se pudo eliminar el archivo",
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    public static void probarJOP3(JFrame frame) {
        int respuesta = JOptionPane.showConfirmDialog(
                frame,
                "¿Deseas eliminar esta carpeta?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (respuesta == JOptionPane.YES_OPTION) {
            probarJOP1(frame);
        }
    }

    public static void probarJOP4(JFrame frame) {
        String nombre = JOptionPane.showInputDialog(
                frame,
                "Introduce el nombre del archivo:"
        );

        if (nombre != null && !nombre.isBlank()) {
            probarJOP1(frame);
        }
    }

    public static void probarJRB1(JFrame frame) {
        JDialog dialog = new JDialog(frame, "JRadioButton", true);

        JRadioButton archivos = new JRadioButton("Archivos");
        JRadioButton carpetas = new JRadioButton("Carpetas");
        JRadioButton ambos = new JRadioButton("Ambos");

        ButtonGroup grupo = new ButtonGroup();

        grupo.add(archivos);
        grupo.add(carpetas);
        grupo.add(ambos);

        JPanel panel = new JPanel(new MigLayout());

        panel.add(archivos, "wrap");
        panel.add(carpetas, "wrap");
        panel.add(ambos, "wrap");

        if (archivos.isSelected()) {
            probarJOP1(frame);
        } else if (carpetas.isSelected()) {
            probarJOP1(frame);
        } else if (ambos.isSelected()) {
            probarJOP1(frame);
        }

        dialog.add(panel);
        dialog.pack();
        dialog.setSize(300, 300);
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);

        // archivos.setSelected(true);
    }

    public static void probarTodo(JFrame frame) {
        JDialog dialog = new JDialog(frame, "Renombrar", true);

        JRadioButton archivos = new JRadioButton("Archivos", true);
        JRadioButton carpetas = new JRadioButton("Carpetas");
        JRadioButton ambos = new JRadioButton("Ambos");

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(archivos);
        grupo.add(carpetas);
        grupo.add(ambos);

        JTextField nombre = new JTextField(20);
        JCheckBox incluirSubdirectorios =
                new JCheckBox("Incluir subdirectorios");

        JButton aceptar = new JButton("Aceptar");
        JButton cancelar = new JButton("Cancelar");

        JPanel panel = new JPanel(new MigLayout());

        panel.add(archivos, "wrap");
        panel.add(carpetas, "wrap");
        panel.add(ambos, "wrap");

        panel.add(new JLabel("Nuevo nombre:"));
        panel.add(nombre, "wrap");

        panel.add(incluirSubdirectorios, "wrap");

        panel.add(aceptar);
        panel.add(cancelar);

        aceptar.addActionListener(e -> {

            if (archivos.isSelected()) {
                System.out.println("Renombrar archivos");
            } else if (carpetas.isSelected()) {
                System.out.println("Renombrar carpetas");
            } else {
                System.out.println("Renombrar ambos");
            }

            System.out.println(nombre.getText());

            System.out.println(incluirSubdirectorios.isSelected());

            dialog.dispose(); // Cerrar y liberar el diálogo.
        });

        cancelar.addActionListener(e -> dialog.dispose());

        dialog.add(panel);
        dialog.pack(); // Ajustar las dimensiones de la ventana según el tamaño de los componentes.
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
    }
}
