package gui;

import javax.swing.*;

public class MainGUI {
    static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new FileManagerGUI();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
