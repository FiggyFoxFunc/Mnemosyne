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

        // Layout setup.
        prepareLayout(2, 2);
        prepareMainMenu();

        pack();
        setVisible(true);
    }

    private void prepareLayout(Integer width, Integer height) {
        setLayout(new GridBagLayout());
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = width;
        gridBagConstraints.gridheight = height;
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
