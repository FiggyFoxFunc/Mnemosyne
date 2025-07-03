package gui;

import zettelkasten.Zettelkasten;

import javax.swing.*;
import java.awt.*;

public class BaseFrame extends JFrame {
    String title;
    MainMenu mainMenu;
    JMenuBar menuBar;

    public BaseFrame(String title) {
        this.title = title;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
        setMinimumSize(new Dimension(800, 600));

        getContentPane().setBackground(Utilities.defaultBackground);

        // Layout setup.
        prepareMenuBar();
        mainMenu = new MainMenu();
        add(mainMenu);

        pack();
        setVisible(true);
    }

    private void prepareMenuBar() {
        menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem openMenuItem = new JMenuItem("Open");

        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
        menuBar.setVisible(false);
    }

    public void createEditor(Zettelkasten zettelkasten) {
        remove(mainMenu);
        menuBar.setVisible(true);
        add(new Editor(zettelkasten));
        setTitle(title + " - Using Zettelkasten: " + zettelkasten.getName());
    }
}
