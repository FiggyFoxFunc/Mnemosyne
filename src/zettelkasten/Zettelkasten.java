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
    private String directoryPath = "./zettelkastens/";
    private final HashMap<String, Card> cards = new HashMap<>();

    /**
     * Default Constructor for Zettelkasten.
     */
    public Zettelkasten(String name, String directoryPath) throws IOException {
        this.name = name;

        if (directoryPath != null) {
            this.directoryPath = directoryPath;
        }

        File directoryFile = new File(this.directoryPath + this.name + "/");
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

    public String getDirectoryPath() {
        return directoryPath;
    }

    public void setDirectoryPath(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public void addCard(String name) {
        cards.put(name, new Card(name, directoryPath));
    }

    public Card getCard(String name) {
        return cards.get(name);
    }
}
