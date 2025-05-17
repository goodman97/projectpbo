package viewmenu;

import javax.swing.*;
import java.awt.event.*;
import viewdatar.ViewPersegi; // atau view lainnya
import viewmenu.MainView;

public class MenuDatarView extends JFrame {
    public MenuDatarView() {
        setTitle("Pilih Bangun Datar");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Pilih salah satu bangun datar:");
        label.setBounds(30, 20, 300, 20);
        add(label);

        String[] bangunList = {
            "1. Persegi", "2. Persegi Panjang", "3. Segitiga", "4. Lingkaran",
            "5. Jajar Genjang", "6. Trapesium", "7. Belah Ketupat", 
            "8. Layang-Layang", "9. Tembereng", "10. Juring"
        };

        ButtonGroup group = new ButtonGroup();
        JRadioButton[] buttons = new JRadioButton[bangunList.length];
        int y = 50;
        for (int i = 0; i < bangunList.length; i++) {
            buttons[i] = new JRadioButton(bangunList[i]);
            buttons[i].setBounds(30, y, 200, 20);
            group.add(buttons[i]);
            add(buttons[i]);
            y += 25;
        }

        JButton pilihBtn = new JButton("Pilih");
        pilihBtn.setBounds(30, y + 10, 100, 25);
        add(pilihBtn);

        JButton homeBtn = new JButton("Home");
        homeBtn.setBounds(140, y + 10, 100, 25);
        add(homeBtn);

        pilihBtn.addActionListener(e -> {
            boolean selected = false;
            for (int i = 0; i < buttons.length; i++) {
                if (buttons[i].isSelected()) {
                    selected = true;
                    dispose();
                    switch (i) {
                        case 0 -> new ViewPersegi(); // contoh saja
                        // tambahkan View lainnya sesuai nomor
                        default -> JOptionPane.showMessageDialog(this, "View belum dibuat");
                    }
                }
            }
            if (!selected) {
                JOptionPane.showMessageDialog(this, "Pilih salah satu bangun datar terlebih dahulu!");
            }
        });

        homeBtn.addActionListener(e -> {
            dispose();
            new MainView();
        });

        setVisible(true);
    }
}