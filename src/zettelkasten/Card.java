package zettelkasten;

import java.io.*;

/**
 * Card represents a file within the Zettelkasten.
 */
public class Card {
    private String name;
    private String directoryPath;

    public Card(String name, String directoryPath) {
        this.name = name;
        this.directoryPath = directoryPath;
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

    public String getContents() {
        String contents;

        try (FileReader fileReader = new FileReader(directoryPath + name)){
            contents = String.valueOf(fileReader.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return contents;
    }

    public void saveContents(String contents) {
        try (FileWriter fileWriter = new FileWriter(directoryPath + name)){
            fileWriter.write(contents);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
