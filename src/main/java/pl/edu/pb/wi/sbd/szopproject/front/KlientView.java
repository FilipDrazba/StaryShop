package pl.edu.pb.wi.sbd.szopproject.front;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class KlientView extends JFrame {
    protected JButton b1;

    public KlientView() {
        super("Klient");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setLocation(50, 50);


        b1 = new JButton("Wróc do menu wybory użytkownika");
        b1.setVerticalTextPosition(AbstractButton.BOTTOM);
        b1.setHorizontalTextPosition(AbstractButton.LEADING);
        b1.setMnemonic(KeyEvent.VK_D);
        b1.setActionCommand("disable");
        b1.addActionListener(e -> {
            setVisible(false);
            new MainView();
        });

        add(b1);
        setVisible(true);
    };
}
