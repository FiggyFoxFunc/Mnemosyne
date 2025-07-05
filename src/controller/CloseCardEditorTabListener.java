package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CloseCardEditorTabListener implements ActionListener {
    private final JTabbedPane tabbedPane;

    public CloseCardEditorTabListener(JTabbedPane tabbedPane) {
        this.tabbedPane = tabbedPane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = tabbedPane.getSelectedIndex();
        if (index == -1) {
            return;
        }

        tabbedPane.removeTabAt(index);
    }
}
