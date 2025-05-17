package main;

import javax.swing.SwingUtilities;
import viewmenu.MainView;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainView());
    }
}
