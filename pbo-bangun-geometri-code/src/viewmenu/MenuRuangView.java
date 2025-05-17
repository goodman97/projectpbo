package viewmenu;

import javax.swing.*;
import java.awt.event.*;
import viewmenu.MainView;

public class MenuRuangView extends JFrame {
    public MenuRuangView() {
        setTitle("Pilih Bangun Ruang");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Pilih salah satu bangun ruang:");
        label.setBounds(30, 20, 300, 20);
        add(label);

        String[] bangunRuangList = {
            "1. Kubus", "2. Balok", "3. Prisma Segitiga", "4. Limas Segitiga", 
            "5. Limas Segiempat", "6. Tabung", "7. Kerucut", "8. Bola", 
            "9. Kerucut Terpancung", "10. Tabung Terpancung",
            "11. Limas Segi-n", "12. Prisma Segi-n", "13. Setengah Bola", 
            "14. Bola Berongga", "15. Tabung Berongga", "16. Kubus Berongga",
            "17. Silinder Miring", "18. Kerucut Miring", "19. Gabungan Bangun",
            "20. Prisma Tak Beraturan", "21. Limas Tak Beraturan"
        };

        ButtonGroup group = new ButtonGroup();
        JRadioButton[] buttons = new JRadioButton[bangunRuangList.length];
        int y = 50;
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JRadioButton(bangunRuangList[i]);
            buttons[i].setBounds(30, y, 300, 20);
            group.add(buttons[i]);
            add(buttons[i]);
            y += 22;
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
                    // Tambahkan pemanggilan View sesuai bangun ruang
                    JOptionPane.showMessageDialog(this, "Bangun ruang ke-" + (i + 1) + " dipilih (implementasi belum dibuat)");
                }
            }
            if (!selected) {
                JOptionPane.showMessageDialog(this, "Pilih salah satu bangun ruang terlebih dahulu!");
            }
        });

        homeBtn.addActionListener(e -> {
            dispose();
            new MainView();
        });

        setVisible(true);
    }
}