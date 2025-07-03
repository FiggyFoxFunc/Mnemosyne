package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Utilities {
    public static JButton createButton(String title, ActionListener actionListener) {
        JButton button = new JButton(title);
        button.addActionListener(actionListener);

        button.setFocusable(false);
        button.setFont(Font.getFont("Fira Mono"));

        return button;
    }
}
