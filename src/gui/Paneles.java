package gui;

import net.miginfocom.swing.MigLayout;
import nio.Conector;
import javax.swing.*;
import java.awt.*;


public class Paneles {
    public static JRadioButton radioUno;
    public static JRadioButton radioDos;
    public static JRadioButton radioTres;
    public static JRadioButton radioCuatro;
    public static JRadioButton radioCinco;
    public static JRadioButton radioSeis;
    public static JRadioButton radioSiete;
    private static int elección = 0;

    public static void crearElección(JFrame frame) {
        MiJDialog m0 = new MiJDialog(frame, "Crear", true);
        m0.panel = new JPanel(new MigLayout(MiJDialog.FORMA));
        m0.panel.add(new JLabel("Elige el tipo de objeto a crear:"), "wrap, growx");

        JPanel panelElección = new JPanel(new MigLayout(MiJDialog.FORMA));
        JRadioButton radioUno = new JRadioButton("Archivos");
        JRadioButton radioDos = new JRadioButton("Carpetas");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioUno);
        buttonGroup.add(radioDos);
        panelElección.add(radioDos);
        panelElección.add(radioUno);
        m0.panel.add(panelElección, "wrap");

        m0.buttonAceptar = new JButton("Aceptar");
        //m0.buttonAceptar.addActionListener(e -> );
        m0.buttonCancelar = new JButton("Cancelar");
        m0.buttonCancelar.addActionListener(e -> m0.dialog.dispose());

        CardLayout cardLayout = new CardLayout();
        JPanel panelOpciones = new JPanel(cardLayout);
        JPanel panelCarpetas = crearPanelCarpeta();
        JPanel panelArchivos = crearPanelArchivo();
        JPanel panelVacío = new JPanel();

        panelOpciones.add(panelVacío, "VACÍO");
        panelOpciones.add(panelArchivos, "ARCHIVOS");
        panelOpciones.add(panelCarpetas, "CARPETAS");

        radioUno.addActionListener(e -> {
            cardLayout.show(panelOpciones, "ARCHIVOS");
            // JOptionPane.showMessageDialog(null, "Holaaa");
            //m0.dialog.dispose();
            //crearElección(frame);
        });
        radioDos.addActionListener(e -> cardLayout.show(panelOpciones, "CARPETAS"));



        m0.panel.add(panelOpciones, "wrap");
        m0.setMiJDialog();

    }

    private static JPanel crearPanelCarpeta() {
        JPanel panelCarpetas = new JPanel(new MigLayout(MiJDialog.FORMA));

        JRadioButton radioTres = new JRadioButton("Crear 1 carpeta predeterminada");
        radioTres.addActionListener(e -> {
            elegirOpción(3);
        });

        JRadioButton radioCuatro = new JRadioButton("Crear varias carpetas predeterminadas");
        radioCuatro.setActionCommand("4");
        JRadioButton radioCinco = new JRadioButton("Crear 1 carpeta personalizada");
        radioCinco.setActionCommand("5");
        JRadioButton radioSeis = new JRadioButton("Crear varias carpetas personalizadas");
        radioSeis.setActionCommand("6");
        JRadioButton radioSiete = new JRadioButton("Crear varias carpetas personalizadas anidadas");
        radioSiete.setActionCommand("7");

        ButtonGroup grupoUno = new ButtonGroup();
        grupoUno.add(radioTres);
        grupoUno.add(radioCuatro);
        grupoUno.add(radioCinco);
        grupoUno.add(radioSeis);
        grupoUno.add(radioSiete);

        JLabel labelUbicación = new JLabel("Ubicación: ");
        JButton buscarUbicación = new JButton("Buscar");
        JTextField textRuta = new JTextField(20);
        textRuta.setEditable(false);
        buscarUbicación.addActionListener(e -> Conector.guardarRuta(textRuta));

        JPanel panelUno = new JPanel(new MigLayout(MiJDialog.FORMA)); // ESTE es general.
        panelUno.add(labelUbicación);
        panelUno.add(buscarUbicación);
        panelUno.add(textRuta);

        panelCarpetas.add(radioTres, "wrap");
        panelCarpetas.add(radioCuatro, "wrap");
        panelCarpetas.add(radioCinco, "wrap");
        panelCarpetas.add(radioSeis, "wrap");
        panelCarpetas.add(radioSiete, "wrap");

        panelCarpetas.add(panelUno, "wrap");

        return panelCarpetas;
    }

    private static JPanel crearPanelArchivo() {
        JPanel panel = new JPanel(new MigLayout(MiJDialog.FORMA));

        JRadioButton radioTres = new JRadioButton("Crear 1 archivo predeterminado (.txt)");
        JRadioButton radioCuatro = new JRadioButton("Crear varios archivos predeterminados (.txt)");
        JRadioButton radioCinco = new JRadioButton("Crear 1 archivo personalizado");
        JRadioButton radioSeis = new JRadioButton("Crear varios archivos personalizados");
        // JRadioButton radioSiete = new JRadioButton("Crear varias carpetas personalizadas anidadas");

        ButtonGroup grupoUno = new ButtonGroup();
        grupoUno.add(radioTres);
        grupoUno.add(radioCuatro);
        grupoUno.add(radioCinco);
        grupoUno.add(radioSeis);
        // grupoUno.add(radioSiete);

        panel.add(radioTres, "wrap");
        panel.add(radioCuatro, "wrap");
        panel.add(radioCinco, "wrap");
        panel.add(radioSeis, "wrap");
        // panelCarpetas.add(radioSiete, "wrap");

        return panel;
    }

    private static CardLayout getCardLayout() {
        CardLayout cardLayout = new CardLayout();
        JPanel panelOpciones = new JPanel(cardLayout);
        JPanel panelCarpetas = crearPanelCarpeta();
        JPanel panelArchivos = crearPanelArchivo();
        JPanel panelVacío = new JPanel();

        panelOpciones.add(panelVacío, "VACÍO");
        panelOpciones.add(panelArchivos, "ARCHIVOS");
        panelOpciones.add(panelCarpetas, "CARPETAS");

        return cardLayout;
    }

    private static void elegirOpción(int opción) {
        switch (opción) {
            case 1:
                elección = 1;
                break;
            case 2:
                elección = 2;
                break;
            case 3:
                elección = 3;
                break;
            case 4:
                elección = 4;
                break;
            case 5:
                elección = 5;
                break;
            case 6:
                elección = 6;
                break;
            case 7:
                elección = 7;
                break;
            case 8:
                elección = 8;
                break;
            case 9:
                elección = 9;
                break;
            case 10:
                elección = 10;
                break;
            case 11:
                elección = 11;
                break;
            case 12:
                elección = 12;
                break;
            case 13:
                elección = 13;
                break;
            case 14:
                elección = 14;
                break;
            case 15:
                elección = 15;
                break;
            case 16:
                elección = 16;
                break;
            default:
                elección = 0;
        }
    }
}
