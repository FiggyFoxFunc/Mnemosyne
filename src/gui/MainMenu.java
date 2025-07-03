package gui;

import zettelkasten.Zettelkasten;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * MainMenu represents the initial Menu shown upon running Mnemosyne.
 */
public class MainMenu extends JPanel {
    JButton newButton;
    JButton openButton;

    public MainMenu() {
        setLayout(new GridLayout(2,1));
        prepareNewButton();
        prepareOpenButton();
    }

    private void prepareNewButton() {
        newButton = new JButton("New");
        newButton.setFocusable(false);

        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("Name Your Zettelkasten.");
                BaseFrame frame = (BaseFrame) SwingUtilities.getRoot(MainMenu.this);

                frame.setZettelkasten(new Zettelkasten(name));
            }
        });

        add(newButton);
    }

    private void prepareOpenButton() {
        openButton = new JButton("Open");
        openButton.setFocusable(false);
        // TODO: Add Action Listener.

        add(openButton);
    }
}
