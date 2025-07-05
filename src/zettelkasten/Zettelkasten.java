package zettelkasten;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Zettelkasten represents the PKM system as a whole.
 *
 */
public class Zettelkasten {
    private String name;
    private String parentDirectoryPath = "./zettelkastens/";
    private String directoryPath;
    private final HashMap<String, Card> cards = new HashMap<>();

    /**
     * Default Constructor for Zettelkasten.
     */
    public Zettelkasten(String name, String parentDirectoryPath) throws IOException {
        this.name = name;

        if (parentDirectoryPath != null) {
            this.parentDirectoryPath = parentDirectoryPath;
        }

        directoryPath = this.parentDirectoryPath + this.name + "/";
        File directoryFile = new File(directoryPath);
        if (!directoryFile.isDirectory()) {
            if (!directoryFile.mkdirs()) {
                throw new IOException("Unable to create Zettelkasten");
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentDirectoryPath() {
        return parentDirectoryPath;
    }

    public void setParentDirectoryPath(String parentDirectoryPath) {
        this.parentDirectoryPath = parentDirectoryPath;
    }

    public String getDirectoryPath() {
        return directoryPath;
    }

    public void setDirectoryPath(String parentDirectoryPath) {
        this.directoryPath = parentDirectoryPath;
    }

    public void createCard(String name) {
        cards.put(name, new Card(name, directoryPath));
    }

    public void addCard(Card card) {
        cards.put(card.getName(), card);
    }

    public Card getCard(String name) {
        return cards.get(name);
    }
}
