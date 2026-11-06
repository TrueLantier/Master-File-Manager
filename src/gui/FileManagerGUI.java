package gui;

import net.miginfocom.swing.MigLayout;
import com.formdev.flatlaf.themes.*;
import com.formdev.flatlaf.*;
import nio.Conector;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileManagerGUI implements ActionListener {
    private final JFrame frame;
    private JPanel mainPanel;
    private JFileChooser chooser;
    JMenuBar jMenuBar;
    JMenu jMenu;
    JMenuItem menuItem1, menuItem2, menuItem3;
    private JButton btnCrear, btnCopiar, btnMover, btnRenombrar, btnEliminar, btnGuardar, btnBuscarDuplicados;
    private JPanel  panelAcciones;
    private JTextField prueba;


    public FileManagerGUI() throws Exception{
        frame = new JFrame("File Manager");
        initComponents();
        setupFrame();
    }

    private void initComponents() throws Exception {
        // UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        // UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        UIManager.setLookAndFeel(new FlatDarkLaf());
        jMenuBar = new JMenuBar();
        frame.setJMenuBar(jMenuBar);
        jMenu = new JMenu("Creador"); // Se puede cambiar el orden después.
        menuItem1 = new JMenuItem("El Creador");
        menuItem2 = new JMenuItem("Ayuda");
        jMenu.add(menuItem1);
        jMenu.add(menuItem2);
        jMenuBar.add(jMenu);

        chooser = new JFileChooser();

        gestionarBotones();

        // mainPanel = new JPanel(new MigLayout("insets 20, gap 10, wrap 1"));
        // mainPanel.add(crearPanelAcciones(), "grow, wrap");
        mainPanel = new JPanel(new MigLayout("insets 40, gap 30, wrap 3"));

        mainPanel.add(btnCrear,            "growx");
        mainPanel.add(btnCopiar,           "growx");
        mainPanel.add(btnMover,            "growx");
        mainPanel.add(new JSeparator(), "growx, span, wrap");
        mainPanel.add(btnRenombrar,        "growx");
        mainPanel.add(btnEliminar,         "growx");
        mainPanel.add(btnGuardar,          "growx");

        mainPanel.add(new JSeparator(), "growx, span, wrap");
        mainPanel.add(btnBuscarDuplicados, "span 3, alignx center, growx 0, width 220!");
        mainPanel.add(new JSeparator(), "growx, span, wrap");

        prueba = new JTextField(70);
        prueba.setActionCommand("prueba");
        prueba.setEditable(false);
        mainPanel.add(prueba);


        frame.setContentPane(mainPanel);
    }

    private void setupFrame() {
        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Crear")) {
            Paneles.crearElección(frame);

        }
        if (ae.getActionCommand().equals("Copiar")) {

        }
        if (ae.getActionCommand().equals("Mover")) {

        }
        if (ae.getActionCommand().equals("Renombrar")) {


        }
        if (ae.getActionCommand().equals("Eliminar")) {
            JAyudas.probarTodo(frame);

        }
        if (ae.getActionCommand().equals("Guardar")) {
            JAyudas.probarJDialog(frame);
        }
        if (ae.getActionCommand().equals("Buscar duplicados")) {
            //
            Conector.probar(prueba);
        }
    }

    private void gestionarBotones() {
        btnCrear            = new JButton("Crear");
        btnCopiar           = new JButton("Copiar");
        btnMover            = new JButton("Mover");
        btnRenombrar        = new JButton("Renombrar");
        btnEliminar         = new JButton("Eliminar");
        btnGuardar          = new JButton("Guardar");
        btnBuscarDuplicados = new JButton("Buscar duplicados");

        btnCrear.setToolTipText("Crea un nuevo archivo o carpeta");
        btnCopiar.setToolTipText("Copia el elemento seleccionado");
        btnMover.setToolTipText("Mueve el elemento seleccionado a otra ubicación");
        btnRenombrar.setToolTipText("Renombra el elemento seleccionado");
        btnEliminar.setToolTipText("Elimina el elemento seleccionado");
        btnGuardar.setToolTipText("Guarda los cambios pendientes");
        btnBuscarDuplicados.setToolTipText("Busca archivos duplicados");

        btnCrear.addActionListener(this);
        btnCopiar.addActionListener(this);
        btnMover.addActionListener(this);
        btnRenombrar.addActionListener(this);
        btnEliminar.addActionListener(this);
        btnGuardar.addActionListener(this);
        btnBuscarDuplicados.addActionListener(this);
    }
}
