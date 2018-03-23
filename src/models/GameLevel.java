package models;

public class GameLevel {
    private String[] characters;
    private boolean status;
    private int difficulty;

    public String[] getCharacters() {
        return characters;
    }

    private void setCharacters(String[] characters) {
        this.characters = characters;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getDifficulty() {
        return difficulty;
    }

    private void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }


    public GameLevel(String[] characters, int difficulty) {
        this.characters = characters;
        this.difficulty = difficulty;
    }
}
