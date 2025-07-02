package zettelkasten;

import java.util.ArrayList;

/**
 * Zettelkasten represents the PKM system as a whole.
 *
 */
public class Zettelkasten {
    private final ArrayList<Card> cards;

    /**
     * Default Constructor for Zettelkasten.
     */
    public Zettelkasten() {
        cards = new ArrayList<>();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
