package gui;

import zettelkasten.Zettelkasten;

import javax.swing.*;
import java.awt.*;

/**
 * MainMenu represents the initial Menu shown upon running Mnemosyne.
 */
public class MainMenu extends JPanel {
    GridBagConstraints gridBagConstraints = new GridBagConstraints();
    JPanel buttonPanel = new JPanel();

    public MainMenu() {
        setBackground(Utilities.defaultBackground);

        prepareLayout();
        prepareButtons();

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        add(buttonPanel, gridBagConstraints);

    }

    private void prepareLayout() {
        setLayout(new GridBagLayout());
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
    }

    private void prepareButtons() {
        buttonPanel.setBackground(Utilities.defaultBackground);

        buttonPanel.setLayout(new GridLayout(2, 1, 2, 2));

        JButton newButton = Utilities.createButton(
                "New",
                ignored -> {
                    String name = JOptionPane.showInputDialog("Name Your Zettelkasten.");
                    BaseFrame frame = (BaseFrame) SwingUtilities.getRoot(MainMenu.this);

                    if (!name.isBlank()) {
                        frame.createEditor(new Zettelkasten(name));
                    }
                }
        );

        JButton openButton = Utilities.createButton(
                "Open",
                ignored -> {}
        );

        buttonPanel.add(newButton);
        buttonPanel.add(openButton);
    }
}
