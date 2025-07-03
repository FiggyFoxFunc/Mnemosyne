package gui;

import zettelkasten.Zettelkasten;

import javax.swing.*;
import java.awt.*;

public class Editor extends JPanel {
    Zettelkasten zettelkasten;

    public Editor(Zettelkasten zettelkasten) {
        this.zettelkasten = zettelkasten;
        setBackground(Utilities.defaultBackground);
    }
}
