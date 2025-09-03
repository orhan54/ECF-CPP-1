package sparadrap.afpa.view;

import javax.swing.*;
import java.awt.event.*;

public class validationAchat {
    private JPanel contentPane;
    private JComboBox comboBoxValideAchat;
    private JList list1;
    private JTextField textFieldDateAchat;
    private JButton buttonRetourAchat;
    private JButton buttonValiderAchat;
    private JButton buttonQuitterAchat;

    public validationAchat() {
        comboBoxValideAchat.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

            }
        });
        textFieldDateAchat.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent event) {

            }

            @Override
            public void caretPositionChanged(InputMethodEvent event) {

            }
        });
        buttonRetourAchat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonValiderAchat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonQuitterAchat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
