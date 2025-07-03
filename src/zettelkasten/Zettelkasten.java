package zettelkasten;

import java.util.ArrayList;

/**
 * Zettelkasten represents the PKM system as a whole.
 *
 */
public class Zettelkasten {
    private String name;
    private final ArrayList<Card> cards;

    /**
     * Default Constructor for Zettelkasten.
     */
    public Zettelkasten(String name) {
        this.name = name;
        cards = new ArrayList<>();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
