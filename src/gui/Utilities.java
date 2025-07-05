package gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class Utilities {
    public static Color defaultBackground = Color.DARK_GRAY;

    public static JLabel createLabel(String title) {
        JLabel label = new JLabel(title);

        label.setForeground(Color.WHITE);

        return label;
    }

    public static JButton createButton(String title, ActionListener actionListener) {
        JButton button = new JButton(title);
        button.addActionListener(actionListener);

        // Styling
        button.setFocusable(false);
        button.setBorder(new LineBorder(Color.BLACK, 2));
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);

        return button;
    }
}
