package controller;

import gui.BaseFrame;
import zettelkasten.Zettelkasten;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class NewZettelkastenListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent event) {
        String name = JOptionPane.showInputDialog("Name Your Zettelkasten.");
        BaseFrame frame = (BaseFrame) SwingUtilities.getRoot((Component) event.getSource());

        if (!name.isBlank()) {
            try {
                frame.createEditor(new Zettelkasten(name, null));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
