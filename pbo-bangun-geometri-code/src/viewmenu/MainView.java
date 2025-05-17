package viewmenu;

import javax.swing.*;
import java.awt.event.*;
import viewmenu.MenuDatarView;
import viewmenu.MenuRuangView;

public class MainView extends JFrame {
    public MainView() {
        setTitle("Aplikasi Bangun Geometri");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Pilih Jenis Bangun:");
        label.setBounds(100, 20, 200, 30);
        add(label);

        JButton btnDatar = new JButton("Bangun Datar");
        btnDatar.setBounds(100, 60, 150, 30);
        add(btnDatar);

        JButton btnRuang = new JButton("Bangun Ruang");
        btnRuang.setBounds(100, 100, 150, 30);
        add(btnRuang);

        btnDatar.addActionListener(e -> {
            dispose();
            new MenuDatarView();
        });

        btnRuang.addActionListener(e -> {
            dispose();
            new MenuRuangView();
        });

        setVisible(true);
    }
}
