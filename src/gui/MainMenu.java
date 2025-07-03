package gui;

import zettelkasten.Zettelkasten;

import javax.swing.*;
import java.awt.*;

/**
 * MainMenu represents the initial Menu shown upon running Mnemosyne.
 */
public class MainMenu extends JPanel {
    JButton newButton;
    JButton openButton;

    public MainMenu() {
        setBackground(Utilities.defaultBackground);

        setLayout(new GridLayout(2, 1, 2, 2));

        newButton = Utilities.createButton(
                "New",
                ignored -> {
                    String name = JOptionPane.showInputDialog("Name Your Zettelkasten.");
                    BaseFrame frame = (BaseFrame) SwingUtilities.getRoot(MainMenu.this);

                    if (name != null) {
                        frame.setZettelkasten(new Zettelkasten(name));
                    }
                }
        );

        openButton = Utilities.createButton(
                "Open",
                ignored -> {}
        );

        add(newButton);
        add(openButton);
    }
}
