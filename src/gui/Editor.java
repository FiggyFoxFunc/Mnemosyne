package gui;

import zettelkasten.Card;
import zettelkasten.Zettelkasten;

import javax.swing.*;
import java.awt.*;

/**
 * Editor is main point for working with and modifying the Zettelkasten.
 */
public class Editor extends JPanel {
    private Zettelkasten zettelkasten;
    private JSplitPane splitPane;
    private JPanel scrollPanel = new JPanel();
    private JPanel cardEditorPanel = new JPanel();
    // TODO: Make custom TabbedPane to have close buttons and a new Card button.
    private JTabbedPane tabbedPane = new JTabbedPane();

    public Editor(Zettelkasten zettelkasten) {
        this.zettelkasten = zettelkasten;
        setBackground(Utilities.defaultBackground);
        setLayout(new GridLayout(1, 2));

        prepareSplitPane();
        prepareScrollPanel();
        prepareCardEditorPanel();

        add(splitPane);
    }

    private void prepareSplitPane() {
        splitPane = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                scrollPanel,
                cardEditorPanel
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

    private void prepareCardEditorPanel() {
        cardEditorPanel.setBackground(Utilities.defaultBackground);
        cardEditorPanel.setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel();
        controlPanel.setBackground(Utilities.defaultBackground);
        controlPanel.setLayout(new FlowLayout());

        // TODO: Change default tab background colour.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        tabbedPane.setFocusable(false);

        JButton newButton = Utilities.createButton(
                "New",
                ignored -> {
                    addCardEditorTab("New Card");
                }
        );

        JButton closeButton = Utilities.createButton(
                "Close",
                ignored -> {
                    int index = tabbedPane.getSelectedIndex();
                    if (index == -1) {
                        return;
                    }

                    tabbedPane.removeTabAt(index);
                }
        );

        JButton saveButton = Utilities.createButton(
                "Save",
                ignored -> {
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
        );


        controlPanel.add(newButton);
        controlPanel.add(closeButton);
        controlPanel.add(saveButton);
        cardEditorPanel.add(controlPanel, BorderLayout.NORTH);
        cardEditorPanel.add(tabbedPane, BorderLayout.CENTER);
    }

    private void addCardEditorTab(String title) {
        zettelkasten.createCard(title);
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
