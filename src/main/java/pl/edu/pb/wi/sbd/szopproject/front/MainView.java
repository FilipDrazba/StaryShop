package pl.edu.pb.wi.sbd.szopproject.front;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

@Component
public class MainView {
    protected JButton b1, b2;
    private static final String ERROR_TITLE = "Error";
    private JFrame jFrame;
    public MainView() {
//        super("Szop");
        jFrame = new JFrame("Szop");
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setSize(300, 100);
        jFrame.setLocation(500, 300);
        jFrame.setLayout(new GridLayout(2, 6));

        b1 = new JButton("Klient");
        b1.setVerticalTextPosition(AbstractButton.CENTER);
        b1.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
        b1.setMnemonic(KeyEvent.VK_D);
        b1.setActionCommand("disable");

        b2 = new JButton("Sklepowyj");
        b2.setVerticalTextPosition(AbstractButton.BOTTOM);
        b2.setHorizontalTextPosition(AbstractButton.CENTER);
        b2.setMnemonic(KeyEvent.VK_M);

        b1.setToolTipText("Kliknij aby korzytsać z aplikacji jako klient.");
        b2.setToolTipText("Kliknij aby korzytsać z aplikacji jako sklepowyj.");

        b1.addActionListener(e -> {

            b1.addActionListener(e1 -> {
                jFrame.setVisible(false);
                new KlientView();
            });
        });

        jFrame.add(b1);
        jFrame.add(b2);
        jFrame.setVisible(true);
    }
}
