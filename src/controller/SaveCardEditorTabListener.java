package controller;

import zettelkasten.Card;
import zettelkasten.Zettelkasten;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveCardEditorTabListener implements ActionListener {
    private final JTabbedPane tabbedPane;
    private final Zettelkasten zettelkasten;

    public SaveCardEditorTabListener(JTabbedPane tabbedPane, Zettelkasten zettelkasten) {
        this.tabbedPane = tabbedPane;
        this.zettelkasten = zettelkasten;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = tabbedPane.getSelectedIndex();
        if (index == -1) {
            return;
        }

        String title = tabbedPane.getTitleAt(index);
        Card card = zettelkasten.getCard(title);

        JPanel panel = (JPanel)tabbedPane.getComponentAt(index);
        JTextArea textArea = (JTextArea)panel.getComponent(0);
        card.saveContents(textArea.getText());
    }
}
