package controller;

import gui.Editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewCardEditorTabListener implements ActionListener {
    private final Editor editor;

    public NewCardEditorTabListener(Editor editor) {
        super();
        this.editor = editor;
    }

    @Override
    public void actionPerformed(ActionEvent ignored) {
        editor.addCardEditorTab("New Card");
    }
}
