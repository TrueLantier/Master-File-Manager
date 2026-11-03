package gui;

import net.miginfocom.swing.MigLayout;
import com.formdev.flatlaf.themes.*;
import com.formdev.flatlaf.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileManagerGUI implements ActionListener {
    private final JFrame frame;
    private JPanel mainPanel;
    JMenuBar jMenuBar;
    JMenu jMenu;
    JMenuItem menuItem1, menuItem2, menuItem3;
    private JButton btnCrear;
    private JButton btnCopiar;
    private JButton btnMover;
    private JButton btnRenombrar;
    private JButton btnEliminar;
    private JButton btnGuardar;
    private JButton btnBuscarDuplicados;
    private JPanel  panelAcciones;



    public FileManagerGUI() throws Exception{
        frame = new JFrame("File Manager");
        initComponents();
        setupFrame();
    }

    private void initComponents() throws Exception {
        // UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        UIManager.setLookAndFeel(new FlatDarkLaf());
        jMenuBar = new JMenuBar();
        frame.setJMenuBar(jMenuBar);
        jMenu = new JMenu("Creador"); // Se puede cambiar el orden después.
        menuItem1 = new JMenuItem("El Creador");
        jMenu.add(menuItem1);
        jMenuBar.add(jMenu);

        mainPanel = new JPanel(new MigLayout("insets 20, gap 10, wrap 1"));
        mainPanel.add(crearPanelAcciones(), "grow, wrap");


        frame.setContentPane(mainPanel);
    }

    private void setupFrame() {
        frame.setSize(600, 700);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    private JPanel crearPanelAcciones() {
        panelAcciones = new JPanel(new MigLayout(
                "wrap 3, insets 4, fillx, alignx center",
                "[grow, fill][grow, fill][grow, fill]",
                "[]6[]6[]"
        ));

        // --- Instanciación ---
        btnCrear            = new JButton("Crear");
        btnCopiar           = new JButton("Copiar");
        btnMover            = new JButton("Mover");
        btnRenombrar        = new JButton("Renombrar");
        btnEliminar         = new JButton("Eliminar");
        btnGuardar          = new JButton("Guardar");
        btnBuscarDuplicados = new JButton("Buscar duplicados");

        // --- Tooltips (texto de ejemplo, cambialo por el definitivo) ---
        btnCrear.setToolTipText("Crea un nuevo archivo o carpeta");
        btnCopiar.setToolTipText("Copia el elemento seleccionado");
        btnMover.setToolTipText("Mueve el elemento seleccionado a otra ubicación");
        btnRenombrar.setToolTipText("Renombra el elemento seleccionado");
        btnEliminar.setToolTipText("Elimina el elemento seleccionado");
        btnGuardar.setToolTipText("Guarda los cambios pendientes");
        btnBuscarDuplicados.setToolTipText("Busca archivos duplicados por contenido/tamaño");

        // --- Listeners (Ventana debe implementar ActionListener) ---
        btnCrear.addActionListener(this);
        btnCopiar.addActionListener(this);
        btnMover.addActionListener(this);
        btnRenombrar.addActionListener(this);
        btnEliminar.addActionListener(this);
        btnGuardar.addActionListener(this);
        btnBuscarDuplicados.addActionListener(this);

        // --- Layout: 2 filas de 3 + 1 centrado abajo ---
        panelAcciones.add(btnCrear,            "growx");
        panelAcciones.add(btnCopiar,           "growx");
        panelAcciones.add(btnMover,            "growx");

        panelAcciones.add(btnRenombrar,        "growx");
        panelAcciones.add(btnEliminar,         "growx");
        panelAcciones.add(btnGuardar,          "growx");

        panelAcciones.add(btnBuscarDuplicados, "span 3, alignx center, growx 0, width 200!");

        return panelAcciones;
    }
}
