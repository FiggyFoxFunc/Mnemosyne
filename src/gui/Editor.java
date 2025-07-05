package gui;

import zettelkasten.Zettelkasten;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Editor is main point for working with and modifying the Zettelkasten.
 */
public class Editor extends JPanel {
    Zettelkasten zettelkasten;
    JSplitPane splitPane;
    JPanel scrollPanel = new JPanel();
    // TODO: Make custom TabbedPane to have close buttons and a new Card button.
    JTabbedPane tabbedPane = new JTabbedPane();

    public Editor(Zettelkasten zettelkasten) {
        this.zettelkasten = zettelkasten;
        setBackground(Utilities.defaultBackground);
        setLayout(new GridLayout(1, 2));

        prepareSplitPane();
        prepareScrollPanel();
        prepareTabbedPane();

        add(splitPane);
    }

    private void prepareSplitPane() {
        splitPane = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                scrollPanel,
                tabbedPane
                );

        splitPane.setBackground(Utilities.defaultBackground);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerSize(1);
        splitPane.setDividerLocation(150);
    }

    private void prepareScrollPanel() {
        scrollPanel.setBackground(Utilities.defaultBackground);
        scrollPanel.add(Utilities.createLabel("- " + zettelkasten.getName()));
    }

    private void prepareTabbedPane() {
        tabbedPane.setBorder(new LineBorder(Color.BLACK));
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        tabbedPane.setFocusable(false);

        addCardEditorTab("New Card");
    }

    private void addCardEditorTab(String title) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));

        JTextArea textArea = new JTextArea();

        textArea.setBackground(Utilities.defaultBackground);
        textArea.setForeground(Color.WHITE);
        textArea.setCaretColor(Color.WHITE);

        panel.add(textArea);
        tabbedPane.addTab(title, panel);
    }
}
