package sparadrap.afpa.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    private JPanel contentPane;
    private JPanel logoMenu;
    private JPanel mainMenu;
    private JPanel footerMenu;
    private JButton buttonAchatMenu;
    private JButton buttonHistoriqueMenu;
    private JButton buttonMedecinMenu;
    private JButton buttonClientMenu;
    private JLabel titre;
    private JButton buttonQuitterMenu;

    public Menu() {
        buttonAchatMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonHistoriqueMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonMedecinMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonClientMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonQuitterMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
