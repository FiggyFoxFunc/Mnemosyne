package gui;

import zettelkasten.Zettelkasten;

import javax.swing.*;
import java.awt.*;

public class BaseFrame extends JFrame {
    Zettelkasten zettelkasten;
    GridBagConstraints gridBagConstraints;
    MainMenu mainMenu;

    public BaseFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Mnemosyne");
        setMinimumSize(new Dimension(800, 600));

        getContentPane().setBackground(Utilities.defaultBackground);

        // Layout setup.
        prepareLayout();
        prepareMainMenu();

        pack();
        setVisible(true);
    }

    private void prepareLayout() {
        setLayout(new GridBagLayout());
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
    }

    private void prepareMainMenu() {
        mainMenu = new MainMenu();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        add(mainMenu, gridBagConstraints);
    }

    public Zettelkasten getZettelkasten() {
        return zettelkasten;
    }

    public void setZettelkasten(Zettelkasten zettelkasten) {
        this.zettelkasten = zettelkasten;
    }
}
