package viewdatar;

import jenisdatar.Persegi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewPersegi extends JFrame {
    private JTextField sisiInput;
    private JLabel hasilLuas, hasilKeliling;
    private JButton hitungButton;

    public ViewPersegi() {
        setTitle("Hitung Persegi");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        sisiInput = new JTextField(10);
        hitungButton = new JButton("Hitung");
        hasilLuas = new JLabel("Luas: -");
        hasilKeliling = new JLabel("Keliling: -");

        add(new JLabel("Sisi:"));
        add(sisiInput);
        add(hitungButton);
        add(hasilLuas);
        add(hasilKeliling);

        hitungButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double sisi = Double.parseDouble(sisiInput.getText());
                    Persegi persegi = new Persegi(sisi);
                    hasilLuas.setText("Luas: " + persegi.hitungLuas());
                    hasilKeliling.setText("Keliling: " + persegi.hitungKeliling());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Masukkan angka yang valid!");
                }
            }
        });

        setVisible(true);
    }
}
